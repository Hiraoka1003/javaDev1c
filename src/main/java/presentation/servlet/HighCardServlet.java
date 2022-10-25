package presentation.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.service.WebAppSampleService;

/**
 * {@link SampleMemoServlet}
 */
@WebServlet("/highcard")
public class HighCardServlet extends HttpServlet {

	private WebAppSampleService service = new WebAppSampleService();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String view = "/WEB-INF/view/highcard.jsp";
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

		//リクエストからデータを取り出す。
		String kake = request.getParameter("kake");
		String player = request.getParameter("player");

		//リクエストにデータをセットする。
		request.setAttribute("kake", kake);
		request.setAttribute("player", player);

		/////////10月18日追加分///////////
		/******************************************
		 * 独自定義のデータをJSPに送る。
		 ******************************************/

		///////////////【サンプル】///////////////////
		//↓独自定義したデータ「dokuji」に「独自だよー」という文字列を格納↓
		request.setAttribute("dokuji", "かえれたよー");

		///////////////【チュートリアル】///////////////////
		//↓独自定義したデータ「tutorial」に「チュートリアルです」という文字列
		request.setAttribute("tutorial", "チュートリアルです");

		///////////////練習問題①///////////////////
		//独自定義したデータ「dokujiPra1」に「練習問題1できた」という文字列を
		//格納し、JSPに表示しよう
		request.setAttribute("dokujiPra1", "練習問題１できた");

		///////////////練習問題②///////////////////
		//独自定義したデータ「dokujiPra2」に変数「dokuji2」を格納し、JSPに表示しよう
		String dokuji2 = "練習問題2できました。";

		//リクエストをJSPに送る。
		doGet(request, response);
		/************************************************
		 *             ここまで重要                     *
		 ************************************************/

	}

}