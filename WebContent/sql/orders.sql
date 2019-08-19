--订单表
create table ORDERS
(
  --订单id
  ID      NUMBER not null,
  --用户名
  USERNAME VARCHAR2(50) not null
)
;
alter table ORDERS
  add constraint ORDER_ID primary key (ID);
alter table ORDERS
  add constraint FK_USERNAME foreign key (USERNAME)
  references USERINFO (USERNAME);

--prompt Loading ORDERS...
insert into ORDERS (ID, USERNAME)
values (81, 'test');
insert into ORDERS (ID, USERNAME)
values (61, 'test');
insert into ORDERS (ID, USERNAME)
values (1001, 'test');
insert into ORDERS (ID, USERNAME)
values (1002, 'test');
insert into ORDERS (ID, USERNAME)
values (1004, 'test');
insert into ORDERS (ID, USERNAME)
values (1005, 'wangxiao');
insert into ORDERS (ID, USERNAME)
values (1003, 'test');
commit;

