Use librairieDB
Go


-- Afficher les appreciations des clients 
select LASTNAMECUSTOMER 'Nom Customer', COMMENTAPPRECIATE 'Comment', RATINGAPPRECIATE 'Rating',
		DATEAPPRECIATE 'Date comment', IPAPPRECIATE 'ip Customer'			 
From Customer cus, Appreciation app
Where cus.LOGINCUSTOMER = app.LOGINCUSTOMERAPPRECIATE



 -- Afficher les appreciations d'un client

Declare @logincustomer Varchar ( 50) ='Bob01'

select LASTNAMECUSTOMER 'Nom Customer', COMMENTAPPRECIATE 'Comment', RATINGAPPRECIATE 'Rating',
		DATEAPPRECIATE 'Date comment', IPAPPRECIATE 'ip Customer'			 
From Customer cus, Appreciation app
Where cus.LOGINCUSTOMER = app.LOGINCUSTOMERAPPRECIATE
		and cus.LOGINCUSTOMER =@logincustomer



-- Afficher les adresses d'un client

Declare @logincustomer1 Varchar ( 50) ='Bob01'

select LASTNAMECUSTOMER 'Nom Customer', FIRSTNAMECUSTOMER 'Prénom Customer', EMAILCUSTOMER 'Email',
adrS.NUMADRESS +' '+adrS.TYPESTREETADRESS+' '+adrS.NAMESTREETADRESS+' '+adrS.NAMESTEET2ADRESS+' '+
adrS.ZIPCODEADRESS+' '+adrS.CITYADRESS+' '+
adrS.COUNTRYADRESS  'Adresse Livraison' ,

adrB.NUMADRESS +' '+adrB.TYPESTREETADRESS+' '+adrB.NAMESTREETADRESS+' '+adrB.NAMESTEET2ADRESS+' '+
adrB.ZIPCODEADRESS+' '+adrB.CITYADRESS+' '+
adrB.COUNTRYADRESS  'Adresse Facturation'

from  Customer cus,ADRESS adrS,ADRESS adrB
where	adrB.LOGINCUSTOMERSHIPADRESS = cus.LOGINCUSTOMER
		and adrS.LOGINCUSTOMERBILLADRESS = cus.LOGINCUSTOMER
		and LOGINCUSTOMER =@logincustomer1



-- Afficher les auteurs d'un livres
Declare @NUMISBNBOOK Varchar ( 13) ='2253092533'
select LASTNAMEAUTHOR 'Nom Auteur', FIRSTNAMEAUTHOR 'Prénom Auteur', BIOGRAPHYAUTHOR 'Biographie',
		BIRTHDATEAUTHOR 'Date de naissance',TITREBOOK 'Titre', SYNOPSISBOOK 'Résumé' 		 
From AUTHOR aut, BOOK bok, AUTHORBOOK autbok
Where	bok.NUMISBNBOOK = autbok.NUMISBNBOOK
		and autbok.IDAUTHOR = aut.IDAUTHOR
		and bok.NUMISBNBOOK =@NUMISBNBOOK



-- Afficher la ligne de commande d'un livre et un customer
Declare @NUMISBNBOOK1 Varchar ( 13) ='2253092533',
		@logincustomer2 Varchar ( 50) ='Bob01'

select IDORDERLINE 'N° ligne de commande', LASTNAMECUSTOMER 'Nom Client', TITREBOOK 'Titre de livre'
		
From ORDERLINE ordl, CUSTOMER cus, BOOK bok,ORDERS ord
Where	bok.NUMISBNBOOK=  ordl.NUMISBNBOOK  		
		and ordl.IDORDER  = ord.IDORDER	
		and ord.LOGINCUSTOMERORDER = cus.logincustomer		
		and bok.NUMISBNBOOK =@NUMISBNBOOK1
		and	cus.logincustomer = @logincustomer2


-- Afficher une Appreciation d'un livre et un customer
DECLARE 
@NUMISBNBOOK2 Varchar ( 13) ='2253092533',
@logincustomer3 Varchar ( 50) ='Bob01' 

 select IDAPPRECIATE 'N° dappreciation'	,LASTNAMECUSTOMER 'Nom Client', TITREBOOK 'Titre de livre'	
				From  BOOK bok, CUSTOMER cus,APPRECIATION app
				Where	bok.NUMISBNBOOK=  app.NUMISBNBOOKAPPRECIATE		
						and app.LOGINCUSTOMERAPPRECIATE  = cus.logincustomer
						and bok.NUMISBNBOOK =@NUMISBNBOOK2
						and	cus.logincustomer = @logincustomer3 









