package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.IPL.addGoodsDao;
import Do.commodity;

/**
 * Servlet implementation class addGoodsServlet
 */
@WebServlet("/addGoodsServlet")
public class addGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addGoodsServlet() {
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
		String two= request.getParameter("price");//密码
		System.out.println(two);
		String image= request.getParameter("image");//密码
		System.out.println(image);
		commodity goods = new commodity(one, two, image);
		 List list =new ArrayList();
		 list.add(goods );
		addGoodsDao list1= new addGoodsDao();
	     list1.setGoods(list);
		HttpSession session = request.getSession();
		session.setAttribute("goods",list1);
		 
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
