/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bussines.SubsidyTypeBussines;
import Entidades.EntSubsidiesType;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josef
 */
public class SubsidiesTypeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try {
            SubsidyTypeBussines subsidyTypeBussines = new SubsidyTypeBussines();
            EntSubsidiesType subsidyType = new EntSubsidiesType();
            String info = "";
            
            if (request.getParameter("action") != null && !request.getParameter("action").isEmpty()) {
                switch(request.getParameter("action")){
                    case "Guardar" :
                        subsidyType = composeSubsidyType(request);
                        info = subsidyTypeBussines.saveSubsidyType(subsidyType);
                        subsidyType = new EntSubsidiesType();
                        break;
                    case "Borrar" :
                        info = subsidyTypeBussines.deleteSubsidyType(request.getParameter("idsubsidyTypes"));
                        break;
                }
            }
            
            try {
                request.setAttribute("info", info);
                request.setAttribute("list", subsidyTypeBussines.subsidiesTypeList(subsidyType));
                request.getRequestDispatcher("/SubsidyType.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(SubsidiesTypeServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error general : " + e.getMessage());
        }
    }

    public EntSubsidiesType composeSubsidyType(HttpServletRequest request) {
        EntSubsidiesType subsidyType = new EntSubsidiesType();
        subsidyType.setIdsubsidyTypes(request.getParameter("idsubsidyTypes") != null && !request.getParameter("idsubsidyTypes").isEmpty() ? Integer.parseInt(request.getParameter("idsubsidyTypes")) : 0);
        subsidyType.setNombre(request.getParameter("nombre")); 
        subsidyType.setDescripcion(request.getParameter("descripcion"));
        subsidyType.setValueAtDiscretion(request.getParameter("valueAtDiscretion") != null && !request.getParameter("valueAtDiscretion").isEmpty() ? Double.parseDouble(request.getParameter("valueAtDiscretion")) : null);      
        return subsidyType;
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SubsidiosServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(SubsidiosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
