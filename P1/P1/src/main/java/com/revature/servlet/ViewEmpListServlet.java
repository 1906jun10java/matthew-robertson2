package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.R_Request;
import com.revature.daoimpl.EmployeeDAOImpl;

@WebServlet("/viewC1ManagerEmpList")
public class ViewEmpListServlet extends HttpServlet {
	
	
	ObjectMapper om = new ObjectMapper();
	
	//R_RequestServices rrs = new R_RequestServices();
	EmployeeDAOImpl edi = new EmployeeDAOImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		if(session != null) {
				try {
					ArrayList<Employee> reqList = edi.getEmpListByMClass(Integer.parseInt(session.getAttribute("managerclass").toString()));
					resp.getWriter().write((new ObjectMapper()).writeValueAsString(reqList));
					
				}catch(Exception e) {
					e.printStackTrace();
				}
		} else {
			resp.sendRedirect("/profile");
		}
	}
		
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}

}
