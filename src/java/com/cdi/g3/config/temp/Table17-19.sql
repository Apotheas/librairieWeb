-- Order  - OrderLine - Apreciate

----------------------------------------------------------------------------------------
----------------Creation table 
------------------------------------------------------------------------------------------

/*==============================================================*/
/* Table : "ORDER"                                              */
/*==============================================================*/
create table "ORDER" (
   IDORDER              numeric(10)          identity,
   LOGINCUSTOMER        varchar(50)          not null,
   IDADRESSSHIP             int                  not null,
   IDADRESSBILL         int                  not null,
   NAMESHIPPER          varchar(50)          not null,
   NAMESTATUS           varchar(50)          not null,
   DATEORDER            datetime             not null,
   SHIPPINGCOSTSORDER   money                null,
   PAYMENTSYSTEMORDER   varchar(50)          null,
   IPORDER              varchar(45)          null,
  
)
go


/*==============================================================*/
/* Table : ORDERLINE                                            */
/*==============================================================*/
create table ORDERLINE (
   IDORDERLINE          numeric(10)          identity,
   IDORDER              int                  not null,
   NUMISBNBOOK          varchar(13)          not null,
   IDAPPRECIATE         numeric              not null,
   APP_IDAPPRECIATE     numeric              not null,
   QUANTITYORDERLINE    smallint             not null,
   DISCOUNTORDERLINE    numeric(8)           null,
   UNITCOSTORDERLINE    float                null,
   RATETVAORDERLINE     float                null,
   
)
go

/*==============================================================*/
/* Table : APPRECIATION                                         */
/*==============================================================*/
create table APPRECIATION (
   IDAPPRECIATE         numeric              identity,
   IDORDERLINE          numeric(10)          not null,
   ORD_IDORDERLINE      numeric(10)          not null,
   LOGINCUSTOMER        varchar(50)          not null,
   NUMISBNBOOK          varchar(13)          not null,
   LOGINEMPLOYE         varchar(50)          not null,
   COMMENTAPPRECIATE    varchar(500)         null,
   RATINGAPPRECIATE     smallint             null,
   DATEAPPRECIATE       datetime             null,
   IPAPPRECIATE         varchar(45)          null,
  
)
go






----------------------------------------------------------------------------------------
----------------Creation PK
------------------------------------------------------------------------------------------

--PRIMARY KEY Order 
ALTER TABLE ORDER 
ADD CONSTRAINT idOrder_pk 
PRIMARY KEY (idOrder) 
 
--PRIMARY KEY OrderLine 
ALTER TABLE ORDERLINE 
ADD CONSTRAINT IdOrderLine_pk 
PRIMARY KEY (IdOrderLine) 
 
--PRIMARY KEY AuthorBook 
ALTER TABLE AuthorBook 
ADD CONSTRAINT AuthorBook_pk 
PRIMARY KEY (NumISBNbook, IdAuthor) 
 
--PRIMARY KEY APPRECIATION 
ALTER TABLE APPRECIATION 
ADD CONSTRAINT idAppreciation_pk 
PRIMARY KEY (idAppreciation) 




----------------------------------------------------------------------------------------
----------------Creation FK
------------------------------------------------------------------------------------------
--FOREIGN KEY ORDER 
ALTER TABLE ORDER 
ADD CONSTRAINT ORDERnumISBNbook_fk 
FOREIGN KEY(numISBNbook) 
REFERENCES Book(numISBNbook) 
 
ALTER TABLE ORDER 
ADD CONSTRAINT ORDERIDADRESSSHIP_fk 
FOREIGN KEY(IDADRESSSHIP) 
REFERENCES Adress(idAdress) 

ALTER TABLE ORDER 
ADD CONSTRAINT ORDERIDADRESSBILL_fk 
FOREIGN KEY(IDADRESSBILL) 
REFERENCES Adress(idAdress) 

ALTER TABLE ORDER 
ADD CONSTRAINT OrderNAMESHIPPER_fk
FOREIGN KEY(NAMESHIPPER) 
REFERENCES SHIPPER(NAMESHIPPER) 

ALTER TABLE ORDER 
ADD CONSTRAINT ORDERNAMESTATUS_fk 
FOREIGN KEY(NAMESTATUS) 
REFERENCES STATUS(NAMESTATUS) 
 
--FOREIGN KEY ORDERLINE 
ALTER TABLE ORDERLINE 
ADD CONSTRAINT ORDERLINEIDORDER_fk 
FOREIGN KEY(IDORDER) 
REFERENCES Order(IDORDER) 

ALTER TABLE ORDERLINE 
ADD CONSTRAINT ORDERLINENUMISBNBOOK_fk 
FOREIGN KEY(NUMISBNBOOK) 
REFERENCES BOOK(NUMISBNBOOK) 

ALTER TABLE ORDERLINE 
ADD CONSTRAINT ORDERLINEIDAPPRECIATE_fk 
FOREIGN KEY(IDAPPRECIATE) 
REFERENCES APPRECIATE(IDAPPRECIATE) 

--FOREIGN KEY APPRECIATION 
ALTER TABLE APPRECIATION 
ADD CONSTRAINT APPRECIATIONLOGINCUSTOMER_fk 
FOREIGN KEY(LOGINCUSTOMER) 
REFERENCES CUSTOMER(LOGINCUSTOMER) 

ALTER TABLE APPRECIATION 
ADD CONSTRAINT APPRECIATIONIDORDERLINE_fk 
FOREIGN KEY(IDORDERLINE) 
REFERENCES ORDERLINE(IDORDERLINE)

ALTER TABLE APPRECIATION 
ADD CONSTRAINT APPRECIATIONNUMISBNBOOK_fk 
FOREIGN KEY(NUMISBNBOOK) 
REFERENCES BOOK(NUMISBNBOOK)

ALTER TABLE APPRECIATION 
ADD CONSTRAINT APPRECIATIONLOGINEMPLOYE_fk 
FOREIGN KEY(LOGINEMPLOYE) 
REFERENCES EMPLOYE(LOGINEMPLOYE)





----------------------------------------------------------------------------------------
----------------Drop table 
------------------------------------------------------------------------------------------

Drop table Customer 
Drop table Author 
drop table AuthorBook 
Drop table Adress 

----------------------------------------------------------------------------------------
----------------Drop PK
------------------------------------------------------------------------------------------
--FOREIGN KEY Order 
ALTER TABLE Order 
DROP CONSTRAINT idOrder_pk

--FOREIGN KEY OrderLine 
ALTER TABLE OrderLine 
DROP CONSTRAINT IdOrderLine_pk 

--FOREIGN KEY APPRECIATION 
ALTER TABLE Appreciation 
DROP CONSTRAINT idAppreciation_pk 


----------------------------------------------------------------------------------------
----------------Drop FK
------------------------------------------------------------------------------------------
--FOREIGN KEY APPRECIATION 
ALTER TABLE APPRECIATION 
DROP CONSTRAINT APPRECIATIONLOGINEMPLOYE_fk 
 
ALTER TABLE APPRECIATION 
DROP CONSTRAINT APPRECIATIONNUMISBNBOOK_fk 
 
ALTER TABLE APPRECIATION 
DROP CONSTRAINT APPRECIATIONIDORDERLINE_fk 

ALTER TABLE APPRECIATION 
DROP CONSTRAINT APPRECIATIONLOGINCUSTOMER_fk 


--FOREIGN KEY ORDERLINE 
ALTER TABLE ORDERLINE 
DROP CONSTRAINT ORDERLINEIDAPPRECIATE_fk 

ALTER TABLE ORDERLINE 
DROP CONSTRAINT ORDERLINENUMISBNBOOK_fk 

ALTER TABLE ORDERLINE 
DROP CONSTRAINT ORDERLINEIDORDER_fk 

--FOREIGN KEY ORDER 
ALTER TABLE ORDER 
DROP CONSTRAINT ORDERNAMESTATUS_fk 

ALTER TABLE ORDER 
DROP CONSTRAINT OrderNAMESHIPPER_fk 

ALTER TABLE ORDER 
DROP CONSTRAINT ORDERIDADRESSBILL_fk 

ALTER TABLE ORDER 
DROP CONSTRAINT ORDERIDADRESSSHIP_fk 

ALTER TABLE ORDER 
DROP CONSTRAINT ORDERnumISBNbook_fk

