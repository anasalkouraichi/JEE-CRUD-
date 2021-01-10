<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>CRUD VOITURE</title>
</head>
<body>
 <center>
  <h1>Voiture Management</h1>
        <h2>
         <a href="new">Ajouter nouvelle voiture</a>
         &nbsp;&nbsp;&nbsp;
         <a href="list">Lister tout </a>
         
        </h2>
 </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Liste des voitures</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Matricule</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="voiture" items="${listVoiture}">
                <tr>
                    <td><c:out value="${voiture.id}" /></td>
                    <td><c:out value="${voiture.nom}" /></td>
                    <td><c:out value="${voiture.matricule}" /></td>
                    <td>
                     <a href="edit?id=<c:out value='${voiture.id}' />">Edit</a>
                     &nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="delete?id=<c:out value='${voiture.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div> 
</body>
</html>