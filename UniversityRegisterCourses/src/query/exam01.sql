--<ScriptOptions statementTerminator=";"/>
--학과 테이블(일련번호, 학과번호, 학과명)
CREATE TABLE subject(
    no NUMBER,
    s_num VARCHAR2(2) NOT NULL,
    s_name VARCHAR(20) NOT NULL,
    
    CONSTRAINT subject_no_pk PRIMARY KEY(no),
    CONSTRAINT subject_s_num_uk UNIQUE(s_num)
);

INSERT INTO subject VALUES(1, '01', '컴퓨터학과');
INSERT INTO subject VALUES(2, '02', '교육학과');
INSERT INTO subject VALUES(3, '03', '신문방송학과');
INSERT INTO subject VALUES(4, '04', '인터넷비즈니스과');
INSERT INTO subject VALUES(5, '05', '기술경영과');

--학생 테이블(일련번호, 학번, 이름, 아이디, 비밀번호, 학과번호, 생년월일, 핸드폰번호, 주소, 이메일, 등록일자)
CREATE TABLE student(
    no NUMBER,
    sd_num VARCHAR2(8) NOT NULL,
    sd_name VARCHAR2(10) NOT NULL,
    sd_id VARCHAR2(20) NOT NULL,
    sd_passwd VARCHAR2(20) NOT NULL,
    s_num VARCHAR2(2)  NOT NULL,
    sd_birth DATE NOT NULL,
    sd_phone VARCHAR2(15) NOT NULL,
    sd_address VARCHAR2(40) NOT NULL,
    sd_email VARCHAR2(40) NOT NULL,
    sd_date DATE DEFAULT SYSDATE NOT NULL,
    
    CONSTRAINT student_no_pk PRIMARY KEY(no),
    CONSTRAINT student_sd_num_uk UNIQUE(sd_num),
    CONSTRAINT student_s_num_fk FOREIGN KEY(s_num) REFERENCES subject(s_num)
);

INSERT INTO student(no, sd_num, sd_name, sd_id, sd_passwd, s_num, sd_birth, sd_phone, sd_address, sd_email, sd_date)
                    VALUES(1, '06010001', '김정수', 'javajsp', 'java1234', '01', '1999/11/01', 
                    '010-1111-1111', '서울시 서대문구 창전동', 'aaaa@aaaa.com', SYSDATE);
INSERT INTO student(no, sd_num, sd_name, sd_id, sd_passwd, s_num, sd_birth, sd_phone, sd_address, sd_email, sd_date)
                    VALUES(2, '95010002', '김수현', 'jdbcmania', 'jdbc1234', '01', '1998/10/01', 
                    '010-2222-2222', '서울시 서초구 양재동', 'bbbb@bbbb.com', SYSDATE);
INSERT INTO student(no, sd_num, sd_name, sd_id, sd_passwd, s_num, sd_birth, sd_phone, sd_address, sd_email, sd_date)
                    VALUES(3, '98040001', '공지영', 'gonji', 'gon1234', '04', '1997/09/01', 
                    '010-3333-3333', '부산광역시 해운대구 반송동', 'cccc@cccc.com', SYSDATE);
INSERT INTO student(no, sd_num, sd_name, sd_id, sd_passwd, s_num, sd_birth, sd_phone, sd_address, sd_email, sd_date)
                    VALUES(4, '02050001', '조수영', 'water', 'water1234', '05', '1996/08/01', 
                    '010-4444-4444', '대전광역시 중구 은행동', 'dddd@dddd.com', SYSDATE);
INSERT INTO student(no, sd_num, sd_name, sd_id, sd_passwd, s_num, sd_birth, sd_phone, sd_address, sd_email, sd_date)
                    VALUES(5, '94040002', '최경란', 'novel', 'no1234', '04', '1995/07/01', 
                    '010-5555-5555', '경기도 수원시 장안구 이목동', 'eeee@eeee.com', SYSDATE);
INSERT INTO student(no, sd_num, sd_name, sd_id, sd_passwd, s_num, sd_birth, sd_phone, sd_address, sd_email, sd_date)
                    VALUES(6, '08020001', '안익태', 'korea', 'kor1234', '02', '1994/06/01', 
                    '010-6666-6666', '본인의 주소', 'ffff@ffff.com', SYSDATE);