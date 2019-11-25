package org.news.servlet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.news.dao.NewsDao;
import org.news.dao.impl.NewsDaoImpl;
import org.news.entity.News;
import org.news.service.NewsService;
import org.news.util.RequestParameterBeanMapper;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private NewsService newsService = new NewsService();

	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if("getAll".equals(method)) {
			getAll(request, response);
		}else if("add".equals(method)) {
			add(request, response);
		}else if("delete".equals(method)) {
			delete(request, response);
		}else if("get".equals(method)) {
			getById(request, response);
		}else if("update".equals(method)) {
			update(request, response);
		}
	}
	
	
	
	/**
	 * 获取新闻列表
	 * 
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		NewsService newsService = new NewsService();
		List<News> list = newsService.getNewsList();
//		request.setAttribute("list",list);
		session.setAttribute("list", list);
		response.sendRedirect(request.getContextPath()+"/newspages/admin.jsp");
//		request.getRequestDispatcher(request.getContextPath()+"/newspages/admin.jsp").forward(request, response);
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		News s = RequestParameterBeanMapper.getBean(request, News.class);
		s.setNcreatedate(new Date());
		System.out.println(s);
		newsService.addNews(s);
//		throw new RuntimeException();
		getAll(request, response);
	
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		newsService.deleteById(id);
//		throw new RuntimeException();
		getAll(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * 根据id 获取新闻
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		News n = newsService.getById(id);
		System.out.println(n);
		if(n != null) {
			request.setAttribute("news", n);
			request.getRequestDispatcher(request.getContextPath()+"/newspages/news_edit.jsp").forward(request, response);;
			return;
		}
		response.sendRedirect(request.getContextPath()+"/newspages/admin.jsp");
//		throw new RuntimeException();
	
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		News n = RequestParameterBeanMapper.getBean(request, News.class);
		newsService.update(n);
		getAll(request, response);
//		throw new RuntimeException();
	
	}

}
