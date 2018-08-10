drop database if exists demo;
create database demo default character set utf8;
use demo;
drop table if exists product;

create table product
(
   id                  int not null auto_increment,
   name                varchar(20),
   price               decimal(8,2),
   remark              longtext,
   date                timestamp default CURRENT_TIMESTAMP,
   primary key (id)
);

/* 商品测试用例 */
insert into product (name,price,remark) values ('圣得西服',3000.00,'这里是简单介绍');
insert into product (name,price,remark) values ('衫衫西服',3000.00,'这里是简单介绍');
insert into product (name,price,remark) values ('Iphone6',6000.00,'这里是简单介绍');
-- 闭区间 [0,4]  开区间 ()  size = 5  (page - 1) * size = 5
select * from product where name like '%%' limit 5,2








