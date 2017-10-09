/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.server.domain.other;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.server.domain.DomainObject;
import java.io.Serializable;

/**
 *
 * @author youssef
 */
public class KeyWord extends DomainObject implements Serializable {

    private String nameKeyWord;

    // ======================================
    // =           Business methods         =
    // ======================================

    public void checkData() throws CheckException {

        if (nameKeyWord == null || "".equals(nameKeyWord)) {
            throw new CheckException("Invalid nameKeyWord, must be insert");
        }

    }

    // ======================================
    // =             Constructors           =
    // ======================================
    public KeyWord() {
    }

    public KeyWord(String nameKeyWord) {
        this.nameKeyWord = nameKeyWord;
    }

    //-------------------------------------//  
    @Override
    public String getId() {
        return nameKeyWord;
    }

    @Override
    public void setId(String nameKeyWord) {
        this.nameKeyWord = nameKeyWord;
    }

    // ======================================
    // =         Getters and Setters        =
    // ======================================
    public String getNameKeyWord() {
        return nameKeyWord;
    }

    public void setNameKeyWord(String nameKeyWord) {
        this.nameKeyWord = nameKeyWord;
    }

    @Override
    public String toString() {
        return nameKeyWord;
    }

}
