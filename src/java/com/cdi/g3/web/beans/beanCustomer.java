/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cdi.g3.web.beans;

import com.cdi.g3.common.exception.CheckException;
import com.cdi.g3.common.exception.CreateException;
import com.cdi.g3.common.exception.ObjectNotFoundException;
import com.cdi.g3.server.service.customers.CustomerService;
import com.cdi.g3.server.domain.customers.Customer;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author cdi314
 */
public class beanCustomer implements Serializable{    
    private CustomerService customerService = new CustomerService();

    private Customer customer;
    private String login;
    private String password;
    private String confirmationPassword;
    private String email;
    private String lastName;
    private String firstName;
    
    
    private String              resultat;

private Map<String, String> erreurs      = new HashMap<String, String>();


public String getResultat() {
    return resultat;}

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }


public Map<String, String> getErreurs() {
    return erreurs;
}
/*
 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
 */
private void setErreur( String champ, String message ) {
    erreurs.put( champ, message );
}

    public beanCustomer() {
    }

    
    public beanCustomer(String login) throws ObjectNotFoundException, CheckException {
       this.customer= customerService.findCustomer(login);        
    }

    public void setEmail(String email) {
	this.email = email;
    }
    public String getEmail() {
	return email;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public Customer getCustomer(String login) {
        return this.customer;
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }

    public void setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
    }
    
    
    public beanCustomer registerCustomer(beanCustomer bCustomer) throws CreateException, CheckException{
        
         Customer utilisateur = new Customer();
        
        try {
        validationEmail( bCustomer.getEmail() );
    } catch ( Exception e ) {
        bCustomer.setErreur( bCustomer.getEmail(), e.getMessage() );
    }
    utilisateur.setEmailCustomer(bCustomer.getEmail() );

    try {
        validationMotsDePasse( bCustomer.getPassword(),bCustomer.getConfirmationPassword() );
    } catch ( Exception e ) {
        bCustomer.setErreur( bCustomer.getPassword(), e.getMessage() );
        bCustomer.setErreur( bCustomer.getConfirmationPassword(), null );
    }
    utilisateur.setPasswordCustomer(bCustomer.getPassword() );

    try {
        validationNom( bCustomer.getLastName() );
    } catch ( Exception e ) {
        bCustomer.setErreur( bCustomer.getLastName(), e.getMessage() );
    }
    utilisateur.setLastNameCustomer(bCustomer.getLastName() );

    if ( bCustomer.getErreurs().isEmpty() ) {
        bCustomer.setResultat("Succès de l'inscription.") ;
        customerService.createCustomer(utilisateur); 
    } else {        
         bCustomer.setResultat("Échec de l'inscription.") ;
    }
      
    return bCustomer;
}
    
    
    private void validationEmail( String email ) throws Exception {
    if ( email != null ) {
        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    } else {
        throw new Exception( "Merci de saisir une adresse mail." );
    }
}

private void validationMotsDePasse( String motDePasse, String confirmation ) throws Exception {
    if ( motDePasse != null && confirmation != null ) {
        if ( !motDePasse.equals( confirmation ) ) {
            throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
        } else if ( motDePasse.length() < 3 ) {
            throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
        }
    } else {
        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
    }
}

private void validationNom( String nom ) throws Exception {
    if ( nom != null && nom.length() < 3 ) {
        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );
    }
}

    
    
}
