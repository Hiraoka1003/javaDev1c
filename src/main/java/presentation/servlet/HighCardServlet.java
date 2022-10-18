package presentation.servlet;

import java.io.IOException;
import java.util.Random;

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

		request.setAttribute("dokuji", "変えれたよ～");

		///////////////【チュートリアル】///////////////////
		//↓独自定義したデータ「tutorial」に「チュートリアルです」という文字列
		request.setAttribute("tutorial", "チュートリアルです");
		///////////////練習問題①///////////////////
		//独自定義したデータ「dokujiPra1」に「練習問題1できた」という文字列を
		//格納し、JSPに表示しよう
		request.setAttribute("dokujiPra1", "練習問題1できた。");
		///////////////練習問題②///////////////////
		//独自定義したデータ「dokujiPra2」に変数「dokuji2」を格納し、JSPに表示しよう

		String dokuji2 = "練習問題2できました。";
		request.setAttribute("dokujiPra2", dokuji2);
		///////////////応用問題①///////////////////
		//以下の変数「randomNumber」には1-100までのランダムな数値が格納される。
		//このrandomNumberの値が1~3なら「SSRあたり」、3～20なら「SRあたり」、21～100なら「Rあたり」
		//という文字列を独自定義「dokujiOuyou1」に格納し、JSPに表示しよう。
		Random rnd = new Random();
		int randomNumber = rnd.nextInt(100) + 1;
		if (randomNumber <= 3 && randomNumber >= 1) {
			request.setAttribute("dokuji0you1", "SSRあたり");
		} else if (randomNumber <= 20) {
			request.setAttribute("dokuji0you1", "SRあたり");
		} else if (randomNumber <= 100) {
			request.setAttribute("dokuji0you1", "Rあたり");
		}
		///////////////応用問題②///////////////////
		//1-13までのランダムな数字を取得し、変数「randomNumber2」に格納しよう。
		//画面の「出る数字の予想」欄から入力された数値と一致していたら、
		//独自定義「dokujiOuyou2」に「予想的中」という文字列を格納し、
		//外れていたら「どんまい」という文字列を格納する。
		//その後、dokujiOuyou2をJSPに表示しよう。

		//リクエストをJSPに送る。
		doGet(request, response);
		/************************************************
		 *             ここまで重要                     *
		 ************************************************/

	}

}