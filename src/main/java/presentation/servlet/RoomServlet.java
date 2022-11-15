package presentation.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Player;

/**
 * {@link SampleMemoServlet}
 */
@WebServlet("/room")
public class RoomServlet extends HttpServlet {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//DB接続の準備
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/javadev?serverTimezone=JST&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		List<Player> resultList = new ArrayList<>();

		//データベースへの接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			///////////////////SQLの発行////////////////////
			String sql = "SELECT * FROM user";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Player p = new Player();
				p.setUser_id(rs.getString("user_id"));
				p.setUser_name(rs.getString("user_name"));
				p.setWin_rate(rs.getString("win_rate"));
				resultList.add(p);
			}

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// 例外処理
			}
		}

		request.setAttribute("resultList", resultList);
		String view = "/WEB-INF/view/room.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ここは無視してね
		request.setCharacterEncoding("UTF-8");

		//送られて来たデータを取り出す。
		String playerid = request.getParameter("playerid");
		String playername = request.getParameter("playername");

		//DB接続の準備
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/javadev?serverTimezone=JST&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		List<Player> resultList = new ArrayList<>();

		//データベースへの接続
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);

			///////////////////SQLの用意////////////////////
			String sql = "INSERT INTO user (user_id, user_name, win_rate) VALUES ('" + playerid + "', '" + playername
					+ "','0')";
			PreparedStatement stmt = con.prepareStatement(sql);

			//SQLの実行
			stmt.executeUpdate(sql);

		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// 例外処理
			}
		}
		/////////////
		//リクエストをJSPに送る。
		doGet(request, response);
	}
}