drop table board;
create table board(
	seq integer auto_increment primary key,
	write_seq integer default 0,
	current_seq varchar(100) not null,
	title varchar(100) not null,
	content varchar(500) not null,
	read_count integer not null default 0,
	next_seq varchar(100) not null,
	write_date datetime not null default now(),
	writer varchar(20) not null,
	user_id varchar(20) not null
);
select * from board where seq = (select max(seq) from board);
update board set write_seq = m where seq = (select max(seq)  from board); 
delete from board where seq = 23;
insert into board(write_seq,current_seq,title,content,next_seq,writer,user_id) values (last_insert_id()+1,'a','b','c','d','e','f');
select * from board order by seq desc , current_seq asc;