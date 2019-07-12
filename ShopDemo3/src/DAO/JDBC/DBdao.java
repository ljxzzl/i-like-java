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
public class DBdao {
	static Connection con = null;

	public static void connect() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载数据库驱动
			System.out.println("加载数据库驱动成功");
			String url = "jdbc:mysql://localhost:3307/shopping";// 声明数据库test的url
			String user = "root";// 数据库用户名
			String password = "123456";// 数据库密码
			// 建立数据库连接，获得连接对象conn
		    con = DriverManager.getConnection(url, user, password);
			System.out.println("连接数据库驱动成功");
		    String sql="SELECT * FROM shopping.goods;";
            PreparedStatement ps=con.prepareStatement(sql);//创建一个Statement对象
            ResultSet resultSet=ps.executeQuery();
            List list=new ArrayList();
            while(resultSet.next())
            {
            	commodity goods=new commodity(resultSet.getString(1),resultSet.getString(2), resultSet.getString(3));
                
                list.add(goods);
            }
            
            

        	addGoodsDao list1= new addGoodsDao();
            
            list1.setGoods(list);
            
			// 生成一条SQL语句

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void close() throws SQLException {
		con.close();// 关闭数据库连接对象
		System.out.println("关闭数据库连接对象");

	}

}