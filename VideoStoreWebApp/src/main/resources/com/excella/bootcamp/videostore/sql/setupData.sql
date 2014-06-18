insert into Genre (Genre) values ('Action');
insert into Genre (Genre) values ('Comedy');
insert into Genre (Genre) values ('Drama');
insert into Genre (Genre) values ('Horror');
insert into Genre (Genre) values ('Sci-Fi');

insert into Movie(Name, HD, GenreId) values ('Die Hard', TRUE, 
	(select GenreId from Genre where Genre='Action'));
insert into Movie(Name, HD, GenreId) values ('Predator', TRUE, 
	(select GenreId from Genre where Genre='Action'));
insert into Movie(Name, HD, GenreId) values ('Dumb and Dumber', TRUE, 
	(select GenreId from Genre where Genre='Comedy'));
insert into Movie(Name, HD, GenreId) values ('Stripes', FALSE, 
	(select GenreId from Genre where Genre='Comedy'));
insert into Movie(Name, HD, GenreId) values ('American Hustle', TRUE, 
	(select GenreId from Genre where Genre='Drama'));
insert into Movie(Name, HD, GenreId) values ('Dallas Buyers Club', TRUE, 
	(select GenreId from Genre where Genre='Drama'));
insert into Movie(Name, HD, GenreId) values ('Amityville Horror', FALSE, 
	(select GenreId from Genre where Genre='Horror'));
insert into Movie(Name, HD, GenreId) values ('Nightmare on Elm Street', TRUE, 
	(select GenreId from Genre where Genre='Horror'));
insert into Movie(Name, HD, GenreId) values ('The Empire Strikes Back', TRUE, 
	(select GenreId from Genre where Genre='Sci-Fi'));
insert into Movie(Name, HD, GenreId) values ('Star Trek', TRUE, 
	(select GenreId from Genre where Genre='Sci-Fi'));

insert into Customer (Name, VIP) values ('Barney Rubble', FALSE);
insert into Customer (Name, VIP) values ('Fred Flintstone', FALSE);
insert into Customer (Name, VIP) values ('Bugs Bunny', TRUE);
insert into Customer (Name, VIP) values ('Daffy Duck', TRUE);
