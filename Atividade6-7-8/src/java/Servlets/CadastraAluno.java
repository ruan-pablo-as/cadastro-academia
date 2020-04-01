/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.AlunoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;

/**
 *
 * @author r_pab
 */
public class CadastraAluno extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8"); 
        try (PrintWriter out = response.getWriter()) {
            Aluno aluno = new Aluno();
            String nome = (String) request.getParameter("nome");
            out.println(nome + "    ");
            String email = (String) request.getParameter("email");
            out.println(email + "    ");
            String telMask = (String) request.getParameter("tel");
            String replace = telMask.replace("(","").replace(")","").replace("-","");
            long tel = Long.parseLong(replace);
            out.println(tel + "    ");
            String rua = (String) request.getParameter("rua");
            out.println(rua + "    ");
            String numrua = (String) request.getParameter("num");
            out.println(numrua + "    ");
            String sex = (String) request.getParameter("sex");
            out.println(sex + "    ");
            String ativ = (String) request.getParameter("atv");
            String atv = "erro";
            switch (ativ) {
                case "1":
                    atv = "Musculação";
                    break;
                case "2":
                    atv = "Crossfit";
                    break;
                case "3":
                    atv = "Pilates";
                    break;
                default:
                    break;
            }
            out.println(atv + "    ");
            aluno.setNome(nome);
            aluno.setEmail(email);
            aluno.setTel(tel);
            aluno.setRua(rua);
            aluno.setNumRua(numrua);
            aluno.setSexo(sex);
            aluno.setAtv(atv);
            out.println("    até aqui tudo bem");
            AlunoDAO.insereAluno(aluno);
            out.println("    Se passou daqui deu bom");
            RequestDispatcher rd = request.getRequestDispatcher("exer3.2.html");
            rd.forward(request, response);
            
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
