package net.javaguides.voiture.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.voiture.dao.VoitureDAO;
import net.javaguides.voiture.model.Voiture;


@WebServlet("/")
public class VoitureServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VoitureDAO voitureDao;

    public void init() {
        voitureDao = new VoitureDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertVoiture(request, response);
                    break;
                case "/delete":
                    deleteVoiture(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateVoiture(request, response);
                    break;
                default:
                    listVoiture(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listVoiture(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Voiture > listVoiture = voitureDao.getAllVoiture();
        request.setAttribute("listVoiture", listVoiture);
        RequestDispatcher dispatcher = request.getRequestDispatcher("voiture-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("voiture-form.jsp");
        dispatcher.forward(request, response);
    }

 private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Voiture existingUser = voitureDao.getVoiture(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("voiture-form.jsp");
        request.setAttribute("voiture", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertVoiture(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String nom = request.getParameter("nom");
        String matricule = request.getParameter("matricule");
        Voiture newVoiture = new Voiture(nom, matricule);
        voitureDao.saveVoiture(newVoiture);
        response.sendRedirect("list");
    }

    private void updateVoiture(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String matricule = request.getParameter("matricule");

        Voiture voiture = new Voiture(id, nom, matricule);
        voitureDao.updateVoiture(voiture);
        response.sendRedirect("list");
    }

    private void deleteVoiture(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        voitureDao.deleteVoiture(id);
        response.sendRedirect("list");
    }
}