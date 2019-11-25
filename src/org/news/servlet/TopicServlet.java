package org.news.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.news.entity.Topic;
import org.news.service.TopicService;
import org.news.util.RequestParameterBeanMapper;

/**
 * Servlet implementation class TopicServlet
 */
@WebServlet("/topic")
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TopicService topicService = new TopicService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicServlet() {
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
			getTopicList(request, response);
		}else if("add".equals(method)) {
			addTopic(request, response);
		}else if("getAllAsync".equals(method)) {
			getTopicsAsync(request, response);
		}else if("delete".equals(method)) {
			delete(request, response);
		}else if("get".equals(method)) {
			getById(request, response);
		}else if("update".equals(method)) {
			update(request, response);
		}else if("get_home".equals(method)) {
			getTopicListForHome(request, response);
		}
		
	}
	
	protected void getTopicList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Topic> ls = topicService.getTopicList();
		request.getSession().setAttribute("topicList", ls);
		response.sendRedirect(request.getContextPath()+"/newspages/topic_list.jsp");
//		request.setAttribute("list", ls);
//		request.getRequestDispatcher(request.getContextPath()+"/newspages/topic_list.jsp")
//	        .forward(request,response);
	}
	
	protected void addTopic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Topic topic = RequestParameterBeanMapper.getBean(request, Topic.class);
		if(topicService.addTopic(topic)) {
			response.sendRedirect(request.getContextPath()+"/topic?method=getAll");
			return;
		}
		request.getSession().setAttribute("error", "已存在同名标签！");
		response.sendRedirect(request.getContextPath()+"/newspages/topic_add.jsp");
	}
	
	protected void getTopicsAsync(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Topic> ls = topicService.getTopicList();
//		request.setAttribute("list", ls);
		request.getSession().setAttribute("topicEs", ls);
//		request.getRequestDispatcher(request.getContextPath()+"/newspages/topics.jsp")
//	        .forward(request,response);
		response.sendRedirect(request.getContextPath()+"/newspages/topics.jsp");
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int tid = Integer.parseInt(request.getParameter("id"));
		topicService.deleteById(tid);
//		getTopicList(request, response);
		response.sendRedirect(request.getContextPath()+"/topic?method=getAll");

	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Topic t = topicService.getById(id);
//		request.setAttribute("topic", t);
//		request.getRequestDispatcher(request.getContextPath()+"/newspages/topic_edit.jsp").forward(request, response);
		request.getSession().setAttribute("topic", t);
		response.sendRedirect(request.getContextPath()+"/newspages/topic_edit.jsp");
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Topic t = RequestParameterBeanMapper.getBean(request, Topic.class);
		if(topicService.update(t)) {
//			getTopicList(request, response);
			response.sendRedirect(request.getContextPath()+"/topic?method=getAll");
			return;
		}
		request.getSession().setAttribute("error", "同名主题已存在！");
		request.setAttribute("topic", t);
		request.getRequestDispatcher(request.getContextPath()+"/newspages/topic_edit.jsp").forward(request, response);;
	}
	
	protected void getTopicListForHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<Topic> ls = topicService.getTopicList();
		System.out.println(ls);
		request.getSession().setAttribute("topicList", ls);
		response.sendRedirect(request.getContextPath()+"/newspages/components/home_topic.jsp");
//		request.setAttribute("list", ls);
//		request.getRequestDispatcher(request.getContextPath()+"/newspages/topic_list.jsp")
//	        .forward(request,response);
	}

}
