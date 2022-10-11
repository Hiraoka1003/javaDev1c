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
@WebServlet("0...........0.0"
		+ "."
		+ "")
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

		/***********************************************:
		 *               ここから超重要                *
		 ***********************************************/

		String kake = request.getParameter("kake");
		String yoso = request.getParameter("yoso");
		System.out.println(kake);
		System.out.println(yoso);
		//リクエストにしまうには
		request.setAttribute("kake", kake);
		request.setAttribute("yoso", yoso);

		/************************************************
		 *             ここまで重要                     *
		 ************************************************/

		doGet(request, response);
	}

}
