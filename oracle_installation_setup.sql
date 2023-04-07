download oracle database based on
	1) Supported OS and its OS support for that DB version
	2) Check JDK version, JDBC driver required for the database
		https://www.oracle.com/in/database/technologies/appdev/jdbc-downloads.html
	3) download oracle db
		https://www.oracle.com/uk/database/technologies/oracle19c-windows-downloads.html
	4) set up ORACLE_HOME ENV VARIABLE TO THIS EXTRACTED FOLDER and add it to the path
	5) delete any oracle past installation directories from program_files and other path if available
		i) delete from regedit -> hkey -> software -> oracle and restart
	5) extract and setup -> run as administrator
	
1) cmd run as administrator
2) open @oracle_home/network/admin
-- listener.ora file
DEFAULT_SERVICE_LISTENER = XE

SID_LIST_LISTENER =
  (SID_LIST =
    (SID_DESC =
      (SID_NAME = CLRExtProc)
      (ORACLE_HOME = E:\oracle19c)
      (PROGRAM = extproc)
      (ENVS = "EXTPROC_DLLS=ONLY:E:\oracle19c\bin\oraclr19.dll")
    )
	(SID_DESC =
		(GLOBAL_DBNAME = orcl)
		(ORACLE_HOME = E:\oracle19c)
		(SID_NAME = orcl)
	)
  )

LISTENER =
  (DESCRIPTION_LIST =
    (DESCRIPTION =
      (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521))
      (ADDRESS = (PROTOCOL = IPC)(KEY = EXTPROC1521))
    )
  )
  
tnsnames.ora
XE =
	(DESCRIPTION =
		(ADDRESS = (PROTOCOL = TCP)(HOST= localhost) (PORT = 1521)))
		(CONNECT_DATA = 
			(SERVER = DEDICATED)
			(SERVICE_NAME = XE)
		)
	)

LISTENER_XE = 
	(ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521))

ORACLR_CONNECTION_DATA =
  (DESCRIPTION =
    (ADDRESS_LIST =
      (ADDRESS = (PROTOCOL = IPC)(KEY = EXTPROC1521))
    )
    (CONNECT_DATA =
      (SID = CLRExtProc)
      (PRESENTATION = RO)
    )
  )

3) lsnrctl start
4) lnsrctl status
5) sqlplus / as sysdba
6) exec dbms_xdb_config.setglobalportenabled(TRUE);
7) show con_name;
5) https://localhost:5500/em/login
	username, pword,container_name;
6) install squirrel/sqldeveloper for connecting to the db
For using a ServiceIdentifier (SID) => : 
jdbc:oracle:thin:@localhost:1521:orcl

For using a ServiceName				=> /
jdbc:oracle:thin:@localhost:1521/orclpdb

7) create pluggable database lucky2000 from orclpdb 
	storage unlimited tempfile resue 
	admin user lucky identified by 2000 file_name_convert = ('ORCLPDB','/lucky2000/');

8) alter session set container = lucky2000;
 
sqlplus sys/2000@//localhost:1521/lucky2000 as sysdba

create user lucky IDENTIFIED by 2000;

grant create session to lucky;

drop user lucky;

create tablespace lucky_tablespace datafile 'lucky_tablespace.dat' size 10M autoextend on;

create temporary tablespace lucky_tablespace_temp tempfile 'lucky_tablespace_temp.dat' size 5M autoextend on;

create user lucky identified by 2000 default tablespace lucky_tablespace temporary tablespace lucky_tablespace_temp;

grant create session to lucky;
grant create table to lucky;
grant unlimited tablespace to lucky;

9) 
jdbc:oracle:thin:@localhost:1521/lucky2000
lucky
2000

10) maven project -> ojdbc dependency jar -> java class -> connect
11) Connection connection = DriverManager.getConnection(url,uname,pword);


SELECT name, open_mode FROM v$pdbs;
ALTER SESSION SET container=LUCKY2000;
connect lucky/2000@LUCKY2000;

to clear screen in sqlplus
clear screen
clear screenbuffer

SELECT USER FROM DUAL;

grant all privileges on lucky.user_details to lucky;
GRANT CREATE ANY SEQUENCE, ALTER ANY SEQUENCE, DROP ANY SEQUENCE, SELECT ANY SEQUENCE TO lucky;

SELECT BANNER, BANNER_FULL FROM v$version;

SELECT * FROM USER_SYS_PRIVS