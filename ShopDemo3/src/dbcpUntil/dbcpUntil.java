package dbcpUntil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 * DBCP配置类
 * @author SUN
 */
public class dbcpUntil {
 private static DataSource dataSource;
    //加载DBCP配置文件
    static{
        try{
        // java application project
 FileInputStream is = new FileInputStream("config/dbcp.properties");  
//Web project
//InputStream is = null;//???
Properties properties = new Properties();
            properties.load(is);
        }catch(IOException e){
            e.printStackTrace();
        }

        try{
  Properties properties = null;
dataSource = BasicDataSourceFactory.createDataSource(properties);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //从连接池中获取一个连接
    public static Connection getConnection(){
        Connection connection = null;
        try{
connection = dataSource.getConnection();
        }catch(SQLException e){
            e.printStackTrace();
        }
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}