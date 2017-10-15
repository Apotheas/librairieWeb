/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.service;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.server.domain.Invoice;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.customers.Address;
import com.cdi.g3.server.domain.customers.Customer;
import com.cdi.g3.server.domain.orders.OrderLine;
import com.cdi.g3.server.domain.orders.Orders;
import com.cdi.g3.server.service.catalog.CatalogService;
import com.cdi.g3.server.service.customers.AdressService;
import com.cdi.g3.server.service.customers.CustomerService;
import com.cdi.g3.server.service.orders.OrderService;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;

import java.io.FileOutputStream;
import java.io.IOException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Table;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 * @author youssef
 */
public class GeneratorInvoice {

    private String carteSosienté;
    private static AdressService serviceAdresse = new AdressService();
    private static CustomerService serviceCustomer= new CustomerService();
    private static CatalogService serviceCatalog= new CatalogService();

    public static  void printInvoce(Orders order) {
        
        Document document = new Document(PageSize.A4);
        try {
            try {
                
            PdfWriter writer = PdfWriter.getInstance(document,
          new FileOutputStream("C:\\Users\\cdi314\\Documents\\NetBeansProjects\\filRougeLibrairie\\documents/test.pdf"));
                     writer.setViewerPreferences(PdfWriter.PageLayoutSinglePage
                              | PdfWriter.PageModeUseThumbs);
            
            
            } catch (FileNotFoundException ex) {
                Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
            document.addTitle("Hello World");
            document.addAuthor("YM");
            document.addSubject("Exemple de génération de PDF.");
            document.addKeywords("iText, test");
            document.open(); 
            
            Image image = null;
            try {
                image = Image.getInstance("C:\\Users\\cdi314\\Documents\\NetBeansProjects\\filRougeLibrairie\\images/logo.jpg");
                image.setAlignment(1); 
            
            } catch (BadElementException ex) {
                Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
            }
            document.add(image);
            
            
            document.add(new Paragraph("Facture Client", 
	    new Font(Font.COURIER, 28, Font.BOLD, Color.RED)));

            document.add(generateAdressesHeader(order));
            
            Paragraph paragraph = new Paragraph("\n\n\n\n Facture N° : "+order.getInternalNumOrder() 
            + "\t\t\t\t\t Date : " +order.getDateOrder() + "\n");
            paragraph.setIndentationLeft(20f);
            document.add(paragraph); 
            
            document.add(generateOrderLine(order));
        } catch (DocumentException de) {
            de.printStackTrace();
        }

        document.close();
    }

public static Table generateOrderLine(Orders order) {
        Table tableau = null;
        try {
            tableau = new Table(4, order.getListOrderLines().size()+1);
            tableau.setAutoFillEmptyCells(true);
            tableau.setPadding(2);
            
           
            Cell cell = new Cell("Désignation");
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.GRAY);
            cell.setHeader(true);
            tableau.addCell(cell);
            
//            tableau.addCell("Désignation");
            cell = new Cell("Quantity");
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.GRAY);
            cell.setHeader(true);
            tableau.addCell(cell);
            
            cell = new Cell("PU HT");
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.GRAY);
            cell.setHeader(true);
            tableau.addCell(cell);
            
            cell = new Cell("TOTAL HT");
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.GRAY);
            cell.setHeader(true);
            tableau.addCell(cell);
            tableau.endHeaders();

            for (Iterator iterator = order.getListOrderLines().iterator(); iterator.hasNext();) {
               
                OrderLine orderLine = (OrderLine) iterator.next();
                Book book =null;
                try {
                   book = serviceCatalog.findBook(orderLine.getBook().getId());
                } catch (FinderException ex) {
                    Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CheckException ex) {
                    Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String isbn = book.getId();
                String titre = book.getTitleBook();
                cell = new Cell("N° ISBN : "+isbn + " Titre : "+ titre);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tableau.addCell(cell);
                
                int quantity = orderLine.getQuantityOrderLine();
                cell = new Cell(String.valueOf(quantity));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tableau.addCell(cell);
                
                float prixUT =orderLine.getUnitCostOrderLine();
                cell = new Cell(String.valueOf(prixUT)); 
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tableau.addCell(cell);
                
                float totalHT = prixUT * quantity;
                cell = new Cell(String.valueOf(totalHT));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                tableau.addCell(cell);
                
            }
        } catch (DocumentException de) {
            de.printStackTrace();
        }

        return tableau;

 }

public static   Table generateAdressesHeader(Orders order) {
    
    Table tableau1 =null;
        try {
            tableau1 = new Table(3, 2);
            tableau1.setAutoFillEmptyCells(true);
            tableau1.setPadding(1);
            
            
            Cell cell = new Cell("Information Company");
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.GRAY);
            cell.setHeader(true);
            tableau1.addCell(cell);
            
//            tableau.addCell("Désignation");
            cell = new Cell("Client");
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.GRAY);
            cell.setHeader(true);
            tableau1.addCell(cell);
            
            cell = new Cell("Adresse de Livraison");
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(Color.GRAY);
            cell.setHeader(true);
            tableau1.addCell(cell);
            tableau1.endHeaders();
            
            cell = new Cell(generateCartCompany());
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            tableau1.addCell(cell);
            
            cell = new Cell(generateCartCustomer(order));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            tableau1.addCell(cell);
            
            tableau1.addCell(generateCartAdressShoppingCustomer(order));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            tableau1.addCell(cell);
            
        } catch (BadElementException ex) {
            Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
          return tableau1;  
}

    public static  String generateCartCompany() {
        Address adress = null;
        try {

            adress = serviceAdresse.findAdress("1");
        } catch (CheckException ex) {
            Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FinderException ex) {
            Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        String strAdress = adress.getNameReceiverAdress() + "\n"
                + adress.getNumAdress() + " " + adress.getTypeStreetAdress() + " " + adress.getNameStreetAdress() + "\n"
                + adress.getNameStreet2Adress() 
                + adress.getZipcodeAdress() + " " + adress.getCountryAdress() + "\n";

        
        return strAdress;
    }

    public static String generateCartCustomer(Orders order) {
        
        Customer customer =null;
        try {
         customer = serviceCustomer.findCustomer(order.getCustomer().getId());
        } catch (FinderException ex) {
            Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CheckException ex) {
            Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String strCustomer = customer.getLastNameCustomer() + " "
                + customer.getFirstNameCustomer() + " " + customer.getNameCompanyCustomer() + "\n";
          
        
        Address adress =null;
        try {
         adress = serviceAdresse.findAdress(order.getAdressBilling().getId());
        } catch (FinderException ex) {
            Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CheckException ex) {
            Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
               strCustomer+= adress.getNameReceiverAdress() + "\n"
                +adress.getNumAdress() + " " + adress.getTypeStreetAdress() + " " + adress.getNameStreetAdress() + "\n"
                + adress.getNameStreet2Adress()
                + adress.getZipcodeAdress() + " " + adress.getCountryAdress() + "\n";

                System.out.println(strCustomer);
        return strCustomer;
    }

    public static String generateCartAdressShoppingCustomer(Orders order) {
        Address adress =null;
        try {
         adress = serviceAdresse.findAdress(order.getAdressShipping().getId());
        } catch (FinderException ex) {
            Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CheckException ex) {
            Logger.getLogger(GeneratorInvoice.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String strAdress = adress.getNameReceiverAdress() + "\n"
                + adress.getNumAdress() + " " + adress.getTypeStreetAdress() + " " + adress.getNameStreetAdress() + "\n"
                + adress.getNameStreet2Adress()
                + adress.getZipcodeAdress() + " " + adress.getCountryAdress() + "\n";

        return strAdress;
    }

}
