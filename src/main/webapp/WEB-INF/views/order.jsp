<%--
  Created by IntelliJ IDEA.
  User: megal
  Date: 22.05.2024
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
order.jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title> Orders</title>
    <link rel="stylesheet" href="css/style_w.css"> <!--[if !IE]><!-->
    <style> @media only screen and (max-width: 760px), (min-device-width: 768px) and (max-device-width: 1024px) {
        /* Force table to not be like tables anymore */
        table, thead, tbody, th, td, tr {
            display: block;
        }

        /* Hide table headers (but not display: none;, for accessibility) */
        thead tr {
            position: absolute;
            top: -9999px;
            left: -9999px;
        }

        tr {
            border: 1px solid #ccc;
        }

        td { /* Behave like a "row" */
            border: none;
            border-bottom: 1px solid #eee;
            position: relative;
            padding-left: 50%;
        }

        td:before { /* Now like a table header */
            position: absolute; /* Top/left values mimic padding */
            top: 6px;
            left: 6px;
            width: 45%;
            padding-right: 10px;
            white-space: nowrap;
        }

        /* Label the data */
        td:nth-of-type(1):before {
            content: "Имя";
        }

        td:nth-of-type(2):before {
            content: "Телефон";
        }

        td:nth-of-type(3):before {
            content: "Email";
        }
    }

    /* Smartphones (portrait and landscape) ----------- */
    @media only screen and (min-device-width: 320px) and (max-device-width: 480px) {
        body {
            padding: 0;
            margin: 0;
            width: 320px;
        }
    }

    /* iPads (portrait and landscape) ----------- */
    @media only screen and (min-device-width: 768px) and (max-device-width: 1024px) {
        body {
            width: 495px;
        }
    } </style> <!--<![endif]--> </head>
<body>
<nav role="navigation" class="navbar navbar-default">
    <div>
        <nav class="menu">
            <ul>
                <li><a href="${pageContext.request.contextPath}/controller?command=login_page">Login</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/controller?command=sign_out">Logout</a></li>
                <li><a href="${pageContext.servletContext.contextPath}/controller?command=welcome">Welcome</a></li>
                <li style="float:right;">
            </ul>
        </nav>
    </div>
</nav>
<div class="container"><h4>Добрый день, ${username} </h4>
    <div class="layer1">
        <H2>
            <caption>Список абонементов</caption>
        </H2>
        <p/>
        <table class="container" border="2">
            <tr>
                <th>PersonId</th>
                <th>SportOfferId</th>
                <th>QuantityOfDay</th>
                <th>Month</th>
            </tr>
            <c:forEach items="${group}" var="order">
                <tr>
                    <td>${order.personId}</td>
                    <td>${order.sportOfferId}</td>
                    <td>${order.quantityOfDay}</td>
                    <td>${order.month}</td>
                </tr>
            </c:forEach></table>
    </div>
    <div class="layer2">
        <div class="container">
            <section id="content"><p><font color="red">${errorMessage}</font></p>
                <form class="login-form" method="POST"
                      action="${pageContext.servletContext.contextPath}/controller?command=add_new_order"> Добавить
                    новый абонемент
                    <div><input name="npersonId" type="text" placeholder="Введите personId" required=""/></div>
                    <div><input name="nsportOfferId" type="text" placeholder="Введите sportOfferId" required=""/></div>
                    <div><input name="nquantityOfDay" type="text" placeholder="Введите quantityOfDay" required=""/></div>
                    <div><input name="nmonth" type="text" placeholder="Введите month" required=""/></div>
                    <div><input class="button-main-page" value="Добавить" type="submit"/></div>
                </form>
            </section>
        </div>
    </div>
</div>
</body>
</html>

