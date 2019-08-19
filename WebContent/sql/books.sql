--图书信息表
create table BOOKS
(
  --图书id
  ID      NUMBER not null,
  --图书名称
  BOOKNAME VARCHAR2(100) not null,
  --图书价格
  BOOKPRICE  VARCHAR2(10) not null,
  --图片存放路径
  IMAGE    VARCHAR2(200) not null,
  --图书库存
  STOCK    NUMBER not null
)
;
alter table BOOKS
  add constraint PK_BOOKID primary key (ID);

--prompt Loading BOOKS...
insert into BOOKS (ID, BOOKNAME, BOOKPRICE, IMAGE, STOCK)
values (27, '泰戈尔诗集', '18.00', 'images/book/book_01.gif', 979);
insert into BOOKS (ID, BOOKNAME, BOOKPRICE, IMAGE, STOCK)
values (28, '痕记', '22.80', 'images/book/book_02.gif', 977);
insert into BOOKS (ID, BOOKNAME, BOOKPRICE, IMAGE, STOCK)
values (29, '天堂之旅', '25.00', 'images/book/book_03.gif', 989);
insert into BOOKS (ID, BOOKNAME, BOOKPRICE, IMAGE, STOCK)
values (30, '钱钟书集', '332.50', 'images/book/book_04.gif', 999);
insert into BOOKS (ID, BOOKNAME, BOOKPRICE, IMAGE, STOCK)
values (31, '赵俪生高昭—夫妻回忆录', '38.00', 'images/book/book_05.gif', 998);
insert into BOOKS (ID, BOOKNAME, BOOKPRICE, IMAGE, STOCK)
values (32, '无聊斋', '28.00', 'images/book/book_06.gif', 998);
insert into BOOKS (ID, BOOKNAME, BOOKPRICE, IMAGE, STOCK)
values (33, '一颗热土豆是一张温馨的床', '38.00', 'images/book/book_07.gif', 999);
insert into BOOKS (ID, BOOKNAME, BOOKPRICE, IMAGE, STOCK)
values (34, '李戡戡乱记', '22.00', 'images/book/book_08.gif', 999);
insert into BOOKS (ID, BOOKNAME, BOOKPRICE, IMAGE, STOCK)
values (35, '生生世世未了缘', '17.50', 'images/book/book_09.gif', 999);
insert into BOOKS (ID, BOOKNAME, BOOKPRICE, IMAGE, STOCK)
values (36, '一生有多少爱', '17.50', 'images/book/book_10.gif', 999);
commit;
