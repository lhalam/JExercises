<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <%@ include file="../base.jsp" %>
    <%@ include file="../navigation.jsp" %>
    <link href="${basedir}/resources/css/profile.cssjquery.Jcrop.min.css"
          rel="stylesheet"
          type="text/css">
    <link href="${basedir}/resources/css/editprofile.css"
          rel="stylesheet"
          type="text/css">
    <script src="${basedir}/resources/js/editprofile.js"></script>

    <script src="${basedir}/resources/js/uploader/define-FileAPI.js"></script>
    <script src="${basedir}/resources/js/uploader/FileAPI.min.js"></script>
    <script src="${basedir}/resources/js/uploader/FileAPI.exif.js"></script>
    <script src="${basedir}/resources/js/uploader/jquery.fileapi.js"></script>
    <script src="${basedir}/resources/js/uploader/jquery.Jcrop.min.js"></script>
    <script src="${basedir}/resources/js/uploader/upload-avatar.js"></script>
</head>

<body id="container">
<div class="container">
    <div class="row">
        <div class="col-md-5">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Account Settings </h3>
                </div>
                <div class="panel-body">

                    <div class="success-alert" id="successAlert">
                        <div class="alert alert-success alert-dismissible">
                            <button type="button" class="close"
                                    >&times;</button>
                            Your settings have been updated!
                        </div>
                    </div>
                    <form method="post"
                          id="editProfileForm"
                          class="form-horizontal">

                        <fieldset>

                            <div class="form-group ">
                                <label for="email"
                                       class="col-lg-4 control-label">First
                                    Name</label>

                                <div class="col-lg-8">
                                    <input id="firstName" class="form-control"
                                           placeholder="First Name"
                                           value="${userFirstName}"
                                           name="firstName"
                                           type="text">
                                </div>
                            </div>


                            <div class="form-group ">
                                <label for="email"
                                       class="col-lg-4 control-label">Last
                                    Name</label>

                                <div class="col-lg-8">
                                    <input id="lastName" class="form-control"
                                           placeholder="Last Name"
                                           value="${userLastName}"
                                           name="lastName"
                                           type="text">
                                </div>
                            </div>

                            <div class="form-group ">
                                <label for="email"
                                       class="col-lg-4 control-label">Email</label>

                                <div class="col-lg-8">
                                    <input class="form-control"
                                           placeholder="${userEmail}"
                                           disabled="true"
                                           name="email"
                                           type="text"
                                           id="email">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-4 control-label">Profile
                                    Picture</label>

                                <div class="col-lg-8">
                                    <input type="hidden" id="avatar-hidden"
                                           name="avatar" value="">

                                    <div id="upload-avatar"
                                         class="upload-avatar">
                                        <div class="userpic">
                                            <div class="js-preview userpic__preview"></div>
                                        </div>
                                        <div class="btn btn-sm btn-success js-fileapi-wrapper">
                                            <div class="js-browse">
                                                <span class="btn-txt">Choose</span>
                                                <input type="file"
                                                       name="filedata">
                                            </div>
                                            <div class="js-upload uploading-progress">
                                                <div class="progress progress-success">
                                                    <div class="js-progress bar"></div>
                                                </div>
                                                <span class="btn-txt">Uploading</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="form-group ">
                                <label for="password"
                                       class="col-lg-4 control-label">Password</label>

                                <div class="col-lg-8">
                                    <input class="form-control"
                                           id="password"
                                           placeholder="New Password"
                                           name="password"
                                           type="password">
                                </div>
                            </div>

                            <div class="form-group ">
                                <label for="matchingPassword"
                                       class="col-lg-4 control-label">Confirm
                                    Password</label>

                                <div class="col-lg-8">
                                    <input class="form-control"
                                           id="matchingPassword"
                                           placeholder="Confirm Password"
                                           type="password"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-lg-offset-7 col-lg-12">
                                    <a href="../profile"
                                       class="btn btn-default btn-sm"
                                       type="button">Cancel</a>
                                    <input class="btn btn-info"
                                           id="submitButton"
                                           type="button"
                                           value="Update">
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>

        <div class="col-md-7">
            <div class="cropper-prev" id="cropper-preview">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title"> Crop the picture </h3>
                    </div>
                    <div class="panel-body">
                        <div class="js-img"></div>
                        <p>

                        <div class="js-upload btn btn-primary">Upload</div>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="hidden-attribute" basedir="${basedir}"></div>
</div>

</body>
</html>