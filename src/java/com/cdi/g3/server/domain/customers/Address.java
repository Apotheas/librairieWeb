package com.cdi.g3.server.domain.customers;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.utiles.Utility;
import com.cdi.g3.server.domain.DomainObject;
import com.cdi.g3.server.domain.company.Company;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public final class Address extends DomainObject implements Serializable {

    // ======================================
    // =             Attributes             =
    // ======================================
    private String idAdress;
    private Customer customerShipAdress;
    private Customer customerBillAdress;
    private String nameReceiverAdress;
    private String typeStreetAdress;
    private String numAdress;
    private String nameStreetAdress;
    private String nameStreet2Adress;
    private String zipcodeAdress;
    private String cityAdress;
    private String countryAdress;
    private Company nameCompanyReceiverAdress;

    private Collection listOrdersShipping = new ArrayList();
    private Collection listOrdersBilling = new ArrayList();

    // ======================================
    // =           Business methods         =
    // ======================================
    public void checkData() throws CheckException {
        if (((customerShipAdress == null || "".equals(customerShipAdress)))
                && ((customerBillAdress == null || "".equals(customerBillAdress)))) {
            throw new CheckException("Invalid loginCustomerBillAdress , must be insert ");
        }

        if (nameReceiverAdress == null ||"".equals(nameReceiverAdress)) {
            throw new CheckException("Invalid nameReceiverAdress, must be insert");
        }

        if (numAdress == null || "".equals(numAdress)) {
            throw new CheckException("Invalid numAdress, must be insert");
        }

        if (nameStreetAdress == null || "".equals(nameStreetAdress)) {
            throw new CheckException("Invalid nameStreetAdress , must be insert");
        }

        if (zipcodeAdress == null || "".equals(zipcodeAdress)|| !Utility.regexCp(zipcodeAdress)) {
            throw new CheckException("Invalid zipcodeAdress  , must be insert");
        }

        if (cityAdress == null || "".equals(cityAdress)) {
            throw new CheckException("Invalid cityAdress  , must be insert");
        }

    }

    // ======================================
    // =            Constructors            =
    // ======================================
    public Address() {
    }

    public Address(final String id) {
        idAdress = id;
    }

    public Address(final String id,
            Customer CustomerShipAdress,
            Customer CustomerBillAdress,
            String nameReceiverAdress,
            String typeStreetAdress,
            String numAdress,
            String nameStreetAdress,
            String nameStreet2Adress,
            String zipcodeAdress,
            String cityAdress,
            String countryAdress,
            Company nameCompanyReceiverAdress) {
        super();

        idAdress = id;
        this.customerShipAdress = CustomerShipAdress;
        this.customerBillAdress = CustomerBillAdress;
        this.nameReceiverAdress = nameReceiverAdress;
        this.typeStreetAdress = typeStreetAdress;
        this.numAdress = numAdress;
        this.nameStreetAdress = nameStreetAdress;
        this.nameStreet2Adress = nameStreet2Adress;
        this.zipcodeAdress = zipcodeAdress;
        this.cityAdress = cityAdress;
        this.countryAdress = countryAdress;
        this.nameCompanyReceiverAdress = nameCompanyReceiverAdress;
    }

    // ======================================
    // =         Getters and Setters        =
    // ======================================
    @Override
    public String getId() {
        return idAdress;
    }
    @Override
    public void setId(String idAdress) {
        this.idAdress = idAdress;
    }
    //-------------------------------------//
    public String getIdAdress() {
        return idAdress;
    }

    public void setIdAdress(String idAdress) {
        this.idAdress = idAdress;
    }

    public String getNameReceiverAdress() {
        return nameReceiverAdress;
    }

    public void setNameReceiverAdress(String nameReceiverAdress) {
        this.nameReceiverAdress = nameReceiverAdress;
    }

    public String getTypeStreetAdress() {
        return typeStreetAdress;
    }

    public void setTypeStreetAdress(String typeStreetAdress) {
        this.typeStreetAdress = typeStreetAdress;
    }

    public String getNumAdress() {
        return numAdress;
    }

    public void setNumAdress(String numAdress) {
        this.numAdress = numAdress;
    }

    public String getNameStreetAdress() {
        return nameStreetAdress;
    }

    public void setNameStreetAdress(String nameStreetAdress) {
        this.nameStreetAdress = nameStreetAdress;
    }

    public String getNameStreet2Adress() {
        return nameStreet2Adress;
    }

    public void setNameStreet2Adress(String nameStreet2Adress) {
        this.nameStreet2Adress = nameStreet2Adress;
    }

    public String getZipcodeAdress() {
        return zipcodeAdress;
    }

    public void setZipcodeAdress(String zipcodeAdress) {
        this.zipcodeAdress = zipcodeAdress;
    }

    public String getCityAdress() {
        return cityAdress;
    }

    public void setCityAdress(String cityAdress) {
        this.cityAdress = cityAdress;
    }

    public String getCountryAdress() {
        return countryAdress;
    }

    public void setCountryAdress(String countryAdress) {
        this.countryAdress = countryAdress;
    }

    public Company getNameCompanyReceiverAdress() {
        return nameCompanyReceiverAdress;
    }

    public void setNameCompanyReceiverAdress(Company nameCompanyReceiverAdress) {
        this.nameCompanyReceiverAdress = nameCompanyReceiverAdress;
    }

    public Customer getCustomerShipAdress() {
        return customerShipAdress;
    }

    public void setCustomerShipAdress(Customer customerShipAdress) {
        this.customerShipAdress = customerShipAdress;
    }

    public Customer getCustomerBillAdress() {
        return customerBillAdress;
    }

    public void setCustomerBillAdress(Customer customerBillAdress) {
        this.customerBillAdress = customerBillAdress;
    }

    public Collection getListOrdersShipping() {
        return listOrdersShipping;
    }

    public void setListOrdersShipping(Collection listOrdersShipping) {
        this.listOrdersShipping = listOrdersShipping;
    }

    public Collection getListOrdersBilling() {
        return listOrdersBilling;
    }

    public void setListOrdersBilling(Collection listOrdersBilling) {
        this.listOrdersBilling = listOrdersBilling;
    }

    @Override
    public String toString() {
        return this.numAdress + " " + this.nameStreetAdress + " " + this.zipcodeAdress  + " " + this.cityAdress  ;
    }
}
