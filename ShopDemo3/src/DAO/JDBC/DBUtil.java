package DAO.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DAO.IPL.addGoodsDao;
import Do.commodity;

/**
 * 1:使用PreparedStatement接口来执行插入语句
 * 
 * @author biexiansheng
 *
 */
public class DBUtil {
	 static Connection conn=null;
    public static void connect() {
        // TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
            System.out.println("加载数据库驱动成功");
            String url="jdbc:mysql://localhost:3307/shopping";//声明数据库test的url
            String user="root";//数据库用户名
            String password="123456";//数据库密码
            //建立数据库连接，获得连接对象conn
           conn=DriverManager.getConnection(url, user, password);
            System.out.println("连接数据库驱动成功");
            //生成一条SQL语句
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
        
        
        
        
        public  void insert(String s1,String s2,String s3) throws SQLException 
{

        	String sql="INSERT INTO `shopping`.`goods` (`id`, `name`, `price`) VALUES (?, ?, ?);";
      
            PreparedStatement ps=conn.prepareStatement(sql);//创建一个Statement对象
            
            ps.setString(1, s1);
            ps.setString(2, s2);
            ps.setString(3, s3);
            int resultSet=ps.executeUpdate();
            
          
   
            conn.close();//关闭数据库连接对象
            System.out.println("关闭数据库连接对象");
        
    }
        public  void delete(String s1) throws SQLException 
        {

                	String sql="DELETE FROM `shopping`.`goods` WHERE (`id` = ?);";
              
                    PreparedStatement ps=conn.prepareStatement(sql);//创建一个Statement对象
                 
                    ps.setString(1, s1);
      
                    int resultSet=ps.executeUpdate();
                  
           
                    conn.close();//关闭数据库连接对象
                    System.out.println("关闭数据库连接对象");
                
            }
                
        public  void update(String s1,String s2,String s3,String s4) throws SQLException 
        {

                	String sql="UPDATE `shopping`.`goods` SET `id` = ?, `name` = ?, `price` = ? WHERE (`id` = ?);";

                    PreparedStatement ps=conn.prepareStatement(sql);//创建一个Statement对象
                 
                    ps.setString(1, s1);
                    ps.setString(2, s2);
                    ps.setString(3, s3);
                    ps.setString(4, s4); 
      
                    int resultSet=ps.executeUpdate();
                  
           
                    conn.close();//关闭数据库连接对象
                    System.out.println("关闭数据库连接对象");
                
            }
                
        
        
}




