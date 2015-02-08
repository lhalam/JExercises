<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta charset="utf-8">
<title>JExercises</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="JExercises UI">
<meta name="author" content="Lv-137.|Java">
<link href="../../resources/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="../../resources/css/bootstrap-theme.css" rel="stylesheet" type="text/css">
<link href="../../resources/css/style.css" rel="stylesheet"
	type="text/css">
<link href="../resources/css/bootstrap-responsive.css" rel="stylesheet"
	type="text/css">
<link rel="shortcut icon" href="ss-logo.png">
<script src="../../resources/js/jquery-2.1.3.js" type="text/javascript"></script>
<script src="../../resources/js/bootstrap.js" type="text/javascript"></script>
</head>
<body id="container">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" aria-expanded="true">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">JExercises</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
     
      
      
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Type to search">
        </div>
        <button type="button" class="btn btn-default">Search</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="btn" aria-expanded="false">Entity <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="btn" aria-expanded="false">Entity field <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
          </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="btn" aria-expanded="false">Sirb by <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#"> Up </a></li>
            <li><a href="#">Down</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</body>
</html>