CREATE TABLE Dipendente (
  ID       int(11) NOT NULL AUTO_INCREMENT, 
  Username varchar(255), 
  Pwd      varchar(255), 
  Level    int(11) NOT NULL, 
  PRIMARY KEY (ID)) ENGINE=InnoDB CHARACTER SET UTF8;
ALTER TABLE Item 
  ADD COLUMN State varchar(255);
