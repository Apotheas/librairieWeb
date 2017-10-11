/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.servlets;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.server.domain.customers.Customer;
import com.cdi.g3.web.beans.beanCatalog;
import com.cdi.g3.web.beans.beanCustomer;
import com.cdi.g3.web.beans.beanLogin;
import com.cdi.g3.web.beans.beanPagination;
import com.cdi.g3.web.beans.beanPanier;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cdi314
 */
@WebServlet(name = "controller", urlPatterns = {"/controller"})
public class controller extends HttpServlet {

    private Cookie getCookie(Cookie[] cookies, String name) {
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
        return null;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = "/WEB-INF/home.jsp";

        HttpSession session = request.getSession();
        ServletContext application = this.getServletContext();
        
         // Charger le bean pagination dans la application
        if (application.getAttribute("pagination") == null) {
            beanPagination bPagination
                    = (beanPagination) application.getAttribute("pagination");
            if (bPagination == null) {
                bPagination = new beanPagination();
                application.setAttribute("pagination", bPagination);
            }
        }
        

        // Charger le catalog dans la application
        if (application.getAttribute("catalog") == null) {
            beanCatalog bCatalog
                    = (beanCatalog) application.getAttribute("catalog");
            if (bCatalog == null) {
                try {
                    bCatalog = new beanCatalog();
                } catch (ObjectNotFoundException ex) {
                    ex.printStackTrace();
                }
                application.setAttribute("catalog", bCatalog);
            }
            int page = 1;

            String pageNumberValue = request.getParameter("pageHome");
            if (pageNumberValue != null) {
                try {
                    page = Integer.parseInt(pageNumberValue);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            beanPagination bPagination = (beanPagination) application.getAttribute("pagination");
            bPagination.setOffset(bPagination.getRecordsPerPage() * (page - 1));
            request.setAttribute("pages", bPagination.getPages(bCatalog.getBooksCatalog()));
            request.setAttribute("noOfPages", bPagination.getNoOfPages(bCatalog.getBooksCatalog()));
            request.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(bCatalog.getBooksCatalog()));
        
        }

        if (request.getParameter("pageHome") == null) {
            int pageHome = 1;
            request.setAttribute("currentPage", pageHome);
        }
        // Fin de chargement du catalog dans la application        
        if ("pagination".equals(request.getParameter("section"))) {
            
            if ((request.getParameter("pageHome") != null)) {
            url = "/WEB-INF/home.jsp";
            beanPagination bPagination = (beanPagination) application.getAttribute("pagination");
            beanCatalog bCatalog = (beanCatalog) application.getAttribute("catalog");
            int pageHome;
            if (request.getParameter("pageHome") == null) {
                pageHome = 1;
            }
            if (request.getParameter("pageHome") != null) {
                pageHome = Integer.parseInt(request.getParameter("pageHome"));
                bPagination.setOffset(bPagination.getRecordsPerPage() * (pageHome - 1));
            request.setAttribute("pages", bPagination.getPages(bCatalog.getBooksCatalog()));
            request.setAttribute("noOfPages", bPagination.getNoOfPages(bCatalog.getBooksCatalog()));
            request.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(bCatalog.getBooksCatalog()));
            request.setAttribute("currentPage", pageHome);
            }
        }
        
    }

        if ("catalog".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspCatalog.jsp";
        }

        if ("panier".equals(request.getParameter("section"))) {
            beanPanier bPanier
                    = (beanPanier) session.getAttribute("panier");
            if (bPanier == null) {
                bPanier = new beanPanier();
                session.setAttribute("panier", bPanier);
            }
            if (request.getParameter("add") != null) {
                bPanier.add(request.getParameter("add"));

            }
            if (request.getParameter("dec") != null) {
                bPanier.dec(request.getParameter("dec"));
            }
            if (request.getParameter("del") != null) {
                bPanier.del(request.getParameter("del"));
            }
            if (request.getParameter("clear") != null) {
                bPanier.clear();
            }

            if (request.getParameter("affichePanier") != null) {
                url = "/WEB-INF/jspCartShopping.jsp";
                bPanier
                        = (beanPanier) session.getAttribute("panier");
                if (bPanier == null) {
                    bPanier = new beanPanier();
                    session.setAttribute("panier", bPanier);
                }
                request.setAttribute("panierVide", bPanier.isEmpty());
                request.setAttribute("panier", bPanier.list());

            }
        }

        if ("login".equals(request.getParameter("section"))) {

            if (request.getParameter("signOn") != null) {
                url = "/WEB-INF/jspFormLogin.jsp";
            }

            if (request.getParameter("doIt") != null) {
                beanLogin bLogin
                        = (beanLogin) application.getAttribute("beanLogin");
                if (bLogin == null) {
                    bLogin = new beanLogin();
                    application.setAttribute("beanLogin", bLogin);
                }
                if (bLogin.checkLogin(request.getParameter("login"),
                        request.getParameter("password"))) {
                    url = "/WEB-INF/jspWelcome.jsp";
                    String welcome = request.getParameter("login");

                    request.setAttribute("Welcome", welcome);
                    ////ajouter session aussi 
                    session.setAttribute("Welcome", welcome);
                    Cookie cc = new Cookie("ok", welcome);
                    response.addCookie(cc);

                    beanCustomer bCustomer
                            = (beanCustomer) session.getAttribute("beanCustomer");
                    if (bCustomer == null) {
                        try {
                            bCustomer = new beanCustomer(request.getParameter("login"));
                        } catch (ObjectNotFoundException ex) {
                            ex.printStackTrace();
                        } catch (CheckException ex) {
                            ex.printStackTrace();
                        }
                        session.setAttribute("beanCustomer", bCustomer);
                    }
                    session.setAttribute("beanCustomer", bCustomer);

                    cc = new Cookie("try", "");
                    cc.setMaxAge(0);
                    response.addCookie(cc);
                } else {
                    url = "/WEB-INF/jspFormLogin.jsp";
                    request.setAttribute("user",
                            request.getParameter("login"));
                    request.setAttribute("msg",
                            "Utilisateur/Mot de passe invalide !!!");
                    Cookie cc = getCookie(request.getCookies(), "try");
                    if (cc == null) {
                        cc = new Cookie("try", "*");
                    } else {
                        cc.setValue(cc.getValue() + "*");
                    }
                    cc.setMaxAge(45);
                    response.addCookie(cc);
                    if (cc.getValue().length() >= 3) {
                        url = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError",
                                "Trop de tentatives !!");
                    }
                }
            }

            Cookie c = getCookie(request.getCookies(), "ok");
            if (c != null) {
                url = "/WEB-INF/jspWelcome.jsp";
                request.setAttribute("Welcome", c.getValue());
            }

            Cookie ccc = getCookie(request.getCookies(), "try");
            if (ccc != null) {
                if (ccc.getValue().length() >= 3) {
                    url = "/WEB-INF/jspFatalError.jsp";
                    request.setAttribute("fatalError",
                            "Trop de tentatives !!!");
                }
            }

            if (request.getParameter("deconnect") != null) {
                url = "/WEB-INF/jspFormLogin.jsp";

                //detruire la session et vider le cader
                beanPanier bPanier = (beanPanier) session.getAttribute("beanPanier");
                if (bPanier != null) {
                    bPanier.clear();
                }
                session.invalidate();

                request.setAttribute("user", c.getValue());
                Cookie cc = new Cookie("ok", "");
                cc.setMaxAge(0);
                response.addCookie(cc);
            }
        }

        System.out.println(url);
        System.out.println(request.getRequestURI());

        request.getRequestDispatcher(url).include(request, response);
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
