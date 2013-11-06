CREATE TABLE Dipendente (
  ID         int(11) NOT NULL AUTO_INCREMENT, 
  Pwd        varchar(255), 
  Usr        varchar(255), 
  Level      int(11) NOT NULL, 
  Name       varchar(255), 
  Familyname varchar(255), 
  PRIMARY KEY (ID)) ENGINE=InnoDB CHARACTER SET UTF8;
