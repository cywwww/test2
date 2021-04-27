CREATE TEMPORARY TABLESPACE javaExam
 TEMPFILE  '/home/oracle/app/oracle/oradata/helowin/javaExam.dbf' size 100m autoextend on next 10m;

 create USER javaexam
 identified by 123456
 temporary tablespace javaExam;

 GRANT dba to javaexam;}