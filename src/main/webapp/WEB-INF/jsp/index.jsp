<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

    <title>Quiz</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div role="navigation">
    <div class="navbar navbar-inverse">
        <a href="/" class="navbar-brand">Quiz</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="new-question">Add new Question</a></li>
                <li><a href="quiz">All questions</a></li>
            </ul>
        </div>
    </div>
</div>

<c:choose>
    <c:when test="${mode == 'MODE_HOME'}">
        <div class="container invisible-at-first" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Questions List</h1>
            </div>
        </div>
    </c:when>

    <c:when test="${mode == 'MODE_SUCCESS'}">
        Successfully submitted quiz
    </c:when>

    <c:when test="${mode == 'MODE_QESTIONS'}">
        <div class="container text-center" id="questionsDiv">
            <h3>Quiz</h3>
            <hr>
            <div class="table-responsive">
                <form:form modelAttribute="submissionDTO" method="POST" action="/quiz">
                    Vardas <input type="text" name="firstName">
                    Pavarde <input type="text" name="lastName">
                    <table class="table table-striped table-bordered text-left">
                        <thead>
                        <tr>
                            <th>Id</th>
                            <th>Question</th>
                            <th>Answer</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="element" items="${elements}">
                            <tr>
                                <td>${element.question.id}</td>
                                <td>${element.question.questionText}</td>
                                <td>
                                    <c:if test="${element.question.type=='RADIO'}">

                                        <c:forEach var="answer" items="${element.answers}">
                                            <input type="radio" name="answer" value="${answer}">
                                            <form:label path="answer">${answer}</form:label>
                                        </c:forEach>

                                    </c:if>
                                    <c:if test="${element.question.type=='SELECT'}">
                                        <select name="item">
                                            <c:forEach var="answer" items="${element.answers}">
                                                <option value="1">${answer}</option>
                                            </c:forEach>
                                        </select>
                                    </c:if>
                                    <c:if test="${element.question.type=='CHECK'}">
                                        <c:forEach var="answer" items="${element.answers}">
                                            <input type="checkbox" name="id"> ${answer} <BR>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${element.question.type=='INPUT'}">
                                        <input type="text" name="name">
                                    </c:if>

                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <input type="submit" class="btn btn-primary" value="Submit">
                </form:form>
            </div>
        </div>
    </c:when>

    <c:when test="${mode == 'MODE_NEW' || MODE_EDIT}">
        <div class="container text-center">
            <h3>Create new question</h3>
            <hr/>
            <form class="form-horizontal" method="POST" action="save-question">
                <input type="hidden" name="id" value="${question.id}">
                <div class="form-group">
                    <label class="control-label col-md-3">Question</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="questionText" value="${question.question}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-3">Question type</label>
                    <div class="col-md-7">
                        <input type="text" class="form-control" name="type" value="${question.type}"/>
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Save"/>
                </div>
            </form>
        </div>
    </c:when>
</c:choose>

<script src="static/js/jquery-1.11.1.min.js"></script>
<script src="static/js/bootstrap.min.js"></script>
</body>
</html>