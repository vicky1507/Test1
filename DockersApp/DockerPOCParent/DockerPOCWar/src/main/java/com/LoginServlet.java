package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	   
        String name=request.getParameter("txtUserName");
        String pass=request.getParameter("txtPass");
        
        Connection conn;
        Statement stmt;
        ResultSet rs;
        int count = 0;
        String fullname = "";
        
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@deapvdwj.serv.dev.dc.de.telefonica:17135:OT171DEV", "SWB", "swbot171dev");
			
			String query = "SELECT FULLNAME FROM POC_USER_MASTER WHERE USERID = '"+name+"' AND PASSWORD = '"+pass+"' ";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			if(rs.next())
			{
				count++;
				fullname = rs.getString(1);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(count > 0)
        {
        	RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
            request.setAttribute("uname", fullname);
            rd.forward(request, response);
        }
        else
        {
        	response.sendRedirect("error.jsp");
        }
       
        /*if(name.equalsIgnoreCase("prakash")&& pass.equalsIgnoreCase("awatade"))
        {
              RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
            request.setAttribute("uname", name);
            rd.forward(request, response);
        }
        else
        {//if name&pass not match then it display error page//
            response.sendRedirect("error.jsp");
        }*/
       
    }
   
   
   
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
