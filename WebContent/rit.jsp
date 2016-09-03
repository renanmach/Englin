<%@page import="constants.Constants"%>
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
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/web/css/jquery.modal.css" type="text/css" media="screen" />
         
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
 	 <!-- Modal HTML embedded directly into document. It is displayed when the RememberIt finished -->
	  <div id="modal" style="display:none;">
	    <p align="center">Finished RemembertIt!<br><a href="#" rel="modal:close">Close</a> or press ESC to go to the RememberIt initial page.</p>
	  </div>

	<!-- Fixed navbar -->
    <nav class="navbar navbar-custom navbar-fixed-top">
      <div class="container">
        <div class="navbar-header" align="center">
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
            <li><a href="<%=request.getContextPath()%>/index.jsp"><fmt:message key="navbar.home"/></a></li>
            <li class="active"><a href="<%=request.getContextPath()%>/rememberit.jsp"><fmt:message key="navbar.rememberit"/></a></li>
            <li><a href="#"><fmt:message key="navbar.commas"/></a></li>
            <li><a href="#"><fmt:message key="navbar.prepositions"/></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    

     <div id="temp" class="container" >
		<div class="center-menu" align="center">
			<form method="post" onsubmit="nextWord(); return false;">
			<!-- Progress div -->
			<div class="row" align="right" style="padding-right:20px;">
				<div class="text-input progress selected-border"> 
					<span class="middle-text" id="progress_div">
						<span id="current_word">0</span>/<%=request.getSession().getAttribute(Constants.SESSION_NUM_WORDS)%>
					</span>
				</div>
			</div>
			<div class="row center">
				<h2><b><fmt:message key="rit.just_rememberit"/></b></h2>
			</div>
			
			<div class="row" style="padding-top:20px;">	
				<!-- Left text box -->
				<div class="col-lg-1 text-input col-lg-offset-2" id="left_box">
					<span class="middle-text" id="text-input1"></span>
				</div>
				
				<div class="col-sm-1" style="color: #6b0000;">
					<h1><b>></b></h1>
				</div>
				
				<!-- Right text box -->
				<div class="col-lg-1 text-input" id="right_box">
					<span class="middle-text" id="text-input2"></span>
				</div>
			</div>	
			
			<div class="row" style="padding-top:20px;">	
				<div class="col-lg-1 col-lg-offset-9">
					<input class="btn btn-md btn-danger" style="width:120px" id="translate_button" type="submit" value="Next">
				</div>
			</div>
			</form>
	    </div>
    </div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="<%=request.getContextPath()%>/web/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/web/js/bootstrap.min.js"></script>
    <!-- for the dialog box  -->
    <script src="<%=request.getContextPath()%>/web/js/jquery.modal.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/web/js/englin.js"></script>
</body>
</html>