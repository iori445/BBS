import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UserBean;

public class UserServlet extends HttpServlet {


	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//POST�v���ɂ���đ��M���ꂽ��������N���C�A���g��
		//�G���R�[�h�����Ƃ��̕����R�[�h���w�肷��
		//������w�肵�Ȃ��ƕ�����������\��������
		req.setCharacterEncoding("Windows-31J");


		String name = req.getParameter("user_name");
		String pass = req.getParameter("user_pass");

		DBAccess.UserInsert(name, pass);

		int user_id = Integer.parseInt(req.getParameter("user_id"));
		
		ArrayList userlist = DBAccess.UserSelect(user_id);

		req.setAttribute("userlist", userlist);

		RequestDispatcher dis = getRequestDispatcher("���[�U�[���\��jsp");
		dis.forward(req,res);
	}
}
