--用户信息表
create table USERINFO
(
  --用户名
  USERNAME VARCHAR2(50) not null,
  --密码
  PASSWORD VARCHAR2(50) not null,
  --用户邮箱
  EMAIL    VARCHAR2(50) not null
)
;
alter table USERINFO
  add constraint PK_USERNAME primary key (USERNAME);


insert into USERINFO (USERNAME, PASSWORD, EMAIL)
values ('test3', 'aaaaaaaa', 'test@163.com');
insert into USERINFO (USERNAME, PASSWORD, EMAIL)
values ('test2', 'aaaaaaaa', 'test2@163.com');
insert into USERINFO (USERNAME, PASSWORD, EMAIL)
values ('test4', 'aaaaaaaa', 'test2@163.com');
insert into USERINFO (USERNAME, PASSWORD, EMAIL)
values ('test007', '12312312', 'test007@aptech.com.cn');
insert into USERINFO (USERNAME, PASSWORD, EMAIL)
values ('test321', 'aaaaaaaa', 'aa@com.cm');
insert into USERINFO (USERNAME, PASSWORD, EMAIL)
values ('test008', 'aaaaaaaa', 'test008@1.c');
insert into USERINFO (USERNAME, PASSWORD, EMAIL)
values ('user1', 'aaaaaaaa', 'user1@aptech.com.cn');
insert into USERINFO (USERNAME, PASSWORD, EMAIL)
values ('test', 'test', 'test@test.com');
insert into USERINFO (USERNAME, PASSWORD, EMAIL)
values ('user123', '12312312', 'user123@123.com');
insert into USERINFO (USERNAME, PASSWORD, EMAIL)
values ('wangxiao', '12345678', '123@asd.com');
commit
