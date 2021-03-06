CREATE TABLE user (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  CREATED_BY_USER varchar(255) DEFAULT NULL,
  CREATED_DATE datetime DEFAULT NULL,
  MODIFIED_BY_USER varchar(255) DEFAULT NULL,
  MODIFIED_DATE datetime DEFAULT NULL,
  VERSION bigint(20) DEFAULT NULL,
  AVATAR longblob,
  BIRTH_DATE datetime NOT NULL,
  EMAIL varchar(255) NOT NULL,
  FIRST_NAME varchar(255) NOT NULL,
  LAST_NAME varchar(255) NOT NULL,
  PASSWORD varchar(255) NOT NULL,
  ROLE int(11) NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE KEY (EMAIL)
) DEFAULT CHARSET=utf8;

CREATE TABLE question (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  CREATED_BY_USER varchar(255) DEFAULT NULL,
  CREATED_DATE datetime DEFAULT NULL,
  MODIFIED_BY_USER varchar(255) DEFAULT NULL,
  MODIFIED_DATE datetime DEFAULT NULL,
  VERSION bigint(20) DEFAULT NULL,
  DESCRIPTION varchar(255) NOT NULL,
  NAME varchar(255) NOT NULL,
  PRIMARY KEY (ID)
) DEFAULT CHARSET=utf8;

CREATE TABLE test (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  CREATED_BY_USER varchar(255) DEFAULT NULL,
  CREATED_DATE datetime DEFAULT NULL,
  MODIFIED_BY_USER varchar(255) DEFAULT NULL,
  MODIFIED_DATE datetime DEFAULT NULL,
  VERSION bigint(20) DEFAULT NULL,
  DESCRIPTION varchar(255) DEFAULT NULL,
  IS_PUBLIC bit(1) DEFAULT NULL,
  NAME varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID)
) DEFAULT CHARSET=utf8;

CREATE TABLE assert (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  CREATED_BY_USER varchar(255) DEFAULT NULL,
  CREATED_DATE datetime DEFAULT NULL,
  MODIFIED_BY_USER varchar(255) DEFAULT NULL,
  MODIFIED_DATE datetime DEFAULT NULL,
  VERSION bigint(20) DEFAULT NULL,
  EXPECTED_ANSWER varchar(255) DEFAULT NULL,
  INPUT_DATA varchar(255) DEFAULT NULL,
  QUESTION_ID bigint(20) DEFAULT NULL,
  PRIMARY KEY (ID),
  KEY (QUESTION_ID),
  FOREIGN KEY (QUESTION_ID) REFERENCES question (ID)
);

CREATE TABLE attempt (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  CREATED_BY_USER varchar(255) DEFAULT NULL,
  CREATED_DATE datetime DEFAULT NULL,
  MODIFIED_BY_USER varchar(255) DEFAULT NULL,
  MODIFIED_DATE datetime DEFAULT NULL,
  VERSION bigint(20) DEFAULT NULL,
  TEST_ID bigint(20) DEFAULT NULL,
  USER_ID bigint(20) DEFAULT NULL,
  PRIMARY KEY (ID),
  KEY FK_a2kofu6sbifhvpkqqngq7xo2a (TEST_ID),
  KEY FK_m42jq221f7d9490mmx7aemyi0 (USER_ID),
  FOREIGN KEY (TEST_ID) REFERENCES test (ID),
  FOREIGN KEY (USER_ID) REFERENCES user (ID)
) DEFAULT CHARSET=utf8;

CREATE TABLE link (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  CREATED_BY_USER varchar(255) DEFAULT NULL,
  CREATED_DATE datetime DEFAULT NULL,
  MODIFIED_BY_USER varchar(255) DEFAULT NULL,
  MODIFIED_DATE datetime DEFAULT NULL,
  VERSION bigint(20) DEFAULT NULL,
  SHORT_CODE varchar(255) NOT NULL,
  TEST_ID bigint(20) NOT NULL,
  URL varchar(255) NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE KEY (SHORT_CODE),
  UNIQUE KEY (URL),
  KEY (TEST_ID),
  FOREIGN KEY (TEST_ID) REFERENCES test (ID)
) DEFAULT CHARSET=utf8;

CREATE TABLE question_test (
  QUESTION_ID bigint(20) NOT NULL,
  TEST_ID bigint(20) NOT NULL,
  PRIMARY KEY (TEST_ID,QUESTION_ID),
  KEY FK_74nr2qe00dow76a1g7925n4nu (QUESTION_ID),
  FOREIGN KEY (QUESTION_ID) REFERENCES question (ID),
  FOREIGN KEY (TEST_ID) REFERENCES test (ID)
) DEFAULT CHARSET=utf8;

CREATE TABLE user_answer (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  CREATED_BY_USER varchar(255) DEFAULT NULL,
  CREATED_DATE datetime DEFAULT NULL,
  MODIFIED_BY_USER varchar(255) DEFAULT NULL,
  MODIFIED_DATE datetime DEFAULT NULL,
  VERSION bigint(20) DEFAULT NULL,
  ANSWER varchar(255) DEFAULT NULL,
  IS_CORRECT bit(1) DEFAULT NULL,
  ATTEMPT_ID bigint(20) DEFAULT NULL,
  QUESTION_ID bigint(20) DEFAULT NULL,
  PRIMARY KEY (ID),
  KEY (ATTEMPT_ID),
  KEY (QUESTION_ID),
  FOREIGN KEY (QUESTION_ID) REFERENCES question (ID),
  FOREIGN KEY (ATTEMPT_ID) REFERENCES attempt (ID)
) DEFAULT CHARSET=utf8;

INSERT INTO user (ID,BIRTH_DATE,EMAIL,FIRST_NAME,LAST_NAME,PASSWORD,ROLE) VALUES (2,'1994-05-13 00:00:00','td@gmail.com','Tom','Delonge','password',1);
INSERT INTO user (ID,BIRTH_DATE,EMAIL,FIRST_NAME,LAST_NAME,PASSWORD,ROLE) VALUES (3,'2000-03-18 00:00:00','mr@gmail.com','Mark','Rawson','password',1);
INSERT INTO user (ID,BIRTH_DATE,EMAIL,FIRST_NAME,LAST_NAME,PASSWORD,ROLE) VALUES (4,'1899-12-31 00:00:00','or@soft.ua','Orest','Sov','password',0);
INSERT INTO user (ID,BIRTH_DATE,EMAIL,FIRST_NAME,LAST_NAME,PASSWORD,ROLE) VALUES (5,'2000-04-10 00:00:00','ts@mail.com','Tom','Sanders','password',0);
INSERT INTO user (ID,BIRTH_DATE,EMAIL,FIRST_NAME,LAST_NAME,PASSWORD,ROLE) VALUES (6,'2002-02-06 00:00:00','jj@john.com','Jack','Johnson','password',0);
INSERT INTO user (ID,BIRTH_DATE,EMAIL,FIRST_NAME,LAST_NAME,PASSWORD,ROLE) VALUES (7,'2003-09-17 00:00:00','rw@gmail.com','Rick','Wright','password',0);
INSERT INTO user (ID,BIRTH_DATE,EMAIL,FIRST_NAME,LAST_NAME,PASSWORD,ROLE) VALUES (8,'2003-08-13 00:00:00','tr@ukr.net','Tim','Roth','password',0);
INSERT INTO user (ID,BIRTH_DATE,EMAIL,FIRST_NAME,LAST_NAME,PASSWORD,ROLE) VALUES (9,'2002-07-16 00:00:00','rm@yahoo.com','Ringo','Matt','password',0);
INSERT INTO user (ID,BIRTH_DATE,EMAIL,FIRST_NAME,LAST_NAME,PASSWORD,ROLE) VALUES (10,'1899-12-31 00:00:00','user@gmail.com','user','user','password',0);
INSERT INTO user (ID,BIRTH_DATE,EMAIL,FIRST_NAME,LAST_NAME,PASSWORD,ROLE) VALUES (15,'2003-07-14 00:00:00','admin@admin.com','admin','admin','password',1);
INSERT INTO test (ID,DESCRIPTION,IS_PUBLIC,NAME) VALUES (1,'Description_1',1,'TEST_1');
INSERT INTO test (ID,DESCRIPTION,IS_PUBLIC,NAME) VALUES (2,'Description_2',0,'TEST_2');
INSERT INTO test (ID,DESCRIPTION,IS_PUBLIC,NAME) VALUES (3,'Description_3',0,'TEST_3');
INSERT INTO test (ID,DESCRIPTION,IS_PUBLIC,NAME) VALUES (4,'Description_4',1,'TEST_4');
INSERT INTO question (ID,DESCRIPTION,NAME) VALUES (1,'Text_1','Question_1');
INSERT INTO question (ID,DESCRIPTION,NAME) VALUES (2,'Text_2','Question_2');
INSERT INTO question (ID,DESCRIPTION,NAME) VALUES (3,'Text_3','Question_3');
INSERT INTO question (ID,DESCRIPTION,NAME) VALUES (4,'Text_4','Question_4');
INSERT INTO question (ID,DESCRIPTION,NAME) VALUES (5,'Text_5','Question_5');
INSERT INTO question_test (QUESTION_ID,TEST_ID) VALUES (1,2);
INSERT INTO question_test (QUESTION_ID,TEST_ID) VALUES (1,3);
INSERT INTO question_test (QUESTION_ID,TEST_ID) VALUES (1,4);
INSERT INTO question_test (QUESTION_ID,TEST_ID) VALUES (2,2);
INSERT INTO question_test (QUESTION_ID,TEST_ID) VALUES (2,4);
INSERT INTO question_test (QUESTION_ID,TEST_ID) VALUES (3,2);
INSERT INTO question_test (QUESTION_ID,TEST_ID) VALUES (3,4);
INSERT INTO question_test (QUESTION_ID,TEST_ID) VALUES (4,2);
INSERT INTO question_test (QUESTION_ID,TEST_ID) VALUES (5,3);
