DROP TABLE Staff;
DROP TABLE Member;
DROP TABLE Classes;
DROP TABLE Membership;
DROP TABLE Suppliments;

CREATE TABLE Staff (
StaffId Number(3) PRIMARY KEY,
firstName VARCHAR(15) NOT NULL,
lastName VARCHAR(15)NOT NULL,
gender CHAR(1) NOT NULL,
teaches Number (3), 
FOREIGN KEY (teaches) REFERENCES Classes(ClassId) ,
)ENGINE=INNODB;


CREATE TABLE Member (
MemberId Number(3) PRIMARY KEY,
firstName VARCHAR(15) NOT NULL,
lastName VARCHAR(15)NOT NULL,
dateOfBirth DATE,
gender CHAR(1) NOT NULL,
takesClass Number(3),
mShipType Number (3) NOT NULL,
FOREIGN KEY (takesClass) REFERENCES Classes(ClassId),
FOREIGN KEY (mShipType) REFERENCES Membership(MembershipId),
)ENGINE=INNODB;

CREATE TABLE Classes (
ClassId Number(3) PRIMARY KEY,
ClassName VARCHAR(15) NOT NULL,
)ENGINE=INNODB;

CREATE Table Membership(
MembershipId Number(3) PRIMARY KEY,
MembershipName VARCHAR(15) NOT NULL,
Price Number(2) NOT NULL,
)ENGINE=INNODB;

CREATE Table Suppliments(
SuppId Number (3) PRIMARY KEY,
SuppName VARCHAR (15) NOT NULL,
SuppType VARCHAR (10) NOT NULL,
SuppPrice Number (2) NOT NULL,
)ENGINE=INNODB;