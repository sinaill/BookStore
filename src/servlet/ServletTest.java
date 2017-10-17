package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import service.Productservice;

public class ServletTest extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private Productservice productservice;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,  
	              config.getServletContext()); 
	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("servlet  "+productservice);
	}
	
}
