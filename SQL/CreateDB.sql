create table Account(
Account_Num numeric(4) not null,
First_Name varchar(25),
Last_Name varchar(25),
Username varchar(25) unique,
ACC_password varchar(30),
Born_On date default current_date not null,
Country varchar (50),

constraint PK_Account
primary key (Account_Num)


);

create table Account_Image(
Account_Num numeric(4) not null,
image_data BYTEA,

constraint PK_AccountNum
primary key (Account_Num)
);