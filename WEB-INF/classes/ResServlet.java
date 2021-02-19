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
		//POST�v���ɂ���đ��M���ꂽ��������N���C�A���g��
		//�G���R�[�h�����Ƃ��̕����R�[�h���w�肷��
		//������w�肵�Ȃ��ƕ�����������\��������
		req.setCharacterEncoding("Windows-31J");

		//POST�v���ɂ���đ��M���ꂽ�p�����[�^���擾����
				String text = req.getParameter("res_text");
				int th_id = Integer.parseInt(req.getParameter("th_id"));
				int user_id = Integer.parseInt(req.getParameter("user_id"));

				DBAccess.ResInsert(text, th_id, user_id);

				ArrayList response = DBAccess.ResSelect(th_id);

				req.setAttribute("reslist", response);

				RequestDispatcher dis = getRequestDispatcher("res��\������jsp");

				dis.forward(req, res);





			}

		public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
			int th_id = Integer.parseInt(req.getParameter("th_id"));

			ArrayList response = DBAccess.ResSelect(th_id);

			req.setAttribute("reslist", response);

			RequestDispatcher dis = getRequestDispatcher("res��\������jsp");

			dis.forward(req, res);
		}
}