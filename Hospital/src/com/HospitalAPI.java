package com;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Hospital;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HospitalAPI
 */
@WebServlet("/HospitalAPI")
public class HospitalAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Hospital HospitalObj = new Hospital();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get method.............................");
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       //		doGet(request, response);
		System.out.println("post method.............................");
		
		
		String output = HospitalObj.insertHospital(request.getParameter("H_name"),
				                    request.getParameter("H_contactNumber"),
				                    request.getParameter("H_address"),
				                    request.getParameter("H_email"));
		
		System.out.println(request.getParameter("H_name")+" "+request.getParameter("H_contactNumber")+" "+request.getParameter("H_address")+" "+request.getParameter("H_email"));
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("put method.............................");
		// TODO Auto-generated method stub
		
         Map paras = getParasMap(request);
         
         
		
		String output = HospitalObj.updateHopital(paras.get("hidHospitalIDSave").toString(),
										   paras.get("H_name").toString().replace('+', ' '),
										   paras.get("H_contactNumber").toString(),
										   paras.get("H_address").toString().replace('+', ' ').replaceAll("%2C",",").replaceAll("%2F","/"),
										   paras.get("H_email").toString().replaceAll("%40","@"));
		
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		          // TODO Auto-generated method stub
        Map paras = getParasMap(request);
        
      
		
		String output = HospitalObj.deleteHospital(paras.get("H_ID").toString());
		
		response.getWriter().write(output);
	}
	
	
	
	  private static Map getParasMap(HttpServletRequest request) { Map<String,
	  String> map = new HashMap<String, String>();
	  
	  try { Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	  String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() :
	  ""; scanner.close();
	  
	  String[] params = queryString.split("&");
	  
	  for (String param : params) { String[] p = param.split("="); map.put(p[0],
	  p[1]); } } catch (Exception e) { }
	  
	  return map; }
	 
	
	

	
}