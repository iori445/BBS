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
					/** �{�������̃G���[�܂��͑���*/
				}

				req.setAttribute("thread_id", /**����DB�A�N�Z�X�܂ŎQ�ƈȉ����� */ t_id);
				req.setAttribute("user_id", u_id);
				req.setAttribute("res_text", rtext);

				RequestDispatcher res_dis = req.getRequestDispatcher("webxml�̃����N")

				res_dis.forward(req, res);

		}

		private void Response(int t, String r, int u){
			/**�I���N���ɃC���T�[�g */

		}

		public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
			doPost(req, res);
		}
}