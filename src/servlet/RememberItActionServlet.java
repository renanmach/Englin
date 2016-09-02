package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RememberIt.RememberIt;
import constants.Constants;


@WebServlet("/RememberItActionServlet")
public class RememberItActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RememberItActionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String type = request.getParameter("type");
		RememberIt rememberit = (RememberIt) request.getSession().getAttribute(Constants.SESSION_REMEMBERIT_OBJ);

		if(type == null) {
			return;
		}

		switch (type) {
		case "0":
			String[] word = rememberit.getNextWord(true);
			if(word != null) {
				out.println(word[0]);
				request.getSession().setAttribute(Constants.SESSION_REMEMBERIT_WORD_RIGHT, word[1]);
			}
			break;
		case "1":
			out.println((String)request.getSession().getAttribute(Constants.SESSION_REMEMBERIT_WORD_RIGHT));
			break;
		default:
			break;
		}
	}
}
