package com.todo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todo.handler.LoginHandler;
import com.todo.handler.UploadHandler;

/**
 * Servlet Filter implementation class MainFilter
 */
public class MainFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MainFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//System.out.println("In the filter");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		String handler=req.getParameter("handler");
		//check for the appropriate handler
		
		if("validateLogin".equals(handler)){
			/*Validation Login Handler*/
			LoginHandler lh=new LoginHandler(req);
			if(lh.validateLogin()){
				System.out.println("Starting to upload..");
				UploadHandler uh=new UploadHandler(req.getSession());
				if(uh.initUpload()){// upload to taskset attribute
					System.out.println("Upload Complete!");
				}
				//complete here
				//res.sendRedirect("/WEB-INF/pages/mainpage.jsp");
				//req.getSession().setAttribute("loggedin", "true");
				RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/pages/mainpage.jsp");
				rd.forward(req, res);
				//res.sendRedirect("default.html");
			}
			else{
				RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/pages/login.jsp");
				rd.forward(req, res);
			}
			
		}
		// pass the request along the filter chain
		else
			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//System.out.println("Filter init called");
	}

}
