<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="Do.*,DAO.*,DAO.IPL.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%useDo use=(useDo)request.getSession().getAttribute("use");%>
<p>欢迎  <%=use.getName()%></p>

<a href="goods.jsp">商品首页</a>
 <a href="useMessage.jsp">个人中心</a>
  <a href="Car.jsp">购物车</a>
 <a href="Fileupload.jsp">商品后台操作</a>
</body>
</html>