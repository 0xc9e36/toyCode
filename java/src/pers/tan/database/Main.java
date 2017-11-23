package pers.tan.database;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Main class
 *
 * @author tanwei
 * @date 17-11-19
 */
public class Main {
    public static void main(String[] args) {
        //获取数据库连接
        DB db = new DB();
        Connection connection = null;
        try {
            //connection = db.getConnectByDriver();
            connection = db.getConnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //插入100条记录
        db.insert();

        //释放连接
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

