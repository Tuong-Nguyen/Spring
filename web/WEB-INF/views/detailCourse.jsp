<%--
  Created by IntelliJ IDEA.
  User: nkim
  Date: 5/12/2017
  Time: 11:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail Course</title>
</head>
<body>
<jsp:include page="../views/fragments/header.jsp"></jsp:include>
<h1>Detail Course</h1>
<div class="container">
    <div class="row">

        <div class="form-group">
            <label>Title :</label>
            <span>${courseForm.title}</span>
        </div>

        <div class="form-group">
            <label>Description :</label>
            <span>${courseForm.description}</span>
        </div>

        <div class="form-group">
            <label>Start Date :</label>
            <span>${courseForm.startDate}</span>
        </div>

        <div class="form-group">
            <label>End Date :</label>
            <span>${courseForm.endDate}</span>
        </div>

        <div class="form-group">
            <label>Pax :</label>
            <span>${courseForm.pax}</span>
        </div>

        <div class="form-group">
            <label>Acitve :</label>
            <span>${(courseForm.active == true ? "Yes" : "No")}</span>
        </div>

        <div class="form-group">
            <h2>Lessons of Course</h2>
        </div>

        <div class="form-group">
            <h3>Lesson 1</h3>
            <div>
                <label>Id :</label>
                <span>${courseForm.lessons[0].id}</span>
            </div>
            <div>
                <label>Title :</label>
                <span>${courseForm.lessons[0].title}</span>
            </div>
            <div>
                <label>Time :</label>
                <span>${courseForm.lessons[0].time}</span>
            </div>
        </div>

        <div class="form-group">
            <h3>Lesson 2</h3>
            <div>
                <label>Id :</label>
                <span>${courseForm.lessons[1].id}</span>
            </div>
            <div>
                <label>Title :</label>
                <span>${courseForm.lessons[1].title}</span>
            </div>
            <div>
                <label>Time :</label>
                <span>${courseForm.lessons[1].time}</span>
            </div>
        </div>

        <div class="form-group">
            <h3>Lesson 3</h3>
            <div>
                <label>Id :</label>
                <span>${courseForm.lessons[2].id}</span>
            </div>
            <div>
                <label>Title :</label>
                <span>${courseForm.lessons[2].title}</span>
            </div>
            <div>
                <label>Time :</label>
                <span>${courseForm.lessons[2].time}</span>
            </div>
        </div>

        <br>

        <div>
            <button onclick="location.href='/courses'">Back</button>
            <button onclick="location.href='/courses/${courseForm.id}/edit'">Edit</button>
        </div>

    </div>
</div>
</body>
</html>
