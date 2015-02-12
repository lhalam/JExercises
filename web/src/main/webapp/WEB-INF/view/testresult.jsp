<%--
  User: Volodymyr Lishchynskiy
  Date: 12.02.15
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<%@include file="base.jsp" %>
<%@include file="navigation.jsp" %>
<body>
<div class="row-fluid" style="margin-top: 60px;">
    <div class="col-md-4 col-md-offset-4">
        <form class="panel panel-primary">
            <div class="container-fluid">
                
                    <h3> User: </h3>

                    <h3> Test: </h3>

                    <h3> Date: </h3>
                
                <hr class="colorgraph">

                <h3> Test result is </h3>
            </div>
        </form>
    </div>
</div>
<div class="row-fluid" id="testresult">
    <div class="col-md-8 col-md-offset-2" style="padding: 60">
        <form class="panel panel-primary">

            <div class="table-responsive">
                <table class="table table-bordered">
                    <tr class="row">
                        <td class="field-label col-md-2 active">
                            <label>Number</label>
                        </td>
                        <td class="col-md-8">
                            Question
                        </td>
                        <td class="col-md-2">
                            Result
                        </td>
                    </tr>
                    <tr class="row">
                        <td class="field-label col-md-2 active">
                            <label>1</label>
                        </td>
                        <td class="col-md-8">
                            Question bla-bla-bla
                        </td>
                        <td class="col-md-2">
                            Correct
                        </td>
                    </tr>
                    <tr class="row">
                        <td class="field-label col-md-2 active">
                            <label>2</label>
                        </td>
                        <td class="col-md-8">
                            Bla-bla-bla question
                        </td>
                        <td class="col-md-2">
                            Incorrect
                        </td>
                    </tr>
                </table>
            </div>

        </form>
    </div>
</div>
<div class="row-fluid" id="testresultprivate" style="padding: 60px">
    <div class="col-md-4 col-md-offset-4">
        <form class="panel panel-primary">
            <h3 style="text-align: center"> Thank you for complete test ! </h3>
        </form>
    </div>
</div>
</body>
</html>
