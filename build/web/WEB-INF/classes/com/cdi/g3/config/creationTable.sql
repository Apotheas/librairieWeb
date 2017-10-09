drop database librairieDB
USE librairieDB
Go



/*==============================================================*/
/* Table: EDITOR                                                */
/*==============================================================*/
create table EDITOR 
(
   IDEDITOR             varchar(10)                    not null ,
   NAMEEDITOR           varchar(50)                    not null,
   STATUSEDITOR         integer                        null,
   constraint PK_EDITOR primary key (IDEDITOR)
);

/*==============================================================*/
/* Table: CODETVA                                             */
/*==============================================================*/
create table CODETVA 
(
   TYPETVA              varchar(50)                    not null,
   RATECODETVA          float(3)                       not null,
   constraint PK_CODETVA primary key (TYPETVA)
);
/*==============================================================*/
/* Table: KEYWORD                                               */
/*==============================================================*/
create table KEYWORD 
(
   NAMEKEYWORD          varchar(50)                    not null,
   constraint PK_KEYWORD primary key (NAMEKEYWORD)
);

/*==============================================================*/
/* Table: BOOK                                                  */
/*==============================================================*/
create table BOOK 
(
   NUMISBNBOOK          varchar(13)                    not null,
   IDEDITORBOOK         varchar(10)                    not null,
   TYPETVABOOK          varchar(50)                    not null,
   TITREBOOK            varchar(50)                    not null,
   UNITCOSTBOOK         float                          not null,
   STOCKBOOK            integer                        not null,
   STATUSBOOK           integer                        not null,
   SUBTITREBOOK         varchar(50)                    null,   
   SYNOPSISBOOK         varchar(Max)                   null,
   PATHICONBOOK         varchar(100)                   null,
   WEIGHTBOOK           float                          null,
   SIZELARGEBOOK        float                          null,
   SIZELONGBOOK         float                          null,   
   COMMENTBOOK          varchar(Max)                   null,
   
   constraint PK_BOOK primary key (NUMISBNBOOK)
);

/*==============================================================*/
/* Table: KEYWORDBOOK                                           */
/*==============================================================*/
create table KEYWORDBOOK 
(
   IDKEYWORDBOOK        varchar(10)                    not null,
   NUMISBNBOOKKB          varchar(13)                    not null,
   NAMEKEYWORDKB          varchar(50)                    not null,
   constraint PK_KEYWORDBOOK primary key clustered (IDKEYWORDBOOK)
);
/*==============================================================*/
/* Table: THEME                                                 */
/*==============================================================*/
create table THEME 
(
   NAMETHEME            varchar(50)                    not null,
   constraint PK_THEME primary key (NAMETHEME)
);


/*==============================================================*/
/* Table: SUBTHEME                                              */
/*==============================================================*/
create table SUBTHEME 
(  IDSUBTHEME			varchar(10)            not null,
   NAMESUBTHEME         varchar(50)                    not null,
   NAMETHEMESB            varchar(50)                    not null,
   constraint PK_SUBTHEME primary key (IDSUBTHEME)
);

/*==============================================================*/
/* Table: SUBTHEMEBOOK                                          */
/*==============================================================*/
create table SUBTHEMEBOOK 
(
   IDSUBTHEMEBOOK       varchar(10)                    not null,
   NUMISBNBOOKSB          varchar(13)                    not null,
   IDSUBTHEMESB			varchar(10)            not null,
   constraint PK_SUBTHEMEBOOK primary key clustered (IDSUBTHEMEBOOK)
);
/*==============================================================*/
/* Table: OCCASION                                               */
/*==============================================================*/
create table OCCASION 
(
   NAMEOCCASION           varchar(50)                    not null,
   DATEDEBUTOCCASION      date                           not null,
   DATEFINOCCASION        date                           not null,  
   DISCOUNTOCCASION       float                          null,
   constraint PK_OCCASION primary key (NAMEOCCASION)
);
/*==============================================================*/
/* Table: EVENTBOOK                                             */
/*==============================================================*/
create table OCCASIONBOOK 
(
   IDOCCASIONBOOK           varchar(10)                    not null,
   NUMISBNBOOKOB              varchar(13)                    not null,
   NAMEOCCASIONOB            varchar(50)                     not null,
   constraint PK_OCCASIONBOOK primary key clustered (IDOCCASIONBOOK)
);

/*==============================================================*/
/* Table: EMPLOYERIGHT                                         */
/*==============================================================*/
create table EMPLOYERIGHT 
(
   IDEMPLOYERIGHT       varchar(10)                    not null ,
   TYPEEMPLOYERIGHT     integer                        not null,
   constraint PK_EMPLOYERIGHT primary key (IDEMPLOYERIGHT)
);
/*==============================================================*/
/* Table: EMPLOYE                                               */
/*==============================================================*/
create table EMPLOYE 
(
   LOGINEMPLOYE         varchar(50)                    not null,
   IDEMPLOYERIGHTEMP       varchar(10)                    not null,
   FIRSTNAMEEMPLOYE     varchar(50)                    null,
   LASTNAMEEMPLOYE      varchar(50)                    not null,
   EMAILEMPLOYE         varchar(50)                    not null,
   PASSWORDEMPLOYE      varchar(50)                    not null,
   STATUSEMPLOYE        varchar(50)                     null,
   constraint PK_EMPLOYE primary key (LOGINEMPLOYE)
);


/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
create table CUSTOMER 
(
   LOGINCUSTOMER        varchar(50)                    not null,
   LASTNAMECUSTOMER     varchar(50)                    not null,
   FIRSTNAMECUSTOMER    varchar(50)                    not null,
   EMAILCUSTOMER        varchar(50)                    not null,
   PASSWORDCUSTOMER     varchar(50)                    not null,
   NAMECOMPANYCUSTOMER  varchar(50)                    null,
   COMMENTCUSTOMER      varchar(250)                   null,
   STATUSCUSTOMER       integer                        null,
   constraint PK_CUSTOMER primary key (LOGINCUSTOMER)
);

/*==============================================================*/
/* Table: AUTHOR                                                */
/*==============================================================*/
create table AUTHOR 
(
   IDAUTHOR             varchar(10)                    not null,
   LASTNAMEAUTHOR       varchar(50)                    not null,
   FIRSTNAMEAUTHOR      varchar(50)                    null,   
   BIOGRAPHYAUTHOR      varchar(250)                   null,
   BIRTHDATEAUTHOR      date                           null,
   DIEDATEAUTHOR        date                           null,
   COMMENTAUTHOR        varchar(250)                   null,
   constraint PK_AUTHOR primary key (IDAUTHOR)
);

/*==============================================================*/
/* Table: AUTHORBOOK                                            */
/*==============================================================*/
create table AUTHORBOOK 
(
   IDAUTHORBOOK         varchar(10)                       not null,
   NUMISBNBOOKAB          varchar(13)                       not null,
   IDAUTHORAB             varchar(10)                       not null,
   constraint PK_AUTHORBOOK primary key clustered (IDAUTHORBOOK)
);

/*==============================================================*/
/* Table: SHIPPER                                               */
/*==============================================================*/
create table SHIPPER 
(
   NAMESHIPPER          varchar(50)                    not null,
   COMMENTSHIPPER       varchar(250)                   null,
   constraint PK_SHIPPER primary key (NAMESHIPPER)
);

/*==============================================================*/
/* Table: INFOSTATUS                                                */
/*==============================================================*/
create table INFOSTATUS 
(
   NAMEINFOSTATUS           varchar(50)                    not null,
   VALUEINFOSTATUS          integer                        not null,
   constraint PK_INFOSTATUS primary key (NAMEINFOSTATUS)
);

/*==============================================================*/
/* Table: COMPANY                                               */
/*==============================================================*/
create table COMPANY 
(
   SIRETCOMPANY         varchar(14)                    not null,
   NAMECOMPANY          varchar(50)                    not null,
   LOGOCOMPANY          varchar(100)                   not null,
   TELEPHONECOMPANY     varchar(12)                    null,
   FAXCOMPANY           varchar(12)                    null,
   MAILCOMPANY          varchar(30)                    null,
   constraint PK_COMPANY primary key (SIRETCOMPANY)
);

/*==============================================================*/
/* Table: INFOCOMPANY                                           */
/*==============================================================*/
create table INFOCOMPANY 
(  
   nameINFOCOMPANY          varchar(50)                    not null,
   DESCRIPTIONINFOCOMPANY   varchar(250)                   not null,
   constraint PK_INFOCOMPANY primary key (nameINFOCOMPANY)
); 

/*==============================================================*/
/* Table: PACKAGESHIPPER                                        */
/*==============================================================*/
create table PACKAGESHIPPER 
(
   IDPACKAGESHIPPER     varchar(10)                    not null ,
   NAMESHIPPER          varchar(50)                    not null,
   COSTPACKAGESHIPPER   float                          null,
   constraint PK_PACKAGESHIPPER primary key (IDPACKAGESHIPPER)
);

/*==============================================================*/
/* Table: ADRESS                                                */
/*==============================================================*/
create table ADRESS 
(
   IDADRESS                 varchar(10)                    not null ,   
   LOGINCUSTOMERSHIPADRESS  varchar(50)                    null,
   LOGINCUSTOMERBILLADRESS  varchar(50)                    null,
   NAMERECEIVERADRESS       varchar(50)                    not null,
   TYPESTREETADRESS         varchar(30)                    null,
   NUMADRESS                varchar(10)                    not null,
   NAMESTREETADRESS         varchar(50)                    not null,
   NAMESTEET2ADRESS         varchar (50)                   null,
   ZIPCODEADRESS            varchar(5)                     not null,
   CITYADRESS               varchar(40)                    not null,
   COUNTRYADRESS            varchar(50)                    not null,
   NAMECOMPANYRECEIVERADRESS varchar(50)                   null,
   constraint PK_ADRESS primary key (IDADRESS)
);

/*==============================================================*/
/* Table: "ORDERS"                                               */
/*==============================================================*/
create table "ORDERS" 
(
   IDORDER                  varchar(10)                    not null,   
   IDADRESSSHIPPINGORDER    varchar(10)                    not null,
   LOGINCUSTOMERORDER       varchar(50)                    not null,
   DATEORDER                date                           not null,
   NAMEINFOSTATUSORDER      varchar(50)                    not null,
   IDADRESSBILLINGORDER     varchar(10)                    null,
   IDPACKAGESHIPPERORDER    varchar(10)                    null,
   INTERNALNUMORDER         varchar(10)                    not null,   
   PAYMENTSYSTEMORDER       varchar(50)                    not null,
   IPORDER                  varchar(45)                    not null,
   DATEPACKAGESHIPPERORDER  date                           null,
   constraint PK_ORDER primary key (IDORDER)
);
/*==============================================================*/
/* Table: ORDERLINE                                             */
/*==============================================================*/
create table ORDERLINE 
(
    IDORDERLINE          varchar(10)                    not null,
    QUANTITYORDERLINE    smallint                       not null,
    UNITCOSTORDERLINE    float                          not null,
    IDORDER              varchar(10)                    null,
    NUMISBNBOOK          varchar(13)                    not null,
    DISCOUNTORDERLINE    float                          null,  
    RATETVAORDERLINE     float                          not null,
    IDAPPRECIATE         varchar(10)                    null,
   constraint PK_ORDERLINE primary key (IDORDERLINE)
);

/*==============================================================*/
/* Table: APPRECIATION                                          */
/*==============================================================*/
create table APPRECIATION 
(
   IDAPPRECIATE         varchar(10)                     not null ,
   LOGINCUSTOMERAPPRECIATE varchar(50)                  not null,
   IDORDERLINEAPPRECIATE varchar(10)                    not null,
   NUMISBNBOOKAPPRECIATE varchar(13)                    not null,
   DATEAPPRECIATE       date                            not null,
   IPAPPRECIATE         varchar(45)                     not null,
   COMMENTAPPRECIATE    varchar(500)                    null,
   RATINGAPPRECIATE     smallint                        null,
   
   LOGINEMPLOYEAPPRECIATE varchar(50)                   null,
   moderateAPPRECIATE	bit				null,
   DATEmoderateAPPRECIATE		date		null,
   STATUSAPPRECIATE        integer                        null
   constraint PK_APPRECIATION primary key (IDAPPRECIATE)
);


CREATE TABLE COUNTER( name VARCHAR(30), PRIMARY KEY(name), value INTEGER NOT NULL);

