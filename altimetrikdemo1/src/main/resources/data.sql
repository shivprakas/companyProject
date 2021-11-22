DROP TABLE IF EXISTS EMPLOYEES;
CREATE TABLE EMPLOYEES (
  empcode VARCHAR(250) PRIMARY KEY,
  empname VARCHAR(250) NOT NULL   
);

DROP TABLE IF EXISTS DEPARTMENTS;
CREATE TABLE DEPARTMENTS (
  deptcode VARCHAR(250) PRIMARY KEY,
  deptname VARCHAR(250) NOT NULL   
);

DROP TABLE IF EXISTS PROJECTS;
CREATE TABLE PROJECTS (
  projcode VARCHAR(250) NOT NULL,
  projname VARCHAR(250) NOT NULL,   
  deptcode VARCHAR(250) NOT NULL,
  PRIMARY KEY(projcode, deptcode));
);
  
DROP TABLE IF EXISTS EMPLOYEES_PROJECTS;
CREATE TABLE EMPLOYEES_PROJECTS (
  empcode VARCHAR(250) NOT NULL,
  projcode VARCHAR(250) NOT NULL   
);

INSERT INTO EMPLOYEES (empcode, empname) VALUES ('E10001', 'NameE10001')
INSERT INTO EMPLOYEES (empcode, empname) VALUES ('E10002', 'NameE10002')
INSERT INTO EMPLOYEES (empcode, empname) VALUES ('E10003', 'NameE10003')
INSERT INTO EMPLOYEES (empcode, empname) VALUES ('E10004', 'NameE10004')
INSERT INTO EMPLOYEES (empcode, empname) VALUES ('E10005', 'NameE10005')

INSERT INTO DEPARTMENTS (deptcode, deptname) VALUES ('D101', 'NameD101')
INSERT INTO DEPARTMENTS (deptcode, deptname) VALUES ('D102', 'NameD102')

INSERT INTO PROJECTS (projcode, projname, deptcode) VALUES ('P1001', 'NameP1001', 'D101')
INSERT INTO PROJECTS (projcode, projname, deptcode) VALUES ('P1002', 'NameP1002', 'D101')

INSERT INTO EMPLOYEES_PROJECTS (empcode, projcode) VALUES ('E10001', 'P1001')
INSERT INTO EMPLOYEES_PROJECTS (empcode, projcode) VALUES ('E10001', 'P1002')

INSERT INTO EMPLOYEES_PROJECTS (empcode, projcode) VALUES ('E10002', 'P1001')
INSERT INTO EMPLOYEES_PROJECTS (empcode, projcode) VALUES ('E10003', 'P1002')

INSERT INTO EMPLOYEES_PROJECTS (empcode, projcode) VALUES ('E10004', 'P1001')
INSERT INTO EMPLOYEES_PROJECTS (empcode, projcode) VALUES ('E10005', 'P1002')