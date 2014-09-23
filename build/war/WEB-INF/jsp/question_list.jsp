<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%String basePath = request.getContextPath(); %>
<!DOCTYPE html>

<%@page import="java.util.List"%>
<%@page import="com.augmentum.oes.model.Question" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/question_list.css" />
  <title>questionList</title>
</head>
<body>
  <div class="container">
    <div class="header">
      <div class="title">Online Exam System</div>
      <div class="user_info">Welcome freddie.wang, <a href="<%=basePath%>/user/logout">Logout</a></div>
    </div>
    
    <div class="content">
      <div class="nav">
        <div><a href="<%=basePath %>/question/view?currentPage=&questionTitle=">Question Management</a></div>
        <div><a href="<%=basePath %>/exam/view?currentPage=&examName=">Exam Management</a></div>
        <div><a href="<%=basePath %>/user/edit">My Profile</a></div>
      </div>
      
      <div class="main">
        <div class="csc">
          <a href="<%=basePath %>/question/view?currentPage=&questionTitle=">Question Management</a> &gt; Question List
          <div class="search">
            Question Title: <input type="text" id="questionTitle">
            <button>Search</button>
            <a href="<%=basePath %>/question/create" class="create">Create Question</a>
          </div>
        </div>
        
        <div class="question_list">
          <div id="idSortDiv" class="table_header question_id">ID<img alt="id" src="<%=basePath %>/static/images/sort-asc.png"> </div>
          <div class="table_header question_title">Question Title</div>
          <div class="table_header answer">Answer</div>
          <div id="timeSortDiv" class="table_header update_time">Update Time <img alt="time" src="<%=basePath %>/static/images/sort-desc.png"></div>
          <div class="table_header operations">Operations</div>
          
          <div class="table_body_div">
          <table cellpadding="0" cellspacing="0">
            <c:choose>
            <c:when test="${empty questionList}">
              <c:out value="No date had found!"></c:out>
            </c:when>
            <c:otherwise>
              <c:forEach var="question" items="${questionList}">
                <tr>
                  <td class="table_body question_id" title="${question.questionId}">
                    <c:out value="${question.questionId}"></c:out>
                  </td>
                  <td class="table_body question_title" title="${question.questionTitle }">
                    <c:out value="${question.questionTitle}"></c:out>
                  </td>
                  <td class="table_body answer" title="${question.correctAnswer }">
                    <c:out value="${question.correctAnswer}"></c:out>
                  </td>
                  <td class="table_body update_time">
                    <c:out value="${question.updateTime}"></c:out>
                  </td>
                  <td class="table_body operations">
                    <a href="<%=basePath %>/question/edit?id=${question.id}">Edit</a>
                    &nbsp;<a url="<%=basePath %>/question/delete/${question.id}" class="delete">Delete</a>
                  </td>
                </tr>
              </c:forEach>
            </c:otherwise>
          </c:choose>
          
          </table>
          </div>
        </div>
        
        <div class="page">
          <span>Total&nbsp;<span id="pageCount">${page.pageCount }</span>&nbsp;Pages</span>
          <div>
            Page 
            <input type="text" name="currentPage" value="${page.currentPage }" class="currentPage"> 
            <button>Goto</button>
          </div>
          <div>
            Page Size 
            <select>
              <option value="10">10</option>
              <option value="15">15</option>
              <option value="20">20</option>
            </select>
          </div>
          
          <ul style="float: right;">
            <li class="li_unallowed">|&lt;</li>
            <li class="li_unallowed">&lt;</li>
            
            <c:forEach items="${page.pageNumbers}" var="item">
              <c:choose>
                <c:when test="${page.currentPage == item}">
                  <li class="li_now"><c:out value="${item}"></c:out> </li>
                </c:when>
                <c:otherwise>
                  <li class="li_other"><c:out value="${item}"></c:out> </li>
                </c:otherwise>
              </c:choose>
            </c:forEach>
            <li class="li_other">&gt;</li>
            <li class="li_other">&gt;|</li>
          </ul>
          <input type="hidden" id="currentPage" value="${page.currentPage }" />
        </div>
      </div>
    </div>
  </div>
  <script src="<%=basePath %>/static/js/jquery-2.1.1.min.js"></script>
  <script src="<%=basePath %>/static/js/question_list.js"></script>
  <script>
    var baseUrl = '<%=basePath %>';
    var idSort = "";
    var timeSort = "";
  </script>
  
</body>
</html>