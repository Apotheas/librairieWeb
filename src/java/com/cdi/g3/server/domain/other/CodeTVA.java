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
public class CodeTVA extends DomainObject implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================  
    private String typeTva;
    private Float rateCodeTva;

    // ======================================
    // =           Business methods         =
    // ======================================
    public void checkData() throws CheckException {

        if (typeTva == null || "".equals(typeTva)) {
            throw new CheckException("Invalid typeTva, must be insert");
        }

        if (rateCodeTva == null || "".equals(rateCodeTva)) {
            throw new CheckException("Invalid rateCodeTva, must be insert");
        }

    }

    // ======================================
    // =             Constructors           =
    // ======================================
    public CodeTVA() {

    }

    public CodeTVA(String typeTva) {
        this.typeTva = typeTva;
    }

    public CodeTVA(String typeTva, Float rateCodeTva) {
        this.typeTva = typeTva;
        this.rateCodeTva = rateCodeTva;
    }

    // ======================================
    // =         Getters and Setters        =
    // ======================================
    @Override
    public String getId() {
        return typeTva;

    }
    @Override
    public void setId(String typeTva) {
        this.typeTva = typeTva;
    }
    

    //--------------------------------------//
    public String getTypeTva() {
        return typeTva;
    }

    public void setTypeTva(String typeTva) {
        this.typeTva = typeTva;
    }

    public Float getRateCodeTva() {
        return rateCodeTva;
    }

    public void setRateCodeTva(Float rateCodeTva) {
        this.rateCodeTva = rateCodeTva;
    }

    @Override
    public String toString() {
        return typeTva ;
    }

}
