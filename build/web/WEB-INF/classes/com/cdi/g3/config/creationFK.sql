
USE librairieDB
Go


/*==============================================================*/
/* Table: EDITOR                                                */
/*==============================================================*/


/*==============================================================*/
/* Table: CODETVA                                             */
/*==============================================================*/



/*==============================================================*/
/* Table: KEYWORD                                               */
/*==============================================================*/


/*==============================================================*/
/* Table: BOOK                                                  */
/*==============================================================*/
alter table BOOK
   add constraint FK_BOOK_APPEAR_EDITOR foreign key (IDEDITORBOOK)
      references EDITOR (IDEDITOR)
      on update Cascade
      on delete Cascade;

alter table BOOK
   add constraint FK_BOOK_ASSOCIATE_CODETVA foreign key (TYPETVABOOK)
      references CODETVA (TYPETVA)
      on update Cascade
      on delete Cascade;

/*==============================================================*/
/* Table: KEYWORDBOOK                                           */
/*==============================================================*/
alter table KEYWORDBOOK
   add constraint FK_KEYWORDB_FOUND_BOOK foreign key (NUMISBNBOOKKB)
      references BOOK (NUMISBNBOOK)
      on update Cascade
      on delete Cascade;

alter table KEYWORDBOOK
   add constraint FK_KEYWORDB_FOUND2_KEYWORD foreign key (NAMEKEYWORDKB)
      references KEYWORD (NAMEKEYWORD)
      on update Cascade
      on delete Cascade;

/*==============================================================*/
/* Table: THEME                                                 */
/*==============================================================*/



/*==============================================================*/
/* Table: SUBTHEME                                              */
/*==============================================================*/
alter table SUBTHEME
   add constraint FK_SUBTHEME_BEGETS_THEME foreign key (NAMETHEMESB)
      references THEME (NAMETHEME)
      on update Cascade
      on delete Cascade;

/*==============================================================*/
/* Table: SUBTHEMEBOOK                                          */
/*==============================================================*/
alter table SUBTHEMEBOOK
   add constraint FK_SUBTHEME_BELONG_BOOK foreign key (NUMISBNBOOKSB)
      references BOOK (NUMISBNBOOK)
      on update Cascade
      on delete Cascade;

alter table SUBTHEMEBOOK
   add constraint FK_SUBTHEME_BELONG2_SUBTHEME foreign key (IDSUBTHEMESB)
      references SUBTHEME (IDSUBTHEME)
      on update Cascade
      on delete Cascade;
/*==============================================================*/
/* Table: OCCATION                                                 */
/*==============================================================*/



/*==============================================================*/
/* Table: OCCASIONBOOK                                             */
/*==============================================================*/
alter table OCCASIONBOOK
   add constraint FK_OCCASIONBOOK_PARTICIPA_BOOK foreign key (NUMISBNBOOKOB)
      references BOOK (NUMISBNBOOK)
      on update Cascade
      on delete Cascade;

alter table OCCASIONBOOK
   add constraint FK_OCCASIONBOOK_PARTICIPA_OCCASION foreign key (NAMEOCCASIONOB)
      references OCCASION (NAMEOCCASION)
      on update Cascade
      on delete Cascade;

/*==============================================================*/
/* Table: EMPLOYERIGHT                                          */
/*==============================================================*/



/*==============================================================*/
/* Table: EMPLOYE                                               */
/*==============================================================*/
alter table EMPLOYE
   add constraint FK_EMPLOYE_OWN_RIGHTEMP foreign key (IDEMPLOYERIGHTEMP)
      references EMPLOYERIGHT (IDEMPLOYERIGHT)
      on update Cascade
      on delete Cascade;

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/

/*==============================================================*/
/* Table: AUTHOR                                                */
/*==============================================================*/

/*==============================================================*/
/* Table: AUTHORBOOK                                            */
/*==============================================================*/
alter table AUTHORBOOK
   add constraint FK_AUTHORBO_WRITE_BOOK foreign key (NUMISBNBOOKAB)
      references BOOK (NUMISBNBOOK)
      on update Cascade
      on delete Cascade;

alter table AUTHORBOOK
   add constraint FK_AUTHORBO_WRITE2_AUTHOR foreign key (IDAUTHORAB)
      references AUTHOR (IDAUTHOR)
      on update Cascade
      on delete Cascade;

/*==============================================================*/
/* Table: SHIPPER                                               */
/*==============================================================*/


/*==============================================================*/
/* Table: INFOSTATUS                                                */
/*==============================================================*/


/*==============================================================*/
/* Table: COMPANY                                               */
/*==============================================================*/


/*==============================================================*/
/* Table: INFOCOMPANY                                           */
/*==============================================================*/
--alter table INFOCOMPANY
--   add constraint FK_INFOCOMP_PRECISE_COMPANY foreign key (SIRETCOMPANY)
--      references COMPANY (SIRETCOMPANY)
--      on update Cascade
--      on delete Cascade;

/*==============================================================*/
/* Table: PACKAGESHIPPER                                        */
/*==============================================================*/
alter table PACKAGESHIPPER
   add constraint FK_PACKAGES_APPLICATE_SHIPPER foreign key (NAMESHIPPER)
      references SHIPPER (NAMESHIPPER)
      on update Cascade
      on delete Cascade;

/*==============================================================*/
/* Table: ADRESS                                                */
/*==============================================================*/
alter table ADRESS
   add constraint FK_ADRESS_DEFAULTBI_CUSTOMER foreign key (LOGINCUSTOMERBILLADRESS)
      references CUSTOMER (LOGINCUSTOMER)
      on update Cascade
      on delete Cascade;

alter table ADRESS
   add constraint FK_ADRESS_DEFAULTSH_CUSTOMER foreign key (LOGINCUSTOMERSHIPADRESS)
      references CUSTOMER (LOGINCUSTOMER)
      on update no action
      on delete no action;

--alter table ADRESS
--   add constraint FK_ADRESS_HAVE_COMPANY foreign key (SIRETCOMPANYADRESS)
--      references COMPANY (SIRETCOMPANY)
--      on update Cascade
--      on delete Cascade;

/*==============================================================*/
/* Table: "ORDERS"                                               */
/*==============================================================*/
alter table "ORDERS"
   add constraint FK_ORDER_BILL_ADRESS foreign key (IDADRESSSHIPPINGORDER)
      references ADRESS (IDADRESS)
      on update Cascade
      on delete Cascade;

alter table "ORDERS"
   add constraint FK_ORDER_BUY_CUSTOMER foreign key (LOGINCUSTOMERORDER)
      references CUSTOMER (LOGINCUSTOMER)
      on update no action 
      on delete no action;

alter table "ORDERS"
   add constraint FK_ORDER_SHIP_ADRESS foreign key (IDADRESSBILLINGORDER)
      references ADRESS (IDADRESS)
      on update no action 
      on delete no action;

alter table "ORDERS"
   add constraint FK_ORDER_SHIPPED_PACKAGES foreign key (IDPACKAGESHIPPERORDER)
      references PACKAGESHIPPER (IDPACKAGESHIPPER)
      on update Cascade
      on delete Cascade;

alter table "ORDERS"
   add constraint FK_ORDER_STATUATE_INFOSTATUS foreign key (NAMEINFOSTATUSORDER)
      references INFOSTATUS (NAMEINFOSTATUS)
      on update Cascade
      on delete Cascade;

/*==============================================================*/
/* Table: ORDERLINE                                             */
/*==============================================================*/
alter table ORDERLINE
   add constraint FK_ORDERLIN_PUT_ORDER foreign key (IDORDER)
      references "ORDERS" (IDORDER)
      on update Cascade
      on delete Cascade;

alter table ORDERLINE
   add constraint FK_ORDERLIN_RECUPERAT_APPRECIA foreign key (IDAPPRECIATE)
      references APPRECIATION (IDAPPRECIATE)
      on update Cascade
      on delete Cascade;

alter table ORDERLINE
   add constraint FK_ORDERLIN_REPRESENT_BOOK foreign key (NUMISBNBOOK)
      references BOOK (NUMISBNBOOK)
      on update Cascade
      on delete Cascade;

/*==============================================================*/
/* Table: APPRECIATION                                          */
/*==============================================================*/

alter table APPRECIATION
   add constraint FK_APPRECIA_APPRECIAT_CUSTOMER foreign key (LOGINCUSTOMERAPPRECIATE)
      references CUSTOMER (LOGINCUSTOMER)
      on update no action 
      on delete no action;

alter table APPRECIATION
   add constraint FK_APPRECIA_BEAPPRECI_BOOK foreign key (NUMISBNBOOKAPPRECIATE)
      references BOOK (NUMISBNBOOK)
      on update no action 
      on delete no action;

alter table APPRECIATION
   add constraint FK_APPRECIA_MODERATE_EMPLOYE foreign key (LOGINEMPLOYEAPPRECIATE)
      references EMPLOYE (LOGINEMPLOYE)
      on update Cascade
      on delete Cascade;

alter table APPRECIATION
   add constraint FK_APPRECIA_RECUPERAT_ORDERLIN foreign key (IDORDERLINEAPPRECIATE)
      references ORDERLINE (IDORDERLINE)
      on update no action 
      on delete no action;



	  