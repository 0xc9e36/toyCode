package pers.tan.database;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * DB class
 *
 * @author tanwei
 * @date 17-11-19
 */
public class DB {
    private static Properties info = null;
    private static String driverUrl = null;
    private static String user = null;
    private static String password = null;
    private static String driverClass = null;

    {
        try {
            InputStream in = getClass().getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(in);

            driverClass = properties.getProperty("driverClass");
            driverUrl = properties.getProperty("driverUrl");
            user = properties.getProperty("user");
            password = properties.getProperty("password");


            info = new Properties();
            info.put("user", user);
            info.put("password", password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 直接通过驱动获取数据库连接
     * @return
     * @throws Exception
     */
    public Connection getConnectByDriver() throws Exception {

        Driver driver = (Driver) Class.forName(driverClass).newInstance();
        Connection connection = driver.connect(driverUrl, info);

        return connection;
    }

    /**
     * 通过DriverManager获取数据库连接
     * @return
     * @throws Exception
     */
    public Connection getConnect() throws Exception {
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(driverUrl,user, password);
        return connection;
    }

    /**
     * 插入100条记录
     */
    public void insert() {
        Statement statement = null;

        try {
            statement = getConnect().createStatement();
            long start = System.currentTimeMillis();
            for(int i = 1; i <= 100; ++i) {
                String sql = "INSERT INTO hero VALUES(null, '英雄'," + i + ", " + i + ")";
                statement.execute(sql);
            }
            long end = System.currentTimeMillis();
            System.out.println("插入100条sql耗时" + (end - start) / 1000 + "s");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
