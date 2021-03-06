package cn.OnlineTestSystem.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @ClassName DataSourceUtils
 * @Desciption TODO
 * @Author shangjin
 * @Date 2019-11-28 21:26
 * @Version 1.0
 **/
public class DataSourceUtils {
    private static DataSource dataSource = new ComboPooledDataSource();
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    public static DataSource getDataSource() {
        System.out.println("getdatasource");
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        Connection con = tl.get();
        if (con == null) {
            con = dataSource.getConnection();
            tl.set(con);
        }
        return con;
    }

    public static void startTransaction() throws SQLException {
        Connection con = getConnection();
        if (con != null) {
            con.setAutoCommit(false);
        }
    }

    public static void releaseAndCloseConnection() throws SQLException {
        Connection con = getConnection();
        if (con != null) {
            con.commit();
            tl.remove();
            con.close();
        }
    }

    public static void rollback() throws SQLException {
        Connection con = getConnection();
        if (con != null) {
            con.rollback();
        }
    }
}
