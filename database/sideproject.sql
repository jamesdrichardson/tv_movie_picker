drop table if exists movie, tv_show, suggester cascade;

create table suggester (
suggester_name varchar(25) not null,

constraint PK_suggester primary key(suggester_name),
constraint UQ_suggester_name unique(suggester_name)
);

create table movie (
movie_id serial,
movie_name varchar(100) not null,
movie_streaming_service varchar(100) not null,
movie_genre1 varchar(100) not null,
movie_genre2 varchar(100),
movie_IMDB_rating decimal,
movie_RT_rating int,
movie_our_rating decimal,
movie_description varchar(10000),
movie_keyword1 varchar(100),
movie_keyword2 varchar(100),
movie_keyword3 varchar(100),
movie_suggester_name varchar(100) not null,
movie_image bytea,
movie_completed boolean,
is_free boolean,
price decimal,
runtime_minutes int,
movie_director varchar(100),

constraint UQ_movie_name unique (movie_name),
constraint PK_movie primary key (movie_id),
constraint FK_suggester foreign key (movie_suggester_name) references suggester (suggester_name)
);

create table tv_show (
tv_show_id serial,
tv_show_name varchar(100) not null,
tv_show_streaming_service varchar(100) not null,
tv_show_genre1 varchar(100) not null,
tv_show_genre2 varchar(100),
tv_show_IMDB_rating decimal,
tv_show_RT_rating int,
tv_show_our_rating decimal,
tv_show_description varchar(10000),
tv_show_keyword1 varchar(100),
tv_show_keyword2 varchar(100),
tv_show_keyword3 varchar(100),
tv_show_suggester_name varchar(100) not null,
tv_show_image bytea,
tv_show_completed boolean,
ongoing boolean,
episode_count int,
season_count int,
episode_length varchar(10),
episodes_per_season varchar(100),
day_of_release varchar(15),


constraint PK_tv_show primary key (tv_show_id),
constraint FK_suggester foreign key (tv_show_suggester_name) references suggester (suggester_name),
constraint UQ_tv_show_name unique (tv_show_name)
);

