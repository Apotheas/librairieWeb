Use librairieDB
Go

/*==============================================================*/
/* Table: EDITOR                                                */
/*==============================================================*/
INSERT INTO Editor(
idEditor,
nameEditor,
statusEditor
)
VALUES
('1','Lafond',''),
('2','Hachette',''),
('3','Panini',''),
('4','Eyrolles',''),
('5','Bayard',''),
('6','Atlas',''),
('7','Actes Sud',''),
('8','Belin',''),
('9','Solar',''),
('10','Arthaud','')


/*==============================================================*/
/* Table: CODETVA                                             */
/*==============================================================*/
INSERT INTO CodeTVA(
typeTVA,
rateCodeTVA
)
VALUES 
('normal' , 20),
('intermediate' , 10),
('reduced' , 5.5),
('particular' , 2.1)



/*==============================================================*/
/* Table: KEYWORD                                               */
/*==============================================================*/
INSERT INTO KeyWord(
nameKeyWord)
VALUES
('Rebel'),
('Sexiste'),
('Old'),
('rare'),
('pocket')


/*==============================================================*/
/* Table: BOOK                                                  */
/*==============================================================*/
INSERT INTO Book ( 
        NUMISBNBOOK,         
        IDEDITORBOOK,        
        TYPETVABOOK ,        
        TITREBOOK ,           
        UNITCOSTBOOK,        
        STOCKBOOK,            
        STATUSBOOK,           
        SUBTITREBOOK,         
        SYNOPSISBOOK ,        
        PATHICONBOOK ,        
        WEIGHTBOOK,           
        SIZELARGEBOOK,        
        SIZELONGBOOK,          
        COMMENTBOOK)
VALUES 
('2253092533','1','reduced','Le piege',8.10,15,1, null ,'L auteur � succ�s Linda Conrads n a pas quitt� sa maison depuis onze ans. Hant�e par la mort de sa soeur et le visage de son assassin, qu elle a surpris juste avant qu il ne prenne la fuite, elle vit d�sormais recluse.','images/lePiege.jpg',null,null,null,'interessant'),
('2253092770','2','reduced', 'Da Vinci Code',5.90,11,1, null ,'Robert Langdon, un �minent sp�cialiste de symbologie de Harvard, est convoqu� d urgence au Louvre. On a d�couvert un message cod� sur le cadavre du conservateur en chef, retrouv� assassin� au milieu de la Grande Galerie.','images/daVinciCode.jpg',null,null,null,'long et ennuyeux'),
('2265116491','3','reduced', 'Comme de longs echos',19.90,7,2, null,' Partout, les monstres sont chez eux... � Vincent Dussart est s�r de son coup. Ce break impos� par sa femme va prendre fin aujourd hui. Il n a rien laiss� au hasard. Comme toujours. Confiant, il p�n�tre dans la maison .','images/commeDeLongsEchos.jpg',null,null,null,null),
('2743640707','4','reduced', 'Les Proies',9.00,34,1, null ,'Pendant la Guerre de S�cession, un soldat yankee bless� est recueilli dans un pensionnat de jeunes filles du Sud. L intrusion d un homme bouleverse ce milieu f�minin corset� et repli� sur lui-m�me. Objet de tous les fantasmes','images/lesProies.jpg',null,null,null,'Magnifique livre , je conseille !'),
('2330081545','5','reduced','Le detective de Freud',9.80,19,1, null,'Paris, 1911. � l issue du congr�s de l Association Psychanalytique Internationale, le jeune docteur Du Barrail est charg� par Sigmund Freud en personne d enqu�ter sur la mort myst�rieuse d un de leurs confr�res, retrouv�.','images/detectiveDeFreud.jpg',null,null,null,'Chef d oeuvre'),
('2290147001','6','reduced','Laisse moi t aimer',7.40,63,1, null,null,'images/laisseMoiTaimer.jpg',null,null,null,null),
('2290140961','7','reduced', 'Les ladies de Lantern Street',4.52,25,2, 'La femme mystere' ,null,'images/ladies.jpg',null,null,null,'Top!'),
('2290139998','8','reduced', 'Le jeu de la tentation',7.95,24,1, null,'Trouver l amour ? En ce qui la concerne, Kate Seymour y a renonc� depuis une �ternit�. Ironie du sort, elle a h�rit� d un don infaillible : d�tecter l alchimie entre deux �tres. Alors, faisant contre mauvaise fortune','images/tentation.jpg',null,null,null,null),
('2811222510','9','reduced', 'Wild heart',7.20,19,2, null,'Alors que Menzoberazzan go�te � un semblant de paix, lib�r�e de ses hordes de d�mons, l Outreterre panse ses plaies. Le barbare du Valbise et son compagnon halfelin, seulement d�sireux de profiter de leur nouvelle','images/wildHeart.jpg',null,null,null,'Incroyable'),
('2290139963','10','reduced', 'Gareth',4.07,39,1, null,'GarethGrace Burrowes (Auteur) Depuis neuf ans, Gareth Alexander se conduit en libertin. Pour satisfaire la derni�re volont� d une amie, il est contraint d apprendre � Felicity Worthington, comment diriger une maison close. Mais il ren�cle de plus','images/gareth.jpg',null,null,null,'Pas terrible'),
('2363092533','10','reduced','La Sorciere',9.10,23,1, null ,'Summers 20 Must-Read Books If you want to know the world behind out corporate-sponsored dreamscapes, you read writers like Arundhati Roy. She shows you what s really going on','images/laSorciere.jpg',null,null,null,'interessant'),
('2309992770','9','reduced', 'Trois Baisers',14.90,11,1, null ,'A dazzling new collection of short stories - the internationally bestselling authors first collection for over a decade.','images/troisBaisers.jpg',null,null,null,'long et ennuyeux'),
('2103816491','8','reduced', 'Desire moi',19.90,7,2, null,' Partout, les monstres sont chez eux... � Vincent Dussart est s�r de son coup. Ce break impos� par sa femme va prendre fin aujourd hui. Il n a rien laiss� au hasard. Comme toujours. Confiant, il p�n�tre dans la maison .','images/desire-moi.jpg',null,null,null,null),
('2739500707','7','reduced', 'Instant Crucial',9.00,34,1, null ,'Pendant la Guerre de S�cession, un soldat yankee bless� est recueilli dans un pensionnat de jeunes filles du Sud. L intrusion d un homme bouleverse ce milieu f�minin corset� et repli� sur lui-m�me. Objet de tous les fantasmes','images/cruicial.jpg',null,null,null,'Magnifique livre , je conseille !'),
('2331553545','6','reduced','Ascension',9.80,19,1, null,'Paris, 1911. � l issue du congr�s de l Association Psychanalytique Internationale, le jeune docteur Du Barrail est charg� par Sigmund Freud en personne d enqu�ter sur la mort myst�rieuse d un de leurs confr�res, retrouv�.','images/ascension.jpg',null,null,null,'Chef d oeuvre'),
('2345637001','5','reduced','Ainsi Soient ils',7.40,63,1, null,null,'images/ainsi.jpg',null,null,null,null),
('2123456661','4','reduced', 'raclette et ses amis',4.52,25,2, 'La femme mystere' ,null,'images/raclette.jpg',null,null,null,'Top!'),
('2243539998','3','reduced', 'Java pour les nuls',7.95,24,1, null,'Trouver l amour ? En ce qui la concerne, Kate Seymour y a renonc� depuis une �ternit�. Ironie du sort, elle a h�rit� d un don infaillible : d�tecter l alchimie entre deux �tres. Alors, faisant contre mauvaise fortune','images/java.jpg',null,null,null,null),
('2811356510','2','reduced', 'Horizon',7.20,19,2, null,'Alors que Menzoberazzan go�te � un semblant de paix, lib�r�e de ses hordes de d�mons, l Outreterre panse ses plaies. Le barbare du Valbise et son compagnon halfelin, seulement d�sireux de profiter de leur nouvelle','images/horizon.jpg',null,null,null,'Incroyable'),
('2290134563','1','reduced', 'Les travers du docteur Porc',4.07,39,1, null,'GarethGrace Burrowes (Auteur) Depuis neuf ans, Gareth Alexander se conduit en libertin. Pour satisfaire la derni�re volont� d une amie, il est contraint d apprendre � Felicity Worthington, comment diriger une maison close. Mais il ren�cle de plus','images/docteur.jpg',null,null,null,'Pas terrible'),
('2363586533','9','reduced','Le secret du sorcier',9.10,23,1, null ,'Summers 20 Must-Read Books If you want to know the world behind out corporate-sponsored dreamscapes, you read writers like Arundhati Roy. She shows you what s really going on','images/sorcier.jpg',null,null,null,'interessant'),
('2364992770','10','reduced', 'Bunny',14.90,11,1, null ,'A dazzling new collection of short stories - the internationally bestselling authors first collection for over a decade.','images/bunny.jpg',null,null,null,'long et ennuyeux'),
('2123816491','7','reduced', 'la Patisserie',19.90,7,2, null,' Partout, les monstres sont chez eux... � Vincent Dussart est s�r de son coup. Ce break impos� par sa femme va prendre fin aujourd hui. Il n a rien laiss� au hasard. Comme toujours. Confiant, il p�n�tre dans la maison .','images/patisserie.jpg',null,null,null,null),
('2724500707','8','reduced', 'Zombie story',9.00,34,1, null ,'Pendant la Guerre de S�cession, un soldat yankee bless� est recueilli dans un pensionnat de jeunes filles du Sud. L intrusion d un homme bouleverse ce milieu f�minin corset� et repli� sur lui-m�me. Objet de tous les fantasmes','images/zombie.jpg',null,null,null,'Magnifique livre , je conseille !'),
('2333526545','5','reduced','Rodin Amoureux',9.80,19,1, null,'Paris, 1911. � l issue du congr�s de l Association Psychanalytique Internationale, le jeune docteur Du Barrail est charg� par Sigmund Freud en personne d enqu�ter sur la mort myst�rieuse d un de leurs confr�res, retrouv�.','images/rodin.jpg',null,null,null,'Chef d oeuvre'),
('2263637001','6','reduced','Le Loup',7.40,63,1, null,null,'images/loup.jpg',null,null,null,null),
('2235456661','3','reduced', 'Les Fourmis',4.52,25,2, 'La femme mystere' ,null,'images/fourmis.jpg',null,null,null,'Top!'),
('2243545748','2','reduced', 'Au nom des nuits profondes',7.95,24,1, null,'Trouver l amour ? En ce qui la concerne, Kate Seymour y a renonc� depuis une �ternit�. Ironie du sort, elle a h�rit� d un don infaillible : d�tecter l alchimie entre deux �tres. Alors, faisant contre mauvaise fortune','images/nuit.jpg',null,null,null,null),
('2374356510','1','reduced', 'Poutine',7.20,19,2, null,'Alors que Menzoberazzan go�te � un semblant de paix, lib�r�e de ses hordes de d�mons, l Outreterre panse ses plaies. Le barbare du Valbise et son compagnon halfelin, seulement d�sireux de profiter de leur nouvelle','images/poutine.jpg',null,null,null,'Incroyable'),
('2225637563','4','reduced', 'Deadpool',4.07,39,1, null,'GarethGrace Burrowes (Auteur) Depuis neuf ans, Gareth Alexander se conduit en libertin. Pour satisfaire la derni�re volont� d une amie, il est contraint d apprendre � Felicity Worthington, comment diriger une maison close. Mais il ren�cle de plus','images/deadpool.jpg',null,null,null,'Pas terrible')


             


 
/*==============================================================*/
/* Table: KEYWORDBOOK                                           */
/*==============================================================*/
INSERT INTO KeyWordBook(
idKeyWordBook,
numISBNBookKB,
nameKeyWordKB
)
VALUES
('1','2253092533','Rebel'),
('2','2811222510','Sexiste'),
('3','2265116491','Old'),
('4','2290139963','rare'),
('5','2330081545','pocket')


/*==============================================================*/
/* Table: THEME                                                 */
/*==============================================================*/
INSERT INTO Theme ( NAMETHEME )


Values 
('Policier'),
('Amour'),
('Histoire'),
('Educatif')



/*==============================================================*/
/* Table: SUBTHEME                                              */
/*==============================================================*/
INSERT INTO SubTheme (
            IDSUBTHEME,
            NAMESUBTHEME,
            NAMETHEMESB)

Values 
            ('1','Americain','Amour'),
            ('2','Asiatique','Amour'),
            ('3','18 eme siecles','Amour'),
            ('4','Moderne','Amour'),
            ('5','Australien','Amour'),
            ('6','Corruption','Policier'),
            ('7','Enquete','Policier'),
            ('8','Western','Policier'),
            ('9','18eme Siecle','Histoire'),
            ('10','Politique','Histoire'),
            ('11','Informatique','Educatif'),
            ('12','Cusine','Educatif')
            


			
/*==============================================================*/
/* Table: SUBTHEMEBOOK                                          */
/*==============================================================*/

INSERT INTO SubThemeBook ( 
            IDSUBTHEMEBOOK,
            NUMISBNBOOKSB,
            IDSUBTHEMESB ) 

Values  ('1','2253092533','1'),
        ('2','2253092770','2'),
        ('3','2265116491','4'),
        ('4','2743640707','4'),
        ('5','2330081545','5'),
        ('6','2290147001','4'),
        ('7','2290140961','5'),
        ('8','2290139998','5'),
        ('9','2811222510','6'),
        ('10','2290139963','6'),
        ('11','2253092533','6'),
        ('12','2374356510','7'),
        ('13','2243545748','7'),
        ('14','2235456661','7'),
        ('15','2263637001','8'),
        ('16','2333526545','8'),
        ('17','2724500707','8'),
        ('18','2123816491','9'),
        ('19','2364992770','9'),
        ('20','2363586533','9'),
        ('21','2290134563','10'),
        ('22','2811356510','10'),
        ('23','2243539998','10'),
        ('24','2123456661','11'),
        ('25','2345637001','11'),
        ('26','2331553545','11'),
        ('27','2739500707','11'),
        ('28','2103816491','12'),
        ('29','2309992770','12'),
        ('30','2363092533','12'),
        ('31','2123456661','2'),
        ('32','2345637001','2'),
        ('33','2331553545','2'),
        ('34','2739500707','2'),
        ('35','2103816491','1'),
        ('36','2309992770','1'),
        ('37','2363092533','1'),
        ('38','2374356510','3'),
        ('39','2265116491','3'),
         ('40','2331553545','2'),
        ('41','2253092533','2'),
        ('42','2235456661','2')
/*==============================================================*/
/* Table: OCCASION                                                 */
/*==============================================================*/
INSERT INTO Occasion (
        NAMEOCCASION ,
        DATEDEBUTOCCASION ,
        DATEFINOCCASION ,        
        DISCOUNTOCCASION ) 
VALUES 
        ('Le mois de l amour','12/07/2018','12/08/2018',5);


/*==============================================================*/
/* Table: OCCASIONBOOK                                             */
/*==============================================================*/
INSERT INTO OccasionBook (
        IDOCCASIONBOOK,          
        NUMISBNBOOKOB,         
        NAMEOCCASIONOB )
    Values 
        ('1','2290147001','Le mois de l amour'),
        ('2','2290140961','Le mois de l amour'),
        ('3','2290139998','Le mois de l amour'),
        ('4','2811222510','Le mois de l amour'),
        ('5','2290139963','Le mois de l amour')


/*==============================================================*/
/* Table: EMPLOYERIGHT                                          */
/*==============================================================*/
INSERT INTO EMPLOYERIGHT 
			(IDEMPLOYERIGHT,
			TYPEEMPLOYERIGHT )	
		VALUES  ('Admin',1) ,
				('Moderator',2) , 
				('Neutral',3)


/*==============================================================*/
/* Table: EMPLOYE                                               */
/*==============================================================*/
INSERT INTO Employe (
		 loginEmploye,
		 idEMPLOYERIGHTEMP,
		 firstNameEmploye,
		 lastNameEmploye,
		 emailEmploye,
		 passwordEmploye ,
		 statusEmploye) 

VALUES  ('Admin','Admin','GOD','michet', 'Satan@hell.com','Admin','actif') , 
        ('employe02','Moderator','Nina','Marie', 'nina.marie@compagny.com','ninaPassword','actif') ,
		('employe03','Neutral','marion','dupont','marion.dupont@compagny.com','marionPassword','inactif')  


/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
INSERT INTO Customer (
loginCustomer,
lastNameCustomer,
firstNameCustomer,
emailCustomer,
passwordCustomer,
nameCompanyCustomer,
commentCustomer,
statusCustomer) 

VALUES 
('Bob01','Bob',	'Marley','bob.marley@yahoo.fr',	'bobmarley01','','',11),
	  ------------------------------------------	
('zidane02','Zinedine','Zidane','zinedine.zidane@yahoo.fr','zinedinezidane02','','',11),
	------------------------------------------	
('marc03','Marc','Lewis','marc.lewis@yahoo.fr','marclewis03','','',11),
	------------------------------------------	
('Nicole04','Nicole','Kidman','nicole.kidman@yahoo.fr','nicolekidman04','','',11),
	------------------------------------------	
('Angelina05','ANgelina','jolie','angelina.jolie@yahoo.fr','angelinajolie05','Hollywood','',11)


/*==============================================================*/
/* Table: AUTHOR                                                */
/*==============================================================*/

INSERT INTO Author(
idAuthor, 
lastNameAuthor,
firstNameAuthor,
biographyAuthor,
birthDateAuthor,
dieDateAuthor,
commentAuthor 
) 
VALUES
('1','Melanie','Raabe','à 10 ans elle vendait deja du crack, elle se mis à écrire en centre de désintox','1965-12-09',null,''),
('2','Dan','Brown','expert en communication, Dan à toujours aimé insulter le bas peuple','1945-08-07',null,''),
('3','Elena','Piacentini','Maitresse de zerbib jonathan , elle finis par le tuer et se mis à ecrire des bouquin en prison','1975-04-04',null,''),
('4','Thomas','Cullinan','pere origninel du culliningus , son premier livre fut un best fisteur ','1980-11-02',null,''),
('5','Olivier','Bande','fils de larbre, olivier na jamais supporter ecrire sur du papier  ','1969-02-11',null,''),
('6','Susane','Enoch','susan aime le chocolat et à toujours aimé faire du trampoline','1976-06-01',null,''),
('7','Amanda','Quick','adepte de la partouze, amanda decris dans ses livres ses plus grandes conquetes sexuels','1989-10-11',null,''),
('8','Lily','Haine','contrairement à son nom, lily na jamais ressenti de haine ','1979-11-09',null,''),
('9','Grace','Burrows','anciennement frere de micheal scofield, il est devenu sa soeur apres opérations','1939-11-09','2015-01-04','')



/*==============================================================*/
/* Table: AUTHORBOOK                                            */
/*==============================================================*/
INSERT INTO AuthorBook(
idAuthorBook,
numISBNBookAB,
idAuthorAB
)
VALUES
('1','2253092533','1'),
('2','2253092770','2'),
('3','2265116491','3'),
('4','2743640707','4'),
('5','2330081545','5'),
('6','2290147001','6'),
('7','2290140961','7'),
('8','2290139998','8'),
('9','2811222510','9'),
('10','2290139963','4'),
('11','2253092533','1'),
('12','2309992770','2'),
('13','2103816491','3'),
('14','2739500707','4'),
('15','2331553545','5'),
('16','2345637001','6'),
('17','2123456661','7'),
('18','2243539998','8'),
('19','2811356510','9'),
('20','2290134563','4'),
('21','2363586533','1'),
('22','2364992770','2'),
('23','2123816491','3'),
('24','2724500707','4'),
('25','2333526545','5'),
('26','2263637001','6'),
('27','2235456661','7'),
('28','2243545748','8'),
('29','2374356510','9'),
('30','2225637563','4')

/*==============================================================*/
/* Table: SHIPPER                                               */
/*==============================================================*/
INSERT INTO Shipper(
nameShipper,
commentShipper
) 
VALUES 
('la Poste',''),
('DHL',''),
('Ups','beaucoup trop cher')


/*==============================================================*/
/* Table: INFOSTATUS                                                */
/*==============================================================*/
INSERT INTO InfoStatus
	 (nameInfoStatus,valueInfoStatus) 

VALUES  ('processing',1),
        ('shipping',2) ,
	('received',3) ,
        ('canceled',4) ,
	('customerInactif',10),  
        ('customerActif',11),
        ('customerBlacklist',12),
        ('inactif',20),
        ('actif',21),
        ('Approved',40),
        ('Refused',41)


/*==============================================================*/
/* Table: COMPANY                                               */
/*==============================================================*/
INSERT INTO Company (
siretCompany,
nameCompany,
logoCompany,
telephoneCompany,
faxCompany,
mailCompany)

VALUES (
'33458219400018',
'Librairie Compagnie',
'logoLibrairie Compagnie' ,
'0143263814',
'0146346337',
'info@librairie-compagnie.fr')
/*another compagny-- ('57219879400024', 'Librairie Le Divan',
'logo Librairie Le Divan' ,'0153689068','0153689069','ledivan@ledivan.com'),*/

/*==============================================================*/
/* Table: INFOCOMPANY                                           */
/*==============================================================*/
INSERT INTO INFOCOMPANY (		
		nameINFOCOMPANY,
		descriptionInfoCompany
		) 

VALUES ('AdressCompany','id_1 dans la table Adress'),
       ('Status1-9','Concerne Order'),
       ('Status10-19','Concerne Customer'),
       ('Status20-29','Concerne Employe')
		 

/*==============================================================*/
/* Table: PACKAGESHIPPER                                        */
/*==============================================================*/
INSERT INTO PackageShipper(
idPackageShipper,
nameShipper,
costPackageShipper
)
VALUES
('1','DHL',8.20),
('2','DHL',4.70),
('3','DHL',0.00)


/*==============================================================*/
/* Table: ADRESS                                                */
/*==============================================================*/
INSERT INTO Adress (
			IDADRESS ,                 
                        LOGINCUSTOMERSHIPADRESS,
                        LOGINCUSTOMERBILLADRESS,  
                        NAMERECEIVERADRESS,       
                        TYPESTREETADRESS,         
                        NUMADRESS ,               
                        NAMESTREETADRESS,         
                        NAMESTEET2ADRESS ,        
                        ZIPCODEADRESS,            
                        CITYADRESS,               
                        COUNTRYADRESS, 
                        NAMECOMPANYRECEIVERADRESS
			 ) 

VALUES 
('1',null,null,'Marc','rue','12','Georges et Mai Politzer ','','75012','Paris','France', NULL),

('2','Bob01','Bob01','Marley','livraison','152','rue de la fontaine  ','','75001','Paris','France', NULL), 
		------------------------------------------	
('3','zidane02','zidane02','Foued','livraison','3','avenue de la republique  ','','93350','le Bourget','France',NULL), 
		------------------------------------------	
('4','marc03','marc03','Yous','livraison','17','avenue charle de gaule','','13001','marseille','France',NULL),
	------------------------------------------	
('5','Nicole04','Nicole04','Nicole','livraison','45','rue de vincennes ','','93100','Montreuil','France',NULL ), 
	------------------------------------------			
('6','Angelina05','Angelina05','Angelina','livraison','114','avenue de la division leclerc ','','78100','Sartrouville','France', NULL) 

   
   
     






/*==============================================================*/
/* Table: "ORDERS"                                               */
/*==============================================================*/
INSERT INTO Orders(
        idOrder,
        NAMEINFOSTATUSORDER,
        idAdressShippingOrder,
        loginCustomerOrder,
        idAdressBillingOrder,
        IDPACKAGESHIPPERORDER,
        InternalNumOrder,
        DateOrder,
        PaymentSystemOrder,
        ipOrder,
        datePackageShipperOrder
        )
        VALUES
        ('1','processing','2','Bob01','2','1','201','2017-08-09','cb','5.135.158.101',null),
        ('2','processing','3','Zidane02','3','1','202','2017-04-10','cb','37.59.119.196',null),
        ('3','shipping','4','marc03','4','3','203','2017-08-14','cb','46.19.137.221','2017-08-15'),
        ('4','processing','5','nicole04','5','2','204','2017-08-21','cb','51.15.34.210',null),
        ('5','processing','6','Angelina05','6','2','205','2017-08-24','cb','24.62.155.244',null)

/*==============================================================*/
/* Table: ORDERLINE                                             */
/*==============================================================*/
   INSERT INTO OrderLine (
                IDORDERLINE,          
                QUANTITYORDERLINE, 
                UNITCOSTORDERLINE ,                       
                IDORDER  ,            
                NUMISBNBOOK ,    
                DISCOUNTORDERLINE,
                RATETVAORDERLINE, 
                IDAPPRECIATE
                )
          Values('1',3,9.80,'1','2330081545',5,5.5,null),   
                ('2',1,7.40,'1','2290147001',5,5.5,null),    
                ('3',1,4.52,'2','2290140961',5,5.5,null),   
                ('4',2,7.20,'5','2811222510',5,5.5,null),    
                ('5',1,4.07,'5','2290139963',5,5.5,null),    
                ('6',1,5.90,'4','2253092770',5,5.5,null),    
                ('7',2,19.90,'1','2265116491',5,5.5,null),   
                ('8',1,9.00,'1','2743640707',5,5.5,null),    
                ('9',1,9.80,'2','2330081545',5,5.5,null),    
                ('10',2,7.40,'3','2290147001',5,5.5,null),    
                ('11',1,4.52,'3','2290140961',5,5.5,null),
                ('12',1,7.9,'4','2290139998',5,5.5,null)


/*==============================================================*/
/* Table: APPRECIATION                                          */
/*==============================================================*/
INSERT INTO Appreciation 
		(
		idAppreciate,
                loginCustomerAppreciate,		
                idOrderLineAppreciate ,
                numISBNBookAppreciate,
		dateAppreciate,
                commentAppreciate,
		ratingAppreciate,		
		IPAPPRECIATE,
                loginEmployeAppreciate,
		moderateAPPRECIATE,
		DATEmoderateAPPRECIATE,
                STATUSAPPRECIATE
		) 

VALUES ('1','Bob01','1' ,'2330081545','2017-01-11','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor ',5,'5.135.158.101','employe02', 1, '2017-01-15',40 ),		 
	------------------------------------------	
	 ('2','zidane02','3' ,'2290140961','2017-02-12' ,' Aenean imperdiet. Etiam ultricies nisi veondimentum rhoncus, sem psum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. Nullam quis ',4,'12.130.206.44','employe02' , 1, '2017-02-15',40 ), 
	-----------------------------------------	
	 ('3','marc03','11' ,'2290140961','2017-03-13','Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium dolmodi tempora incidunt ut labore et dol ',3,'104.13.125.62','employe02' , 1, '2017-03-15' ,40 ), 
	 ('4','marc03','10' ,'2290147001','2017-03-13',' nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea ',3,'168.181.48.54',null , 0, null ,null), 
	------------------------------------------
        ('5','Nicole04','12' ,'2290139998','2017-04-14','FUUUCKKK I WONT BOUGHT ANY MORE BOOKS FROM YOUR FUCKING STORE !! FUCK ALL OF YOU FUCKING ASSHOLES !! ', 2,'173.49.240.22','employe02', 1, '2017-04-15' ,41  ), 
	 ('6','Nicole04','6' ,'2253092770','2017-04-14','bibendum sed, posuere ac, mattis non, nunc. Vestibulum fringilla pede sit amet augue. In turpis. Pellentesque posuere. Praesent turpis. Aenean posuere, tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus. Donec elit libero, sodal', 2,'188.24.236.80',null, 0, NULL ,null ),
------------------------------------------
	 ('7','Angelina05','4' ,'2811222510','2017-05-15','A rambling wonderful book with imagery and emotions liberally sprinkled throughout.', 1,'93.113.244.206' ,null, 0, null,null  )
	


INSERT INTO COUNTER 
		(
		name,
		value)
	VALUES ('ADRESS',6),
                ('APPRECIATION',8),
                ('AUTHOR',9),
                ('AUTHORBOOK',10),
                ('EDITOR',10),
                ('KEYWORDBOOK',5),
                ('OCCASIONBOOK',5),
                ('ORDERLINE',12),
                ('ORDERS',2589),
                ('PACKAGESHIPPER',3),
                ('SUBTHEME',8),
                ('SUBTHEMEBOOK',10),
                ('NUMCOMMANDE',456558)
                