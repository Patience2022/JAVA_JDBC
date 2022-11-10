Use master

GO

IF EXISTS(SELECT name FROM master.dbo.sysdatabases

WHERE name = 'clinic')

 

DROP database clinic

 

CREATE DATABASE      clinic

ON PRIMARY

(     

       NAME = "clinic",

       FILENAME ="C:\SQL\clinic.ndf" ,

       SIZE = 5MB,

       FILEGROWTH = 10%

)

LOG ON

(

       NAME = "clinic_log",

       FILENAME ="C:\SQL\clinic_log.ldf" ,

       SIZE = 5MB,

       FILEGROWTH = 10%

)

GO

 

USE clinic

GO

 

CREATE TABLE patients

(

       patID INT NOT NULL PRIMARY KEY,

       patName VARCHAR(20) NOT NULL,

       patSurname VARCHAR(20) NOT NULL,

       patCellNo INT NOT NULL,

       patStudNo VARCHAR(15) NOT NULL CHECK(patStudNo!='0')UNIQUE

)

 