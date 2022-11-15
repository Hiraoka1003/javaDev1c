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
 * Servlet implementation class RoomPraServlet
 */
@WebServlet("/roomPra")
public class RoomPraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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

	}catch(SQLException|

	ClassNotFoundException e)
	{
		System.out.println(e);
	}finally
	{
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// 例外処理
		}
	}

	request.setAttribute("resultList",resultList);
	String view = "/WEB-INF/view/roomPra.jsp";
	RequestDispatcher dispatcher = request.getRequestDispatcher(view);dispatcher.forward(request,response);
}

}