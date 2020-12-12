CREATE DATABASE MLP211;
CREATE USER 'MLP211'@'localhost' IDENTIFIED BY 'MLP211';
GRANT ALL ON MLP211.* TO 'MLP211'@'localhost';
-- using the Database
use MLP211;

-- Creating Menu table 


CREATE TABLE CUSTOMER(
CUSTOMER_ID INT AUTO_INCREMENT,
CUSTOMER_NAME VARCHAR(50),
CUSTOMER_WALLET_AMT DOUBLE,
CUSTOMER_DOB DATE,
CUSTOMER_PHONE1 VARCHAR(15),
CUSTOMER_PHONE2 VARCHAR(15),
customer_email varchar(30),
CONSTRAINT PK_CUSTOMER PRIMARY KEY(CUSTOMER_ID)
);
-------------------------------------------------------------

show tables;
select * from customer;

-------------------------------------------------------------
CREATE TABLE VENDOR(
VENDOR_ID INT AUTO_INCREMENT,
VENDOR_NAME VARCHAR(50),
VENDOR_PHONE1 VARCHAR(15),
VENDOR_PHONE2 VARCHAR(15),
VENDOR_ADDRESS VARCHAR(150),
VENDOR_CONTACTPERSON VARCHAR(50),
VENDOR_EMAIL VARCHAR(20),
VENDOR_RATING INT,
vendor_rating_count int,
CONSTRAINT PK_VENDOR PRIMARY KEY(VENDOR_ID),
CONSTRAINT VENDOR_EMAIL_UNQ UNIQUE(VENDOR_EMAIL)
);
-------------------------------------------------------------

alter table customer drop index CUSTOMER_PH_UNQ1;
alter table customer drop index CUSTOMER_PH_UNQ2;

alter table vendor modify vendor_phone1 varchar(15);
alter table vendor modify vendor_phone2 varchar(15);

alter table vendor add VENODOR_RATING_COUNT int;
desc vendor;

show tables;

SHOW TABLES;
ALTER TABLE VENDOR ADD vendor_rating INT; 
ALTER TABLE VENDOR DROP COLUMN VENDOR_RATING;
select * from vendor;
desc vendor;

-------------------------------------------------------------
CREATE TABLE ORDERS(
ORDERS_ID INT AUTO_INCREMENT,
ORDERS_DATE DATE,
ORDERS_STATUS ENUM('ACCEPTED', 'CANCELLED', 'DELIVERED','PENDING'),
CUSTOMER_ID INT ,
VENDOR_ID INT ,
ORDERS_ESTIMATED_TIME DATE,
ORDERS_DELIVERY_TIME DATE,
ORDERS_AMOUNT DOUBLE,
CONSTRAINT PK_ORDERS PRIMARY KEY(ORDERS_ID),
CONSTRAINT FK_CUST_ORDERS FOREIGN KEY(CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID),
CONSTRAINT FK_VNDR_ORDERS FOREIGN KEY(VENDOR_ID) REFERENCES VENDOR(VENDOR_ID)
);
-------------------------------------------------------------

ALTER table orders modify orders_estimated_time date;
ALTER table orders modify orders_delivery_time date;
desc orders;
UPDATE ORDERS SET ORDERS_STATUS ='PENDING';
alter table orders drop orders_status;
alter table orders add orders_status enum('ACCEPTED', 'CANCELLED','DELIVERED','PENDING');

select * from ORDERS;
delete from ORDERS;
select * from ORDER_ITEMS;
DESC ORDERS;
drop table orders;

-------------------------------------------------------------
CREATE TABLE ORDER_ITEMS(
SERIAL_NO INT,
FOOD_ID INT,
QUANTITY INT,
PRICE DOUBLE,
DISCOUNT DOUBLE,
ORDERS_ID INT,
CONSTRAINT CPK_ORD_ITEMS PRIMARY KEY(ORDERS_ID,SERIAL_NO),
CONSTRAINT FK_FOOD_ORD_ITEMS FOREIGN KEY(FOOD_ID) REFERENCES FOOD_ITEMS(FOOD_ID),
CONSTRAINT FK_ORDERS_ORD_ITEMS FOREIGN KEY(ORDERS_ID) REFERENCES ORDERS(ORDERS_ID)
);
-------------------------------------------------------------

drop table orders;
select * from orders;
show tables;

-------------------------------------------------------------
CREATE TABLE FOOD_ITEMS(
FOOD_ID INT AUTO_INCREMENT,
FOOD_NAME VARCHAR(50),
FOOD_PRICE DOUBLE,
VENDOR_ID INT,
FOOD_RATING int,
PREPARATION_TIME INT,
DESCRIPTION VARCHAR(50),
food_rating_count int,
CONSTRAINT PK_FOOD_ITEMS PRIMARY KEY(FOOD_ID),
CONSTRAINT FK_FNDR_FOOD_ITEMS FOREIGN KEY(VENDOR_ID) REFERENCES VENDOR(VENDOR_ID)
);
-------------------------------------------------------------

alter table food_items add FOOD_RATING_COUNT int;
desc food_items;

select * from user_login;
delete from user_login;

-------------------------------------------------------------
CREATE TABLE FOOD_REVIEW(
FOOD_REVIEW_ID INT AUTO_INCREMENT,
CUSTOMER_ID INT,
FOOD_REVIEW_DATE DATE,
FOOD_REVIEW_REMARKS VARCHAR(50),
FOOD_REVIEW_RATING ENUM ('1','2','3','4','5'),
ORDERS_ID INT,
CONSTRAINT PK_FOOD_REVIEW PRIMARY KEY(FOOD_REVIEW_ID),
CONSTRAINT FK_CUST_FOOD_REVIEW FOREIGN KEY(CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID),
CONSTRAINT FK_ORD_FOODD_REVIEW FOREIGN KEY(ORDERS_ID) REFERENCES ORDERS(ORDERS_ID)
);
-------------------------------------------------------------

-------------------------------------------------------------
CREATE TABLE WALLLET_PAYMENT(
TRANSACTION_ID INT AUTO_INCREMENT,
CUSTOMER_ID INT,
VENDOR_ID INT,
TRANSACTION_DATE DATETIME,
ORDERS_ID INT,
PAYMENT_AMOUNT DOUBLE,
CONSTRAINT PK_WALLET_PAYMENT PRIMARY KEY(TRANSACTION_ID),
CONSTRAINT FK_CUST_WALLET_PAYMENT FOREIGN KEY(CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID),
CONSTRAINT FK__WALLET_PAYMENT FOREIGN KEY(VENDOR_ID) REFERENCES VENDOR(VENDOR_ID),
CONSTRAINT FK_ORD_WALLET_PAYMENT FOREIGN KEY(ORDERS_ID) REFERENCES ORDERS(ORDERS_ID)
);
-------------------------------------------------------------

-------------------------------------------------------------
CREATE TABLE WALLET_RECHARGE(
WALLET_RECHARGE_ID INT AUTO_INCREMENT,
WALLET_RECHARGE_DATE DATETIME,
WALLET_RECHARGE_AMOUNT DOUBLE,
CUSTOMER_ID INT,
WALLET_RECHARGE_BALANCE DOUBLE,
CUSTOMER_WALLET_AMT DOUBLE,
CONSTRAINT PK_WALLET_RECHARGE PRIMARY KEY(WALLET_RECHARGE_ID),
CONSTRAINT FK_CUST_WALLET_RECHARGE FOREIGN KEY(CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID)
);
-------------------------------------------------------------


select * from wallet_recharge;

-------------------------------------------------------------
CREATE TABLE USER_LOGIN(
USER_ID INT AUTO_INCREMENT,
USER_NAME VARCHAR(50),
USER_PASSWORD VARCHAR(12),
USER_TYPE ENUM('CUSTOMER','VENDOR','ADMIN'),
USER_REFERENCE INT,
LAST_PASSWORD_UPDATE DATE,
CONSTRAINT PK_USER_LOGIN PRIMARY KEY(USER_ID)
);
-------------------------------------------------------------

desc user_login;
alter table user_login modify user_id int auto_increment;
select * from user_login;
select * from vendor;
insert into user_login (user_id, user_name, user_password, user_type, user_reference, last_password_update) values (1, "KFC", "KFC123", "VENDOR", 6, now());

insert into user_login (user_id, user_name, user_password, user_type, user_reference, last_password_update) values (2, "Vikal Singh", "VIKALSINGH", "CUSTOMER", 1, now());

insert into user_login (user_id, user_name, user_password, user_type, user_reference, last_password_update) values (3, "ADMIN", "ADMIN", "ADMIN", 0, now());

delete from vendor where vendor_id=16;
delete from user_login where user_id=3;

delete from vendor;
delete from orders;
delete from order_items;
delete from user_login;
delete from food_item;
show tables;
delete from customer;
delete from wallet_recharge;

select * from user_login;
select * from customer;
select * from orders;
select * from order_items;