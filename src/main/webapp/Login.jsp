<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 style="text-align:center">欢迎登录电商后台管理系统</h1>
 <form action="Login.do" method="get">
  <table align="center">
   <tr>
     <td    style="width: 100px;
			  height: 30px;
			  background-color: #FFFFFF ;
			  border: 2px solid #66FFFF  ;
			  border-radius:10%;text-align:center;">用户名：</td>
     <td><input type="text" name="username" 
              style="width: 100px;
			  height: 30px;
			  background-color: #FFFFFF ;
			  border: 2px solid #66FFFF  ;
			  border-radius:10%;"/></td>
   
   </tr>
   
   <tr>
     <td  style="width: 100px;
			  height: 30px;
			  background-color: #FFFFFF ;
			  border: 2px solid #66FFFF  ;
			  border-radius:10%;text-align:center;">密码：</td>
     <td><input type="password" name="password"  style="width: 100px;
			  height: 30px;
			  background-color: #FFFFFF ;
			  border: 2px solid #66FFFF  ;
			  border-radius:10%;"/></td>   
   </tr>
   
   <tr>
      <td><input type="submit" value="登录" 
                style="color: #CC0000;
			    font-size: 20px;"/></td>
      <td><input name="" type="reset" value="重置"  
                style="color: #CC0000;
			    font-size: 20px;"/></td>
   </tr>
   
  </table>
 </form>



</body>
</html>