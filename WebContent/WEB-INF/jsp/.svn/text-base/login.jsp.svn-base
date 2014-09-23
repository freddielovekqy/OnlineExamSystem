<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <%String basePath = request.getContextPath(); %>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/top.css" />
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/login.css" />
  <title>Login</title>
</head>
<body bgcolor="#cdcdcd">
  <div class="container">
  <div class="top">
    <div class="log">
      <font size="30px" color="#fff" >Online Exam System</font>
    </div>
    <div class="userDiv">
      Please <a href="" class="logout">login</a>
    </div>
  </div>
  <div class="login">
    <h3 class="welcome">Welcome</h3>
    <form action="<%=basePath %>/user/loginCheck" method="post">
      <table>
        <tr>
          <td align="right"><font size="4">UserName</font>&nbsp;&nbsp;</td>
          <td><input type="text" name="userName" class="td" value="${userName }" /></td>
          <td></td>
        </tr>
        <tr>
          <td align="right"><font size="4">Password</font>&nbsp;&nbsp;</td>
          <td><input type="password" name="password" class="td" /></td>
          <td></td>
        </tr>
        <tr>
          <td></td>
          <td><c:out value="${error }"></c:out></td>
        </tr>
        <tr>
          <td></td>
          <td>
            <input type="submit" value="Login" class="submit_button" />&nbsp;&nbsp;
            <input type="reset" value="Reset" class="cancel_button" />
          </td>
        </tr>
      </table>
    </form>
  </div>
  </div>
</body>
</html>