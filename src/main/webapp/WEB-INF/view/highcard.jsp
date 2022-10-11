<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!doctype html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>JavaDevelop</title>
<link rel="shortcut icon" href="<c:url value="/assets/favicon.ico" />">
<link rel="stylesheet"
	href="<c:url value="/assets/bootstrap.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/assets/bootstrap-icons.css" />">
<link rel="stylesheet" href="<c:url value="/assets/styles.css" />">
</head>

<body>

	<%@ include file="./_headerNavbar.jsp"%>

	<main>
	<div class="container workspace">

		<!------------------ ここから↓だけ気にしといてね ---------------->

		<h2>HighCard</h2>

		<form action="./highcard" method="POST">
			賭け金<input type="text" name="kake"><br>
			予想<input type="text" name="yoso">
			 <input type="submit"value="送信する。">
		</form>

		<hr>
		<%
		  request.setCharacterEncoding("UTF-8");
		  String kakekin = request.getParameter("kake");
		  String yosou = request.getParameter("yoso");
		%>

		かけ金は：<%= kakekin %>
		予想は: <%= yosou %>

		<!------------------ ここから↑だけ気にしといてね --------------->

	</div>
	</main>

	<footer class="footer mt-auto fixed-bottom py-3 bg-secondary"></footer>

	<script src="<c:url value="/assets/bootstrap.bundle.min.js" />"></script>
	<script src="<c:url value="/assets/script.js" />"></script>
</body>

</html>