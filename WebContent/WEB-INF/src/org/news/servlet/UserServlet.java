package org.news.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.news.entity.User;
import org.news.service.UserService;
import org.news.util.RequestParameterBeanMapper;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/login")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserService();
		User u = RequestParameterBeanMapper.getBean(request, User.class);
		if(userService.login(u)){
			Cookie c1 = new Cookie("uname", u.getUname());
			Cookie c2 = new Cookie("upwd", u.getUpwd());
			c1.setMaxAge(60*10);
			c2.setMaxAge(60*10);
			response.addCookie(c1);
			response.addCookie(c2);
			request.getSession().setAttribute("admin", u.getUname());
			response.sendRedirect(request.getContextPath()+"/news?method=getAll");
			return;
		}
		request.getSession().setAttribute("error", "用户名或密码错误");
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
