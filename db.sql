CREATE DATABASE db;
USE db;

create table voiture (
 id  int(3) NOT NULL AUTO_INCREMENT,
 nom varchar(120) NOT NULL,
 ematricule varchar(220) NOT NULL,
 PRIMARY KEY (id)
);