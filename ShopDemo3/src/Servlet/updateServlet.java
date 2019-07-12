package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.IPL.addGoodsDao;
import DAO.JDBC.DBUtil;
import Do.commodity;

/**
 * Servlet implementation class addGoodsServlet
 */
@WebServlet("/updateServlet ")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	addGoodsDao list1= new addGoodsDao();
/**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String one = request.getParameter("name");//户名
		System.out.println(one);
		String id = request.getParameter("id");//户名
		System.out.println(id);
		String moincker = request.getParameter("moincker");//户名
		System.out.println(moincker);
		String price = request.getParameter("price");//户名
		System.out.println(price);
		DBUtil db=new DBUtil();
		db.connect();
		try {
			db.update(one, id, moincker, price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.getRequestDispatcher("addGoods.jsp").forward(request, response);
			
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
