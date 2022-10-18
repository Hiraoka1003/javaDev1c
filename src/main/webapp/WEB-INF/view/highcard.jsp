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
			予想<input type="text" name="yosou"><br>
			プレイヤー名<input type="text" name="player"><br>

			<!----------- 10/18追加分 ----------->

			<hr>
			<h3>10/18追加分</h3>

			出る数字の予想<input type="number" name="hitNumber" value="1"><br>

			 <input type="submit"value="送信する。">
		</form>

		<hr>

		<!---Servletから送られたデータを受け取るゾーン -->
		<%
		  request.setCharacterEncoding("UTF-8");
		  String kakekin = request.getParameter("kake");
		  String yosou = request.getParameter("yosou");
		  String player = request.getParameter("player");
		  String hitNum = request.getParameter("hitNumber");

		  String dokuji = (String)request.getAttribute("dokuji");
		  String tutorial = (String)request.getAttribute("tutorial");
		  String dokujiPra1 = (String)request.getAttribute("dokujiPra1");
		  String dokujiPra2 = (String)request.getAttribute("dokujiPra2");
		  String dokuji0you1 = (String)request.getAttribute("dokuji0you1");
		%>

		<!-- 受け取ったデータを表示するゾーン -->

		かけ金は：<%= kakekin %><br>

		予想は：<%= yosou %><br>

		プレイヤー名は：<%= player %><br><br><br>

		<h3>
		【10/18 演習問題】<br>
		</h3>
		独自定義：<%= dokuji %><br>

		チュートリアル：<%= tutorial %><br>

		練習問題①：<%= dokujiPra1 %><br>

		練習問題②：<%= dokujiPra2 %><br>

		応用問題①：<%= dokuji0you1 %><br>

		応用問題②：<br>

		<hr>
		3回後の授業で触る。<br>
		<div id="board" onclick="btouch()"style="width:1200px; height:600px; border:solid; border-color:brown; background-color:#2e8b57;">
			<img style="width:100%"src="https://cdn.pixabay.com/photo/2015/08/11/11/58/atlasnye-884206_1280.png">
		</div>


		<!------------------ ここから↑だけ気にしといてね --------------->
		<br><br><br>.
	</div>
	</main>

	<script src="<c:url value="/assets/bootstrap.bundle.min.js" />"></script>
	<script src="<c:url value="/assets/script.js" />"></script>
	<script>
		function btouch(){
			alert('機能は皆が作るよーーー。まだ何も起こらないよーーー')
		}
	</script>
</body>

</html>