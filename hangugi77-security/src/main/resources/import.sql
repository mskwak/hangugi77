-- CREATE DATABASE mskw;

-- DROP TABLE TEST333;
-- CREATE TABLE USERS(id int, name varying, email varying );

-- INSERT INTO USERS(ID, NAME, EMAIL) VALUES (1, '문재인', 'moon@daou.com');
-- INSERT INTO USERS(ID, NAME, EMAIL) VALUES (2, '김정은', 'kim@daou.com');
-- INSERT INTO USERS(ID, NAME, EMAIL) VALUES (3, '트럼프', 't@daou.com');
-- INSERT INTO USERS(ID, NAME, EMAIL) VALUES (4, '시진핑', 'xi@daou.com');
INSERT INTO USERS(NAME, PASSWORD, EMAIL) VALUES ('문재인', '{bcrypt}$2a$10$Wg905Q9fxGDY2e7N4nL8AepLxaw3v7vW5sLuCPREFJ9NihowMgPDm', 'moon@daou.com');
-- INSERT INTO USERS(NAME, PASSWORD, EMAIL) VALUES ('김정은', '1234', 'kim@daou.com');
-- INSERT INTO USERS(NAME, PASSWORD, EMAIL) VALUES ('트럼프', '1234', 't@daou.com');
-- INSERT INTO USERS(NAME, PASSWORD, EMAIL) VALUES ('시진핑', '1234', 'xi@daou.com');
--
-- INSERT INTO USER_ADDRESS(ID, COUNTRY, ADDRESS, USERS_ID) VALUES (1, '한국', '서울', 1);
-- INSERT INTO USER_ADDRESS(ID, COUNTRY, ADDRESS, USERS_ID) VALUES (2, '북한', '평양', 2);
