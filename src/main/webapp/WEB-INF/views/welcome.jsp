<%--
  Created by IntelliJ IDEA.
  User: megal
  Date: 22.05.2024
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title> Welcome</title>
    <link rel="stylesheet" href="css/style_w.css"> <!--[if !IE]><!-->
    <style> /*@media only screen and (max-width: 760px), (min-device-width: 768px) and (max-device-width: 1024px) { */
    /* Force table to not be like tables anymore */
    /*
    table, thead, tbody, th, td, tr {
          display: block;
      }
    */

    /* Hide table headers (but not display: none;, for accessibility) */
    /*
      thead tr {
          position: absolute;
          top: -9999px;
          left: -9999px;
      }

      tr {
          border: 1px solid #ccc;
      }
    */

    /*
      td {
          border: none;
          border-bottom: 1px solid #eee;
          position: relative;
          padding-left: 50%;
      }

      td:before {
          position: absolute;
          top: 6px;
          left: 6px;
          width: 45%;
          padding-right: 10px;
          white-space: nowrap;
      }


      td:nth-of-type(1):before {
          content: "Имя";
      }

      td:nth-of-type(2):before {
          content: "Телефон";
      }

      td:nth-of-type(3):before {
          content: "Email";
      }
    */
    /* }/*

     /* Smartphones (portrait and landscape) ----------- */
    /*
  @media only screen and (min-device-width: 320px) and (max-device-width: 480px) {
      body {
          padding: 0;
          margin: 0;
          width: 320px;
      }
  }
*/
    /* iPads (portrait and landscape) ----------- */
    /*
  @media only screen and (min-device-width: 768px) and (max-device-width: 1024px) {
      body {
          width: 495px;
      }
  }
*/
    </style> <!--<![endif]-->
    <style>
        .header{
            align-items: center;
            background-color: #a7d8f4;

            display: grid;
            grid-template-columns: 1fr max-content;
            padding: 0 10px;
        }
        .header li {
            display: inline;
        }

        table {
            table-layout: fixed;
            border-collapse: collapse;
            border: 2px solid purple;
        }

        th,
        td {
            padding: 10px;
        }

        input {
            font-size: 16px;
            margin-bottom: 4px;
        }

        form{
            width: 200px;
        }
        .layers {
            padding-left: 45px;
            display: grid;
            grid-template-columns: max-content 1fr;
            gap: 20px;
        }
        .error{
            color: red;
         }
    </style>
</head>
<body>
<div class="header">
    <div>

        <ul>
            <li><a href="${pageContext.request.contextPath}/controller?command=login_page">Login</a></li>
            <li><a href="${pageContext.servletContext.contextPath}/controller?command=sign_out">Logout</a></li>
            <li><a href="${pageContext.servletContext.contextPath}/controller?command=order">Order</a></li>
            <li><a href="${pageContext.servletContext.contextPath}/controller?command=sportOffer">SportOffer</a></li>
            <li><a href="${pageContext.servletContext.contextPath}/controller?command=commonInfo">CommonInfo</a></li>
            <li><a href="${pageContext.servletContext.contextPath}/controller?command=monthPrice">MonthPrice</a></li>
        </ul>

    </div>
    <div class="container"><div>Добрый день, <strong>${username}</strong> (welcome.jsp)</div></div>
</div>
<h2>Список посетителей</h2>
<div class="layers">
    <div class="layer2">
        <div class="container">
            <section id="content"><p class="error">${errorMessage}</p>
                <form class="login-form" method="POST"
                      action="${pageContext.servletContext.contextPath}/controller?command=add_new_person">
                    Добавить новый контакт
                    <div><input name="nname" type="text" placeholder="Введите имя" required=""/></div>
                    <div><input name="nphone" type="text" placeholder="Введите телефон" required=""/></div>
                    <div><input name="nemail" type="text" placeholder="Введите email" required=""/></div>
                    <div><input class="button-main-page" value="Добавить" type="submit"/></div>
                </form>
            </section>
        </div>
    </div>
    <div class="layer1">

        <table class="container">
            <tr>
                <th>Имя</th>
                <th>Телефон</th>
                <th>Email</th>
            </tr>
            <c:forEach items="${group}" var="person">
                <tr>
                    <td>${person.name}</td>
                    <td>${person.phone}</td>
                    <td>${person.email}</td>
                </tr>
            </c:forEach></table>
    </div>
</div>
</body>
</html>