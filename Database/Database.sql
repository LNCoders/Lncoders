//Drops Each Table
DROP TABLE Staff;
DROP TABLE Member;
DROP TABLE Classes;
DROP TABLE Membership;
DROP TABLE Suppliments;

// Creates the Staff table with (ID,Firstname,Surname,Gender,Teaches)
CREATE TABLE Staff (
StaffId INT (3) PRIMARY KEY,
firstName VARCHAR(15) NOT NULL,
lastName VARCHAR(15)NOT NULL,
gender CHAR(1) NOT NULL,
teaches INT (3) 
);

// Creates the Member table with (ID,Firstname,Surname,D.O.B,Gender,takesClass,mShipType)

CREATE TABLE Member (
MemberId INT (3) PRIMARY KEY,
firstName VARCHAR(15) NOT NULL,
lastName VARCHAR(15)NOT NULL,
dateOfBirth DATE NOT NULL,
gender CHAR(1) NOT NULL,
takesClass INT(3),
mShipType INT(3) NOT NULL
);

// Creates the Classes table with (ID,ClassName)

CREATE TABLE Classes (
ClassId INT(3) PRIMARY KEY,
ClassName VARCHAR(15) NOT NULL
);

// Creates the Classes table with (ID,MembershipName,Price)

CREATE TABLE Membership(
MembershipId INT (3) PRIMARY KEY,
MembershipName VARCHAR(15) NOT NULL,
Price DECIMAL(3,2) NOT NULL
);

// Creates the Suppliments table with (ID,suppName,suppType,suppPrice)
CREATE TABLE Suppliments(
SuppId INT (3) PRIMARY KEY,
SuppName VARCHAR (15) NOT NULL,
SuppType VARCHAR (10) NOT NULL,
SuppPrice DECIMAL (3,2) NOT NULL
);