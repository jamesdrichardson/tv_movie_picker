drop table if exists movie, tv_show, suggester cascade;

create table movie (
movie_id serial,
movie_name varchar(100) not null,
movie_service varchar(100) not null,
movie_genre varchar(100) not null,
movie_IMBDRating decimal,
movie_RTRating int,
movie_our_rating int not null,
movie_description varchar(100) not null,
movie_keyword1 varchar(100) not null,
movie_keyword2 varchar(100),
movie_keyword3 varchar(100),
suggester_name varchar(100) not null,
completed boolean,

constraint PK_movie primary key(movie_id),
constraint FK_suggester foreign key(suggester_name),
constraint UQ_movie_name unique(movie_name),
);

create table tv_show (
tv_show_id serial,
tv_show_name varchar(100) not null,
tv_show_service varchar(100) not null,
tv_show_genre varchar(100) not null,
tv_show_IMBDRating decimal,
tv_show_RTRating int,
tv_show_our_rating int not null,
tv_show_description varchar(100) not null,
tv_show_keyword1 varchar(100) not null,
tv_show_keyword2 varchar(100),
tv_show_keyword3 varchar(100),
suggester_name varchar(100) not null,
completed boolean,

constraint PK_tv_show primary key(tv_show_id),
constraint FK_suggester foreign key(suggester_name),
constraint UQ_movie_name unique(tv_show_name),
);

create table suggester (
suggester_name varchar(25) not null,

constraint PK_suggester primary key(suggester_name),
constraint UQ_suggester name unique(suggester_name),
);
