-- (주의) 현재 사용자의 모든 시퀀스를 drop하는 명령어
BEGIN
  FOR seq IN (SELECT sequence_name FROM user_sequences) LOOP
    EXECUTE IMMEDIATE 'DROP SEQUENCE "' || seq.sequence_name || '"';
  END LOOP;
END;
/

-- 회원 시퀀스 
CREATE SEQUENCE seq_member_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 스토어
CREATE SEQUENCE seq_store_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 판매자
CREATE SEQUENCE seq_seller_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 상품
CREATE SEQUENCE seq_product_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 상품이미지
CREATE SEQUENCE seq_p_img_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 주문
CREATE SEQUENCE seq_order_info_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 주문상세
CREATE SEQUENCE seq_order_detail_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 배송
CREATE SEQUENCE seq_delivery_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 리뷰
CREATE SEQUENCE seq_review_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 건의사항
CREATE SEQUENCE seq_question_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 주소
CREATE SEQUENCE seq_address_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 카드
CREATE SEQUENCE seq_card_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 장바구니
CREATE SEQUENCE seq_cart_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 채팅방
CREATE SEQUENCE seq_chatroom_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 채팅
CREATE SEQUENCE seq_chatting_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 신고
CREATE SEQUENCE seq_report_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 공지사항
CREATE SEQUENCE seq_notice_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 수공예 종류 카테고리 시퀀스 생성
CREATE SEQUENCE seq_type_category_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 하위카테고리 시퀀스 생성
CREATE SEQUENCE seq_d_category_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 상위카테고리 시퀀스 생성
CREATE SEQUENCE seq_u_category_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 알림 메시지 시퀀스 생성
CREATE SEQUENCE seq_alter_message_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 이메일 인증 시퀀스 생성
CREATE SEQUENCE SEQ_AUTH_KEY_NO
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- 카테고리 값 insert
insert into type_category VALUES(seq_type_category_id.nextval, '뜨개질');
insert into type_category VALUES(seq_type_category_id.nextval, '금속공예');
insert into type_category VALUES(seq_type_category_id.nextval, '목공예');
insert into type_category VALUES(seq_type_category_id.nextval, '도자기공예');
insert into type_category VALUES(seq_type_category_id.nextval, '유리공예');
insert into type_category VALUES(seq_type_category_id.nextval, '가죽공예');
insert into type_category VALUES(seq_type_category_id.nextval, '레진공예');
insert into type_category VALUES(seq_type_category_id.nextval, '식물공예');
insert into type_category VALUES(seq_type_category_id.nextval, '양재공예');
insert into type_category VALUES(seq_type_category_id.nextval, '기타');

-- 상위 카테고리 값
insert into U_CATEGORY VALUES(seq_d_category_id.nextval, '패션잡화');
insert into U_CATEGORY VALUES(seq_d_category_id.nextval, '인테리어 소품');
insert into U_CATEGORY VALUES(seq_d_category_id.nextval, '악세서리');
insert into U_CATEGORY VALUES(seq_d_category_id.nextval, '생활잡화');
insert into U_CATEGORY VALUES(seq_d_category_id.nextval, '기타');

-- 하위 카테고리 값
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 1,'상의');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 1,'하의');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 1,'가방');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 1,'지갑');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 1,'기타(목도리, 모자, 벨트, etc)');

insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 2,'디퓨저,캔들');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 2,'무드등');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 2,'꽃,식물');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 2,'가구');

insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 3,'반지');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 3,'팔찌');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 3,'목걸이');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 3,'키링');

insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 4,'비누');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 4,'그릇');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 4,'식기류');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 4,'컵');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 4,'케이스');

insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 5,'향수');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 5,'인형');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 5,'반려동물');
insert into D_CATEGORY VALUES(seq_u_category_id.nextval, 5,'문구');

select * from d_category;
