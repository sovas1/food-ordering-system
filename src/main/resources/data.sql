delete from drinks;
delete from maincourses;
delete from deserts;
delete from lunches;

insert into drinks (ID,NAME,PRICE) values(null,'Martini',25.0);
insert into drinks (ID,NAME,PRICE) values(null,'Apple Juice',14.0);
insert into drinks (ID,NAME,PRICE) values(null,'Tomato Juice',12.5);
insert into drinks (ID,NAME,PRICE) values(null,'Water',8.5);
insert into drinks (ID,NAME,PRICE) values(null,'Wine',21.5);
insert into drinks (ID,NAME,PRICE) values(null,'Bear',18.0);

insert into maincourses (ID,NAME,PRICE)values(null,'Spaghetti',45.0);
insert into deserts (ID,NAME,PRICE) values(null,'Ice Cream',12.0);
insert into lunches (ID,NAME,CUISINE,MAINCOURSE_ID,DESERT_ID) values(null,'Special Numero Uno',2,1L,1L);

insert into maincourses (ID,NAME,PRICE) values(null,'Pierogi',35.0);
insert into deserts (ID,NAME,PRICE) values(null,'Chocolate',8.0);
insert into lunches (ID,NAME,CUISINE,MAINCOURSE_ID,DESERT_ID) values(null,'Polish ',0,2L,2L);

insert into maincourses (ID,NAME,PRICE) values(null,'Pepita con tasejo',38.0);
insert into deserts (ID,NAME,PRICE) values(null,'Tabasco Ice Cream',7.0);
insert into lunches (ID,NAME,CUISINE,MAINCOURSE_ID,DESERT_ID) values(null,'MexicanOne',1,3L,3L);

insert into maincourses (ID,NAME,PRICE)values(null,'Lasagne bolognese',28.0);
insert into deserts (ID,NAME,PRICE) values(null,'Tiramisu',12.0);
insert into lunches (ID,NAME,CUISINE,MAINCOURSE_ID,DESERT_ID) values(null,'Viva la Italia',2,4L,4L);

insert into maincourses (ID,NAME,PRICE) values(null,'Bigos',18.0);
insert into deserts (ID,NAME,PRICE) values(null,'Makowiec Cake',12.0);
insert into lunches (ID,NAME,CUISINE,MAINCOURSE_ID,DESERT_ID) values(null,'PolishTwo',0,5L,5L);

insert into maincourses (ID,NAME,PRICE) values(null,'Tacos',29.0);
insert into deserts (ID,NAME,PRICE) values(null,'Flan de Vanilla',11.0);
insert into lunches (ID,NAME,CUISINE,MAINCOURSE_ID,DESERT_ID) values(null,'MexicanTwo',1,6L,6L);
