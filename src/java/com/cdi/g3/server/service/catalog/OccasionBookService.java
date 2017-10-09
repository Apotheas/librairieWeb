/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.service.catalog;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.CreateException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.common.logging.Trace;
import com.cdi.g3.server.domain.catalog.BookDAO;
import com.cdi.g3.server.domain.catalog.Occasion;
import com.cdi.g3.server.domain.catalog.OccasionBook;
import com.cdi.g3.server.domain.catalog.OccasionBookDAO;
import com.cdi.g3.server.service.AbstractService;
import java.util.Collection;

/**
 *
 * @author Izet
 */
public class OccasionBookService extends AbstractService {
    
    private static final   BookDAO  _bookDao = new BookDAO();
    private static final   OccasionBookDAO  _daoOccasionBook = new OccasionBookDAO();
    
    
     public Collection FindBooksByChamp(String column, String champ) throws ObjectNotFoundException {
        Collection listBook = _bookDao.findAllByChamp(column, champ);
        
        return listBook;
    }
     
      public OccasionBook createOccasionBook(final OccasionBook occasionBook) throws CreateException, CheckException {
        final String mname = "createOccasionBook";
        Trace.entering(_cname, mname, occasionBook);

        if (occasionBook == null) {
            throw new CreateException("OccasionBook object is null");
        }

      
        occasionBook.checkData();
        checkId(occasionBook.getId());
        // Creates the object
        _daoOccasionBook.insert(occasionBook);

        Trace.exiting(_cname, mname, occasionBook);
        return occasionBook;
    }
}
