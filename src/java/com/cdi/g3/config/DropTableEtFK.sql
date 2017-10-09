USE librairieDB
Go


/*==============================================================*/
/* Table: ORDERLINE                                             */
/*==============================================================*/

ALTER TABLE ORDERLINE 
DROP CONSTRAINT FK_ORDERLIN_PUT_ORDER 

ALTER TABLE ORDERLINE 
DROP CONSTRAINT FK_ORDERLIN_RECUPERAT_APPRECIA 

ALTER TABLE ORDERLINE 
DROP CONSTRAINT FK_ORDERLIN_REPRESENT_BOOK 





/*==============================================================*/
/* Table: APPRECIATION                                          */
/*==============================================================*/


ALTER TABLE APPRECIATION 
DROP CONSTRAINT FK_APPRECIA_APPRECIAT_CUSTOMER 

ALTER TABLE APPRECIATION 
DROP CONSTRAINT FK_APPRECIA_BEAPPRECI_BOOK 

ALTER TABLE APPRECIATION 
DROP CONSTRAINT FK_APPRECIA_MODERATE_EMPLOYE 

ALTER TABLE APPRECIATION 
DROP CONSTRAINT FK_APPRECIA_RECUPERAT_ORDERLIN 




/*==============================================================*/
/* Table:    ORDERLINE   &&    APPRECIATION                     */
/*==============================================================*/

ALTER TABLE ORDERLINE
DROP CONSTRAINT PK_ORDERLINE

drop table ORDERLINE;



ALTER TABLE APPRECIATION
DROP CONSTRAINT PK_APPRECIATION

drop table  APPRECIATION;




/*==============================================================*/
/* Table: "ORDER"                                               */
/*==============================================================*/

ALTER TABLE ORDERS 
DROP CONSTRAINT FK_ORDER_STATUATE_INFOSTATUS 

ALTER TABLE ORDERS 
DROP CONSTRAINT FK_ORDER_SHIPPED_PACKAGES 

ALTER TABLE ORDERS 
DROP CONSTRAINT FK_ORDER_SHIP_ADRESS 

ALTER TABLE ORDERS 
DROP CONSTRAINT FK_ORDER_BUY_CUSTOMER 

ALTER TABLE ORDERS 
DROP CONSTRAINT FK_ORDER_BILL_ADRESS 

ALTER TABLE ORDERS 
DROP CONSTRAINT PK_ORDER 

drop table "ORDERS";

/*==============================================================*/
/* Table: ADRESS                                                */
/*==============================================================*/
ALTER TABLE ADRESS  
DROP CONSTRAINT FK_ADRESS_DEFAULTBI_CUSTOMER 

ALTER TABLE ADRESS  
DROP CONSTRAINT FK_ADRESS_DEFAULTSH_CUSTOMER 

--ALTER TABLE ADRESS  
--DROP CONSTRAINT FK_ADRESS_HAVE_COMPANY 

ALTER TABLE ADRESS  
DROP CONSTRAINT  PK_ADRESS

drop table  ADRESS;

/*==============================================================*/
/* Table: PACKAGESHIPPER                                        */
/*==============================================================*/
ALTER TABLE PACKAGESHIPPER  
DROP CONSTRAINT FK_PACKAGES_APPLICATE_SHIPPER 

ALTER TABLE PACKAGESHIPPER  
DROP CONSTRAINT PK_PACKAGESHIPPER 

drop table  PACKAGESHIPPER;

/*==============================================================*/
/* Table: INFOCOMPANY                                           */
/*==============================================================*/
--ALTER TABLE INFOCOMPANY  
--DROP CONSTRAINT FK_INFOCOMP_PRECISE_COMPANY 

ALTER TABLE INFOCOMPANY  
DROP CONSTRAINT PK_INFOCOMPANY 

drop table  INFOCOMPANY;

/*==============================================================*/
/* Table: COMPANY                                               */
/*==============================================================*/
ALTER TABLE COMPANY  
DROP CONSTRAINT PK_COMPANY 

drop table  COMPANY;

/*==============================================================*/
/* Table: INFOSTATUS                                                */
/*==============================================================*/
ALTER TABLE INFOSTATUS  
DROP CONSTRAINT PK_INFOSTATUS 

drop table INFOSTATUS;

/*==============================================================*/
/* Table: SHIPPER                                               */
/*==============================================================*/
ALTER TABLE SHIPPER  
DROP CONSTRAINT PK_SHIPPER 

drop table  SHIPPER;

/*==============================================================*/
/* Table: AUTHORBOOK                                            */
/*==============================================================*/
ALTER TABLE AUTHORBOOK  
DROP CONSTRAINT FK_AUTHORBO_WRITE2_AUTHOR 

ALTER TABLE AUTHORBOOK  
DROP CONSTRAINT FK_AUTHORBO_WRITE_BOOK 

ALTER TABLE AUTHORBOOK  
DROP CONSTRAINT PK_AUTHORBOOK 

drop table AUTHORBOOK;

/*==============================================================*/
/* Table: AUTHOR                                                */
/*==============================================================*/
ALTER TABLE AUTHOR  
DROP CONSTRAINT PK_AUTHOR 

drop table  AUTHOR;

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
ALTER TABLE CUSTOMER  
DROP CONSTRAINT PK_CUSTOMER 

drop table CUSTOMER;

/*==============================================================*/
/* Table: EMPLOYE                                               */
/*==============================================================*/
ALTER TABLE EMPLOYE  
DROP CONSTRAINT FK_EMPLOYE_OWN_RIGHTEMP 

ALTER TABLE EMPLOYE  
DROP CONSTRAINT PK_EMPLOYE 

drop table  EMPLOYE;

/*==============================================================*/
/* Table: EMPLOYERIGHT                                          */
/*==============================================================*/
ALTER TABLE EMPLOYERIGHT  
DROP CONSTRAINT PK_EMPLOYERIGHT 


drop table  EMPLOYERIGHT;

/*==============================================================*/
/* Table: OCCASIONBOOK                                             */
/*==============================================================*/
ALTER TABLE OCCASIONBOOK  
DROP CONSTRAINT FK_OCCASIONBOOK_PARTICIPA_OCCASION 

ALTER TABLE OCCASIONBOOK  
DROP CONSTRAINT FK_OCCASIONBOOK_PARTICIPA_BOOK 

ALTER TABLE OCCASIONBOOK  
DROP CONSTRAINT PK_OCCASIONBOOK 

drop table OCCASIONBOOK;

/*==============================================================*/
/* Table: OCCASION                                                 */
/*==============================================================*/
ALTER TABLE OCCASION  
DROP CONSTRAINT PK_OCCASION 

drop table OCCASION;

/*==============================================================*/
/* Table: SUBTHEMEBOOK                                          */
/*==============================================================*/
ALTER TABLE SUBTHEMEBOOK  
DROP CONSTRAINT FK_SUBTHEME_BELONG2_SUBTHEME

ALTER TABLE SUBTHEMEBOOK  
DROP CONSTRAINT FK_SUBTHEME_BELONG_BOOK

ALTER TABLE SUBTHEMEBOOK  
DROP CONSTRAINT PK_SUBTHEMEBOOK

drop table  SUBTHEMEBOOK;

/*==============================================================*/
/* Table: SUBTHEME                                              */
/*==============================================================*/
ALTER TABLE SUBTHEME  
DROP CONSTRAINT FK_SUBTHEME_BEGETS_THEME

ALTER TABLE SUBTHEME  
DROP CONSTRAINT PK_SUBTHEME

drop table  SUBTHEME;

/*==============================================================*/
/* Table: THEME                                                 */
/*==============================================================*/
ALTER TABLE THEME  
DROP CONSTRAINT PK_THEME

drop table  THEME;

/*==============================================================*/
/* Table: KEYWORDBOOK                                           */
/*==============================================================*/
ALTER TABLE KEYWORDBOOK  
DROP CONSTRAINT FK_KEYWORDB_FOUND2_KEYWORD

ALTER TABLE KEYWORDBOOK  
DROP CONSTRAINT FK_KEYWORDB_FOUND_BOOK

ALTER TABLE KEYWORDBOOK  
DROP CONSTRAINT PK_KEYWORDBOOK

drop table  KEYWORDBOOK;

/*==============================================================*/
/* Table: BOOK                                                  */
/*==============================================================*/
ALTER TABLE BOOK  
DROP CONSTRAINT FK_BOOK_ASSOCIATE_CODETVA

ALTER TABLE BOOK  
DROP CONSTRAINT FK_BOOK_APPEAR_EDITOR

ALTER TABLE BOOK  
DROP CONSTRAINT PK_BOOK

drop table  BOOK;

/*==============================================================*/
/* Table: KEYWORD                                               */
/*==============================================================*/
ALTER TABLE KEYWORD  
DROP CONSTRAINT PK_KEYWORD

drop table  KEYWORD;

/*==============================================================*/
/* Table: CODETVA                                             */
/*==============================================================*/
ALTER TABLE CODETVA  
DROP CONSTRAINT PK_CODETVA

drop table CODETVA;


/*==============================================================*/
/* Table: EDITOR                                                */
/*==============================================================*/
ALTER TABLE EDITOR  
DROP CONSTRAINT PK_EDITOR

drop table  EDITOR;

