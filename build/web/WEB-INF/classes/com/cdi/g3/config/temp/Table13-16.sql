
-- Customer - Author - AuthorBook - Adress



----------------------------------------------------------------------------------------
----------------Creation table 
------------------------------------------------------------------------------------------
create table CUSTOMER (
   LOGINCUSTOMER        varchar(50)          not null,
   LASTNAMECUSTOMER     char(50)             null,
   FIRSTNAMECUSTOMER    char(50)             null,
   EMAILCUSTOMER        varchar(50)          null,
   PASSWORDCUSTOMER     varchar(50)          null,
   NAMECOMPANYCUSTOMER  varchar(50)          null,
   COMMENTCUSTOMER      varchar(250)         null,
   STATUSCUSTOMER       int                  null,   
)

create table AUTHOR (
   IDAUTHOR             numeric(10)          identity,
   FIRSTNAMEAUTHOR      char(50)             null,
   LASTNAMEAUTHOR       char(50)             null,
   BIOGRAPHY            char(250)            null,
   BIRTHDATEAUTHOR      datetime             null,
   DIEDATEAUTHOR        datetime             null,  
)

create table AuthorBook (
   NUMISBNBOOK          varchar(13)          not null,
   IDAUTHOR             numeric(10)          not null,   
)

create table ADRESS (
   IDADRESS             numeric(10)          identity,
   LOGINCUSTOMERSHIP        varchar(50)          not null,
   LOGINCUSTOMERBILL        varchar(50)          not null,
   TYPESTREETADRESS     varchar(30)          null,
   NUMADRESS            varchar(10)          not null,
   NAMESTREETADRESS     varchar(50)          not null,
   NAMESTEET2ADRESS     text                 null,
   ZIPCODEADRESS        varchar(5)           not null,
   CITYADRESS           varchar(40)          not null,
   COUNTRYADRESS        varchar(50)          not null,  
)

----------------------------------------------------------------------------------------
----------------Creation PK
------------------------------------------------------------------------------------------

--PRIMARY KEY Customer
ALTER TABLE Customer
ADD CONSTRAINT loginCustomer_pk
PRIMARY KEY (loginCustomer)

--PRIMARY KEY Author
ALTER TABLE Author
ADD CONSTRAINT IdAuthor_pk
PRIMARY KEY (IdAuthor)

--PRIMARY KEY AuthorBook
ALTER TABLE AuthorBook
ADD CONSTRAINT AuthorBook_pk
PRIMARY KEY (NumISBNbook, IdAuthor)

--PRIMARY KEY Adress
ALTER TABLE Adress
ADD CONSTRAINT idAdress_pk
PRIMARY KEY (IdAdress)




----------------------------------------------------------------------------------------
----------------Creation FK
------------------------------------------------------------------------------------------
--FOREIGN KEY AuthorBook
ALTER TABLE AuthorBook
ADD CONSTRAINT AuthorBooknumISBNbook_fk
FOREIGN KEY(numISBNbook)
REFERENCES Book(numISBNbook)

ALTER TABLE AuthorBook
ADD CONSTRAINT AuthorBookidAuthor_fk
FOREIGN KEY(idAuthor)
REFERENCES Author(idAuthor)

--FOREIGN KEY Adress
ALTER TABLE Adress
ADD CONSTRAINT AdressLOGINCUSTOMERSHIP_fk
FOREIGN KEY(LOGINCUSTOMERSHIP)
REFERENCES Customer(loginCustomer)

ALTER TABLE Adress
ADD CONSTRAINT AdressLOGINCUSTOMERBILL_fk
FOREIGN KEY(LOGINCUSTOMERBILL)
REFERENCES Customer(loginCustomer)


----------------------------------------------------------------------------------------
----------------Drop table 
------------------------------------------------------------------------------------------
Drop table Adress
drop table AuthorBook
Drop table Author
Drop table Customer




----------------------------------------------------------------------------------------
----------------Drop PK
------------------------------------------------------------------------------------------
ALTER TABLE Customer
DROP CONSTRAINT loginCustomer_pk

ALTER TABLE Author
DROP CONSTRAINT IdAuthor_pk

ALTER TABLE AuthorBook
DROP CONSTRAINT AuthorBook_pk

ALTER TABLE Adress
DROP CONSTRAINT idAdress_pk

----------------------------------------------------------------------------------------
----------------Drop FK
------------------------------------------------------------------------------------------
-- Customer - Author - AuthorBook - Adress

ALTER TABLE Adress
DROP CONSTRAINT AdressLOGINCUSTOMERSHIP_fk

ALTER TABLE Adress
DROP CONSTRAINT AdressLOGINCUSTOMERBILL_fk


ALTER TABLE AuthorBook
DROP CONSTRAINT AuthorBooknumISBNbook_fk

ALTER TABLE AuthorBook
DROP CONSTRAINT AuthorBookidAuthor_fk

