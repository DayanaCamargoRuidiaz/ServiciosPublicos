package Servlets;

import Bussines.SubsidyBussines;
import Entidades.EntSubsidies;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jeison Goinzález Cifuentes
 */

public class SubsidiosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        try {
            SubsidyBussines subsidyBussines = new SubsidyBussines();
            EntSubsidies subsidy = new EntSubsidies();
            String info = "";
            
            if (request.getParameter("action") != null && !request.getParameter("action").isEmpty()) {
                switch(request.getParameter("action")){
                    case "Guardar" :
                        subsidy = composeSubsidy(request);
                        info = subsidyBussines.saveSubsidy(subsidy);
                        subsidy = new EntSubsidies();
                        break;
                    case "Borrar" :
                        info = subsidyBussines.deleteSubsidy(request.getParameter("idSybsudy"));
                        break;
                    case "Buscar" :
                        subsidy.setName(request.getParameter("search"));
                        subsidy.setDescription(request.getParameter("search"));
                        break;
                    case "Calcular" :
                        subsidy = composeSubsidy(request);
                        info = subsidyBussines.calculateSubsidy(subsidy);
                        subsidy = new EntSubsidies();
                        break;
                }
            }
            
            try {
                request.setAttribute("info", info);
                request.setAttribute("list", subsidyBussines.subsidiesList(subsidy));
                request.getRequestDispatcher("/Subsidy.jsp").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(SubsidiosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (NumberFormatException | SQLException e) {
            System.out.println("Error general : " + e.getMessage());
        }
    }

    public EntSubsidies composeSubsidy(HttpServletRequest request) {
        EntSubsidies subsidy = new EntSubsidies();
        subsidy.setIdSybsudy(request.getParameter("idSybsudy") != null && !request.getParameter("idSybsudy").isEmpty() ? Integer.parseInt(request.getParameter("idSybsudy")) : 0);
        subsidy.setEndDate(request.getParameter("endDate") != null && !request.getParameter("endDate").isEmpty() ? Date.valueOf(request.getParameter("endDate")) : null);
        subsidy.setStartDate(request.getParameter("startDate") != null && !request.getParameter("startDate").isEmpty() ? Date.valueOf(request.getParameter("startDate")) : null);
        subsidy.setName(request.getParameter("name"));
        subsidy.setDescription(request.getParameter("description"));
        subsidy.setExpectedEnergyValue(request.getParameter("expectedEnergyValue") != null &&  !request.getParameter("expectedEnergyValue").isEmpty() ? Double.parseDouble(request.getParameter("expectedEnergyValue")) : null);
        subsidy.setExpectedNaturalGasValue(request.getParameter("expectedNaturalGasValue") != null &&  !request.getParameter("expectedNaturalGasValue").isEmpty() ? Double.parseDouble(request.getParameter("expectedNaturalGasValue")) : null);
        subsidy.setExpectedWaterValue(request.getParameter("expectedWaterValue") != null &&  !request.getParameter("expectedWaterValue").isEmpty() ? Double.parseDouble(request.getParameter("expectedWaterValue")) : null);
        subsidy.setType(1);
        return subsidy;
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
