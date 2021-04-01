/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.entity.Estudiante;
import co.edu.unipiloto.entity.Estudiantecurso;
import co.edu.unipiloto.entity.EstudiantecursoPK;
import co.edu.unipiloto.session.EstudianteFacadeLocal;
import co.edu.unipiloto.session.EstudiantecursoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JEFRY
 */
@WebServlet(name = "StudentInfo", urlPatterns = {"/StudentInfo"})
public class StudentInfo extends HttpServlet {

    @EJB(name = "EstudianteFacad")
    private EstudianteFacadeLocal estudianteFacad;

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
            
            String action = request.getParameter("action");
            
            String studentIdStr=request.getParameter("studentId");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String yearLevelStr = request.getParameter("yearLevel");

            Integer studentId = 0;
            Integer yearLevel = 0;
            if (yearLevelStr!=null && !yearLevelStr.equals("")) 
            {studentId = Integer.parseInt(studentIdStr);
            }
            if (studentIdStr!=null && !studentIdStr.equals("")) 
            {yearLevel = Integer.parseInt(yearLevelStr);
            }
            
            Estudiante estudiante = new Estudiante(studentId, firstName, lastName, yearLevel);
            
            if (action.equals("Add")) 
            {
                estudianteFacad.create(estudiante);
            }
            else if (action.equals("Edit")) {
                estudianteFacad.edit(estudiante);
            }
            else if (action.equals("Delete")) {
                estudianteFacad.remove(estudiante);
            }
            else if (action.equals("Search")) {
                estudiante=estudianteFacad.find(estudiante.getStudentid());
            }
            request.setAttribute("student", estudiante);
            request.setAttribute("allStudents", estudianteFacad.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
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
