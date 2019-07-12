<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <title>文件上传</title>
</head>
<body>
  <form action="FileUploadServlet" method="post" enctype="multipart/form-data">
      
  商品id <td><input type="text" name="name" size="20" value=""/></td><br>
  商品名称<td><input type="text" name="price" size="20"  value=""/></td><br>
  商品价格 <td><input type="text" name="image" size="20" value=""/></td><br>
         文件1：<input type="file" name="f1"><br>
         文件2：<input type="file" name="f2"><br>
        <input type="submit" value="提交">
    </form>
     <a href="goods.jsp">商品首页</a>
 </body>
 </html>