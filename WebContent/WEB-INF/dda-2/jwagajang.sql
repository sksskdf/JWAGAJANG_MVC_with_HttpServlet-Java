select * from table_notice;
desc table_notice;
desc notice;

select * from notice where notice_title like '%택배%' order by notice_title desc, notice_content asc;

drop table table_notice;

create table table_notice (
notice_code int PRIMARY KEY,
notice_label varchar NOT NULL,
notice_title varchar(100) NOT NULL,
notice_regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
notice_editdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
notice_content TEXT NOT NULL,
notice_count INT default 0
);