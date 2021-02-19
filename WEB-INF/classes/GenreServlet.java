import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.GenreBean;


public class GenreServlet extends HttpServlet{

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
                req.setCharacterEncoding("Windows-31J");

                int genre_id = Integer.parseInt(req.getParameter("genre_id"));

                String genre_name = req.getParameter("genre_name");

                /**追加したいジャンルをinsert */

                DBAccess.GenreInsert(genre_id, genre_name);

                /**ジャンル一覧select */
                ArrayList allgenre = DBAccess.GenresSelect();


                /**id指定ジャンルselect */
                ArrayList genrelist = DBAccess.GenresSelect(genre_id);

                req.setAttribute("genretb", allgenre);
                req.setAttribute("genre", genrelist);

                RequestDispatcher dis = getRequestDispatcher("ジャンル表示jsp");

                dis.forward(req, res);




            }

}
