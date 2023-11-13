CREATE Table [rv_is].[dbo].[News](

    id int NOT NULL PRIMARY KEY,
	isin_code varchar(20),
	name varchar(30),
	headline varchar(100),
	link varchar(200),
	date smalldatetime()

)



