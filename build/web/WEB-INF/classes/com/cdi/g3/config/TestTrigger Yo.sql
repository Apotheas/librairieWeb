  
use librairieDB
go

 -- commenté un livre qu'il a déjà un commentaire
  insert into Appreciation ( IDAPPRECIATE,
						LOGINEMPLOYEAPPRECIATE,
							 LOGINCUSTOMERAPPRECIATE,
								IDORDERLINEAPPRECIATE,
									NUMISBNBOOKAPPRECIATE,
										 COMMENTAPPRECIATE,
											 RATINGAPPRECIATE,
												DATEAPPRECIATE,												
													IPAPPRECIATE,
														moderateAPPRECIATE,
															DATEmoderateAPPRECIATE)
 values ( '9', null, 'Bob01','9','2330081545','goooood',
				null,'2017-01-11','5.135.158.101',NULL,NULL)

select * from Appreciation


 -- commenté un livre qu'il n'est pas encore acheté
insert into Appreciation ( IDAPPRECIATE,
						LOGINEMPLOYEAPPRECIATE,
							 LOGINCUSTOMERAPPRECIATE,
								IDORDERLINEAPPRECIATE,
									NUMISBNBOOKAPPRECIATE,
										 COMMENTAPPRECIATE,
											 RATINGAPPRECIATE,
												DATEAPPRECIATE,												
													IPAPPRECIATE,
														moderateAPPRECIATE,
															DATEmoderateAPPRECIATE)
 values ( '9', null, 'Bob01','4','2811222510','goooood',
				null,'2017-01-11','5.135.158.101',NULL,NULL)

select * from Appreciation


-- commenté un livre qu'il est acheté et il n'a pas de commentaire
insert into Appreciation ( IDAPPRECIATE,
						LOGINEMPLOYEAPPRECIATE,
							 LOGINCUSTOMERAPPRECIATE,
								IDORDERLINEAPPRECIATE,
									NUMISBNBOOKAPPRECIATE,
										 COMMENTAPPRECIATE,
											 RATINGAPPRECIATE,
												DATEAPPRECIATE,												
													IPAPPRECIATE,
														moderateAPPRECIATE,
															DATEmoderateAPPRECIATE)
 values ( '9', null, 'Bob01','2','2290147001','goooood',
				null,'2017-01-11','5.135.158.101',NULL,NULL)


select * from Appreciation




