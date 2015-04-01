<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="base.jsp" %>
    <%@ include file="navigation.jsp" %>
    <link href="${basedir}/resources/css/about.css" rel="stylesheet" type="text/css">
    <script src="${basedir}/resources/js/about.js"></script>
</head>

<body id="container">
<div class="container">
    <div class="row">
        <div class="col-xs-10 col-sm-10 col-md-8 col-lg-8 col-xs-offset-1 col-sm-offset-1 col-md-offset-2 col-lg-offset-2 ">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h4>About</h4>
                </div>
                <div class="container-fluid">
                    <div class=" col-md-10 col-lg-10 col-md-offset-1 col-md-offset-1 ">
                        <h4>Coding Practice</h4>

                        <p>If you want to build skill in running, what do you do? You run.
                            To build skill in method code, write methods. Ok, that's pretty obvious, but with this site,
                            we are trying to create an environment where people can concentrate on the coding with
                            nothing else
                            to get in the way. With all the surrounding structure taken care of, you can get a lot of
                            coding
                            practice done in just an hour or two.
                            JExercises is just about lots of little problems to provide opportunity to practice.
                            We also like the way you can get immediate, positive feedback. It's a simple mechanism!
                        </p>

                        <hr class="line"/>
                        <h4>Suggestions</h4>

                        <p>If you have any thoughts or suggestions about this server,
                            please don't hesitate to email</p>
                        <hr class="line"/>
                        <div class="form-group">
                            <ul class="pager">
                                <li id="btnteam"><a href="#">Contacts</a></li>
                            </ul>
                        </div>
                        <div class="content row">
                            <table class="table" id="table">
                                <tbody>
                                <tr>
                                    <td><img class="img-circle img-resize"
                                             src="${basedir}/resources/images/no-avatar.png"/></td>
                                    <td><p>Taras Vuyiv <br/> mail:<a
                                            href=""> taras.vuyiv@gmail.com</a>
                                    </p></td>
                                </tr>
                                <tr>
                                    <td><img class="img-circle img-resize"
                                             src="${basedir}/resources/images/no-avatar.png"/></td>
                                    <td><p>Oksana Senchuk <br/> mail:<a
                                            href=""> senchuk.oksana@gmail.com</a>
                                    </p></td>
                                </tr>
                                <tr>
                                    <td><img class="img-circle img-resize"
                                             src="${basedir}/resources/images/no-avatar.png"/></td>
                                    <td><p>Volodymur Lishchynskiy <br/> mail:<a
                                            href=""> Lishchynskiy94@gmail.com</a>
                                    </p></td>
                                </tr>
                                <tr>
                                    <td><img class="img-circle img-resize"
                                             src="${basedir}/resources/images/no-avatar.png"/></td>
                                    <td><p>Volodymyr Yakymiv <br/> mail:<a
                                            href=""> v.yakumiv@gmail.com</a>
                                    </p></td>
                                </tr>
                                <tr>
                                    <td><img class="img-circle img-resize"
                                             src="${basedir}/resources/images/no-avatar.png"/></td>
                                    <td><p>Dmytro Kucheryavenko<br/> mail:<a
                                            href=""> kucheryavenko.dmtr@gmail.com</a>
                                    </p></td>
                                </tr>
                                <tr>
                                    <td><img class="img-circle img-resize"
                                             src="${basedir}/resources/images/no-avatar.png"/></td>
                                    <td><p>Ihor Demkovych <br/> mail:<a
                                            href=""> demkovych.ihor@gmail.com</a>
                                    </p></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
