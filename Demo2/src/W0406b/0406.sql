{\rtf1\ansi\ansicpg936\cocoartf2578
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;\f1\fnil\fcharset134 PingFangSC-Regular;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 drop table userinfo;\
create table userInfo\
(\
	customerID int not null primary key,\
	customerName varchar2(20) not null,\
	PID VARCHAR2(18) not null CHECK((LENGTH(pid)=15) or  (LENGTH(pid)=18) ),\
	telephone VARCHAR2(16) not null CHECK((telephone LIKE '[0-9][0-9][0-9][0-9]%') or (LENGTH(telephone) = 11)),\
	address varchar2(100) default null\
)\
insert into userinfo values(001,'zhang',123456789012345678,'0000-17171717711')\
\
drop table cardInfo;\
create table cardInfo\
(\
cardID varchar2(20) not null primary key,\
curType varchar2(20) DEFAULT 'RMB' not null ,\
savingType varchar2(10),\
openDate DATE DEFAULT SYSDATE,\
openMoney FLOAT not null CHECK(openMoney>=1),\
balance FLOAT not null CHECK(balance>=1),\
pass number(6) DEFAULT 888888 not null CHECK(LENGTH(pass)=6),\
IsReportLoss varchar2(4) DEFAULT '
\f1 \'b7\'f1
\f0 ' not null CHECK(IsReportloss in ('
\f1 \'ca\'c7
\f0 ','
\f1 \'b7\'f1
\f0 ')),\
customerID int not null\
)\
\
alter table cardInfo add constraint  check_ck foreign key (customerID) references userInfo(customerID);\
\
drop table transInfo;\
create table transInfo\
(\
	transDate date DEFAULT SYSDATE not null,\
	cardID varchar2(20) not NULL,\
	transType VARCHAR2(10) not null CHECK(transType in ('
\f1 \'b4\'e6\'c8\'eb
\f0 ','
\f1 \'d6\'a7\'c8\'a1
\f0 ')) ,\
	transMoney FLOAT not null CHECK(transMoney>0),\
	remark VARCHAR2(200)\
	\
)\
ALTER table transInfo add constraint  check_ck3 foreign key (cardID) references cardInfo(cardID);\
\
select * from CARDINFO;\
select * from USERINFO;\
select sq1.nextval from dual;\
select ('1001 6666 6666 '||sqadd.nextval) from dual;\
\
--
\f1 \'bf\'aa\'bb\'a7
\f0 \
CREATE OR REPLACE PROCEDURE pro_add1(uName varchar2,pId VARCHAR2,phone VARCHAR2,openMoney FLOAT,savingType VARCHAR2,address VARCHAR2,result out VARCHAR2) \
as\
	uId int;\
	cardId VARCHAR2(20);\
BEGIN\
	uid:=sq1.nextval;\
\
	select ('1001 6666 6666 '||sqadd.nextval)into cardId from dual;\
	result := cardId;\
	insert into userInfo VALUES(uId,uName,pId,phone,address);\
	INSERT into cardInfo VALUES(cardId,DEFAULT,savingType,DEFAULT,openMoney,openMoney,DEFAULT,DEFAULT,uId);\
	insert into transInfo values(DEFAULT,cardId,'
\f1 \'b4\'e6\'c8\'eb
\f0 ',openMoney,'
\f1 \'bf\'aa\'bb\'a7\'bd\'f0\'b6\'ee
\f0 ');\
end;\
\
update CARDINFO set balance =balance + 1 where CARDID = '1001 6666 6666 1100';\
\
\
--
\f1 \'b4\'e6\'c8\'a1
\f0 \
cCREATE OR REPLACE procedure proc_takeMoney(cid  varchar2, ttype varchar2,pwd number,tmoney FLOAT,res out varchar2)\
as\
     passexception exception; --
\f1 \'c3\'dc\'c2\'eb\'b4\'ed\'ce\'f3\'d2\'ec\'b3\'a3
\f0 \
     balanceexception exception; --
\f1 \'d3\'e0\'b6\'ee\'b2\'bb\'d7\'e3\'d2\'ec\'b3\'a3
\f0 \
     --
\f1 \'b1\'e4\'c1\'bf\'a3\'ac\'d4\'dd\'b4\'e6\'c3\'dc\'c2\'eb
\f0 \
     v_pass cardinfo.pass%type; --
\f1 \'d3\'eb
\f0 cardinfo
\f1 \'b1\'ed\'d6\'d0\'b5\'c4
\f0 pass
\f1 \'d7\'d6\'b6\'ce\'b5\'c4\'c0\'e0\'d0\'cd\'d2\'bb\'d6\'b1
\f0 \
     v_balance cardinfo.balance%type; \
begin\
     --1
\f1 \'a1\'a2\'b8\'f9\'be\'dd\'bf\'a8\'ba\'c5\'b2\'e9\'d1\'af\'c3\'dc\'c2\'eb\'ba\'cd\'d3\'e0\'b6\'ee
\f0 \
     select pass,balance into v_pass,v_balance from cardinfo where cardid =cid;\
     \
     --
\f1 \'c5\'d0\'b6\'cf\'c3\'dc\'c2\'eb\'ca\'c7\'b7\'f1\'d5\'fd\'c8\'b7\'a3\'bf
\f0 \
     if(v_pass != pwd) then \
               raise passexception;\
     end if;\
     --
\f1 \'c5\'d0\'b6\'cf\'bd\'bb\'d2\'d7\'c0\'e0\'d0\'cd
\f0 \
     if(ttype='
\f1 \'d6\'a7\'c8\'a1
\f0 ') then\
            --
\f1 \'d3\'e0\'b6\'ee\'b2\'bb\'d7\'e3
\f0 \
            if(v_balance-1<tmoney) then\
                    raise  balanceexception;\
            else\
                    --
\f1 \'c8\'a1\'c7\'ae
\f0 \
										BEGIN\
                    update  cardinfo set balance = balance-tmoney where cardid=cid;\
										INSERT into transInfo values(SYSDATE,cid,ttype,tmoney,null);\
										END;\
            end if; \
     else\
           --
\f1 \'b4\'e6\'c7\'ae
\f0 \
					 BEGIN\
           update  cardinfo set balance =balance+tmoney where cardid=cid;\
					INSERT into transInfo values(SYSDATE,cid,ttype,tmoney,null);			\
					end;			 \
     end if;\
     res:='
\f1 \'bd\'bb\'d2\'d7\'b3\'c9\'b9\'a6
\f0 ';\
		 commit;\
     --
\f1 \'d2\'ec\'b3\'a3\'b4\'a6\'c0\'ed\'b2\'bf\'b7\'d6
\f0 \
     exception \
         when passexception then\
         begin\
              res := '
\f1 \'c3\'dc\'c2\'eb\'b2\'bb\'d5\'fd\'c8\'b7
\f0 ';\
              dbms_output.put_line('
\f1 \'c3\'dc\'c2\'eb\'b2\'bb\'d5\'fd\'c8\'b7
\f0 ');\
              rollback;\
         end;\
         when balanceexception then\
         begin\
              res :='
\f1 \'bd\'bb\'d2\'d7\'ca\'a7\'b0\'dc\'a3\'a1\'d3\'e0\'b6\'ee\'b2\'bb\'d7\'e3
\f0 ';\
              dbms_output.put_line('
\f1 \'bd\'bb\'d2\'d7\'ca\'a7\'b0\'dc\'a3\'a1\'d3\'e0\'b6\'ee\'b2\'bb\'d7\'e3
\f0 ');\
              rollback;\
         end;\
         when others then\
         begin\
              res := '
\f1 \'bd\'bb\'d2\'d7\'ca\'a7\'b0\'dc
\f0 ';\
              rollback;\
         end;\
end;\
\
\
--
\f1 \'d7\'aa\'d5\'cb
\f0 \
CREATE OR REPLACE PROCEDURE proc_transfer(cid VARCHAR2,pwd NUMBER,mcid VARCHAR2,tmoney FLOAT,res OUT VARCHAR2)\
as\
\
	ttype VARCHAR2(20);\
\
	--
\f1 \'d4\'dd\'b4\'e6\'d6\'a7\'c8\'a1\'d7\'b4\'cc\'ac
\f0 \
	zhiqures VARCHAR2(100);\
	\
	zhiquexe EXCEPTION;\
BEGIN\
ttype:='
\f1 \'d6\'a7\'c8\'a1
\f0 ';\
	PROC_TAKEMONEY(cid,ttype,pwd,tmoney,zhiqures);\
	IF (zhiqures != '
\f1 \'bd\'bb\'d2\'d7\'b3\'c9\'b9\'a6
\f0 ') THEN\
		raise zhiquexe;\
		ELSE\
			update CARDINFO set balance = tmoney + BALANCE where CARDID = mcid;\
	end IF;\
	\
	\
	res:='
\f1 \'d7\'aa\'d5\'cb\'b3\'c9\'b9\'a6
\f0 ';\
	commit;\
	EXCEPTION\
	when zhiquexe THEN\
	BEGIN\
		res := '
\f1 \'d7\'aa\'d5\'cb\'ca\'a7\'b0\'dc
\f0 ';\
		rollback;\
	end;\
	\
END;}