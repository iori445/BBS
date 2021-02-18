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
				String rtext = req.getParameter("res_text");

				int t_id;
				t_id = Integer.parseInt(req.getParameter("th_id"));
				int u_id;
				u_id = Integer.parseInt(req.getParameter("user_id"));
				ResBean resb = new ResBean();


				resb.setRes_text(rtext);


				if(rtext != null){
					Response(t_id, rtext, u_id);
				}else{
					/** 本文無しのエラーまたは操作*/
				}

				req.setAttribute("thread_id", /**ここDBアクセスまで参照以下同じ */ t_id);
				req.setAttribute("user_id", u_id);
				req.setAttribute("res_text", rtext);

				RequestDispatcher res_dis = req.getRequestDispatcher("webxmlのリンク")

				res_dis.forward(req, res);

		}

		private void Response(int t, String r, int u){
			/**オラクルにインサート */

		}

		public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
			doPost(req, res);
		}
}