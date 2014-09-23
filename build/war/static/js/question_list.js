$(function() {
  var questionList = $("table");
  var pageDiv = $("ul");

  var pageNumbers = null;
  var currentPage = $("#currentPage").val();
  var pageCount = "";
  var questionTitle = "";
  var pageSize = "";

  var clearContents = function() {
    questionList.empty();
    pageDiv.empty();
  };

  var pageQuery = function() {
    questionTitle = $("#questionTitle").val();
    pageSize = $("select").val();
    
    var url = "";
    
    if (idSort != "") {
      url = baseUrl + "/question/query?pageSize=" + pageSize + 
              "&currentPage=" + currentPage + "&questionTitle=" + questionTitle + "&sort=id_" + idSort;
    } else if (timeSort != "") {
      url = baseUrl + "/question/query?pageSize=" + pageSize + 
              "&currentPage=" + currentPage + "&questionTitle=" + questionTitle + "&sort=lastUpdateTime_" + timeSort;
    } else {
      url = baseUrl + "/question/query?pageSize=" + pageSize + 
      "&currentPage=" + currentPage + "&questionTitle=" + questionTitle + "&sort=";
    }
    $.getJSON(url, function(data) {
      currentPage = data.currentPage;
      pageNumbers = data.pageNumbers;
      pageCount = data.pageCount;

      $("#currentPage").val(currentPage);
      $(".currentPage").val(currentPage);
      $("#pageCount").html(pageCount);

      

      $.each(data.list, function(index, question) {
        var questionContent = $("<tr />");
        var questionIdTd = $("<td />", {
          "class" : "table_body question_id",
          "title" : question.questionId,
          "html" : question.questionId
        });
        var questionTitleTd = $("<td />", {
          "class" : "table_body question_title",
          "title" : question.questionTitle,
          "html" : question.questionTitle
        });
        var answerTd = $("<td />", {
          "class" : "table_body answer",
          "title" : question.correctAnswer,
          "html" : question.correctAnswer
        });
        var lastUpdateTime = $("<td/>", {
          "class" : "table_body update_time",
          "html" : question.lastUpdateTime
        });
        var optionTd = $("<td />", {
          "class" : "table_body operations",
          "html" : "<a href='" + baseUrl + "/question/edit?id=" + question.id + "'>Edit" +
              "</a>&nbsp;<a question-id='" + question.id + "' class='delete' url='" + baseUrl + "/question/delete/" + question.id + "'>Delete</a>"
        });

        questionContent.append(questionIdTd).append(questionTitleTd).append(answerTd).append(lastUpdateTime).append(optionTd);
        questionList.append(questionContent);
      });

      var firstLi = $("<li />", {
        "html" : "|&lt;"
      });
      var lastLi = $("<li />", {
        "html" : "&lt;"
      });
      var nextLi = $("<li />", {
        "html" : "&gt;"
      });
      var finalLi = $("<li />", {
        "html" : "&gt;|"
      });

      pageDiv.append(firstLi).append(lastLi).append(nextLi).append(finalLi);

      $.each(pageNumbers, function(index, item) {
        if (item == currentPage) {
          nextLi.before("<li class='li_now'>" + item + "</li>");
        } else {
          nextLi.before("<li class='li_other'>" + item + "</li>");
        }
      });
      if (currentPage === 1) {
        firstLi.addClass("li_unallowed");
        lastLi.addClass("li_unallowed");
        if (currentPage === pageCount) {
          nextLi.addClass("li_unallowed");
          finalLi.addClass("li_unallowed");
        } else {
          nextLi.addClass("li_other");
          finalLi.addClass("li_other");
        }

      } else if (currentPage === pageCount) {
        firstLi.addClass("li_other");
        lastLi.addClass("li_other");
        nextLi.addClass("li_unallowed");
        finalLi.addClass("li_unallowed");
      } else {
        firstLi.addClass("li_other");
        lastLi.addClass("li_other");
        nextLi.addClass("li_other");
        finalLi.addClass("li_other");
      }

    });
  };

  $("ul").on("click", "li", function() {
    
    if ($(this).attr("class") === "li_unallowed") {
      return false;
    } 
    
    var operation = $(this).html();
    pageCount = $("#pageCount").html();
    pageSize = $("select").val();

    if (operation === "&lt;") {
      clearContents();
      currentPage = new Number(currentPage) - 1;

      pageQuery();
    } else if (operation === "&gt;") {
      clearContents();
      currentPage = new Number(currentPage) + 1;
      pageQuery();
    } else if (operation === "|&lt;") {
      clearContents();
      currentPage = new Number(1);
      pageQuery();
    } else if (operation === "&gt;|") {
      clearContents();
      currentPage = new Number(pageCount);
      pageQuery();
    } else {
      clearContents();
      currentPage = new Number($(this).html());
      pageQuery();
    }
  });

  $("button").click(function() {
    pageCount = $("#pageCount").html();
    currentPage = $(".currentPage").val();

    if ($(this).html() === "Search") {
      currentPage = new Number(1);
    }

    if (new Number(currentPage) >= 1 && new Number(currentPage) <= pageCount) {
      clearContents();
      pageQuery();
      $("#pageCount").html(pageCount);
    } else {
      $(".currentPage").val($("#currentPage").val());
      return false;
    }

  });

  $("select").change(function() {
    currentPage = new Number(1);
    clearContents();
    pageQuery();
    $("#pageCount").html(pageCount);
  });

  $("#idSortDiv").click(function() {
    clearContents();
    
    var imgSrc = $("#timeSortDiv img").attr("src");
    $("#timeSortDiv").css("color", "#fff");
    timeSort = "";
    if (imgSrc === baseUrl + "/static/images/sort-asc-active.png") {
      $("#timeSortDiv img").attr("src", baseUrl + "/static/images/sort-asc.png");
    } else {
      $("#timeSortDiv img").attr("src", baseUrl + "/static/images/sort-desc.png");
    }
    
    imgSrc = $("#idSortDiv img").attr("src");
    $("#idSortDiv").css("color", "#37DE0A");
    if (imgSrc === baseUrl + "/static/images/sort-asc-active.png" || imgSrc === baseUrl + "/static/images/sort-desc.png") {
      $("#idSortDiv img").attr("src", baseUrl + "/static/images/sort-desc-active.png");
      idSort = "desc";
    } else {
      $("#idSortDiv img").attr("src", baseUrl + "/static/images/sort-asc-active.png");
      idSort = "asc";
    }
    pageQuery();
  });
  
  $("#timeSortDiv").click(function(){
    clearContents();
    var imgSrc = $("#idSortDiv img").attr("src");
    $("#timeSortDiv").css("color", "#37DE0A");
    idSort = "";
    if (imgSrc === baseUrl + "/static/images/sort-asc-active.png") {
      $("#idSortDiv img").attr("src", baseUrl + "/static/images/sort-asc.png");
    } else {
      $("#idSortDiv img").attr("src", baseUrl + "/static/images/sort-desc.png");
    }
    
    imgSrc = $("#timeSortDiv img").attr("src");
    $("#idSortDiv").css("color", "#fff");
    if (imgSrc === baseUrl + "/static/images/sort-asc-active.png" || imgSrc === baseUrl + "/static/images/sort-desc.png") {
      $("#timeSortDiv img").attr("src", baseUrl + "/static/images/sort-desc-active.png");
      timeSort = "desc";
    } else {
      $("#timeSortDiv img").attr("src", baseUrl + "/static/images/sort-asc-active.png");
      timeSort = "asc";
    }
    pageQuery();
  });

  $("table").on("click", "a", function(){
    if ($(this).html() === "Delete") {
      var node = $(this);
      if (confirm("Are you want to delete this question?")) {
        var url = $(this).attr("url");
        $.getJSON(url, function(data) {
        }).done(function(data){
          if (true == data) {
            node.parents("tr").remove();
          }
        });
      }
    }
});

});