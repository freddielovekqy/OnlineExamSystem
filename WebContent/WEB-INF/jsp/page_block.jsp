<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%String basePath = request.getContextPath(); %>

<%@page import="com.augmentum.oes.model.Pagination"%>
<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/css/pagination.css" />

<div class="pageDiv">
    <div class="pageLabel">Page</div>
    <div class="pageFieldDiv">
        ${page.currentPage }
        &nbsp;/&nbsp;
        ${page.pageCount }
    </div>
    <div class="pageHref">
        <a href="${page.url }&currentPage=1" class="page">&lt;&lt;</a>
    </div>
    <div class="pageHref">
        <a href="${page.url }&currentPage=${page.currentPage - 1}" class="page">&lt;</a>
    </div>
    <%int pageCount = ((Pagination) request.getAttribute("page")).getPageCount();
      int currentPage = ((Pagination) request.getAttribute("page")).getCurrentPage();%>
    <%
      if (pageCount <= 5) {
          for (int i = 0;i < pageCount;i++) {
    %>
            <div class="pageHref">
              <a href="${page.url }&currentPage=<%=i + 1%>" class="page"><%=i + 1%></a>
            </div>
    <%    }
      } else {
          if (currentPage <= 3) {
              for (int i = 0;i < 5;i++) {%>
                  <div class="pageHref">
                    <a href="${page.url }&currentPage=<%=i + 1%>" class="page"><%=i + 1%></a>
                  </div>
            <%}
          } else if (currentPage + 2 < pageCount) {
              for (int i = currentPage - 2;i < currentPage + 2;i++) {%>
                  <div class="pageHref">
                    <a href="${page.url }&currentPage=<%=i + 1%>" class="page"><%=i + 1%></a>
                  </div>
            <%}
          } else {
              for (int i = pageCount - 5;i < pageCount;i++) {%>
                  <div class="pageHref">
                    <a href="${page.url }&currentPage=<%=i + 1%>" class="page"><%=i + 1%></a>
                  </div>
            <%}
          }
          
      }%>
    <div class="pageHref">
        <a href="${page.url }&currentPage=${page.currentPage + 1}" class="page">&gt;</a>
    </div>
    <div class="pageHref">
        <a href="${page.url }&currentPage=${page.pageCount}" class="page">&gt;&gt;</a>
    </div>
</div>