package customservlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import users.User;

/**
 * Servlet implementation class Sample1
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		HttpSession session = request.getSession(true);
		List<User> users = (List<User>) session.getAttribute("users");
		boolean found = false;
		if (users!= null) {
			
			for (User user : users) {
				if (user.getUserid().equalsIgnoreCase(name)
						&& user.getPass().equals(password)) {
					session.setAttribute("userid", name);
					session.setAttribute("password", password);
					found = true;
					break;
				}
			}
		}
		if(found){
			 response.sendRedirect("success.jsp");
		}
		else{
			 response.sendRedirect("failure.jsp");
		}
		
		
	}
	}


