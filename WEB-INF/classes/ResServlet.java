import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ResBean;
import bean.ThreadBean;

public class ResServlet extends HttpServlet {


	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//POST要求によって送信された文字列をクライアントで
		//エンコードしたときの文字コードを指定する
		//これを指定しないと文字化けする可能性がある
		req.setCharacterEncoding("Windows-31J");

		//POST要求によって送信されたパラメータを取得する
				String text = req.getParameter("res_text");
				int th_id = Integer.parseInt(req.getParameter("th_id"));
				int user_id = Integer.parseInt(req.getParameter("user_id"));

				DBAccess.ResInsert(text, th_id, user_id);

				ArrayList response = DBAccess.ResSelect(th_id);

				req.setAttribute("reslist", response);

				RequestDispatcher dis = getRequestDispatcher("resを表示するjsp");

				dis.forward(req, res);





			}

		public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
			int th_id = Integer.parseInt(req.getParameter("th_id"));

			ArrayList response = DBAccess.ResSelect(th_id);

			req.setAttribute("reslist", response);

			RequestDispatcher dis = getRequestDispatcher("resを表示するjsp");

			dis.forward(req, res);
		}
}