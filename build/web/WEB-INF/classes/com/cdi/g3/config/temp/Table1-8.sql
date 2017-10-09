
-- CREATION DE---Editor - TVA - KeyWord - Book - KeyWord - Theme - SubTheme- 
-- SubThemeBook - keywordBook (association)

--------------------------------------------------------------------------------
--01-- Editor : ---------------------------------------------------------------- 
 create table Editor(
   IDEDITOR             integer                        not null , 
   NAMEEDITOR           char(50)                       null,
   STATUSEDITOR         integer                        null,
   
   );

--02-- CODETVA : ---------------------------------------------------------------
 create table CodeTVA (
   TYPETVA              varchar(50)                    not null,
   RATECODETVA          float(3)                       not null,

   );
 
--03-- KeyWord :---------------------------------------------------------------- 
 create table Keyword (
   IDKEYWORD            integer                        not null ,
   NAMEKEYWORD          varchar(50)                    null,
   
  );

--04-- Book :------------------------------------------------------------------- 
 create table Book (
   NUMISBNBOOK          varchar(13)                    not null,
   IDEDITOR             integer                        not null,
   TYPETVA              varchar(50)                    not null,
   TITREBOOK            varchar(50)                    null,
   SUBTITREBOOK         varchar(50)                    null,
   UNITCOSTBOOK         float		               null,
   SYNOPSISBOOK         text                           null,
   PATHICONBOOK         varchar(50)                    null,
   WEIGHTBOOK           float                          null,
   SIZELARGEBOOK        float                          null,
   SIZELONGBOOK         float                          null,
   STOCKBOOK            integer                        null,
   COMMENTBOOK          varchar(250)                   null,
   STATUSBOOK           integer                        null,

  );

--05--Theme  :------------------------------------------------------------------
 create table Theme (
   IDTHEME              integer                        not null,
   NAMETHEME            varchar(50)                    null,

   );

--06--SubTheme :----------------------------------------------------------------
 create table SubTheme (
   IDSUBTHEME           integer                        not null,
   IDTHEME              integer                        not null,
   NAMESUNTHEM          varchar(50)                    null,

);
-- TABLE ASSOCIATION -----------------------------------------------------------

--07--SubThemeBook  :----------------------------------------------------------- 
  create table SubThemeBook (
   NUMISBNBOOK          varchar(13)                    not null,
   IDSUBTHEME           integer                        not null,

   );

--08--KeywordBook :-- (BOOK - KEYWORD)------------------------------------------
create table KeywordBook (
   NUMISBNBOOK          varchar(13)                    not null,
   IDKEYWORD            integer                        not null,
   
    );
--------------------------------------------------------------------------------
----------------Creation PK 
--------------------------------------------------------------------------------
 
 --01-- Editor_PK : ------------------------------------------------------------ 
  ALTER TABLE Editor 
  ADD CONSTRAINT editor_PK
  PRIMARY KEY (idEditor)
  
--02-- CODETVA_PK : ------------------------------------------------------------
  ALTER TABLE CODETVA 
  ADD CONSTRAINT typeTVA_PK 
  PRIMARY KEY (typeTVA)
 
--03-- KeyWord_PK :-------------------------------------------------------------
  ALTER TABLE KEYWORD 
  ADD CONSTRAINT idKeyword_PK
  PRIMARY KEY (idKeyword)

--04-- Book_PK :---------------------------------------------------------------- 
  ALTER TABLE BOOK 
  ADD CONSTRAINT numISBNBook_PK 
  PRIMARY KEY (numISBNBook)  
 
--05--Theme_PK  :---------------------------------------------------------------
  ALTER TABLE THEME 
  ADD CONSTRAINT idTheme_PK 
  PRIMARY KEY (idTheme)

--06--SubTheme_PK :-------------------------------------------------------------
  ALTER TABLE SUBTHEME
  ADD CONSTRAINT idSubTheme_Pk
  PRIMARY KEY  (idSubTheme)

--07--SubThemeBook_PK  :-- (BOOK - SUBTHEME)------------------------------------
  ALTER TABLE SubThemeBook
  ADD constraint SubThemeBook_pk
  primary key (NUMISBNBOOK, IDSUBTHEME)

--08--KeywordBook  :-- (BOOK - KEYWORD)-----------------------------------------
 ALTER TABLE KeywordBook 
 ADD CONSTRAINT KeywordBook_PK 
 primary key (NUMISBNBOOK, IDKEYWORD)

--------------------------------------------------------------------------------
----------------Creation FK 
--------------------------------------------------------------------------------
 
  --01-- EditorBook_FK : -------------------------------------------------------
  ALTER TABLE Book 
  ADD CONSTRAINT EditorBook_FK
  FOREIGN KEY (idEditor)
  REFERENCES Editor(idEditor)
  
--02-- BookCodeTva_FK : --------------------------------------------------------
  ALTER TABLE Book 
  ADD CONSTRAINT BooktypeTva_FK
  FOREIGN KEY (typeTVA)
  REFERENCES codetva(typeTVA)

 --03-- ThemeSubtheme_FK : -----------------------------------------------------
  ALTER TABLE Subtheme 
  ADD CONSTRAINT ThemeSubtheme_FK
  FOREIGN KEY (idTheme)
  REFERENCES theme(idTheme) 

--04-- SubThemeBook_FK : -----------------------------------------------------
  ALTER TABLE SubThemeBook 
  ADD CONSTRAINT BookSubThemeBook_FK
  FOREIGN KEY (NUMISBNBOOK)
  REFERENCES Book(NUMISBNBOOK) 

ALTER TABLE SubThemeBook 
  ADD CONSTRAINT SubThemeBookSUBTHEME_FK
  FOREIGN KEY (IDSUBTHEME)
  REFERENCES SUBTHEME(IDSUBTHEME) 


--05-- KeywordBook_FK : -----------------------------------------------------
  ALTER TABLE KeywordBook 
  ADD CONSTRAINT BookKeywordBook_FK
  FOREIGN KEY (NUMISBNBOOK)
  REFERENCES Book(NUMISBNBOOK) 

ALTER TABLE KeywordBook 
  ADD CONSTRAINT KEYWORDBookKeyword_FK
  FOREIGN KEY (IDKEYWORD)
  REFERENCES KEYWORD(IDKEYWORD) 


--------------------------------------------------------------------------------
----------------Drop table  
--------------------------------------------------------------------------------
--01-- Editor_PK : ------------------------------------------------------------- 
 Drop Table Editor
 Drop Table CodeTVA
 Drop Table KeyWord
 Drop Table Book
 Drop Table Theme
 Drop Table SubTheme
 Drop Table SubThemeBook
 Drop Table KeywordBook

-------------------------------------------------------------------------------- 
----------------Drop PK 
--------------------------------------------------------------------------------
  

--01-- Editor_PK : ------------------------------------------------------------- 
  ALTER TABLE Editor 
  DROP editor_PK

--02-- CODETVA_PK : ------------------------------------------------------------
  ALTER TABLE CODETVA 
  DROP typeTVA_PK 
  
--03-- KeyWord_PK :------------------------------------------------------------- 

  ALTER TABLE KEYWORD 
  DROP idKeyword_PK

--04-- Book_PK :----------------------------------------------------------------
  ALTER TABLE BOOK 
  DROP numISBNBook_PK 

--05--Theme_PK  :---------------------------------------------------------------
  ALTER TABLE Theme
  DROP idTheme_PK 

--06--SubTheme_PK :-------------------------------------------------------------
  ALTER TABLE SUBTHEME
  DROP idSubTheme_Pk

--07--SubThemeBook_PK  :-- (BOOK - SUBTHEME)------------------------------------
  ALTER TABLE SubThemeBook
  DROP SubThemeBook_pk

--08--KeywordBook  :-- (BOOK - KEYWORD)-----------------------------------------
  ALTER TABLE KeywordBook 
  DROP KeywordBook_PK 

-------------------------------------------------------------------------------- 
----------------Drop FK 
--------------------------------------------------------------------------------
---Editor - TVA - KeyWord - Book - KeyWord - Theme - SubTheme- 
-- SubThemeBook - keywordBook (association)

--01-- keywordBook_FK : ---------------------------------------------------------
 ALTER TABLE keywordBook
DROP KEYWORDBookKeyword_FK

ALTER TABLE keywordBook
DROP BookKeywordBook_FK

--02-- SubThemeBook_FK : ---------------------------------------------------------
ALTER TABLE SubThemeBook
DROP SubThemeBookSUBTHEME_FK

ALTER TABLE SubThemeBook
DROP BookSubThemeBook_FK

--03-- Subtheme_FK : -----------------------------------------------------
ALTER TABLE Subtheme 
DROP ThemeSubtheme_FK

--04-- Book_FK : -----------------------------------------------------
ALTER TABLE Book 
DROP EditorBook_FK

ALTER TABLE Book 
DROP BooktypeTva_FK

 





--------------------------------------------------------------------------------
--------------------------------------------------------------------------------
------------------------------FIN 1-8 ------------------------------------------