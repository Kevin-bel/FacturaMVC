/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.controlador;

import ec.edu.intsuperior.modelo.modelo;
import ec.edu.intsuperior.modelo.producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
public class controlador extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
         producto pr= new producto ();
         
         //Zona de variables
         String nombrepro, cant, pre;
         int cantidad;
         double precio, Total, subtotal, iva, precioTotal;     
         Total=0;
         subtotal= 0;
         iva=0;
        
        //Captura de datos
        nombrepro= request.getParameter("txtpro");
        cant= request.getParameter("txtcant");
        pre= request.getParameter("txtpre");
        
        //convierto a double
        cantidad= Integer.parseInt(cant);
        precio= Double.parseDouble(pre);
       
        precioTotal=pr.total(iva, precio);
        //Instancio la clase
        modelo d = new modelo(nombrepro, cantidad, precio, precioTotal);
        
        //Zona de arraylist
        ArrayList<modelo> Modelo=  (ArrayList<modelo>)request.getSession().getAttribute("mypro");
        
        if(Modelo==null){
            Modelo=new ArrayList<>();
            Modelo.add(d);
            request.getSession().setAttribute("mypro", Modelo);
            
        }else{
            Modelo.add(d);
            request.getSession().setAttribute("mypro", Modelo); 
            request.getRequestDispatcher("agregado.jsp").forward(request, response);
        }
        for(int i =0; i<Modelo.size();i++){
            subtotal=subtotal+Modelo.get(i).getTotalpaga();
            request.getRequestDispatcher("agregado.jsp").forward(request, response);
        }
        iva=pr.iva(subtotal);
        Total=pr.totalpagar(subtotal, iva);
        
        //devuelvo resultados
        request.getAttribute("txtsub"+subtotal);
        request.getAttribute("txtiva"+iva);
        request.getAttribute("txtTotal"+Total);
        request.setAttribute("txtpro", nombrepro);
        request.setAttribute("txtcant", cantidad);
        request.setAttribute("txtpre", precio);
        RequestDispatcher rd = request.getRequestDispatcher("todo.jsp");
        rd.forward(request, response);
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
