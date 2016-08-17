<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<title><fmt:message key="pages.title"/></title>
	<!-- Bootstrap -->
    <link href="<%=request.getContextPath()%>/web/css/bootstrap.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/web/css/englin.css" rel="stylesheet">
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!-- Fixed navbar -->
    <nav class="navbar navbar-custom navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">Englin</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=request.getContextPath()%>/index.jsp"><fmt:message key="navbar.home"/></a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><fmt:message key="navbar.rememberit"/><span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="<%=request.getContextPath()%>/rit-eng-pt.jsp"><fmt:message key="navbar.rememberit.eng_to_pt"/></a></li>
                <li><a href="#"><fmt:message key="navbar.rememberit.pt_to_eng"/></a></li>
              </ul>
            </li>
            <li><a href="#"><fmt:message key="navbar.commas"/></a></li>
            <li><a href="#"><fmt:message key="navbar.prepositions"/></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/web/js/bootstrap.min.js"></script>
</body>

<!--
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.0/jquery.min.js"></script>
-->
</html>