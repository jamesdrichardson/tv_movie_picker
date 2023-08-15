select setval('movie_movie_id_seq', max(movie_id))from movie;
select setval('tv_show_tv_show_id_seq', max(tv_show_id))from tv_show;

--these lines of sql code allow me to adjust the serial value attached to the corresponding id values if i were to make another mass upload
