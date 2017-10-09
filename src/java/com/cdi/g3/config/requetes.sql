
--10----------- Afficher les livres achet� d'un client---------------
Declare @loginCustomer as varchar(50)
set @loginCustomer ='bob01' 

Select loginCustomer 'login', lastnameCustomer 'Name', FirstNameCustomer 'FirstName', b.NUMISBNBOOK 'book', titrebook 'titre'
From Book b
Join ORDERLINE ordl
on b.NUMISBNBOOK=ordl.NUMISBNBOOK
Join ORDERS ord
on ordl.idorder=ord.IDORDER
Join CUSTOMER cus 
on ord.LOGINCUSTOMERORDER =cus.LOGINCUSTOMER
where ord.LOGINCUSTOMERORDER= @loginCustomer
order by titrebook



--11-------------Afficher les Appreciations non mod�r�s d'un livre---------------
Declare @numisbnbook as varchar(13)
set @numisbnbook ='2811222510'

Select IdAppreciate 'Appreciation' , numisbnBook ' Isbn' , titrebook 'titre'
from book b
join APPRECIATION app
on b.NUMISBNBOOK=app.NUMISBNBOOKAPPRECIATE
where    app.moderateAPPRECIATE = 0 
         and numisbnbook=@numisbnbook




---12---------- Afficher toutes les Appreciations non mod�r�s--------------------

Select IdAppreciate 'Appreciation' , numisbnBookappreciate ' Isbn' , titrebook 'titre'
from book b
join APPRECIATION app
on b.NUMISBNBOOK=app.NUMISBNBOOKAPPRECIATE
where app.moderateAPPRECIATE = 0 

-- where LOGINEMPLOYEAPPRECIATE='' and  numisbnbookappreciate='2253092533'
 


----13------------ Afficher les commandes par Statues-------------

Select  IDORDER 'numero commande',nameInfoStatusOrder 'status' , dateOrder 'date de la commande'
From INFOSTATUS sta
Join Orders ord
On sta.NAMEINFOSTATUS = ord.NAMEINFOSTATUSORDER
Order by nameInfoStatusOrder
-- Order by IdOrder