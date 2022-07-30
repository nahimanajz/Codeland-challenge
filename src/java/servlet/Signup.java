/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.google.gson.Gson;
import com.pharmacy.model.UserModel;
import pharmacy.controller.*;


import pharmacy.helpers.ValidatePassword;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author janvier
 */
@WebServlet(name = "Signup", urlPatterns = {"/Signup"})
public class Signup extends HttpServlet {
    PrintWriter out;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
                
                 out = response.getWriter();
               try {
      
                Admin admin = new Admin();
		Patient patient = new Patient();
                Pharmacist pharmacist = new Pharmacist();
                Physician physician = new Physician();


		LinkedHashMap<Integer, UserModel> lhmUsers = new LinkedHashMap<Integer, UserModel>();

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("retype_password");		
		String role = req.getParameter("usertype");		
		int age = Integer.parseInt(req.getParameter("age"));
                boolean detectError = false;
                
                String successMessage = null;
                
                if(password.equals(confirmPassword) == false){
                    detectError = true;
                    successMessage= "Passwords do not match";
                    
                }
                UserModel um = new UserModel();
                
		um.setUsername(username);
		um.setFname(req.getParameter("fname"));
		um.setLname(req.getParameter("lname"));
		um.setAge(age);
		um.setPhoneNumber(req.getParameter("phoneNumber"));		
		um.setUserPassword(password);
                um.setUserRole(role);
		um.setGender(req.getParameter("gender"));
                    
                   if(ValidatePassword.getInstance().isNumber(password)) {
                       
                       if(um.getUserRole().equalsIgnoreCase("admin")){
                            if(ValidatePassword.getInstance().adminPassword(password) == true){
                                lhmUsers = admin.signup(um);
                                successMessage = "Admin account is created successfully";
                            }else{
                                successMessage="Password should be 8 numbers";
                                                       
                            }
                     }else if(um.getUserRole().equalsIgnoreCase("Patient")){
                         if(ValidatePassword.getInstance().patientPassword(password) == true){
                          lhmUsers = patient.signup(um);  
                           successMessage = "Patient account is created successfully";
                         }else {                             
                              successMessage = "Password should be only 7 numbers";
                              detectError = true;
                         }
                     }else if(um.getUserRole().equalsIgnoreCase("Physician")){
                     
                         if(ValidatePassword.getInstance().physicianPassword(password) == true){
                          lhmUsers = physician.signup(um);  
                            successMessage = "Physician account is created successfully";
                         }else {                             
                             successMessage =  "Password should be only 6 numbers";
                             detectError = true;
                         }
                     
                     }else if(um.getUserRole().equalsIgnoreCase("pharmacist")){
                         
                         if(ValidatePassword.getInstance().pharmacistPassword(password) == true){
                          lhmUsers = pharmacist.signup(um);  
                           successMessage = "Pharmacist account is created";
                         }else {                           
                            
                             successMessage = "Password should be only 5 numbers";
                         }
                     
                     }
                       
                   } else {
                       successMessage = "Password must be number";
                   }
                 
                  out.print(successMessage);
                   
		
               if(detectError == true){
                    successMessage = "Something went wrong";
               }
               } catch (Exception e) {
		    e.printStackTrace();
                    out.print(e.getMessage());
	        }
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
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
    private void setSession(HttpServletRequest req, String key, String value){        
        req.setAttribute(key, value);
    }
   
}
