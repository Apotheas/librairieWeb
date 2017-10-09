
  
  ---AUTHOR -- EDITOR ----SHIPPER ----AUTHORBOOK----CODETVA---KEYWORD---KEYWORDBOOK---PACKAGESHIPPER---ORDER



/* ------------------------ AUTHOR -----------------------    */


INSERT INTO Author(
idAuthor, 
firstNameAuthor,
lastNameAuthor,
biographyAuthor,
birthDateAuthor,
dieDateAuthor,
commentAuthor 
) 
VALUES
(1,'Raabe','Melanie','à 10 ans elle vendait deja du crack, elle se mis à écrire en centre de désintox',1965-12-09,'',''),
(2,'Brown','Dan','expert en communication, Dan à toujours aimé insulter le bas peuple',1945-08-07,'',''),
(3,'Piacentini','Elena','Maitresse de zerbib jonathan , elle finis par le tuer et se mis à ecrire des bouquin en prison',1975-04-04,'',''),
(4,'Cullinan','Thomas','pere origninel du culliningus , son premier livre fut un best fisteur ',1980-11-02,'',''),
(5,'Bande','Olivier','fils de larbre, olivier na jamais supporter ecrire sur du papier  ',1969-02-11,'',''),
(7,'Enoch','Susane','susan aime le chocolat et à toujours aimé faire du trampoline',1976-06-01,'',''),
(8,'Quick','Amanda','adepte de la partouze, amanda decris dans ses livres ses plus grandes conquetes sexuels',1989-10-11,'',''),
(9,'Haine','Lily','contrairement à son nom, lily na jamais ressenti de haine ',1979-11-09,'',''),
(10,'Burrows','Grace','anciennement frere de micheal scofield, il est devenu sa soeur apres opérations',1939-11-09,2015-01-04,'')



/* ------------------------ EDITOR -----------------------    */

INSERT INTO Editor(
idEditor,
nameEditor,
statusEditor
)
VALUES
(1,'Lafond',''),
(2,'Hachette',''),
(3,'Panini',''),
(4,'Eyrolles',''),
(5,'Bayard',''),
(6,'Atlas',''),
(7,'Actes Sud',''),
(8,'Belin',''),
(9,'Solar',''),
(10,'Arthaud','')


/* ------------------------ SHIPPER -----------------------    */

INSERT INTO Shipper(
nameShipper,
commentShipper
) 
VALUES 
('la Poste',''),
('DHL',''),
('Ups','beaucoup trop cher')


/* ------------------------ AuthorBook -----------------------    */

INSERT INTO AuthorBook(
idAuthorBook,
numISBNBook,
idAuthor,
)
VALUES
(1,'2253092533',1),
(2,'2253092770',2),
(3,'2265116491',3),
(4,'2743640707',4),
(5,'2330081545',5),
(6,'2290147001',6),
(7,'2290140961',7),
(8,'2290139998',8),
(9,'2811222510',9),
(10,'2290139963',10)

/* ------------------------ CodeTVA -----------------------    */

INSERT INTO CodeTVA(
typeTVA,
rateCodeTVA
)
VALUES 
('General' , 5.5)


/* ------------------------ Keyword -----------------------    */
INSERT INTO KeyWord(
nameKeyWord)
VALUES
('Rebel'),
('Sexiste'),
('Old'),
('rare'),
('pocket')


/* ------------------------ KeyWordBook-----------------------    */

INSERT INTO KeyWordBook(
numISBNBook,
nameKeyWord
)
VALUES
('2253092533','Rebel'),
('2811222510','Sexiste'),
('2265116491','Old'),
('2290139963','rare'),
('2330081545','pocket')


/* ------------------------ PackageShipper-----------------------    */

INSERT INTO PackageShipper(
idPackageShipper,
nameShipper,
costPackageShipper
)
VALUES
(1,'DHL',8.20),
(2,'DHL',4.70),
(3,'DHL',0.00)



/* ------------------------ ORDER -----------------------    */

INSERT INTO Orders(
idOrder,
nameStatusOrder,
idAdressShippingOrder,
loginCustomerOrder,
idAdressBillingOrder,
InternalNumOrder,
DateOrder,
PaymentSystemOrder,
ipOrder,
datePackageShipperOrder
)
VALUES
('5.135.158.101','
('37.59.119.196','
('46.19.137.221','
('51.15.34.210','
('24.62.155.244','

