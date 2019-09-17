-- CREATE DATABASE mskw;

-- DROP TABLE TEST333;
-- CREATE TABLE USERS(id int, name varying, email varying);
-- DROP TABLE IF EXISTS users;
-- CREATE TABLE users (id integer NOT NULL, name character varying(1024) NOT NULL, email character varying(1024) NOT NULL, CONSTRAINT users_pkey PRIMARY KEY (id));


INSERT INTO test_group(id, name) VALUES (1, '아시아');
INSERT INTO test_group(id, name) VALUES (2, '북미');
INSERT INTO test_group(id, name) VALUES (3, '유럽');

INSERT INTO test_user(id, name, email, group_id) VALUES (1, '문재인', 'moon@daou.com', 1);
INSERT INTO test_user(id, name, email, group_id) VALUES (2, '김정은', 'kim@daou.com', 1);
INSERT INTO test_user(id, name, email, group_id) VALUES (3, '트럼프', 't@daou.com', 2);
INSERT INTO test_user(id, name, email, group_id) VALUES (4, '시진핑', 'xi@daou.com',1);
INSERT INTO test_user(id, name, email, group_id) VALUES (5, '두테르테', 'dute@daou.com',1);
INSERT INTO test_user(id, name, email, group_id) VALUES (6, '아베', 'abe@daou.com',1);
INSERT INTO test_user(id, name, email, group_id) VALUES (7, '메르켈', 'merkel@daou.com',3);

-- INSERT INTO users(id, name, email) VALUES (1, '문재인', 'moon@daou.com');
-- INSERT INTO users(id, name, email) VALUES (2, '김정은', 'kim@daou.com');
-- INSERT INTO users(id, name, email) VALUES (3, '트럼프', 't@daou.com');
-- INSERT INTO users(id, name, email) VALUES (4, '시진핑', 'xi@daou.com');
-- INSERT INTO USERS(NAME, PASSWORD, EMAIL) VALUES ('문재인', '{bcrypt}$2a$10$Wg905Q9fxGDY2e7N4nL8AepLxaw3v7vW5sLuCPREFJ9NihowMgPDm', 'moon@daou.com');
-- INSERT INTO role(role) VALUES ('ADMIN');

-- INSERT INTO USER(NAME, PASSWORD, EMAIL, ACTIVE) VALUES ('문재인', '1234', 'moon@daou.com', true);
-- INSERT INTO USERS(NAME, PASSWORD, EMAIL) VALUES ('트럼프', '1234', 't@daou.com');
-- INSERT INTO USERS(NAME, PASSWORD, EMAIL) VALUES ('시진핑', '1234', 'xi@daou.com');
--
-- INSERT INTO USER_ADDRESS(ID, COUNTRY, ADDRESS, USERS_ID) VALUES (1, '한국', '서울', 1);
-- INSERT INTO USER_ADDRESS(ID, COUNTRY, ADDRESS, USERS_ID) VALUES (2, '북한', '평양', 2);
