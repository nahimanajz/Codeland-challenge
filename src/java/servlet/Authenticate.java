/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.pharmacy.model.UserModel;
import pharmacy.db.CoreDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pharmacy.controller.Admin;
import pharmacy.controller.Patient;
import pharmacy.controller.Pharmacist;
import pharmacy.controller.Physician;

/**
 *
 * @author janvier
 */
@WebServlet(name = "Authenticate", urlPatterns = {"/Authenticate"})
public class Authenticate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(req, response);
        PrintWriter out;
        out = response.getWriter();

     
        String username = req.getParameter("username");
        String password = req.getParameter("password");

       	
        Admin admin = new Admin();
        Patient patient = new Patient();        
        Pharmacist pharmacist = new Pharmacist();       
        Physician physician = new Physician();
        
        //String usertype = null;
        
        if(admin.login(password, username) != null){
           // usertype = admin.login(password, username);    
           out.print("Password:"+ password +"\n Username =>" + username +" -->"+ admin.login(password, username));
        }
        
        /*else if(patient.login(password, username) != null) {
             usertype = patient.login(password, username);
             
        } else if(pharmacist.login(password, username) != null) {
             usertype = pharmacist.login(password, username);
            
        } else if(physician.login(password, username) != null) {
            
            usertype = physician.login(password, username);
            
        } 
        */
        
        // out.print(admin.login(password, username));
        
	}


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
