create schema games;

use games;
drop table games;

create table games(
id varchar(5) primary key,
name varchar(50),
description varchar(300));


Insert into games values(1,'Days Gone', 'Days Gone is an action-adventure survival horror game set in a post-apocalyptic open world, played from a third-person perspective.');
Insert into games values(2,'Control', 'Control is a action game that revolves around the Federal Bureau of Control (FBC), a secret U.S. government agency tasked with containing and studying phenomena that violate the laws of reality.');
Insert into games values(3,'Fall Guys', 'Fall Guys: Ultimate Knockout is a platform battle royale game. It also has seasonal changes, which adds more challenges and changes the games theme.');
Insert into games values(4,'Spiderman', 'Spider-Man is an open-world action-adventure game set in the borough of Manhattan in a fictionalized version of modern-day New York City.');
Insert into games values(5,'Red Dead Redemption 2', 'Red Dead Redmpetion 2 is an action-adventure game set in 1899 in a fictionalized representation of the Western, Midwestern, and Southern United States and follows outlaw Arthur Morgan, a member of the Van der Linde gang.');

select * from games;