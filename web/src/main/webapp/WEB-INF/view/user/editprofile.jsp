<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../base.jsp" %>
    <%@ include file="../navigation.jsp" %>
    <link href="${basedir}/resources/css/jquery.Jcrop.css"
          rel="stylesheet"
          type="text/css">
    <link href="${basedir}/resources/css/editprofile.css"
          rel="stylesheet"
          type="text/css">
    <script src="${basedir}/resources/js/uploader/define-FileAPI.js"></script>
    <script src="${basedir}/resources/js/uploader/FileAPI.min.js"></script>
    <script src="${basedir}/resources/js/uploader/FileAPI.exif.js"></script>
    <script src="${basedir}/resources/js/uploader/jquery.fileapi.js"></script>
    <script src="${basedir}/resources/js/uploader/jquery.Jcrop.min.js"></script>
    <script src="${basedir}/resources/js/uploader/upload-avatar.js"></script>
    <script src="${basedir}/resources/js/lib/jquery.validate.min.js"></script>
    <script src="${basedir}/resources/js/editprofile.js"></script>
</head>

<c:choose>
    <c:when test="${currentUser}">
        <c:set var="postUrl" value="${basedir}/user/profile/" scope="request"/>
        <c:set var="disabled" value="" scope="request"/>
        <c:set var="hiddenInput" value="" scope="request"/>
    </c:when>
    <c:otherwise>
        <c:set var="postUrl" value="${basedir}/user/profile/${userId}/"
               scope="request"/>
        <c:set var="disabled" value="disabled" scope="request"/>
        <c:set var="hiddenInput" value="hidden" scope="request"/>
    </c:otherwise>
</c:choose>

<c:choose>
    <c:when test="${hasAvatar}">
        <c:set var="buttonHidden" value="" scope="request"/>
        <c:set var="margin" value="custom-margin" scope="request"/>
    </c:when>
    <c:otherwise>
        <c:set var="buttonHidden" value="hidden" scope="request"/>
        <c:set var="margin" value="" scope="request"/>
    </c:otherwise>
</c:choose>

<fmt:formatDate var="birthDay" value="${userBirthDate}" pattern='dd'/>
<fmt:formatDate var="birthMonth" value='${userBirthDate}' pattern='MMM'/>
<fmt:formatDate var="birthYear" value='${userBirthDate}' pattern='yyyy'/>

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

        <div class="alert alert-danger alert-dismissible" id="dangerAlert">
            <button id="dangerAlertClose" type="button" class="close"
                    >&times;</button>
            <span id="errorMessage"></span>
        </div>

<form method="post"
      id="editProfileForm"
      class="form-horizontal">

    <fieldset>

        <div class="form-group has-feedback ${hiddenInput}">
            <label for="email"
                   class="col-lg-4 control-label">First
                Name</label>

            <div class="col-lg-8">
                <input id="firstName" class="form-control"
                       placeholder="First Name"
                       value="${userFirstName}"
                       name="firstName"
                       type="text">
                <span class="glyphicon form-control-feedback"
                      id="firstNameFeedback"></span>
            </div>
        </div>


        <div class="form-group has-feedback ${hiddenInput}">
            <label for="email"
                   class="col-lg-4 control-label">Last
                Name</label>

            <div class="col-lg-8">
                <input id="lastName" class="form-control"
                       placeholder="Last Name"
                       value="${userLastName}"
                       name="lastName"
                       type="text">
                <span class="glyphicon form-control-feedback"
                      id="lastNameFeedback"></span>
            </div>
        </div>

        <div class="form-group ${hiddenInput}">
            <label for="email"
                   class="col-lg-4 control-label">Email</label>

            <div class="col-lg-8">
                <input class="form-control"
                       placeholder="${userEmail}"
                       disabled
                       name="email"
                       type="text"
                       id="email">
            </div>
        </div>

        <div id="avatarFormGroup" class="form-group ${margin}">
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
                    <div class="btn btn-sm btn-success js-fileapi-wrapper ${disabled}">
                        <div class="js-browse">
                            <span class="btn-txt">Choose</span>
                            <input class="ignore" type="file"
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
        <div class="row">
            <div class="col-lg-3 col-lg-offset-4">
                <div id="deleteAvatar" class="btn btn-xs btn-danger btn-delete ${buttonHidden}">
                    Delete</div>
            </div>
        </div>
        <div class="form-group has-feedback ${hiddenInput}">
            <label for="currentPassword"
                   class="col-lg-4 control-label">Password</label>

            <div class="col-lg-8">
                <input class="form-control"
                       id="currentPassword"
                       placeholder="Current Password"
                       name="currentPassword"
                       type="password">
                <span class="glyphicon form-control-feedback"
                      id="currentPasswordFeedback"></span>
            </div>
        </div>

        <div class="form-group ${hiddenInput}">
            <label for="password"
                   class="col-lg-4 control-label">New Password</label>

            <div class="col-lg-8">
                <input class="form-control"
                       id="password"
                       placeholder="New Password"
                       name="password"
                       type="password">
            </div>
        </div>

        <div class="form-group has-feedback ${hiddenInput}">
            <label for="matchingPassword"
                   class="col-lg-4 control-label">Confirm</label>

            <div class="col-lg-8">
                <input class="form-control"
                       id="matchingPassword"
                       name="matchingPassword"
                       placeholder="Confirm Password"
                       type="password"/>
                <span class="glyphicon form-control-feedback"
                      id="matchingPasswordFeedback"></span>
            </div>

        </div>

        <div class="form-group has-feedback ${hiddenInput}">
            <label for="datePicker" class="col-lg-4 control-label">Birth
                Date</label>

            <div id="datePicker" class="combodate col-lg-8">
                <select id="day" name="day">
                    <option disabled>Day</option>
                    <c:forEach items="${days}" var="day">
                        <option value="${day}"
                                <c:if test="${birthDay == day}">
                                    <c:out value="selected"/>
                                </c:if>
                                >
                            <c:out value="${day}"/></option>
                    </c:forEach>
                </select>

                <select id="month" name="month">
                    <option disabled>Month</option>
                    <c:forEach items="${months}" var="month">
                        <option value="${month.key}"
                                <c:if test="${birthMonth == month.value}">
                                    <c:out value="selected"/>
                                </c:if>
                                >
                            <c:out value="${month.value}"/></option>
                    </c:forEach>
                </select>

                <select id="year" name="year">
                    <option disabled>Year</option>
                    <c:forEach items="${years}" var="year">
                        <option value="${year}"
                                <c:if test="${birthYear == year}">
                                    <c:out value="selected"/>
                                </c:if>
                                >
                            <c:out value="${year}"/></option>
                    </c:forEach>
                </select>

                <span class="form-control-feedback"
                      id="birthDateFeedback"></span>
            </div>
        </div>
        <c:if test="${!currentUser}">
            <div class="form-group">
                <label for="role"
                       class="col-lg-4 control-label">Role</label>

                <div class="col-lg-8">
                    <select id="role" name="role" class="form-control">
                        <option value="ROLE_USER"
                                <c:if test="${userRole == 'ROLE_USER'}">
                                        <c:out value="selected"/>
                                </c:if>
                                >User</option>
                        <option value="ROLE_ADMIN"
                                <c:if test="${userRole == 'ROLE_ADMIN'}">
                                    <c:out value="selected"/>
                                </c:if>
                                >Admin</option>
                    </select>
                </div>
            </div>
        </c:if>

        <div class="form-group">
            <div class="col-lg-8 col-lg-offset-4">
                <span class="pull-right">
                <a href="${postUrl}"
                   class="btn btn-default btn-sm"
                   type="button">Cancel</a>
                <input class="btn btn-info"
                       id="submitButton"
                       type="submit"
                       name="submitButton"
                       value="Update">
                    </span>
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
<div class="hidden" id="hidden-attr" data-basedir="${basedir}" data-post-url="${postUrl}"></div>
</div>

</body>
</html>