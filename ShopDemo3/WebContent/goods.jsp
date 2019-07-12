<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="Do.*,DAO.*,DAO.IPL.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看商品</title>
</head>
<body>
<% 
addGoodsDao dao=new addGoodsDao();
List<commodity> list=dao.getGoods();
 %>
   <table>
    <tr>
    <th>id</th>
    <th>名字</th>
    <th>价格</th>
    </tr>
    <%for(int i = 0;i < list.size();i++){
     %> 
     <tr>
     <td><%=list.get(i).getSize()%></td>
     <td><%=list.get(i).getPrice()%></td>
    <td><%=list.get(i).getImage()%></td> </tr>
   <td> <a href="addCarServlet?name= <%=list.get(i).getSize()%>">加入购物车</a>
   </td>
    <td> <a href="deleteServlet?name= <%=list.get(i).getSize()%>">删除</a>
   </td>
    <td> <a href="update.jsp?name= <%=list.get(i).getSize()%>">更改属性</a>
   </td>
     <%} %>
    </table>
    
  
</body>
</html>