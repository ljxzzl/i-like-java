package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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
 * Servlet implementation class addCarServlet
 */
@WebServlet("/addCarServlet")
public class addCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	addGoodsDao dao = new addGoodsDao();
	List<commodity> list = dao.getGoods();

	static List<commodity> ad = new ArrayList();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");// 户名
		System.out.println(name);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("商品名" + list.get(i).getSize());
			if (name.trim().equals(list.get(i).getSize().trim())) {

				System.out.println("zheshi" + list.get(i).getSize());

			ad.add((list.get(i)));
			}

		}

		
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
	HttpSession session = request.getSession();

	session.setAttribute("goods",ad);
   
request.getRequestDispatcher("/Car.jsp").forward(request,response);

}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
