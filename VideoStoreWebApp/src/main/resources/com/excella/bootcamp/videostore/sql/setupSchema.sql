drop table if exists Customer;
drop table if exists Movie;
drop table if exists Genre;

create table Customer (
	CustomerId INT auto_increment Primary Key, 
	Name VARCHAR(255), 
	VIP BOOLEAN);
	
create table Genre (
	GenreId INT auto_increment Primary Key, 
	Genre VARCHAR(50));

create table Movie (
	MovieId INT auto_increment Primary Key, 
	Name VARCHAR(255), 
	HD BOOLEAN,
	GenreId INT,
	FOREIGN KEY(GenreId) REFERENCES Genre(GenreId));
