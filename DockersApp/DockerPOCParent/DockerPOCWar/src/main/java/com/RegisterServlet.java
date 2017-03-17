package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	String name=request.getParameter("txtUserName");
        String pass=request.getParameter("txtPass");
        String fullName=request.getParameter("txtFullName");
        //String email=request.getParameter("txtEmail");
        
        Connection conn;
        PreparedStatement stmt;
        
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@deapvdwj.serv.dev.dc.de.telefonica:17135:OT171DEV", "SWB", "swbot171dev");
			
			String insertQuery = "Insert into POC_USER_MASTER " +
								"   (USERID, PASSWORD, FULLNAME) " +
								" Values " +
								"   (?, ?, ?)";
			
			stmt = conn.prepareStatement(insertQuery);
			
			stmt.setString(1, name);
			stmt.setString(2, pass);
			stmt.setString(3, fullName.toUpperCase());
			
			stmt.executeUpdate();
			
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
            request.setAttribute("uname", name);
            rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
