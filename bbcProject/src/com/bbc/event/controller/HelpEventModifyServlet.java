package com.bbc.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbc.event.model.service.EventService;
import com.bbc.event.model.vo.Event;

/**
 * Servlet implementation class HelpEventModifyServlet
 */
@WebServlet("/modifyEvent.b.ev")
public class HelpEventModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelpEventModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.setCharacterEncoding("utf-8");
		
		int memNo = 21;
		
		int eno = Integer.parseInt(request.getParameter("eno"));
		String title = request.getParameter("title");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String rate = request.getParameter("rate");
		String content = request.getParameter("content");
		
		Event e = new Event();
		
		e.setEventNo(eno);
		e.setEventTitle(title);
		e.setEventContent(content);
		
		int result = new EventService().updateEvent(e, startDate, endDate, rate);
		
		if(result > 0) {
			response.sendRedirect("event.b.ev");
		} else {
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
