/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.service.other;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.CreateException;
import com.cdi.g3.common.exception.DataAccessException;
import com.cdi.g3.common.exception.FinderException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.exception.RemoveException;
import com.cdi.g3.common.exception.UpdateException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.catalog.Book;
import com.cdi.g3.server.domain.catalog.BookDAO;
import com.cdi.g3.server.domain.catalog.Editor;
import com.cdi.g3.server.domain.other.CodeTVA;
import com.cdi.g3.server.domain.other.CodeTVADAO;
import com.cdi.g3.server.domain.other.KeyWord;
import com.cdi.g3.server.domain.other.KeyWordBook;
import com.cdi.g3.server.domain.other.KeyWordDAO;
import com.cdi.g3.server.service.AbstractService;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.displaySqlException;
import static com.cdi.g3.server.util.persistence.AbstractDataAccessObject.getConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class OtherService extends AbstractService {

//****************************************************************************//
//***************************   CodeTVA   ************************************//
//****************************************************************************//    
// ======================================
//        Buisness Methodes CodeTVA 
// ======================================
    private static final CodeTVADAO _daoCodeTVA = new CodeTVADAO();

    // CREATE CODE TVA  -----------------------------------------------------------------------
    public CodeTVA createCodeTVA(final CodeTVA codeTVA) throws CreateException, CheckException {
        final String mname = "createCodeTva";
        Trace.entering(_cname, mname, codeTVA);

        if (codeTVA == null) {
            throw new CreateException("CodeTVA object is null");
        }

        codeTVA.checkData();
//         Customer  customer1 = null ;
        try {
            _daoCodeTVA.findByPrimaryKey(codeTVA.getId());
        } catch (ObjectNotFoundException ex) {
            //checkId( CodeTVA.getId() );
            checkId(codeTVA.getId());
            // Creates the object
            _daoCodeTVA.insert(codeTVA);
            return codeTVA;
        }
        Trace.exiting(_cname, mname, codeTVA);
        throw new CreateException("CodeTva object exist");

    }
 // FINDCODETVA  -----------------------------------------------------------------------

    public CodeTVA findCodeTVA(final String codeTVAId) throws FinderException, CheckException {
        final String mname = "findCodeTva";
        Trace.entering(_cname, mname, codeTVAId);

        checkId(codeTVAId);
        // Finds the object
        final CodeTVA codeTVA = (CodeTVA) _daoCodeTVA.findByPrimaryKey(codeTVAId);
        Trace.exiting(_cname, mname, codeTVA);
        return codeTVA;
    }

    // DELETE CODETVA  -----------------------------------------------------------------------

    public void deleteCodeTVA(final String codeTVAId) throws RemoveException, CheckException {
        final String mname = "deleteCodeTVA";
        Trace.entering(_cname, mname, codeTVAId);

        checkId(codeTVAId);

        // Checks if the object exists
        try {
            _daoCodeTVA.findByPrimaryKey(codeTVAId);
        } catch (FinderException e) {
            throw new RemoveException("CodeTVA must exist to be deleted");
        }

        // Deletes the object
        try {
            _daoCodeTVA.remove(codeTVAId);
        } catch (ObjectNotFoundException e) {
            throw new RemoveException("CodeTVA must exist to be deleted");
        }
    }
// UPDATE CODETVA  -----------------------------------------------------------------------

    public void updateCodeTVA(CodeTVA codeTVA) throws UpdateException, CheckException {
        final String mname = "updateCodeTVA";
        Trace.entering(_cname, mname, codeTVA);

        if (codeTVA == null) {
            throw new UpdateException("CodeTVA object is null");
        }

        checkId(codeTVA.getId());

        final CodeTVA codeTVAFinded;

        // Checks if the object exists
        try {
            codeTVAFinded = (CodeTVA) _daoCodeTVA.findByPrimaryKey(codeTVA.getId());
        } catch (FinderException e) {
            throw new UpdateException("CodeTVA must exist to be updated");
        }

        codeTVA.checkData();
        codeTVA = setCodeTVA(codeTVA, codeTVAFinded);

        // Updates the object
        try {
            _daoCodeTVA.update(codeTVAFinded);
        } catch (ObjectNotFoundException e) {
            throw new UpdateException("CodeTVA must exist to be updated");
        }
    }

    // find Code TVA
    public Collection findCodeTva() throws ObjectNotFoundException {
        final String mname = "findCodeTva";
        Trace.entering(_cname, mname);

        // Finds all the objects
        final Collection codeTva = _daoCodeTVA.findAll();

        Trace.exiting(_cname, mname, new Integer(codeTva.size()));
        return codeTva;
    }

    // ======================================
    // = Private Methods codeTva
    // ======================================
    private CodeTVA setCodeTVA(CodeTVA codeTVA, CodeTVA codeTVAFinded) {
        codeTVAFinded.setRateCodeTva(codeTVA.getRateCodeTva());
        return codeTVAFinded;
    }

    /**
     * This method returns a unique identifer generated by the system.
     *
     * @return a unique identifer
     */
    public final String getUniqueIdCodeTva() {
        return _daoCodeTVA.getUniqueId();

    }

//**********************************************************************************************************************//
//**********************************************************************************************************************//
                //***************************   KeyWord   ************************************//
                //****************************************************************************//
//**********************************************************************************************************************//
//**********************************************************************************************************************//
// ======================================
//        Buisness Methodes KeyWord
// ======================================
    private static final KeyWordDAO _daokeyWord = new KeyWordDAO();
    private static final BookDAO _bookDao = new BookDAO();

    // CREATE CODE TVA  -----------------------------------------------------------------------
    public KeyWord createKeyWord(final KeyWord keyWord) throws CreateException, CheckException {
        final String mname = "createKeyWord";
        Trace.entering(_cname, mname, keyWord);

        if (keyWord == null) {
            throw new CreateException("KeyWord object is null");
        }

        keyWord.checkData();
//         Customer  customer1 = null ;
        try {
            _daokeyWord.findByPrimaryKey(keyWord.getId());
        } catch (ObjectNotFoundException ex) {
            //checkId( keyWord.getId() );
            checkId(keyWord.getId());
            // Creates the object
            _daokeyWord.insert(keyWord);
            return keyWord;
        }
        Trace.exiting(_cname, mname, keyWord);
        throw new CreateException("keyWord object exist");

    }

 // FIND KeyWord -----------------------------------------------------------------------
    public Collection findKeyWordByChamp(String column, String champ) throws ObjectNotFoundException {
        return _daokeyWord.findAllByChamp(column, champ);
    }

    public Collection FindKeywordByISBN(String column, String champ) throws ObjectNotFoundException {

        Collection listKeyWord = _daokeyWord.findAllByChamp(column, champ);
        return listKeyWord;
    }

    //*********** Find books by keywords ***************************************************************************************

    public Collection findBooksByKeyword(String Column, String champ) throws ObjectNotFoundException {
        Collection listBook = _bookDao.selectBooksByKeyWord(Column, champ);
        return listBook;
    }

      public KeyWordBook  insertisbnBookByKeyword (String column , String champs )throws ObjectNotFoundException{ 
          KeyWordBook keyWordBook = new KeyWordBook();
      //
          return keyWordBook ;
      }

  
    //-----------------------------------------------------------------------------------------------------  
    public KeyWord findKeyWord(final String keyWordId) throws FinderException, CheckException {
        final String mname = "findKeyWord";
        Trace.entering(_cname, mname, keyWordId);

        checkId(keyWordId);
        // Finds the object
        final KeyWord keyWord = (KeyWord) _daokeyWord.findByPrimaryKey(keyWordId);
        Trace.exiting(_cname, mname, keyWord);
        return keyWord;
    }

    // DELETE KeyWord  -----------------------------------------------------------------------
    public void deleteKeyWord(final String keyWordId) throws RemoveException, CheckException {
        final String mname = "deleteKeyWord";
        Trace.entering(_cname, mname, keyWordId);

        checkId(keyWordId);

        // Checks if the object exists
        try {
            _daokeyWord.findByPrimaryKey(keyWordId);
        } catch (FinderException e) {
            throw new RemoveException("KeyWord must exist to be deleted");
        }

        // Deletes the object
        try {
            _daokeyWord.remove(keyWordId);
        } catch (ObjectNotFoundException e) {
            throw new RemoveException("KeyWord must exist to be deleted");
        }
    }

    // Delete Keyword KB ****************************************************************************

        public void deleteKeyWordKB(final String keyWordId) throws RemoveException, CheckException {
        final String mname = "deleteKeyWord";
        Trace.entering(_cname, mname, keyWordId);

        checkId(keyWordId);

        // Checks if the object exists
        try {
            _daokeyWord.findByPrimaryKey(keyWordId);
        } catch (FinderException e) {
            throw new RemoveException("KeyWord must exist to be deleted");
        }

        // Deletes the object
        try {
            _daokeyWord.remove(keyWordId);
        } catch (ObjectNotFoundException e) {
            throw new RemoveException("KeyWord must exist to be deleted");
        }
    }

// UPDATE KeyWord  -----------------------------------------------------------------------
//   public void updateKeyWord(KeyWord myKeyWord) throws  UpdateException, CheckException {
//        if (myKeyWord == null) {
//            throw new UpdateException("myKeyWord is null");
//        }
//        checkId(myKeyWord.getId());
//        try {
//            _daokeyWord.update(myKeyWord);
//        } catch (ObjectNotFoundException ex) {
//            System.out.println(ex.getMessage() + " erreur update " + ex.getMessage());
//        }
    public void updateKeyWord(KeyWord keyWord) throws UpdateException, CheckException {
              

        // Updates the object 
        try {
            _daokeyWord.update(keyWord);
        } catch (ObjectNotFoundException e) {
            throw new UpdateException("keyWord must exist to be updated");
        }
    }

    


    // find KeyWord -----------------------------------------------------------------------
    public Collection findKeyWord() throws FinderException {
        final String mname = "findKeyWord";
        Trace.entering(_cname, mname);

        // Finds all the objects
        final Collection keyWord = _daokeyWord.findAll();

        Trace.exiting(_cname, mname, new Integer(keyWord.size()));
        return keyWord;
    }

    KeyWord keyWordBook = new KeyWord();

    


    // ** ASSOCIATE ISBN WITH kEYwORD  **************************
    //****************//***********//********************
   
    

// ======================================
    // = Private Methods KeyWord
    // ======================================
  
    
    
    private KeyWord setKeyWord(KeyWord keyWord, KeyWord KeyWordFinded) {
        KeyWordFinded.setNameKeyWord(keyWord.getNameKeyWord());
        return KeyWordFinded;
    }

    /**
     * This method returns a unique identifer generated by the system.
     *
     * @return a unique identifer
     */

    public final String getUniqueIdKeyWord() {
        return _daokeyWord.getUniqueId();
    }

}
