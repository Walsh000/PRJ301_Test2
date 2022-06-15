/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.anual_request;

import dal.AnualRequestDBContext;
import dal.EmployeeDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.ArrayList;
import object.AnualRequest;
import object.Employee;

/**
 *
 * @author Silver_000
 */
public class Insert extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Insert</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Insert at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        EmployeeDBContext employeeDBC = new EmployeeDBContext();
        ArrayList<Employee> empList = employeeDBC.list();
        request.setAttribute("empList", empList);
        request.getRequestDispatcher("../view/anualrequest/Insert.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String rawReason = request.getParameter("reason");
        String rawFrom = request.getParameter("from");
        String rawTo = request.getParameter("to");
        String rawCreate = request.getParameter("create");
        String rawReview = request.getParameter("review");
        
        AnualRequest req = new AnualRequest();
        req.setReason(rawReason);
        req.setFrom(Date.valueOf(rawFrom));
        req.setTo(Date.valueOf(rawTo));
        req.setCreatedBy(Integer.parseInt(rawCreate));
        req.setReviewedBy(Integer.parseInt(rawReview));
        req.setStatus("pending");
        AnualRequestDBContext reqDBC = new AnualRequestDBContext();
        reqDBC.insert(req);
//        request.getRequestDispatcher("../view/anualrequest/Insert.jsp").forward(request, response);
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
