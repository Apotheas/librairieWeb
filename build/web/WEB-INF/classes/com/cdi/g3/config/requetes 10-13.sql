------------- Afficher les livres acheté d'un client---------------

Select loginCustomer 'login', lastnameCustomer 'Name', FirstNameCustomer 'FirstName', b.NUMISBNBOOK 'book', titrebook 'titre'
From Book b
Join ORDERLINE ordl
on b.NUMISBNBOOK=ordl.NUMISBNBOOK
Join ORDERS ord
on ordl.idorder=ord.IDORDER
Join CUSTOMER cus
on ord.LOGINCUSTOMERORDER=cus.LOGINCUSTOMER


order by LOGINCUSTOMER







---------------Afficher les Appreciations non modérés d'un livre---------------


Select IdAppreciate 'Appreciation' , numisbnBookappreciate ' Isbn' , titrebook 'titre'
from book b
join APPRECIATION app
on b.NUMISBNBOOK=app.NUMISBNBOOKAPPRECIATE
join Employe emp
on app.LOGINEMPLOYEAPPRECIATE=emp.LOGINEMPLOYE

where LOGINEMPLOYEAPPRECIATE='' 





------------- Afficher toutes les Appreciations non modérés--------------------

Select IdAppreciate 'Appreciation' , numisbnBookappreciate ' Isbn' , titrebook 'titre'
from book b
join APPRECIATION app
on b.NUMISBNBOOK=app.NUMISBNBOOKAPPRECIATE
join Employe emp
on app.LOGINEMPLOYEAPPRECIATE=emp.LOGINEMPLOYE

where LOGINEMPLOYEAPPRECIATE='' and  numisbnbookappreciate='2253092533'
 





---------------- Afficher les commandes par Statues-------------


Select  IDORDER 'numero commande',nameInfoStatusOrder 'status' , dateOrder 'date de la commande'
From INFOSTATUS sta
Join Orders ord
On sta.NAMEINFOSTATUS = ord.NAMEINFOSTATUSORDER



Order by IdOrder