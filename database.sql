drop database if exists eshop;
create database eshop;

use eshop;


drop table if exists jersey;
create table jersey (
   id int,
   name varchar(50),
   team varchar(50),
   size varchar(10),
   price float,
   qty int,
   colour varchar(10));

   insert into jersey values (101, 'Giannis Antetokounmpo', 'Bucks', 'L', 119, 2, 'orange');
   insert into jersey values (102, 'Giannis Antetokounmpo', 'Bucks', 'XL', 119, 2, 'orange');
   insert into jersey values (103, 'Giannis Antetokounmpo', 'Bucks', 'XXL', 119, 1, 'orange');

   insert into jersey values (11, 'Kyrie Irving', 'Celtics', 'M', 119, 2, 'green');
   insert into jersey values (12, 'Kyrie Irving', 'Celtics', 'L', 119, 1, 'green');
   insert into jersey values (13, 'Kyrie Irving', 'Celtics', 'XL', 119, 0, 'green');

   insert into jersey values (231, 'Lebron James', 'Lakers', 'L', 129, 0, 'white');
   insert into jersey values (232, 'Lebron James', 'Lakers', 'XL', 129, 2, 'white');
   insert into jersey values (233, 'Lebron James', 'Lakers', 'XXL', 129, 1, 'white');

   insert into jersey values (51, 'Kawhi Leonard', 'Raptors', 'L', 119, 2, 'red');
   insert into jersey values (52, 'Kawhi Leonard', 'Raptors', 'XL', 119, 0, 'red');
   insert into jersey values (53, 'Kawhi Leonard', 'Raptors', 'XXL', 119, 0, 'red');

   insert into jersey values (271, 'James Harden', 'Rockets', 'L', 139, 1, 'white');
   insert into jersey values (272, 'James Harden', 'Rockets', 'XL', 139, 0, 'white');
   insert into jersey values (273, 'James Harden', 'Rockets', 'XXL', 139, 1, 'white');

   insert into jersey values (181, 'Russell Westbrook', 'Thunder', 'M', 129, 2, 'blue');
   insert into jersey values (182, 'Russell Westbrook', 'Thunder', 'L', 129, 0, 'blue');
   insert into jersey values (183, 'Russell Westbrook', 'Thunder', 'XL', 129, 1, 'blue');

   insert into jersey values (211, 'Stephen Curry', 'Warriors', 'M', 129, 0, 'black');
   insert into jersey values (212, 'Stephen Curry', 'Warriors', 'L', 129, 0, 'black');
   insert into jersey values (213, 'Stephen Curry', 'Warriors', 'XL', 129, 2, 'black');

   insert into jersey values (41, 'Ben Simmons', '76ers', 'L', 129, 2, 'white');
   insert into jersey values (42, 'Ben Simmons', '76ers', 'XL', 129, 1, 'white');
   insert into jersey values (43, 'Ben Simmons', '76ers', 'XXL', 129, 0, 'white');


   select * from jersey;



   drop table if exists sneakers;
   create table sneakers (
      id int,
      name varchar(50),
      team varchar(50),
      brand varchar(20),
      size varchar(10),
      price float,
      qty int,
      colour varchar(10));

      insert into sneakers values (1, 'Dame 5', 'Trail Blazers', 'Adidas', '8', 158, 2, 'white');
      insert into sneakers values (1, 'Dame 5', 'Trail Blazers', 'Adidas', '9', 158, 1, 'white');
      insert into sneakers values (1, 'Dame 5', 'Trail Blazers', 'Adidas',  '10', 158, 1, 'white');
      insert into sneakers values (1, 'Dame 5', 'Trail Blazers', 'Adidas',  '8', 158, 0, 'black');
      insert into sneakers values (1, 'Dame 5', 'Trail Blazers', 'Adidas',  '9', 158, 2, 'black');
      insert into sneakers values (1, 'Dame 5', 'Trail Blazers', 'Adidas',  '10', 158, 1, 'black');

      insert into sneakers values (2, 'Harden Vol.3', 'Rockets', 'Adidas',  '8', 245, 2, 'black');
      insert into sneakers values (2, 'Harden Vol.3', 'Rockets', 'Adidas',  '9', 245, 0, 'black');
      insert into sneakers values (2, 'Harden Vol.3', 'Rockets', 'Adidas',  '10', 245, 1, 'black');
      insert into sneakers values (2, 'Harden Vol.3', 'Rockets', 'Adidas',  '8', 245, 0, 'red');
      insert into sneakers values (2, 'Harden Vol.3', 'Rockets', 'Adidas',  '9', 245, 0, 'red');
      insert into sneakers values (2, 'Harden Vol.3', 'Rockets', 'Adidas',  '10', 245, 1, 'red');

      insert into sneakers values (3, 'Harden Vol.2', 'Rockets', 'Adidas',  '8', 209, 1, 'black');
      insert into sneakers values (3, 'Harden Vol.2', 'Rockets', 'Adidas',  '9', 209, 2, 'black');
      insert into sneakers values (3, 'Harden Vol.2', 'Rockets', 'Adidas',  '10', 209, 1, 'black');
      insert into sneakers values (3, 'Harden Vol.2', 'Rockets', 'Adidas',  '8', 209, 0, 'red');
      insert into sneakers values (3, 'Harden Vol.2', 'Rockets', 'Adidas',  '9', 209, 1, 'red');
      insert into sneakers values (3, 'Harden Vol.2', 'Rockets', 'Adidas',  '10', 209, 1, 'red');

      insert into sneakers values (4, 'Kobe AD NXT', 'Lakers', 'Nike', '8', 299, 1, 'white');
      insert into sneakers values (4, 'Kobe AD NXT', 'Lakers', 'Nike', '9', 299, 0, 'white');
      insert into sneakers values (4, 'Kobe AD NXT', 'Lakers', 'Nike', '10', 299, 1, 'white');
      insert into sneakers values (4, 'Kobe AD NXT', 'Lakers', 'Nike', '8', 299, 0, 'black');
      insert into sneakers values (4, 'Kobe AD NXT', 'Lakers', 'Nike', '9', 299, 0, 'black');
      insert into sneakers values (4, 'Kobe AD NXT', 'Lakers', 'Nike', '10', 299, 1, 'black');

      insert into sneakers values (5, 'KD 10', 'Warriors', 'Nike', '8', 239, 1, 'grey');
      insert into sneakers values (5, 'KD 10', 'Warriors', 'Nike', '9', 239, 2, 'grey');
      insert into sneakers values (5, 'KD 10', 'Warriors', 'Nike', '10', 239, 0, 'grey');
      insert into sneakers values (5, 'KD 10', 'Warriors', 'Nike', '8', 239, 2, 'white');
      insert into sneakers values (5, 'KD 10', 'Warriors', 'Nike', '9', 239, 1, 'white');
      insert into sneakers values (5, 'KD 10', 'Warriors', 'Nike', '10', 239, 1, 'white');

      insert into sneakers values (6, 'Jordan XXXII', 'Bulls', 'Jordan', '8', 219, 1, 'black');
      insert into sneakers values (6, 'Jordan XXXII', 'Bulls', 'Jordan', '9', 219, 1, 'black');
      insert into sneakers values (6, 'Jordan XXXII', 'Bulls', 'Jordan', '10', 219, 0, 'black');
      insert into sneakers values (6, 'Jordan XXXII', 'Bulls', 'Jordan', '8', 219, 1, 'white');
      insert into sneakers values (6, 'Jordan XXXII', 'Bulls', 'Jordan', '9', 219, 0, 'white');
      insert into sneakers values (6, 'Jordan XXXII', 'Bulls', 'Jordan', '10', 219, 0, 'white');

      insert into sneakers values (7, 'Curry 6', 'Warriors', 'Under Armour', '8', 239, 1, 'white');
      insert into sneakers values (7, 'Curry 6', 'Warriors', 'Under Armour', '9', 239, 1, 'white');
      insert into sneakers values (7, 'Curry 6', 'Warriors', 'Under Armour', '10', 239, 0, 'white');
      insert into sneakers values (7, 'Curry 6', 'Warriors', 'Under Armour', '8', 239, 0, 'grey');
      insert into sneakers values (7, 'Curry 6', 'Warriors', 'Under Armour', '9', 239, 1, 'grey');
      insert into sneakers values (7, 'Curry 6', 'Warriors', 'Under Armour', '10', 239, 0, 'grey');

      select * from sneakers;

      drop table if exists order_records;
create table order_records (
  id          int,
  qty_ordered int,
  cust_name   varchar(30),
  cust_email  varchar(30),
  cust_phone  char(8));
