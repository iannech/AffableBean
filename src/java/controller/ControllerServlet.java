/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Category;
import entity.Product;
import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.CategoryFacade;

/**
 *
 * @author nech
 */

@WebServlet(name="ControllerServlet",
            loadOnStartup = 1,
            urlPatterns = {"/category",
                           "/addToCart",
                           "/viewCart",
                           "/updateCart",
                           "/checkout",
                           "/purchase",
                           "/chooseLanguage"})
public class ControllerServlet extends HttpServlet {

   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB
    private CategoryFacade categoryFacade;

    @Override
    public void init() throws ServletException {

        // store category list in servlet context
        getServletContext().setAttribute("categories", categoryFacade.findAll());
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userPath =  request.getServletPath();
        
        // if category path is selected
        if(userPath.equals("/category")){
            // get categoryId from request 
            String categoryId = request.getQueryString();
            
            if(categoryId != null){
                // get selected category
                Category selectedCategory = categoryFacade.find(Short.parseShort(categoryId));
                
                // place selected category in request scope
                request.setAttribute("selectedCategory", selectedCategory);
                
                // get all products for selected category
                Collection<Product> categoryProducts = selectedCategory.getProductCollection();
                
                // place category products in requested scope
                request.setAttribute("categoryProducts", categoryProducts);
            }
            
         // if cart path is requested   
        }else if(userPath.equals("/viewCart")){
            // TODO: Implement cart request
            
            userPath = "/cart";
            
        // if checkout path is requested
        }else if(userPath.equals("/checkout")){
            // TODO: Implement checkout page request
            
        // if user switches language
        }else if(userPath.equals("/chooseLanguage")){
            // TODO: Implement language request
            
        }
        
        // use RequestDispatcher to forward request internally 
        String url = "/WEB-INF/view" + userPath + ".jsp";
        
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // get requested url pattern from client
        String userPath = request.getServletPath();
        
        // if addToCart action is called
        if(userPath.equals("/addToCart")){
            // TODO: implement add to cart action
            
        // if updateCart action is called    
        }else if(userPath.equals("/updateCart")){
            // TODO: implement update cart action
            
        // if purchase action is called
        }else if(userPath.equals("/purchase")){
            // TODO: implement purchase action
            
            userPath = "/confirmation";
            
        }
        
        // use RequestDispatcher to forward internally
        String url = "/WEB-INF/view" + userPath + ".jsp";
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
