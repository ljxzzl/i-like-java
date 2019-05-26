<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="Do.*,DAO.*,DAO.IPL.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
</head>
<body>
<form action="addGoodsServlet" method="post">
 
 商品名称 <td><input type="text" name="name" size="20" value=""/></td><br>
  商品价格<td><input type="text" name="price" size="20"  value=""/></td><br>
  商品图片 <td><input type="text" name="image" size="20" value=""/></td><br>
<input type="submit"  name="that" value="提交">  
 </form> 
 <a href="goods.jsp">商品首页</a>
</body>
</html>