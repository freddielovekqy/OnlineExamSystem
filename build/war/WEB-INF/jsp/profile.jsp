<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="f" uri="../oes.tld"%>
<!DOCTYPE>

<%@page import="com.augmentum.oes.model.User"%><html>
<head>
  <%String basePath = request.getContextPath(); %>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/top.css" />
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/profile.css" />
  <title>My profile</title>
</head>
<body>
  <div class="container">
  <div class="top">
    <f:block name="header"/>
  </div>
  <div class="menu">
    <f:block name="nav"/>
  </div>
  <div class="profileDiv">
    <span class="breadCrumb">My Profile &gt; Edit Profile</span>
    <form action="<%=basePath %>/user/update" id="form" method="post" class="editProfile">
      <table>
        <tr>
          <td class="labelTd"><b>UserName</b></td>
          <td class="td"><%=((User)session.getAttribute("user")).getUserName() %></td>
        </tr>
        <tr>
          <td class="labelTd"><b>Full Name</b></td>
          <td class="td"><input type="text" name="fullName" id="fullName" value="${user.fullName }" class="textField"/> </td>
          <td><span id="fullNameCheck" class="error">${exceptionMessage.fullName }</span></td>
        </tr>
        <tr>
          <td class="labelTd"><b>Role Type</b></td>
          <td class="td">${user.roleName }</td>
        </tr>
        <tr>
          <td class="labelTd"><b>Telephone</b></td>
          <td class="td"><input type="text" name="telephone" id="telephone" value="${user.telephone }" class="textField" > </td>
          <td><span id="telephoneCheck" class="error">${exceptionMessage.telephone }</span></td>
        </tr>
        <tr>
          <td class="labelTd"><b>Email</b></td>
          <td class="td"><input type="text" name="email" id="email" value="${user.email }" class="textField" > </td>
          <td><span id="emailCheck" class="error">${exceptionMessage.email }</span></td>
          <%session.removeAttribute("exceptionMessage"); %>
        </tr>
        <tr>
          <td class="labelTd"><b>Gender</b></td>
          <td class="td">
            <c:choose>
              <c:when test="${user.gender == 'male'}">
                <input type="radio" name="gender1" value="male" checked="checked" />Male
                <input type="radio" name="gender1" value="female" />Female
              </c:when>
              <c:otherwise>
                <input type="radio" name="gender1" value="male" />Male
                <input type="radio" name="gender1" value="female" checked="checked" />Female
              </c:otherwise>
            </c:choose>
          </td>
        </tr>
        <tr>
          <td>
            <input type="hidden" name="id" value="${user.id }">
            <input type="hidden" name="gender" id="gender" value=""/>
          </td>
          <td>
            <input type="submit" value="Submit" id="save" class="submitButton" />
            <input type="button" value="Cancel" class="cancelButton" />
          </td>
        </tr>
      </table>
    </form>
    </div>
  </div>
</body>
<script type="text/javascript" src="<%=basePath %>/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/profile.js"></script>
</html>