package fun.xruo.lle.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class DatabaseUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(DatabaseUtil.class);

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/test?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private static final String SQL = "SELECT * FROM ";// 数据库操作

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("can not load jdbc driver", e);
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("get connection failure", e);
            return null;
        }
    }

    /**
     * 关闭数据库连接
     *
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure", e);
            }
        }
    }


    private static List<String> getTables(Connection connection) {
        try {
            DatabaseMetaData db = connection.getMetaData();
            ResultSet rs = db.getTables(null, null, null, new String[]{"TABLE"});

            List<String> list = new ArrayList<>();
            while (rs.next()) {
                String tableName = rs.getString(3);
                String remarks = rs.getString(5);

                list.add(tableName);
                log.info("TABLE_NAME: {}, REMARKS: {}", tableName, remarks);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取数据库下的所有表名
     */
    public static List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            //获取数据库的元数据
            assert conn != null;
            DatabaseMetaData db = conn.getMetaData();
            //从元数据中获取到所有的表名
            rs = db.getTables("", "", null, new String[]{"TABLE"});
            while (rs.next()) {
                tableNames.add(rs.getString(3));
            }
        } catch (SQLException e) {
            LOGGER.error("getTableNames failure", e);
        } finally {
            try {
                rs.close();
                closeConnection(conn);
            } catch (SQLException e) {
                LOGGER.error("close ResultSet failure", e);
            }
        }
        return tableNames;
    }

    /**
     * 获取表中所有字段名称
     *
     * @param tableName 表名
     * @return
     */
    public static List<String> getColumnNames(String tableName) {
        List<String> columnNames = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement preparedStatement = null;
        String tableSql = SQL + tableName + " LIMIT 0";
        try {
            preparedStatement = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData resultSetMetaData = preparedStatement.getMetaData();
            //表列数
            int size = resultSetMetaData.getColumnCount();
            for (int i = 0; i < size; i++) {
                log.info("column name: {}", resultSetMetaData.getColumnName(i + 1));
                log.info("column type: {}", resultSetMetaData.getColumnType(i + 1));
                log.info("column type: {}", resultSetMetaData.getColumnTypeName(i + 1));
                log.info("column type: {}", resultSetMetaData.getColumnClassName(i + 1));
                log.info("===============");
                columnNames.add(resultSetMetaData.getColumnName(i + 1));
            }
        } catch (SQLException e) {
            log.error("getColumnNames failure", e);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    log.error("getColumnNames close pstem and connection failure", e);
                }
            }
        }
        return columnNames;
    }


    /**
     * 获取表中所有字段类型
     *
     * @param tableName
     * @return
     */
    public static List<String> getColumnTypes(String tableName) {
        List<String> columnTypes = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        try {
            pStemt = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //表列数
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                columnTypes.add(rsmd.getColumnTypeName(i + 1));
            }
        } catch (SQLException e) {
            LOGGER.error("getColumnTypes failure", e);
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnTypes close pstem and connection failure", e);
                }
            }
        }
        return columnTypes;
    }

    /**
     * 获取表中字段的所有注释
     *
     * @param tableName
     * @return
     */
    public static List<String> getColumnComments(String tableName) {
        List<String> columnTypes = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        List<String> columnComments = new ArrayList<>();//列名注释集合
        ResultSet rs = null;
        try {
            pStemt = conn.prepareStatement(tableSql);
            rs = pStemt.executeQuery("show full columns from " + tableName);
            while (rs.next()) {
                columnComments.add(rs.getString("Comment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnComments close ResultSet and connection failure", e);
                }
            }
        }
        return columnComments;
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        List<String> tables = getTables(connection);
        for (String table : tables) {
            getColumnNames(table);
        }
//        List<String> tableNames = getTableNames();
//        System.out.println("tableNames:" + tableNames);
//        for (String tableName : tableNames) {
//            System.out.println("ColumnNames:" + getColumnNames(tableName));
//            System.out.println("ColumnTypes:" + getColumnTypes(tableName));
//            System.out.println("ColumnComments:" + getColumnComments(tableName));
//        }
    }
}