# CSE5234_Group1


This is the Lab / Project for cse 5234, which aims to build a simple electronic commerce website to sell breads.  

To run this project, please make sure:

1. Change the build path of websphere.javaee.ejb and  websphere.javaee.ejb.persistence at myBreadEJB and myBreadClient from /User/dawei to your location

2. Set up liberty Server called defaultServer and set up the right path of database at server.xml 

3. To make sure table in database is correct and related to the object define by java source code, please run these sql in the DB engine:  

    create table ITEM (ID int auto_increment primary key, ITEM_NUMBER int, NAME varchar(255), DESCRIPTION varchar(255), AVAILABLE_QUANTITY int, UNIT_PRICE double);  
    create table CUSTOMER_ORDER (ID int auto_increment primary key, CUSTOMER_NAME varchar(255), CUSTOMER_EMAIL varchar(255), SHIPPING_INFO_ID_FK int, PAYMENT_INFO_ID_FK int, STATUS varchar(255) default 'New');  
    create table CUSTOMER_ORDER_LINE_ITEM (ID int auto_increment primary key, ITEM_NUMBER int, ITEM_NAME varchar(255), QUANTITY int, CUSTOMER_ORDER_ID_FK int);  
    create table PAYMENT_INFO (ID int auto_increment primary key, HOLDER_NAME varchar(255), CARD_NUM varchar(255),  EXP_DATE varchar(255), CVV varchar(3));  
    create table SHIPPING_INFO (ID int auto_increment primary key, ADDRESS1 varchar(255), ADDRESS2 varchar(255), CITY varchar(255), STATE varchar(255), COUNTRY varchar(255) default "USA", ZIP varchar(255), EMAIL varchar(255));  
    
To Do:  
1. updatingInventory() to allow update the quality of items in inventory
2. coding updating and refactor
