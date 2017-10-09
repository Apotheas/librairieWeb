--Event - EventBook - DroitEmploye - Employe
----------------------------------------------------------------------------------------
----------------Creation table 
------------------------------------------------------------------------------------------

 create table EVENT 
(
   IDEVENT              char(10)                       not null,
   DATEDEBUTEVENT       date                           null,
   DATEFINEVENT         date                           null,
   NAMEEVENT            varchar(50)                    null,
   DISCOUNTEVENT        float                          null,
   
)

create table EventBook
(
 NUMISBNBOOK          varchar(13)                    not null, 
 IDEVENT              char(10)                       not null,

)

create table DROITEMPLOYE 
(
   IDDROITEMPLOYE       integer                        not null default autoincrement,
   TYPEDROITEMPLOYE     integer                        null,
)

create table EMPLOYE 
(
   LOGINEMPLOYE         varchar(50)                    not null,
   IDDROITEMPLOYE       integer                        not null,
   FIRSTNAMEEMPLOYE     varchar(50)                    null,
   LASTNAMEEMPLOYE      varchar(50)                    null,
   EMAILEMPLOYE         varchar(50)                    null,
   PASSWORDEMPLOYE      varchar(50)                    null,
   STATUSEMPLOYE        char(10)                       null,
   
)






----------------------------------------------------------------------------------------
----------------Creation PK
------------------------------------------------------------------------------------------


--PRIMARY KEY Event 
ALTER TABLE Event 
ADD CONSTRAINT IdEvent_pk 
PRIMARY KEY (IdEvent) 

--PRIMARY KEY EventBook 
ALTER TABLE EventBook 
ADD CONSTRAINT EventBook_pk 
PRIMARY KEY (NumISBNbook, IdEvent)
 
--PRIMARY KEY DroitEmploye 
ALTER TABLE DroitEmploye 
ADD CONSTRAINT IdDroitEmploye_pk 
PRIMARY KEY (IdDroitEmploye) 
 
--PRIMARY KEY Employe
ALTER TABLE Employe 
ADD CONSTRAINT loginEmploye_pk 
PRIMARY KEY (loginEmploye) 



----------------------------------------------------------------------------------------
----------------Creation FK
------------------------------------------------------------------------------------------


ALTER TABLE EventBook 
ADD CONSTRAINT EventBooknumISBNbook_fk 
FOREIGN KEY(numISBNbook) 
REFERENCES Book(numISBNbook) 
 
ALTER TABLE EventBook 
ADD CONSTRAINT EventBookidEvent_fk 
FOREIGN KEY(idEvent) 
REFERENCES Event(idEvent) 
 

ALTER TABLE Employe 
ADD CONSTRAINT EmployeIdDroitEmploye_fk 
FOREIGN KEY(IdDroitEmploye) 
REFERENCES DroitEmploye(IdDroitEmploye) 
 
 


----------------------------------------------------------------------------------------
----------------Drop table 
--------------------------------------------------------------------



Drop table Employe
Drop table DroitEmploye
Drop table EventBook
Drop table Event




----------------------------------------------------------------------------------------
----------------Drop PK
------------------------------------------------------------------------------------------


ALTER TABLE Event 
DROP CONSTRAINT IdEvent_pk 
 
ALTER TABLE EventBook
DROP CONSTRAINT EventBook_pk 
 
ALTER TABLE DroitEmploye 
DROP CONSTRAINT idDroitEmploye_pk 
 
 
ALTER TABLE Employe 
DROP CONSTRAINT loginEmploye_pk 
 




----------------------------------------------------------------------------------------
----------------Drop FK
------------------------------------------------------------------------------------------
ALTER TABLE Employe
DROP CONSTRAINT EmployeIdDroitEmploye_fk 


ALTER TABLE EventBook 
DROP CONSTRAINT EventBooknumISBNbook_fk 
 
ALTER TABLE EventBook 
DROP CONSTRAINT EventBookidEvent_fk 
 

