/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.service.catalog;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.DuplicateKeyException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.catalog.Author;
import com.cdi.g3.server.domain.catalog.AuthorDAO;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.catalog.BookDAO;
import com.cdi.g3.server.domain.catalog.Editor;
import com.cdi.g3.server.domain.catalog.EditorDAO;
import com.cdi.g3.server.domain.other.CodeTVA;
import com.cdi.g3.server.domain.other.CodeTVADAO;
import com.cdi.g3.server.service.AbstractService;
import com.sun.javafx.scene.input.InputEventUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatalogService extends AbstractService {

    private static final BookDAO _bookDao = new BookDAO();
    private static final EditorDAO _editorDao = new EditorDAO();
    private static final AuthorDAO _authorDao = new AuthorDAO();
    private static final CodeTVADAO _codeTVADAO = new CodeTVADAO();

    public Book findBook(final String bookId) throws FinderException, CheckException {
        checkId(bookId);
        final Book book = (Book) _bookDao.findByPrimaryKey(bookId);
        return book;
    }
    public Collection FindAllBooks() throws ObjectNotFoundException{
        Collection listBook = _bookDao.findAll();
        return listBook;
    }
    public Book FindBookByChamp(String column, String champ) throws ObjectNotFoundException {
        Book book = (Book)_bookDao.findByChamp(column, champ);        
        Editor editor = (Editor) _editorDao.findByPrimaryKey(book.getEditor().getId());
        CodeTVA tva = (CodeTVA) _codeTVADAO.findByPrimaryKey(book.getCodeTVA().getId());
        book.setEditor(editor);
        book.setCodeTVA(tva);
        
        return book;
    }
    public Collection FindBooksByTitre(String titre) throws ObjectNotFoundException {
       Collection listBook = _bookDao.selectBooksByTitre(titre);
       return listBook;
   }

    public Collection FindBooksByChamp(String column, String champ) throws ObjectNotFoundException {
        Collection listBook = _bookDao.findAllByChamp(column, champ);
        
        return listBook;
    }
     public Collection FindBooksBySub(String column, String champ) throws ObjectNotFoundException {
        Collection listBook = _bookDao.selectBooksBySub(column, champ);
        
        return listBook;
    }
     
      public Collection FindBooksByTheme(String theme) throws ObjectNotFoundException {
        Collection listBook = _bookDao.selectBooksByTheme(theme);        
        return listBook;
    }
     

    public void createBook(final Book book) throws FinderException, CheckException {
        final String mname = "findBook";
        Trace.entering(_cname, mname, book);
        try {
            _bookDao.insert(book);
        } catch (DuplicateKeyException ex) {
            Logger.getLogger(CatalogService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateBook(final Book book) throws ObjectNotFoundException{
        _bookDao.update(book);
    }

}
