package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RememberIt.RememberIt;
import constants.Constants;
import util.FileUtil;
import words.Language;


@WebServlet("/RememberItStartServlet")
public class RememberItStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RememberItStartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Language lang1, lang2;
				
		try {
			lang1 = Language.valueOf((String)request.getParameter("lang1"));
			lang2 = Language.valueOf((String)request.getParameter("lang2"));
		} catch(Exception e) {
			lang1 = Language.en;
			lang2 = Language.pt;
		}
		RememberIt rememberit = new RememberIt(FileUtil.readVocabularyFile(Constants.WORD_LIST) , lang1, lang2);
		request.getSession().setAttribute(Constants.SESSION_REMEMBERIT_OBJ, rememberit);
		
		if (!response.isCommitted()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/rit.jsp");			
			dispatcher.forward(request, response);				
		}
	}
}
