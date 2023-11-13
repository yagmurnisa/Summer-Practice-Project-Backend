/****** Script for SelectTopNRows command from SSMS  ******/
Create table [rv_is].[dbo].[Index] (
    id int NOT NULL PRIMARY KEY IDENTITY(1,1),
    isin_code varchar(20),
    name varchar(50),
    index_ varchar(30),
    link varchar(200)
    )