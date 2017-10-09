/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.service.publishing;

import com.cdi.g3.client.ui.swing.HomePage;
import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.DuplicateKeyException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.exception.UpdateException;
import com.cdi.g3.server.domain.catalog.Author;
import com.cdi.g3.server.domain.catalog.AuthorDAO;
import com.cdi.g3.server.domain.catalog.Editor;
import com.cdi.g3.server.domain.catalog.EditorDAO;
import com.cdi.g3.server.service.AbstractService;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cdi314
 */
public class PublishingService extends AbstractService {

    AuthorDAO _daoAuthor = new AuthorDAO();
    EditorDAO _daoEditor = new EditorDAO();

    public Editor findEditorByChamp(String column, String champ) throws ObjectNotFoundException {
        return (Editor) _daoEditor.findByChamp(column, champ);
    }
     public Editor findEditor(String column, String champ) throws ObjectNotFoundException {
        return (Editor) _daoEditor.selectEditorByChamp(column, champ);
    }
    public void createEditor(Editor editor) {
        try {
            _daoEditor.insert(editor);
        } catch (DuplicateKeyException ex) {
            Logger.getLogger(PublishingService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Collection findAllEditor() throws ObjectNotFoundException {
        return _daoEditor.findAll();
    }

    public Collection findAuthorByISBN(String column, String champ) {
        try {
            return _daoAuthor.findAllByChamp(column, champ);
        } catch (ObjectNotFoundException ex) {
            System.out.println(" eurreur no authors founded " + ex.getMessage());
        }
        return null;
    }
    public void insertAuthorBook(String isbn, String idAuthor) throws DuplicateKeyException{
         _daoAuthor.associateAuthorBook(isbn, idAuthor);
        
    }
    public void createAuthor(Author author) {
        try {
            _daoAuthor.insert(author);
        } catch (DuplicateKeyException ex) {
            Logger.getLogger(PublishingService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Author findAuthor(String column, String idAuthor) throws ObjectNotFoundException {
        return (Author) _daoAuthor.findByPrimaryKey(idAuthor);
    }

    public Collection findAuthorByChamp(String column, String champ) throws ObjectNotFoundException {
        return _daoAuthor.findAllByChamp(column, champ);
    }

    public Author findAuthorOByChamp(String column, String champ) throws ObjectNotFoundException {
        return (Author) _daoAuthor.findByChamp(column, champ);
    }

    public Collection FindAllAuthor() throws ObjectNotFoundException {
        return _daoAuthor.findAll();
    }

    public void updateAuthor(Author myAuthor) throws ObjectNotFoundException, UpdateException, CheckException {
        if (myAuthor == null) {
            throw new UpdateException("myauthor is null");
        }
        checkId(myAuthor.getId());
        try {
            _daoAuthor.update(myAuthor);
        } catch (ObjectNotFoundException ex) {
            System.out.println(ex.getMessage() + " erreur update ");
        }
    }

    public void updateEditor(Editor myEditor) throws UpdateException, CheckException {
        if (myEditor == null) {
            throw new UpdateException("myEditor is null");
        }
        checkId(myEditor.getId());
        try {
            _daoEditor.update(myEditor);
        } catch (ObjectNotFoundException ex) {
            System.out.println(ex.getMessage() + " erreur update " + ex.getMessage());
        }
    }

}
