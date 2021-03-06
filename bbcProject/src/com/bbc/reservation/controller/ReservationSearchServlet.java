package com.bbc.reservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bbc.area.model.service.AreaService;
import com.bbc.area.model.vo.Area;
import com.bbc.event.model.service.EventService;
import com.bbc.event.model.vo.Event;
import com.bbc.notice.model.service.NoticeService;
import com.bbc.notice.model.vo.Notice;

/**
 * Servlet implementation class ReservationSearchServlet
 */			  
@WebServlet("/reservationSearch.rv")
public class ReservationSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* parentMenu가 없으면 널값으로 셋팅, 여러 단계인 경우 ^로 구분 */

		// 이벤트 리스트 가져오기
		ArrayList<Event> elist = new EventService().selectListRv();
				
		// 공지사항 리스트 가져오기
		ArrayList<Notice> nlist = new NoticeService().selectListRv();
	
		// 지점관리 지역리스트 가져오기
		ArrayList<Area> list = new AreaService().selectList();
				
		request.setAttribute("parentMenu", "차량예약");
		request.setAttribute("currentMenu", "차량선택");
		
		// 처음으로 호출하는 경우
		request.setAttribute("rent_branch", "99999");
		request.setAttribute("return_branch", "99999");
		request.setAttribute("rent_branchnm", "99999");
		request.setAttribute("return_branchnm", "99999");
		request.setAttribute("rentDate", "99999");
		request.setAttribute("returnDate", "99999");
		request.setAttribute("carno", "99999");
		request.setAttribute("preLink", "N");
		
		request.setAttribute("elist", elist);
		request.setAttribute("nlist", nlist);
		request.setAttribute("list", list);
				
		request.getRequestDispatcher("views/reservation/reservationSearchForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
