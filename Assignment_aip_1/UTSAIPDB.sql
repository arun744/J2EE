


select orderlinetbl.orderID, producttbl.productid, producttbl.category, producttbl.decription, orderlinetbl.quantity, orderlinetbl.price  
from producttbl INNER JOIN orderlinetbl 
ON producttbl.productid = orderlinetbl.productid where orderlinetbl.orderid =  'ajayaraj0003'
order by producttbl.productid;