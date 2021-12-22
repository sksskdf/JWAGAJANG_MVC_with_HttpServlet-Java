select * from table_md;
desc table_md;

select * from table_user;

alter table table_md add md_ordercnt int;
alter table table_md modify md_ordercnt int default 0;

update table_md set md_ordercnt=0 where md_code=4;

select md_code, md_name, md_price, md_dc, img_main from table_md order by md_ordercnt desc limit 4;
select md_code, md_name, md_price, md_dc, img_main from table_md order by md_regdate  desc limit 4;