import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ThreadBean;


public class ThreadServlet extends HttpServlet{

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
                req.setCharacterEncoding("Windows-31J");

                int th_id = Integer.parseInt(req.getParameter("th_id"));
                String th_title = req.getParameter("th_title");
                String th_des = req.getParameter("th_description");
                int genre_id = Integer.parseInt(req.getParameter("genre_id"));
                int user_id = Integer.parseInt(req.getParameter("user_id"));

                DBAccess.ThreadInsert(th_title, th_des, genre_id, user_id);

                ArrayList thlist = DBAccess.ThreadsSelect();
                ArrayList thtb = DBAccess.ThreadSelect(th_id);

                req.setAttribute("thlist", thlist);
                req.setAttribute("thtb", thtb);

                RequestDispatcher dis = getRequestDispatcher("スレッドを表示するjsp");

                dis.forward(req, res);
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        int th_id = Integer.parseInt(req.getParameter("th_id"));

        ArrayList thtb = DBAccess.ThreadSelect(th_id);

        req.setAttribute("thtb", thtb);
        RequestDispatcher dis = getRequestDispatcher("スレッドを表示するjsp");

        dis.forward(req, res);
    }
}