package fun.xruo.lle.util.generator;

import com.google.common.base.CaseFormat;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Generator {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/test?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public static void main(String[] args) {
        Generator generator = new Generator();
        generator.run();
    }

    private void run() {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            List<Table> tables = getTableList(connection);
            for (Table table : tables) {
                List<Column> columns = getColumnList(connection, table);
                table.setColumns(columns);
                log.info("table: {}", table);
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
                table.setRemarks(rs.getString(5));
                table.setUpperCamelName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, table.getName()));
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
                column.setLowerCamelName(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, column.getName()));
                list.add(column);
                log.info("column: {}", column);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
