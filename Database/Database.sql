DROP TABLE Member;
DROP TABLE Classes;
DROP TABLE Membership;
DROP TABLE Suppliments;
DROP TABLE Staff;

CREATE TABLE Staff (
StaffId INT (3) PRIMARY KEY,
firstName VARCHAR(15) NOT NULL,
lastName VARCHAR(15)NOT NULL,
gender CHAR(1) NOT NULL,
teaches INT (3) 
);


CREATE TABLE Member (
MemberId INT (3) PRIMARY KEY,
firstName VARCHAR(15) NOT NULL,
lastName VARCHAR(15)NOT NULL,
dateOfBirth DATE NOT NULL,
gender CHAR(1) NOT NULL,
takesClass INT(3),
mShipType INT(3) NOT NULL
);


CREATE TABLE Classes (
ClassId INT(3) PRIMARY KEY,
ClassName VARCHAR(15) NOT NULL
);


CREATE TABLE Membership(
MembershipId INT (3) PRIMARY KEY,
MembershipName VARCHAR(15) NOT NULL,
Price DECIMAL(3,2) NOT NULL,
takesClass INT(3) NOT NULL,
mShipType INT(3) NOT NULL
);


CREATE TABLE Suppliments(
SuppId INT (3) PRIMARY KEY,
SuppName VARCHAR (15) NOT NULL,
SuppType VARCHAR (10) NOT NULL,
SuppPrice DECIMAL (3,2) NOT NULL
);

ALTER TABLE Staff 
ADD FOREIGN KEY (teaches) REFERENCES Classes(ClassId); 

ALTER TABLE Membership 
ADD FOREIGN KEY (takesClass) REFERENCES Classes(ClassId);

ALTER TABLE Member
ADD FOREIGN KEY (mShipType) REFERENCES Membership(MembershipId);  