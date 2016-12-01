/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import facade.ProductoLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Productos;

/**
 *
 * @author Buging
 */
@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {
    
    @EJB
    private ProductoLocal productoFacade;
    
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
     
        String action = request.getParameter("action");
        String productoIdStr = request.getParameter("productoId");
        int productoId=0;
        if(productoIdStr!=null && !productoIdStr.equals("")){
            productoId=Integer.parseInt(productoIdStr);    
        }
        String nombreProducto = request.getParameter("nombreProducto");
        String cantidadProductoStr = request.getParameter("cantidadProducto");
        int cantidadProducto=0;
        if(cantidadProductoStr!=null && !cantidadProductoStr.equals("")){
            cantidadProducto=Integer.parseInt(cantidadProductoStr);    
        }
        Productos producto = new Productos(productoId, nombreProducto,cantidadProducto);
        
        if("Add".equalsIgnoreCase(action)){
            productoFacade.addProducto(producto);
        }else if("Edit".equalsIgnoreCase(action)){
            productoFacade.editProducto(producto);
        }else if("Delete".equalsIgnoreCase(action)){
            productoFacade.deleteProducto(productoId);
        }else if("Search".equalsIgnoreCase(action)){
            producto = productoFacade.getProducto(productoId);
        }
        request.setAttribute("producto", producto);
        request.setAttribute("allProductos", productoFacade.getAllProductos());
        request.getRequestDispatcher("productoinfo.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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