DROP TABLE Staff;
DROP TABLE Member;
DROP TABLE Classes;

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
FOREIGN KEY (takesClass) REFERENCES Classes(ClassId) ,
)ENGINE=INNODB;

CREATE TABLE Classes (
ClassId Number(3) PRIMARY KEY,
ClassName VARCHAR(15) NOT NULL,
)ENGINE=INNODB;
