Use librairieDB
go

---- Ce trigger se declenche lors d'une insertion ou d'une mise � jour
---- dans la table Appreciation

CREATE TRIGGER insertionAppreciation
ON APPRECIATION 
INSTEAD  OF INSERT
--FOR INSERT,UPDATE 
AS


DECLARE 
@orderLine AS INT,
@appreciation AS INT,
@ErrComment AS Varchar(255),
@ErrBuy AS Varchar(255)
--set @NUMISBNBOOK1 ='2253092533'
--set  @logincustomer='Bob01'


set  @appreciation= (	select COUNT(*) 	
				From  APPRECIATION app
                                join book bok 
                                on app.NUMISBNBOOKAPPRECIATE =   bok.NUMISBNBOOK
                                join CUSTOMER cus
                                on app.LOGINCUSTOMERAPPRECIATE  = cus.logincustomer
								join inserted
				on	app.NUMISBNBOOKAPPRECIATE =inserted.NUMISBNBOOKAPPRECIATE
				and	app.LOGINCUSTOMERAPPRECIATE = inserted.LOGINCUSTOMERAPPRECIATE )
 
 
 set  @orderLine= (	select COUNT(*) 		
				From ORDERLINE ordl
                                join ORDERS ord
                                on ordl.IDORDER  = ord.IDORDER
                                join CUSTOMER cus
                                on ord.LOGINCUSTOMERORDER = cus.logincustomer
								join inserted
				on  ordl.NUMISBNBOOK =inserted.NUMISBNBOOKAPPRECIATE
				and    ord.LOGINCUSTOMERORDER = inserted.LOGINCUSTOMERAPPRECIATE )

IF @appreciation <> 0
	BEGIN
	SET @ErrComment = 'ERROR, le livre est d�j� comment�.' 
    RAISERROR (@ErrComment, 16, 1)
	rollback		
	END

ELSE IF @orderLine = 0
		BEGIN
		SET @ErrBuy = 'ERROR, le livre devrait �tre acheter pour �tre comment�.'
        RAISERROR (@ErrBuy, 16, 1)	
		rollback		
		END
	else
	BEGIN
	INSERT INTO Appreciation SELECT * FROM INSERTED
	END
