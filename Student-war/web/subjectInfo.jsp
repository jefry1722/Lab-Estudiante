<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subject information</title>
    </head>
    <body>
        <h1>Subject Information</h1>
        <form action="./SubjectInfo" method="POST">
            <table>
                <tr>
                    <td>Subject Id</td>
                    <td><input type="text" name="subjectId" value="${subject.subjectid}" /></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name" value="${subject.name}" /></td>
                </tr>
                <tr>
                    <td>Credit number</td>
                    <td><input type="text" name="creditNumber" value="${subject.creditnumber}" /></td>
                </tr>
                <tr>
                    <td>Semester</td>
                    <td><input type="text" name="semester" value="${subject.semester}" /></td>
                </tr>
                <tr>
                    <td>Admited Students</td>
                    <td><input type="text" name="admitedStudents" value="${subject.admitedstudents}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" /><br>
                    </td>
                </tr>
                
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>Name</th>
            <th>Credit Number</th>
            <th>Semester</th>
            <th>Admited Students</th>
                <c:forEach items="${allSubjects}" var="sub">
                <tr>
                    <td>${sub.subjectid}</td>
                    <td>${sub.name}</td>
                    <td>${sub.creditnumber}</td>
                    <td>${sub.semester}</td>
                    <td>${sub.admitedstudents}</td>
                </tr>
            </c:forEach> 
        </table>
        <br>
        
        <form action="./StuSubInfo" method="POST">
        <table>
            <h1>Vincular estudiante con clase</h1>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="studentId" value="${stuSub.studentid}" /></td>
                </tr>
                <tr>
                    <td>Subject Id</td>
                    <td><input type="text" name="subjectId" value="${stuSub.subjectid}" /></td>
                </tr>
                <tr>
                    <td>Grade</td>
                    <td><input type="text" name="grade" value="${stuSub.grade}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add"/>
                    </td>
                </tr>
            </table>
        </form>
                
        <br>
        <form action="http://localhost:8080/Student-war/studentInfo.jsp">
            <input type="submit" value="Ir a Student Information" />
        </form>
    </body>
</html>