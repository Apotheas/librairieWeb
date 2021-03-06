/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.servlets;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.CreateException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.exception.UpdateException;
import com.cdi.g3.common.utiles.Utility;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.company.Company;
import com.cdi.g3.server.domain.customers.Address;
import com.cdi.g3.server.domain.customers.Customer;
import com.cdi.g3.server.service.GeneratorInvoice;
import com.cdi.g3.web.beans.beanAddress;
import com.cdi.g3.web.beans.beanCatalog;
import com.cdi.g3.web.beans.beanCustomer;
import com.cdi.g3.web.beans.beanEvent;
import com.cdi.g3.web.beans.beanLogin;
import com.cdi.g3.web.beans.beanOrder;
import com.cdi.g3.web.beans.beanPagination;
import com.cdi.g3.web.beans.beanPanier;
import com.cdi.g3.web.beans.beanTheme;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        /*==========================================================================================================/
         |
         |   Début du controleur     
         |
         /*===========================================================================================================*/

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

        /*==========================================================================================================/
         |
         |    Charger le catalog dans la application
         |
         /*===========================================================================================================*/
        if (application.getAttribute("catalog") == null || request.getParameter("home") != null) {

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
            application.setAttribute("pages", bPagination.getPages(bCatalog.getBooksCatalog()));
            application.setAttribute("noOfPages", bPagination.getNoOfPages(bCatalog.getBooksCatalog()));
            application.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(bCatalog.getBooksCatalog()));
            bPagination.setPagination("catalog");

        }

        if (request.getParameter("pageHome") == null) {
            int pageHome = 1;
            request.setAttribute("currentPage", pageHome);
        }
        // Fin de chargement du catalog dans la application        

//        
        if ("catalog".equals(request.getParameter("section"))) {
            url = "/WEB-INF/jspCatalog.jsp";
        }

        /*==========================================================================================================/
         |
         |    Charger la barre des themes
         |
         /*===========================================================================================================*/
        url = "/WEB-INF/home.jsp";
        beanPagination bPagination = (beanPagination) application.getAttribute("pagination");
        beanCatalog bCatalog = (beanCatalog) application.getAttribute("catalog");

        if (request.getParameter("theme") == null) {
            beanTheme bTheme = null;
            if (application.getAttribute("theme") == null) {
                if (bTheme == null) {
                    try {
                        bTheme = new beanTheme();
                        application.setAttribute("theme", bTheme.getThemes());
                    } catch (ObjectNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        if (request.getParameter("theme") != null) {
            int pageHome = 1;
            if ((request.getParameter("pageHome") != null)) {
                pageHome = Integer.parseInt(request.getParameter("pageHome"));
            }
            String nameTheme = request.getParameter("theme");
            request.setAttribute("theme", application.getAttribute("theme"));

            if (request.getParameter("sub") != null) {
                bPagination.setPagination("sub");
                String nameSub = request.getParameter("sub");
                Collection bookSubList = bCatalog.getBooksbySub(nameSub, nameTheme);
                if (bookSubList != null) {
                    bCatalog.setBooks(bookSubList);
                    bPagination.setOffset(bPagination.getRecordsPerPage() * (pageHome - 1));
                    request.setAttribute("pages", bPagination.getPages(bookSubList));
                    request.setAttribute("noOfPages", bPagination.getNoOfPages(bookSubList));
                    request.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(bookSubList));
                } else {
                    request.setAttribute("listVide", "il n'y a pas de livre pour ce sous theme pour le moment");

                }
            } else {
                bPagination.setPagination("theme");
                Collection bookThemeList = bCatalog.getBooksbyTheme(nameTheme);
                if (bookThemeList != null) {
                    bCatalog.setBooks(bookThemeList);
                    bPagination.setOffset(bPagination.getRecordsPerPage() * (pageHome - 1));
                    request.setAttribute("pages", bPagination.getPages(bookThemeList));
                    request.setAttribute("noOfPages", bPagination.getNoOfPages(bookThemeList));
                    request.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(bookThemeList));
                } else {
                    request.setAttribute("listVide", "il n'y a pas de livre pour ce sous theme pour le moment");

                }

            }

        }
        if (request.getParameter("event") == null) {
            beanEvent bEvent = null;
            if (application.getAttribute("event") == null) {
                if (bEvent == null) {
                    try {
                        bEvent = new beanEvent();
                        application.setAttribute("event", bEvent.getOccasions());
                    } catch (ObjectNotFoundException ex) {
                        url = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", ex.getMessage());
                    }
                }
            }
        }
        if (request.getParameter("event") != null) {
            int pageHome = 1;
            if ((request.getParameter("pageHome") != null)) {
                pageHome = Integer.parseInt(request.getParameter("pageHome"));
            }
            String nameOccasion = request.getParameter("event");
            request.setAttribute("event", application.getAttribute("event"));
            bPagination.setPagination("event");
            Collection bookEventList = bCatalog.getBooksbyOccasion(nameOccasion);
            if (bookEventList != null) {
                bCatalog.setBooks(bookEventList);
                bPagination.setOffset(bPagination.getRecordsPerPage() * (pageHome - 1));
                request.setAttribute("pages", bPagination.getPages(bookEventList));
                request.setAttribute("noOfPages", bPagination.getNoOfPages(bookEventList));
                request.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(bookEventList));
            } else {
                request.setAttribute("listVide", "il n'y a pas de livre pour cet evenement");

            }
        }

        /*==========================================================================================================/
         |
         |    Section pagination
         |
         /*===========================================================================================================*/
        if ("pagination".equals(request.getParameter("section"))) {
            int pageHome = 1;
            if ((request.getParameter("pageHome") != null)) {
                pageHome = Integer.parseInt(request.getParameter("pageHome"));
            }

            if ("sub".equals(bPagination.getPagination())) {
                bPagination.setPagination("sub");
                Collection bookSubList = bCatalog.getBooks();
                bPagination.setOffset(bPagination.getRecordsPerPage() * (pageHome - 1));
                request.setAttribute("currentPage", pageHome);
                request.setAttribute("pages", bPagination.getPages(bookSubList));
                request.setAttribute("noOfPages", bPagination.getNoOfPages(bookSubList));
                request.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(bookSubList));
            }
            if ("theme".equals(bPagination.getPagination())) {
                bPagination.setPagination("theme");
                Collection bookThemeList = bCatalog.getBooks();
                bPagination.setOffset(bPagination.getRecordsPerPage() * (pageHome - 1));
                request.setAttribute("currentPage", pageHome);
                request.setAttribute("pages", bPagination.getPages(bookThemeList));
                request.setAttribute("noOfPages", bPagination.getNoOfPages(bookThemeList));
                request.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(bookThemeList));
            }

            if ("catalog".equals(bPagination.getPagination())) {
                bPagination.setPagination("catalog");
                request.setAttribute("currentPage", pageHome);
                bPagination.setOffset(bPagination.getRecordsPerPage() * (pageHome - 1));
                request.setAttribute("pages", bPagination.getPages(bCatalog.getBooksCatalog()));
                request.setAttribute("noOfPages", bPagination.getNoOfPages(bCatalog.getBooksCatalog()));
                request.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(bCatalog.getBooksCatalog()));

            }
        }

        /*==========================================================================================================/
         |
         |    Section Panier
         |
         /*===========================================================================================================*/
        if ("panier".equals(request.getParameter("section"))) {
            beanPanier bPanier
                    = (beanPanier) session.getAttribute("panier");
            if (bPanier == null) {
                bPanier = new beanPanier();
                session.setAttribute("panier", bPanier);
            }
            if (request.getParameter("add") != null) {
                try {
                    bPanier.add(request.getParameter("add"));
                } catch (FinderException ex) {
                    url = "/WEB-INF/jspFatalError.jsp";
                    request.setAttribute("fatalError", ex.getMessage());
                } catch (CheckException ex) {
                    url = "/WEB-INF/jspFatalError.jsp";
                    request.setAttribute("fatalError", ex.getMessage());
                }
                session.setAttribute("size", bPanier.getSize());
                session.setAttribute("subTotalHT", bPanier.getTotalHT());
                session.setAttribute("fraisPort", bPanier.getFraisPort());
                session.setAttribute("tva", bPanier.getTva());
                session.setAttribute("subTotalTCC", bPanier.getTotalTTC());
                float TotalTCCAvecFraisPort = bPanier.getTotalTTC() + bPanier.getFraisPort();
                TotalTCCAvecFraisPort = Utility.formatFloatToFloatPrecision(TotalTCCAvecFraisPort, 2);
                session.setAttribute("TotalTCCAvecFraisPort", TotalTCCAvecFraisPort);

            }
            if (request.getParameter("dec") != null) {
                try {
                    bPanier.dec(request.getParameter("dec"));
                } catch (FinderException ex) {
                    url = "/WEB-INF/jspFatalError.jsp";
                    request.setAttribute("fatalError", ex.getMessage());
                } catch (CheckException ex) {
                    url = "/WEB-INF/jspFatalError.jsp";
                    request.setAttribute("fatalError", ex.getMessage());
                }
                session.setAttribute("size", bPanier.getSize());
                request.setAttribute("subTotalHT", bPanier.getTotalHT());
            }
            if (request.getParameter("del") != null) {
                bPanier.del(request.getParameter("del"));
                session.setAttribute("size", bPanier.getSize());
                request.setAttribute("subTotalHT", bPanier.getTotalHT());
            }
            if (request.getParameter("clear") != null) {
                bPanier.clear();
                session.setAttribute("size", bPanier.getSize());
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

        /*==========================================================================================================/
         |
         |    selectionner adresses
         |
         /*===========================================================================================================*/
        beanCustomer bCustomer = (beanCustomer) session.getAttribute("bCustomer");

        if (bCustomer != null) {
            if (request.getParameter("selectAddressShip") != null) {

                String idAddress = request.getParameter("addressShip");
                for (Address address : (ArrayList<Address>) bCustomer.getAddressShipList()) {
                    if (address.getId().equals(idAddress)) {
                        bCustomer.setAddressShip(address);
                    }
                }

                if (request.getParameter("provenance").equals("order")) {
                    url = "/WEB-INF/jspAddAddressesOrder.jsp";
                }
                if (request.getParameter("provenance").equals("customer")) {
                    url = "/WEB-INF/jspCustomer.jsp";
                }

            }

            if (request.getParameter("selectAddressBill") != null) {

                String idAddress = request.getParameter("addressBill");
                for (Address address : (ArrayList<Address>) bCustomer.getAddressBillList()) {
                    if (address.getId().equals(idAddress)) {
                        bCustomer.setAddressBill(address);

                    }
                }

                if (request.getParameter("provenance").equals("order")) {
                    url = "/WEB-INF/jspAddAddressesOrder.jsp";
                }

                if (request.getParameter("provenance").equals("customer")) {
                    url = "/WEB-INF/jspCustomer.jsp";
                }
            }

        }

        /*==========================================================================================================/
         |
         |    Section Order
         |
         /*===========================================================================================================*/
        if ("order".equals(request.getParameter("section"))) {
            String login = (String) session.getAttribute("Welcome");
            bCustomer = (beanCustomer) session.getAttribute("bCustomer");

            if (request.getParameter("checkOut") != null) {
                url = "/WEB-INF/jspCheckOut.jsp";
                beanPanier bPanier = (beanPanier) session.getAttribute("panier");

                if (login == null) {
                    request.setAttribute("passOrder", "true");
                    url = "/WEB-INF/jspFormLogin.jsp";

                } else {

                    String orderId = null;
                    try {
                        orderId = bPanier.checkOut(login, bPanier.list());
                    } catch (CreateException ex) {
                        url = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", ex.getMessage());
                    } catch (CheckException ex) {
                        url = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", ex.getMessage());
                    } catch (FinderException ex) {
                        url = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", ex.getMessage());
                    }
                    request.setAttribute("orderId", orderId);

                    bPanier.clear();
                    session.setAttribute("size", bPanier.getSize());

                }
            }

            if (request.getParameter("AddAddressesOrder") != null) {

                if (request.getParameter("provenance").equals("order")) {
                    url = "/WEB-INF/jspAddAddressesOrder.jsp";
                }

                if (request.getParameter("provenance").equals("customer")) {
                    url = "/WEB-INF/jspCustomer.jsp";
                }

                if (login == null) {
                    url = "/WEB-INF/jspFormLogin.jsp";

                } else {

                    if (request.getParameter("updateAddressBill") != null) {
                        beanAddress bAddress = new beanAddress();
                        bAddress.getAddressBill().setId(request.getParameter("idAddress"));
                        bAddress.getAddressBill().setNameReceiverAdress(request.getParameter("nameReceiverAdress"));
                        if (request.getParameter("nameCompanyReceiverAdress") != null) {
                            bAddress.getAddressBill().setNameCompanyReceiverAdress(new Company(request.getParameter("nameCompanyReceiverAdress")));
                        }
                        bAddress.getAddressBill().setTypeStreetAdress(request.getParameter("typeStreetAdress"));
                        bAddress.getAddressBill().setNumAdress(request.getParameter("numAdress"));
                        bAddress.getAddressBill().setNameStreetAdress(request.getParameter("nameStreetAdress"));
                        bAddress.getAddressBill().setNameStreet2Adress(request.getParameter("nameStreet2Adress"));
                        bAddress.getAddressBill().setZipcodeAdress(request.getParameter("zipcodeAdress"));
                        bAddress.getAddressBill().setCityAdress(request.getParameter("cityAdress"));
                        bAddress.getAddressBill().setCountryAdress(request.getParameter("countryAdress"));
                        bAddress.getAddressBill().setCustomerBillAdress(bCustomer.getCustomer());
                        try {
                            bAddress.updateAddressBill(bCustomer.getCustomer().getLoginCustomer());
                        } catch (CreateException ex) {
                            url = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", ex.getMessage());
                        } catch (CheckException ex) {
                            url = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", ex.getMessage());
                        } catch (UpdateException ex) {
                            url = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", ex.getMessage());
                        } catch (FinderException ex) {
                            url = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", ex.getMessage());
                        }
                        bCustomer.setAddressBill(bAddress.getAddressBill());

                    }

                    if (request.getParameter("updateAddressShip") != null) {
                        beanAddress bAddress = bCustomer.getbAddress();
                        bAddress.getAddressShip().setId(request.getParameter("idAddress"));
                        bAddress.getAddressShip().setNameReceiverAdress(request.getParameter("nameReceiverAdress"));
                        if (request.getParameter("nameCompanyReceiverAdress") != null) {
                            bAddress.getAddressShip().setNameCompanyReceiverAdress(new Company(request.getParameter("nameCompanyReceiverAdress")));
                        }
                        bAddress.getAddressShip().setTypeStreetAdress(request.getParameter("typeStreetAdress"));
                        bAddress.getAddressShip().setNumAdress(request.getParameter("numAdress"));
                        bAddress.getAddressShip().setNameStreetAdress(request.getParameter("nameStreetAdress"));
                        bAddress.getAddressShip().setNameStreet2Adress(request.getParameter("nameStreet2Adress"));
                        bAddress.getAddressShip().setZipcodeAdress(request.getParameter("zipcodeAdress"));
                        bAddress.getAddressShip().setCityAdress(request.getParameter("cityAdress"));
                        bAddress.getAddressShip().setCountryAdress(request.getParameter("countryAdress"));
                        bAddress.getAddressShip().setCustomerBillAdress(bCustomer.getCustomer());
                        try {
                            bAddress.updateAddressShip(bCustomer.getCustomer().getLoginCustomer());
                        } catch (CreateException ex) {
                            url = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", ex.getMessage());
                        } catch (CheckException ex) {
                            ex.printStackTrace();
                            url = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", ex.getMessage());
                        } catch (UpdateException ex) {
                            url = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", ex.getMessage());
                        } catch (FinderException ex) {
                            url = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", ex.getMessage());
                        }
                        bCustomer.setAddressShip(bAddress.getAddressShip());

                    }
                    /*==========================================================================================================/
                     |
                     |    selectionner adresses
                     |
                     /*===========================================================================================================*/
                    bCustomer = (beanCustomer) session.getAttribute("bCustomer");

                    if (bCustomer != null) {
                        if (request.getParameter("selectAddressShip") != null) {

                            String idAddress = request.getParameter("addressShip");
                            for (Address address : (ArrayList<Address>) bCustomer.getAddressShipList()) {
                                if (address.getId().equals(idAddress)) {
                                    bCustomer.setAddressShip(address);
                                }
                            }

                            if (request.getParameter("provenance").equals("order")) {
                                url = "/WEB-INF/jspAddAddressesOrder.jsp";
                            }
                            if (request.getParameter("provenance").equals("customer")) {
                                url = "/WEB-INF/jspCustomer.jsp";
                            }

                        }

                        if (request.getParameter("selectAddressBill") != null) {

                            String idAddress = request.getParameter("addressBill");
                            for (Address address : (ArrayList<Address>) bCustomer.getAddressBillList()) {
                                if (address.getId().equals(idAddress)) {
                                    bCustomer.setAddressBill(address);

                                }
                            }

                            if (request.getParameter("provenance").equals("order")) {
                                url = "/WEB-INF/jspAddAddressesOrder.jsp";
                            }

                            if (request.getParameter("provenance").equals("customer")) {
                                url = "/WEB-INF/jspCustomer.jsp";
                            }
                        }

                    }

                }

            }

            if (request.getParameter("VerifCreditCardOrder") != null) {

                if (request.getParameter("DoIt") != null) {

                    if (request.getParameter("idAddressShip") != null && request.getParameter("idAddressBill") != null) {
                        url = "/WEB-INF/jspVerifCreditCardOrder.jsp";
                    }

                    if (request.getParameter("idAddressShip").isEmpty() || request.getParameter("idAddressBill").isEmpty()) {
                        url = "/WEB-INF/jspAddAddressesOrder.jsp";
                        request.setAttribute("retour","ok");
                    }
                }
            }

            if (request.getParameter("imprimer") != null) {
                try {
                    beanOrder bOrder = new beanOrder();
                    bOrder.print(request.getParameter("idOrder"));
                } catch (FinderException ex) {
                    url = "/WEB-INF/jspFatalError.jsp";
                    request.setAttribute("fatalError", ex.getMessage());
                } catch (CheckException ex) {
                    url = "/WEB-INF/jspFatalError.jsp";
                    request.setAttribute("fatalError", ex.getMessage());
                }

            }

        }

        /*==========================================================================================================/
         |
         |    Section Customer
         |
         /*===========================================================================================================*/
        if ("customer".equals(request.getParameter("section"))) {

            if (request.getParameter("afficheCustomer") != null) {
                url = "/WEB-INF/jspCustomer.jsp";

                bCustomer
                        = (beanCustomer) session.getAttribute("bCustomer");
            }

            if (request.getParameter("addCustomer") != null) {
                url = "/WEB-INF/jspRegister.jsp";

                if (request.getParameter("doIt") != null) {
                    bCustomer = new beanCustomer();

                    bCustomer.getCustomer().setLoginCustomer(request.getParameter("login"));
                    bCustomer.getCustomer().setFirstNameCustomer(request.getParameter("prenom"));
                    bCustomer.getCustomer().setLastNameCustomer(request.getParameter("nom"));
                    bCustomer.getCustomer().setEmailCustomer(request.getParameter("email"));
                    bCustomer.getCustomer().setPasswordCustomer(request.getParameter("password"));
                    bCustomer.setConfirmationPassword(request.getParameter("confirmation"));
                    try {
                        bCustomer = bCustomer.registerCustomer();
                        // puts the customer into the session
                        String welcome = request.getParameter("login");
                        bCustomer.initializeAddresses(request.getParameter("login"));
                        request.getSession().setAttribute("bCustomer", bCustomer);
                        request.getSession().setAttribute("Welcome", welcome);
                        Cookie cc = new Cookie("ok", welcome);
                        response.addCookie(cc);

                    } catch (CreateException ex) {
                        url = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", ex.getMessage());

                    } catch (CheckException ex) {
                        url = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", ex.getMessage());
                    }
                }
            }

            if (request.getParameter("update") != null) {
                if (request.getParameter("doIt") != null) {
                    url = "/WEB-INF/jspCustomer.jsp";
                    bCustomer = (beanCustomer) session.getAttribute("bCustomer");
                    bCustomer.getCustomer().setLoginCustomer(bCustomer.getCustomer().getId());
                    bCustomer.getCustomer().setFirstNameCustomer(request.getParameter("prenom"));
                    bCustomer.getCustomer().setLastNameCustomer(request.getParameter("nom"));
                    bCustomer.getCustomer().setEmailCustomer(bCustomer.getCustomer().getEmailCustomer());
                    bCustomer.getCustomer().setTelephoneCustomer(request.getParameter("telephoneCustomer"));
                    bCustomer.getCustomer().setNameCompanyCustomer(request.getParameter("nameCompanyCustomer"));

                    try {
                        bCustomer = bCustomer.updateCustomer();
                        request.getSession().setAttribute("bCustomer", bCustomer);
                    } catch (ObjectNotFoundException ex) {
                        url = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", ex.getMessage());
                    } catch (UpdateException ex) {
                        url = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", ex.getMessage());
                    } catch (CheckException ex) {
                        url = "/WEB-INF/jspFatalError.jsp";
                        request.setAttribute("fatalError", ex.getMessage());
                    }

                }
            }

        }
        /*==========================================================================================================/
         |
         |    Section Recherche
         |
         /*===========================================================================================================*/

        if (request.getParameter("keyword") != null) {

            String nameKeyWord = request.getParameter("keyword");

            try {
                bCatalog = new beanCatalog();

                if (bCatalog.getBooksbyKeyWord(nameKeyWord) != null) {

                    Collection bookKeyList = bCatalog.getBooksbyKeyWord(nameKeyWord);
                    application.setAttribute("catalog", bCatalog);

                    int page = 1;
                    String pageNumberValue = request.getParameter("pageHome");
                    if (pageNumberValue != null) {
                        try {
                            page = Integer.parseInt(pageNumberValue);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                    bPagination = (beanPagination) application.getAttribute("pagination");
                    bPagination.setOffset(bPagination.getRecordsPerPage() * (page - 1));
                    request.setAttribute("pages", bPagination.getPages(bookKeyList));
                    request.setAttribute("noOfPages", bPagination.getNoOfPages(bookKeyList));
                    request.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(bookKeyList));
                }

                if (bCatalog.getBooksbyAuthor(nameKeyWord) != null) {

                    Collection bookKeyList = bCatalog.getBooksbyAuthor(nameKeyWord);
                    application.setAttribute("catalog", bCatalog);

                    int page = 1;
                    String pageNumberValue = request.getParameter("pageHome");
                    if (pageNumberValue != null) {
                        try {
                            page = Integer.parseInt(pageNumberValue);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                    bPagination = (beanPagination) application.getAttribute("pagination");
                    bPagination.setOffset(bPagination.getRecordsPerPage() * (page - 1));
                    request.setAttribute("pages", bPagination.getPages(bookKeyList));
                    request.setAttribute("noOfPages", bPagination.getNoOfPages(bookKeyList));
                    request.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(bookKeyList));
                }

                if (bCatalog.getBooksbyTitle(nameKeyWord) != null) {

                    Collection bookKeyList = bCatalog.getBooksbyTitle(nameKeyWord);
                    application.setAttribute("catalog", bCatalog);

                    int page = 1;
                    String pageNumberValue = request.getParameter("pageHome");
                    if (pageNumberValue != null) {
                        try {
                            page = Integer.parseInt(pageNumberValue);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                    bPagination = (beanPagination) application.getAttribute("pagination");
                    bPagination.setOffset(bPagination.getRecordsPerPage() * (page - 1));
                    request.setAttribute("pages", bPagination.getPages(bookKeyList));
                    request.setAttribute("noOfPages", bPagination.getNoOfPages(bookKeyList));
                    request.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(bookKeyList));
                }

                if (bCatalog.getBooksbyEditor(nameKeyWord) != null) {

                    Collection bookKeyList = bCatalog.getBooksbyEditor(nameKeyWord);
                    application.setAttribute("catalog", bCatalog);

                    int page = 1;
                    String pageNumberValue = request.getParameter("pageHome");
                    if (pageNumberValue != null) {
                        try {
                            page = Integer.parseInt(pageNumberValue);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }
                    }
                    bPagination = (beanPagination) application.getAttribute("pagination");
                    bPagination.setOffset(bPagination.getRecordsPerPage() * (page - 1));
                    request.setAttribute("pages", bPagination.getPages(bookKeyList));
                    request.setAttribute("noOfPages", bPagination.getNoOfPages(bookKeyList));
                    request.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(bookKeyList));
                }
            } catch (ObjectNotFoundException ex) {
                System.out.println("Error loading book of keyword");
            }
        }

        /*==========================================================================================================/
         |
         |    Section Login
         |
         /*===========================================================================================================*/
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
                    Cookie cc;
                    bCustomer
                            = (beanCustomer) session.getAttribute("bCustomer");

                    if (bCustomer == null) {
                        try {
                            bCustomer = new beanCustomer(request.getParameter("login"));
                            bCustomer.initializeAddresses(request.getParameter("login"));
                            request.setAttribute("Welcome", welcome);
                            ////ajouter session aussi
                            session.setAttribute("Welcome", welcome);
                            cc = new Cookie("ok", welcome);
                            response.addCookie(cc);
                            session.setAttribute("bCustomer", bCustomer);
                        } catch (ObjectNotFoundException ex) {
                            ex.printStackTrace();
                            url = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", ex.getMessage());
                        } catch (CheckException ex) {
                            ex.printStackTrace();
                            url = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", ex.getMessage());
                        } catch (FinderException ex) {
                            ex.printStackTrace();
                            url = "/WEB-INF/jspFatalError.jsp";
                            request.setAttribute("fatalError", ex.getMessage());
                        }

                    }

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

        /*==========================================================================================================/
         |
         |    Section Book  -- Foued 
         |
         /*===========================================================================================================*/
        if (request.getParameter("showBook") != null) {
            url = "/WEB-INF/jspBook.jsp";
            String numISBN = request.getParameter("isbnBook");
            bCatalog = (beanCatalog) application.getAttribute("catalog");
            Book book;

            book = bCatalog.getBook(numISBN);

            request.setAttribute("book", book);

        }

        /*==========================================================================================================/
         |
         |    Section Tris 
         |
         /*===========================================================================================================*/
        if (request.getParameter("tris") != null) {

            Collection listTris = null;

            if ("croissant".equals(request.getParameter("tris"))) {
                bCatalog.triPrixCroissant();
                listTris = bCatalog.getBooks();
                if ("theme".equals(bPagination.getPagination())) {
                    bPagination.setPagination("theme");
                } else if ("event".equals(bPagination.getPagination())) {
                    bPagination.setPagination("event");
                } else if ("sub".equals(bPagination.getPagination())) {
                    bPagination.setPagination("sub");
                } else {
                    listTris = bCatalog.getBooksCatalog();
                }
            }
            if ("decroissant".equals(request.getParameter("tris"))) {
                bCatalog.triPrixDesc();
                listTris = bCatalog.getBooks();
                if ("theme".equals(bPagination.getPagination())) {
                    bPagination.setPagination("theme");
                } else if ("event".equals(bPagination.getPagination())) {
                    bPagination.setPagination("event");
                } else if ("sub".equals(bPagination.getPagination())) {
                    bPagination.setPagination("sub");
                } else {
                    listTris = bCatalog.getBooksCatalog();
                }
            }
            if ("best".equals(request.getParameter("tris"))) {
                bCatalog.triNotet();
                listTris = bCatalog.getBooks();
                if ("theme".equals(bPagination.getPagination())) {
                    bPagination.setPagination("theme");
                } else if ("event".equals(bPagination.getPagination())) {
                    bPagination.setPagination("event");
                } else if ("sub".equals(bPagination.getPagination())) {
                    bPagination.setPagination("sub");
                } else {
                    listTris = bCatalog.getBooksCatalog();
                }

            }
            int page = 1;
            String pageNumberValue = request.getParameter("pageHome");
            if (pageNumberValue != null) {
                try {
                    page = Integer.parseInt(pageNumberValue);
                } catch (NumberFormatException e) {
                    url = "/WEB-INF/jspFatalError.jsp";
                    request.setAttribute("fatalError", e.getMessage());
                }
            }
            bPagination = (beanPagination) application.getAttribute("pagination");
            bPagination.setOffset(bPagination.getRecordsPerPage() * (page - 1));
            request.setAttribute("pages", bPagination.getPages(listTris));
            request.setAttribute("noOfPages", bPagination.getNoOfPages(listTris));
            request.setAttribute("booksDetails", bPagination.getBooksByOffsetAndLength(listTris));
        }

        /*==========================================================================================================/
         |
         |   Quiter le controlleur
         |
         /*===========================================================================================================*/
//        System.out.println(request.getRequestURI());
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
