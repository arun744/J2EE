package com.ajayaraj.olympicshop;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajayaraj.olympics.db.ConnectDatabase;
import com.ajayaraj.olympics.db.ProductListing;
import com.ajayaraj.olympicshop.service.Product;
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class ProductListServlet
 */

public class ProductListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	    int page = 1;
	    int recordPerPages = 5;
	    String category = null;
	    
	    if(request.getParameter("page") != null)
	    	page = Integer.parseInt(request.getParameter("page"));
	    if (request.getParameter("prod_category") != null)
	    	category = (String)request.getParameter("prod_category");
	    	
	    ProductListing product = new ProductListing();
	    int offSet = (page - 1) * recordPerPages;

	    List<Product> productList = product.viewProduct(offSet, recordPerPages, category);
	    int noOfRecords = product.getResultRecord();
	    int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordPerPages);
	    
	    request.setAttribute("productlist", productList);
	    request.setAttribute("noOfPages", noOfPages);
	    request.setAttribute("currentPage", page);
	    request.setAttribute("productCategory", category);
	    
	    RequestDispatcher view = request.getRequestDispatcher("product.jsp");
	    view.forward(request, response);
	    
	}

}
