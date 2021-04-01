<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentInfo" method="POST">
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="studentId" value="${student.studentid}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value="${student.firstname}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" value="${student.lastname}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${student.yearlevel}" /></td>
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
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.studentid}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>
                    <td>${stud.yearlevel}</td>
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
        <form action="http://localhost:8080/Student-war/subjectInfo.jsp">
            <input type="submit" value="Ir a Subject Information" />
        </form>

    </body>
</html>