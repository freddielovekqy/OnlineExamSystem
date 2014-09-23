<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="f" uri="../oes.tld"%>
<%String basePath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/question.css" />
  <link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/top.css" />
  <title>Create Question</title>
</head>
<body>
  <div class="container">
  <div class="top">
    <f:block name="header"/>
  </div>
  <div class="menu">
    <f:block name="nav"/>
  </div>
  <div class="questionDiv">
  <span class="breadCrumb"><a href="<%=basePath %>/question/view?currentPage=&questionTitle=">Question Management</a> &gt; Create new question</span>
  <form action="<%=basePath %>/question/save" method="post" id="questionForm" class="editQuestionForm">
    <table>
      <tr class="saveQuestionFormTr">
        <td class="saveQuestionFormTd"><b>Question TiTle</b></td>
        <td class="saveQuestionFormTd">
          <textarea rows="6" cols="45" name="questionTitle" id="questionTitle" >${question.questionTitle }</textarea>
        </td>
        <td class="saveQuestionFormTd">
          <span id="questionTitleCheck" class="error">${exceptionMessage.questionTitleException } </span>
        </td>
      </tr>
      <tr class="saveQuestionFormTr">
        <td class="saveQuestionFormTd">
          <c:choose>
            <c:when test="${'A' eq question.answer}">
              <input type="radio" value="A" name="isAnswer" checked="checked"/>
            </c:when>
            <c:otherwise>
              <input type="radio" value="A" name="isAnswer"/>
            </c:otherwise>
          </c:choose>
          <b>Option A</b>
        </td>
        <td class="saveQuestionFormTd">
          <input type="text" name="optionA" id="optionA" value="${question.optionA }" class="optionTextField" /> 
        </td>
        <td class="saveQuestionFormTd">
          <span id="optionACheck" class="error">${exceptionMessage.optionAException } </span>
        </td>
      </tr>
      <tr class="saveQuestionFormTr">
        <td class="saveQuestionFormTd">
          <c:choose>
            <c:when test="${'B' eq question.answer}">
              <input type="radio" value="B" name="isAnswer" checked="checked"/>
            </c:when>
            <c:otherwise>
              <input type="radio" value="B" name="isAnswer" />
            </c:otherwise>
          </c:choose>
          <b>Option B</b>
        </td>
        <td class="saveQuestionFormTd">
          <input type="text" name="optionB" id="optionB" value="${question.optionB }" class="optionTextField" /> 
        </td>
        <td class="saveQuestionFormTd">
          <span id="optionBCheck" class="error">${exceptionMessage.optionBException } </span>
        </td>
      </tr>
      <tr class="saveQuestionFormTr">
        <td class="saveQuestionFormTd">
          <c:choose>
            <c:when test="${'C' eq question.answer}">
              <input type="radio" value="C" name="isAnswer" checked="checked"/>
            </c:when>
            <c:otherwise>
              <input type="radio" value="C" name="isAnswer" />
            </c:otherwise>
          </c:choose>
          <b>Option C</b>
        </td>
        <td class="saveQuestionFormTd">
          <input type="text" name="optionC" id="optionC" value="${question.optionC }" class="optionTextField" /> 
        </td>
        <td class="saveQuestionFormTd">
          <span id="optionCCheck" class="error">${exceptionMessage.optionCException } </span>
        </td>
      </tr>
      <tr class="saveQuestionFormTr">
        <td class="saveQuestionFormTd">
          <c:choose>
            <c:when test="${'D' eq question.answer}">
              <input type="radio" value="D" name="isAnswer" checked="checked"/>
            </c:when>
            <c:otherwise>
              <input type="radio" value="D" name="isAnswer" />
            </c:otherwise>
          </c:choose>
          <b>Option D</b>
        </td>
        <td class="saveQuestionFormTd">
          <input type="text" name="optionD" id="optionD" value="${question.optionD }" class="optionTextField" /> 
        </td>
        <td class="saveQuestionFormTd">
          <span id="optionDCheck" class="error">${exceptionMessage.optionDException } </span>
        </td>
      </tr>
      <tr class="saveQuestionFormTr">
        <td class="saveQuestionFormTd">
          <span id="answerCheck" class="error">
            ${exceptionMessage.answerException }
            <%session.removeAttribute("exceptionMessage"); %>
          </span>
        </td>
        <td class="saveQuestionFormTd">
          <input type="submit" value="Submit" class="submitButton" />
          <input type="button" value="Cancel" class="cancelButton" />
        </td>
      </tr>
    </table>
    <input type="hidden" name="answer" id="answer" value="${question.answer }" />
    <div id="isHasId">
      <input type="hidden" name="id" id="questionId" value="${question.id }" />
    </div>
    
  </form>
  </div>
  </div>
</body>
<script type="text/javascript" src="<%=basePath %>/static/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>/static/js/saveQuestion.js"></script>
</html>