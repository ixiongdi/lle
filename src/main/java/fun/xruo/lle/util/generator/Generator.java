package fun.xruo.lle.util.generator;

import com.google.common.base.CaseFormat;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kevin
 */
@Slf4j
@Import(Config.class)
@EnableConfigurationProperties(Config.class)
public class Generator {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://mysql.ca3zw9ojro1a.rds.cn-northwest-1.amazonaws.com.cn:3306/lle";
    private static final String USERNAME = "lle";
    private static final String PASSWORD = "lle";
    private static final String PACKAGE = "fun.xruo.lle.demo";
    private static final String GROUP_ID = "fun.xruo.lle";
    private static final String ARTIFACT_ID = "";
    private static final String MODULE_ID = "sys";
    private static final List<TemplateFile> TEMPLATES = Arrays.asList(
            new TemplateFile("Controller", "java", "Controller.java.ftl", "controller/"),
            new TemplateFile("DAO", "java", "DAO.java.ftl", "dao/"),
            new TemplateFile("", "java", "DO.java.ftl", "pojo/"),
            new TemplateFile("Service", "java", "Service.java.ftl", "service/"),
            new TemplateFile("ServiceImpl", "java", "ServiceImpl.java.ftl", "service/impl/"),
            new TemplateFile("DAO", "xml", "DAO.xml.ftl", "dao/"),
            new TemplateFile("View", "vue", "View.vue.ftl", "vue/")
    );

    @Resource
    Config config;

    public static void main(String[] args) {
        Generator generator = new Generator();
        generator.run();
    }

    private void write(Table table) {
        try {
            // 创建配置类
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
            // 设置模板路径 toURI()防止路径出现空格
            String classpath = this.getClass().getResource("/").toURI().getPath();
            configuration.setDirectoryForTemplateLoading(new File(classpath + "/templates/"));
            // 设置字符集
            configuration.setDefaultEncoding("UTF-8");
            configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            configuration.setLogTemplateExceptions(false);
            configuration.setWrapUncheckedExceptions(true);
            configuration.setFallbackOnNullLoopVariable(false);
            if (!Files.isDirectory(Paths.get("gen"))) {
                Files.createDirectory(Paths.get("gen"));
            }
            for (TemplateFile file : TEMPLATES) {
                // 加载模板
                Template template = configuration.getTemplate(file.srcPath());

                if (!Files.isDirectory(Paths.get("gen", file.dstPath()))) {
                    Files.createDirectories(Paths.get("gen", file.dstPath()));
                }
                // 数据模型
                FileWriter writer = new FileWriter("gen/" + file.dstPath() + table.getUpperCamelName() + file.name() + "." + file.type());
                template.process(table, writer);
            }

            // 静态化
//            String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, table);
            // 打印静态化内容
//            log.info(content);
//            File file = new File("target/generated-sources/" + table.getUpperCamelName() + ".java");
//            Files.write(content.getBytes(), file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void run() {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            List<Table> tables = getTableList(connection);
            for (Table table : tables) {
                List<Column> columns = getColumnList(connection, table);
                table.setColumns(columns);
                table.setPackageName(PACKAGE);
                log.info("table: {}", table);
                write(table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Table> getTableList(Connection connection) throws SQLException {
        List<Table> list = new ArrayList<>();

        try {
            DatabaseMetaData db = connection.getMetaData();
            ResultSet rs = db.getTables(null, null, null, new String[]{"TABLE"});

            while (rs.next()) {
                Table table = new Table();
                table.setName(rs.getString(3));
                table.setComment(rs.getString(5));
                table.setUpperCamelName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName()));
                table.setLowerCamelName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, table.getName()));
                if (table.getName().equals("sys_config")) {
                    continue;
                }
                list.add(table);
                log.info("table: {}", table);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private List<Column> getColumnList(Connection connection, Table table) {
        List<Column> list = new ArrayList<>();

        try {
            String sql = String.format("SELECT * FROM %s LIMIT 0", table.getName());
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSetMetaData resultSetMetaData = preparedStatement.getMetaData();

            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                Column column = new Column();
                column.setName(resultSetMetaData.getColumnName(i));
                column.setType(resultSetMetaData.getColumnType(i));
                column.setTypeName(resultSetMetaData.getColumnTypeName(i));
                column.setClassName(resultSetMetaData.getColumnClassName(i));
                column.setLabel(resultSetMetaData.getColumnLabel(i));
                column.setDisplaySize(resultSetMetaData.getColumnDisplaySize(i));
                column.setJavaType(Column.getJavaClassNameByTypeName(column.getTypeName()));
                column.setLowerCamelName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, column.getName()));
                column.setRequired(column.getName().matches("(id)|(create_time)|(update_time)|(deleted)"));
                list.add(column);
                log.info("column: {}", column);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
