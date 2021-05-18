

create table mydiaryuser (age number,dimg number, memo varchar(20),name varchar(20),phone varchar(20),year number)


select * from mydiaryuser


create table Blist_per(Bid varchar2(30),Bdate date,Brest number(20),Binout number(20),Buser varchar2(20));
select * from bank;
delete from bank where brest=0
select * from blist where  bid='3456' order by bsequence desc;

select * from users;
delete from bank where bid='3456'
delete from blist where bid='3456' 
delete from users where sid='1234'
select * from users order by Smajor
update users set siscouncil=10 where sgrade=10;
select * from bank;
delete from users where sid='2015112120'

update blist set thishash='e8b347a26403a6d044c77ff7f0bb4b9205ff798a27fdc0e4a4ffc76359ef64b6'
where bid='3456' and bsequence=1

select * from blist order by bsequence desc;
update blist set bid='1234';
delete from blist where bsequence =1

delete from blist where bsequence != 149
update blist set bmemo='hacking2' where bsequence=194 and blusers='default' and bid='1234'

select * from blist where bsequence=194 and bid='1234' and blusers='default'
update blist set thishash='9f4d26c82201c66897c05cb3b17de9baf759d523999e9d646d9c7b80d82b0552' where bsequence=194 and bid='1234' and blusers='default'

delete from bank where bid='2345'

delete from blist where bid='2345'
delete from bank where brest<100000
select * from blist order by bsequence desc;
select * from blist order by bsequence desc;
insert into Bank values('1234','mathmatics','387a8233c96e1fc0ad5e284353276177af2186e7afa85296f106336e376669f7',1000000)
 1234 mathmatics  955000
update blist set bmemo='hacking 2' where bsequence=160 and blusers='default'
update blist set thishash='52e31d0ee82d8581bbc931b9a1b040cb4df0dde92f5b8c8a5c738a9c12e5cc86' where bsequence=160 and blusers='default'


select * from users;
update users set siscouncil=2 where snum=3333;
delete from users;

select * from bank;
update bank set brest = 1000000;
select * from blist;



select * from blist order by blusers ;
select count(*) from blist where blusers='default';

delete from blist;

select * from bank;

update bank set brest=1000000;

delete from blist where blusers='diff2'

insert into blist (bid,bdate,brest,binout,buser,bmemo,bsequence,fname,prehash,thishash)
select bid,bdate,brest,binout,buser,bmemo,bsequence,fname,prehash,thishash from blist where blusers='diff';


create table Blisttmp as select * from blist;

update blist set blusers='diff2' where blusers='default'

select * from blisttmp order by bsequence desc;
update blisttmp set blusers='diff';

insert into blist select * from blisttmp;

insert into blist 
select *
  from blist as of timestamp(systimestamp-interval '10' minute) order by bsequence desc;

delete from blist where bsequence=146;

select * from Blist where Binout=0;

insert into Blist select * from Blist;

alter table blist add blusers varchar2(20) default 'default';

update blist set bmemo ='hacking2 message' where bsequence=137;
update blist set thishash='9412abe1c0ec50bb1aa666530e00532fed00ff12912d72d791c68b1a37d501d2' where bsequence=137;

select * from blist where thishash='b5b808acce1634b241dcda1c5ee7cbe7a6bdb6ad857edd41208ee5baff2520b0';
select * from blist order by bsequence desc;

select * from bank;
select Bsequence , prehash, thishash,rownum from blist order by bsequence desc;
select * from blist order by bsequence desc;


insert into Blist (Bid,Bdate,Brest,Binout,Buser,Bmemo,Bsequence,prehash,thishash,Blusers) values
                ('admin',sysdate	,1000000,0,'admin','admin',149,1,1,'diff')

update bank set brest=950000;
delete from BLIST where brest=850000;
delete from blist_per;

update blist set thishash='2' where brest=595643;

select * from users;
create table users (
Sid varchar2(20) primary key, 
Sname varchar2(20), 
Spw varchar2(100), 
Snum varchar2(20), 
Sgrade number(2),
Smajor varchar2(20),
Siscouncil number(2) default 0);
drop table users;
	select Spw from users where Sid='test';
select * from bank;
create table bank(Bid varchar2(30), Bname varchar2(20),Bpw varchar2(100),Brest number(20));
create table Blist(Bid varchar2(30),Bdate date,Brest number(20),Binout number(20),Buser varchar2(20));

alter table blist add prehash varchar2(100);
alter table blist add thishash varchar2(100);

create table Blist_per(Bid varchar2(30),Bdate date,Brest number(20),Binout number(20),Buser varchar2(20));
alter table Blist_per add (Bmemo varchar2(30), Bsequence number(4));
alter table Blist_per add fname varchar2(20);


create sequence Bseq_p
start with 1
increment by 1
nocache;--임시메모리 사용 안함@!
drop sequence Bseq;






select * from blist_per;

select * from users;
update bank set bpw='387a8233c96e1fc0ad5e284353276177af2186e7afa85296f106336e376669f7';
select * from bank;
delete from users where sid='staris';
update users set siscouncil=3 where sid='2015112120';

update blist_per set fname='';
select Bseq_p.nextval from dual;


select * from blist_per;

update Blist_per set fname='';

