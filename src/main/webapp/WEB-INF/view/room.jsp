<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
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

		<!-------------- ↓ここだけ見てね↓ ---------------->
		<%
			//Servletから送られたデータを受け取るゾーン
			String roomid = (String)request.getAttribute("roomid");
			List<String> resultList = (List<String>) request.getAttribute("resultList");
		%>
		<h3>対戦ルーム</h3>
		<table class="table table-striped table-hover caption-top">
			<caption>ユーザ一覧</caption>
			<thead>
				<tr>
					<th></th>
					<th>PlayerId</th>
					<th>NAME</th>
					<th>winrate</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${resultList}" var="result">
					<tr>
							<td><i class="bi bi-person-fill"></i></td>
							<td><c:out value="${result.user_id}" /></td>
							<td><input type="text" name="name" size="20" value="${result.user_name}" /></td>
							<td><c:out value="${result.win_rate}" /></td>
					</tr>
				</c:forEach>
				<tr>
						<td><i class="bi bi-person"></i></td>
						<td></td>
						<td><input type="text" name="name" size="20" /></td>
						<td></td>
				</tr>
			</tbody>
		</table>
		<hr>
		<h2>ユーザ登録</h2>
		<form action="./room" method="POST">
			自分のID<input type="text" name="playerid"><br>
			プレイヤー名<input type="text" name="playername"><br>
			<input type="submit" value="ユーザ登録">
		</form>

		<!-------------- ↑ここだけ見てね↑ ---------------->
		<p style="font-size: 120px; text-align: center;"></p>

		<br>
	</div>
	</main>

	<script src="<c:url value="/assets/bootstrap.bundle.min.js" />"></script>
	<script src="<c:url value="/assets/script.js" />"></script>
</body>

</html>