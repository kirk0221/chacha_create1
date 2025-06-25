INSERT INTO member (member_id, member_email, member_name, member_pwd, member_phone, member_regi, join_date) VALUES
(seq_member_id.nextval, 'user1@example.com', '홍길동1', 'pwd1', '010-1111-1111', 'REG001', TO_DATE('2025-01-01','YYYY-MM-DD'));
INSERT INTO member (member_id, member_email, member_name, member_pwd, member_phone, member_regi, join_date) VALUES
(seq_member_id.nextval, 'user2@example.com', '홍길동2', 'pwd2', '010-2222-2222', 'REG002', TO_DATE('2025-01-02','YYYY-MM-DD'));
INSERT INTO member (member_id, member_email, member_name, member_pwd, member_phone, member_regi, join_date) VALUES
(seq_member_id.nextval, 'user3@example.com', '홍길동3', 'pwd3', '010-3333-3333', 'REG003', TO_DATE('2025-01-03','YYYY-MM-DD'));
INSERT INTO member (member_id, member_email, member_name, member_pwd, member_phone, member_regi, join_date) VALUES
(seq_member_id.nextval, 'user4@example.com', '홍길동4', 'pwd4', '010-4444-4444', 'REG004', TO_DATE('2025-01-04','YYYY-MM-DD'));
INSERT INTO member (member_id, member_email, member_name, member_pwd, member_phone, member_regi, join_date) VALUES
(seq_member_id.nextval, 'user5@example.com', '홍길동5', 'pwd5', '010-5555-5555', 'REG005', TO_DATE('2025-01-05','YYYY-MM-DD'));

INSERT INTO seller (seller_id, member_id, opening_date, account, account_bank, profile_info) VALUES
(seq_seller_id.nextval, 1, TO_DATE('2024-01-01','YYYY-MM-DD'), '123-456-7890', '국민은행', '프로필1');
INSERT INTO seller (seller_id, member_id, opening_date, account, account_bank, profile_info) VALUES
(seq_seller_id.nextval, 2, TO_DATE('2024-02-01','YYYY-MM-DD'), '234-567-8901', '신한은행', '프로필2');
INSERT INTO seller (seller_id, member_id, opening_date, account, account_bank, profile_info) VALUES
(seq_seller_id.nextval, 3, TO_DATE('2024-03-01','YYYY-MM-DD'), '345-678-9012', '하나은행', '프로필3');
INSERT INTO seller (seller_id, member_id, opening_date, account, account_bank, profile_info, personal_check) VALUES
(seq_seller_id.nextval, 4, TO_DATE('2024-04-01','YYYY-MM-DD'), '456-789-0123', '우리은행', '프로필4', 1);
INSERT INTO seller (seller_id, member_id, opening_date, account, account_bank, profile_info, personal_check) VALUES
(seq_seller_id.nextval, 5, TO_DATE('2024-05-01','YYYY-MM-DD'), '567-890-1234', '농협은행', '프로필5', 1);

INSERT INTO addr (address_id, member_id, post_num, address_road, address_detail, address_extra, address_check) VALUES
(seq_address_id.nextval, 1, '12345', '서울시 강남구', '테헤란로 123', '101동 202호', 1);
INSERT INTO addr (address_id, member_id, post_num, address_road, address_detail, address_extra, address_check) VALUES
(seq_address_id.nextval, 2, '23456', '서울시 서초구', '서초대로 456', '201동 303호', 0);
INSERT INTO addr (address_id, member_id, post_num, address_road, address_detail, address_extra, address_check) VALUES
(seq_address_id.nextval, 3, '34567', '서울시 송파구', '올림픽로 789', '301동 404호', 1);
INSERT INTO addr (address_id, member_id, post_num, address_road, address_detail, address_extra, address_check) VALUES
(seq_address_id.nextval, 4, '45678', '서울시 마포구', '마포대로 101', '401동 505호', 0);
INSERT INTO addr (address_id, member_id, post_num, address_road, address_detail, address_extra, address_check) VALUES
(seq_address_id.nextval, 5, '56789', '서울시 용산구', '용산로 202', '501동 606호', 1);

INSERT INTO card (card_id, member_id, card_num, card_company, card_token, card_alias) VALUES
(seq_card_id.nextval, 1, '1111-2222-3333-4444', '신한카드', 'token1', '나의카드1');
INSERT INTO card (card_id, member_id, card_num, card_company, card_token, card_alias) VALUES
(seq_card_id.nextval, 2, '2222-3333-4444-5555', '국민카드', 'token2', '나의카드2');
INSERT INTO card (card_id, member_id, card_num, card_company, card_token, card_alias) VALUES
(seq_card_id.nextval, 3, '3333-4444-5555-6666', '현대카드', 'token3', '나의카드3');
INSERT INTO card (card_id, member_id, card_num, card_company, card_token, card_alias) VALUES
(seq_card_id.nextval, 4, '4444-5555-6666-7777', '롯데카드', 'token4', '나의카드4');
INSERT INTO card (card_id, member_id, card_num, card_company, card_token, card_alias) VALUES
(seq_card_id.nextval, 5, '5555-6666-7777-8888', '우리카드', 'token5', '나의카드5');

INSERT INTO store (store_id, seller_id, logo_img, store_name, store_detail, store_url, sale_cnt, view_cnt) VALUES
(seq_store_id.nextval, 1, 'logo1.jpg', '스토어1', '설명1', 'store1', 10, 100);
INSERT INTO store (store_id, seller_id, logo_img, store_name, store_detail, store_url, sale_cnt, view_cnt) VALUES
(seq_store_id.nextval, 2, 'logo2.jpg', '스토어2', '설명2', 'store2', 20, 200);
INSERT INTO store (store_id, seller_id, logo_img, store_name, store_detail, store_url, sale_cnt, view_cnt) VALUES
(seq_store_id.nextval, 3, 'logo3.jpg', '스토어3', '설명3', 'store3', 30, 300);
INSERT INTO store (store_id, seller_id) VALUES
(seq_store_id.nextval, 4);
INSERT INTO store (store_id, seller_id) VALUES
(seq_store_id.nextval, 5);

INSERT INTO chatroom (chatroom_id, member_id, store_id) VALUES
(seq_chatroom_id.nextval, 1, 1);
INSERT INTO chatroom (chatroom_id, member_id, store_id) VALUES
(seq_chatroom_id.nextval, 2, 2);
INSERT INTO chatroom (chatroom_id, member_id, store_id) VALUES
(seq_chatroom_id.nextval, 3, 3);
INSERT INTO chatroom (chatroom_id, member_id, store_id) VALUES
(seq_chatroom_id.nextval, 4, 4);
INSERT INTO chatroom (chatroom_id, member_id, store_id) VALUES
(seq_chatroom_id.nextval, 5, 5);

INSERT INTO chatting (chatting_id, chatroom_id, chatting_text, chatting_date) VALUES
(seq_chatting_id.nextval, 1, '안녕하세요! 주문 문의 드립니다.', SYSDATE);
INSERT INTO chatting (chatting_id, chatroom_id, chatting_text, chatting_date) VALUES
(seq_chatting_id.nextval, 1, '안녕하세요! 무엇을 도와드릴까요?', SYSDATE);
INSERT INTO chatting (chatting_id, chatroom_id, chatting_text, chatting_date) VALUES
(seq_chatting_id.nextval, 2, '배송 언제쯤 되나요?', SYSDATE);
INSERT INTO chatting (chatting_id, chatroom_id, chatting_text, chatting_date) VALUES
(seq_chatting_id.nextval, 2, '내일 출고 예정입니다.', SYSDATE);
INSERT INTO chatting (chatting_id, chatroom_id, chatting_text, chatting_date) VALUES
(seq_chatting_id.nextval, 3, '상품 취소 가능한가요?', SYSDATE);

INSERT INTO report (report_id, member_id, seller_id, report_date, report_title, report_text) VALUES
(seq_report_id.nextval, 1, 1, SYSDATE, '욕설 및 비방', '사용자가 욕설을 포함한 메시지를 보냈습니다.');
INSERT INTO report (report_id, member_id, seller_id, report_date, report_title, report_text) VALUES
(seq_report_id.nextval, 2, 2, SYSDATE, '허위 광고', '상품 설명과 실제 상품이 다릅니다.');
INSERT INTO report (report_id, member_id, seller_id, report_date, report_title, report_text) VALUES
(seq_report_id.nextval, 3, 3, SYSDATE, '악성 댓글', '리뷰에 부적절한 댓글이 포함되어 있습니다.');
INSERT INTO report (report_id, member_id, seller_id, report_date, report_title, report_text) VALUES
(seq_report_id.nextval, 4, 4, SYSDATE, '스팸 메시지', '반복적인 광고 메시지를 보냈습니다.');
INSERT INTO report (report_id, member_id, seller_id, report_date, report_title, report_text) VALUES
(seq_report_id.nextval, 5, 5, SYSDATE, '불량 제품', '상품이 고장 난 상태로 도착했습니다.');

INSERT INTO notice (notice_id, store_id, notice_check, notice_title, notice_text, notice_date) VALUES
(seq_notice_id.nextval, 1, 0, '시스템 점검 안내', '2025년 6월 30일 00시부터 06시까지 시스템 점검이 진행됩니다.', SYSDATE);
INSERT INTO notice (notice_id, store_id, notice_check, notice_title, notice_text, notice_date) VALUES
(seq_notice_id.nextval, 2, 1, '신규 이벤트 안내', '7월 한달간 특별 할인 이벤트를 진행합니다.', SYSDATE);
INSERT INTO notice (notice_id, store_id, notice_check, notice_title, notice_text, notice_date) VALUES
(seq_notice_id.nextval, 3, 0, '배송 지연 안내', '일부 지역 배송이 지연되고 있습니다.', SYSDATE);
INSERT INTO notice (notice_id, store_id, notice_check, notice_title, notice_text, notice_date) VALUES
(seq_notice_id.nextval, 4, 1, '서비스 이용약관 변경', '서비스 이용약관이 일부 변경되었습니다.', SYSDATE);
INSERT INTO notice (notice_id, store_id, notice_check, notice_title, notice_text, notice_date) VALUES
(seq_notice_id.nextval, 5, 1, '회원 혜택 안내', '신규 회원 가입 시 5,000원 쿠폰을 드립니다.', SYSDATE);

INSERT INTO product (product_id, store_id, type_category_id, d_category_id, product_name, price, product_detail, stock, product_date, last_modified_date, sale_cnt, view_cnt, flagship_check) VALUES
(seq_product_id.nextval, 1, 1, 1, '상품1', 10000, '상세설명1', 50, TO_DATE('2025-05-01','YYYY-MM-DD'), TO_DATE('2025-05-10','YYYY-MM-DD'), 5, 100, 1);
INSERT INTO product (product_id, store_id, type_category_id, d_category_id, product_name, price, product_detail, stock, product_date, last_modified_date, sale_cnt, view_cnt, flagship_check) VALUES
(seq_product_id.nextval, 2, 2, 2, '상품2', 20000, '상세설명2', 30, TO_DATE('2025-05-02','YYYY-MM-DD'), TO_DATE('2025-05-11','YYYY-MM-DD'), 15, 150, 0);
INSERT INTO product (product_id, store_id, type_category_id, d_category_id, product_name, price, product_detail, stock, product_date, last_modified_date, sale_cnt, view_cnt, flagship_check) VALUES
(seq_product_id.nextval, 3, 3, 3, '상품3', 30000, '상세설명3', 20, TO_DATE('2025-05-03','YYYY-MM-DD'), TO_DATE('2025-05-12','YYYY-MM-DD'), 25, 200, 0);
INSERT INTO product (product_id, store_id, type_category_id, d_category_id, product_name, price, product_detail, stock, product_date, last_modified_date, sale_cnt, view_cnt, flagship_check) VALUES
(seq_product_id.nextval, 4, 4, 4, '상품4', 40000, '상세설명4', 40, TO_DATE('2025-05-04','YYYY-MM-DD'), TO_DATE('2025-05-13','YYYY-MM-DD'), 35, 250, 1);
INSERT INTO product (product_id, store_id, type_category_id, d_category_id, product_name, price, product_detail, stock, product_date, last_modified_date, sale_cnt, view_cnt, flagship_check) VALUES
(seq_product_id.nextval, 5, 5, 5, '상품5', 50000, '상세설명5', 10, TO_DATE('2025-05-05','YYYY-MM-DD'), TO_DATE('2025-05-14','YYYY-MM-DD'), 45, 300, 0);

INSERT INTO p_img (p_img_id, product_id, p_img_url, p_img_enum, p_img_seq) VALUES
(seq_p_img_id.nextval, 1, 'prod1_thumb.jpg', 'THUMBNAIL', 1);
INSERT INTO p_img (p_img_id, product_id, p_img_url, p_img_enum, p_img_seq) VALUES
(seq_p_img_id.nextval, 1, 'prod1_desc1.jpg', 'DESCRIPTION', 2);
INSERT INTO p_img (p_img_id, product_id, p_img_url, p_img_enum, p_img_seq) VALUES
(seq_p_img_id.nextval, 2, 'prod2_thumb.jpg', 'THUMBNAIL', 1);
INSERT INTO p_img (p_img_id, product_id, p_img_url, p_img_enum, p_img_seq) VALUES
(seq_p_img_id.nextval, 3, 'prod3_thumb.jpg', 'THUMBNAIL', 1);
INSERT INTO p_img (p_img_id, product_id, p_img_url, p_img_enum, p_img_seq) VALUES
(seq_p_img_id.nextval, 4, 'prod4_thumb.jpg', 'THUMBNAIL', 1);

INSERT INTO order_info (order_id, member_id, order_date, order_name, order_phone, address_id, card_id, order_status) VALUES
(seq_order_info_id.nextval, 1, SYSDATE, '홍길동', '010-1111-1111', 1, 1, 'ORDER_OK');
INSERT INTO order_info (order_id, member_id, order_date, order_name, order_phone, address_id, card_id, order_status) VALUES
(seq_order_info_id.nextval, 2, SYSDATE, '김철수', '010-2222-2222', 2, 2, 'CONFIRM');
INSERT INTO order_info (order_id, member_id, order_date, order_name, order_phone, address_id, card_id, order_status) VALUES
(seq_order_info_id.nextval, 3, SYSDATE, '이영희', '010-3333-3333', 3, 3, 'REFUND');
INSERT INTO order_info (order_id, member_id, order_date, order_name, order_phone, address_id, card_id, order_status) VALUES
(seq_order_info_id.nextval, 4, SYSDATE, '박민수', '010-4444-4444', 4, 4, 'REFUND_OK');
INSERT INTO order_info (order_id, member_id, order_date, order_name, order_phone, address_id, card_id, order_status) VALUES
(seq_order_info_id.nextval, 5, SYSDATE, '최지우', '010-5555-5555', 5, 5, 'ORDER_OK');

INSERT INTO order_detail (order_detail_id, order_id, product_id, order_cnt, order_price) VALUES
(seq_order_detail_id.nextval, 1, 1, 2, 20000);
INSERT INTO order_detail (order_detail_id, order_id, product_id, order_cnt, order_price) VALUES
(seq_order_detail_id.nextval, 2, 2, 1, 20000);
INSERT INTO order_detail (order_detail_id, order_id, product_id, order_cnt, order_price) VALUES
(seq_order_detail_id.nextval, 3, 3, 3, 90000);
INSERT INTO order_detail (order_detail_id, order_id, product_id, order_cnt, order_price) VALUES
(seq_order_detail_id.nextval, 4, 4, 1, 40000);
INSERT INTO order_detail (order_detail_id, order_id, product_id, order_cnt, order_price) VALUES
(seq_order_detail_id.nextval, 5, 5, 5, 250000);

INSERT INTO delivery (delivery_id, order_id, delivery_check, delivery_date, delivery_fin_date) VALUES
(seq_delivery_id.nextval, 1, 0, TO_DATE('2025-06-01','YYYY-MM-DD'), TO_DATE('2025-06-03','YYYY-MM-DD'));
INSERT INTO delivery (delivery_id, order_id, delivery_check, delivery_date, delivery_fin_date) VALUES
(seq_delivery_id.nextval, 2, 0, TO_DATE('2025-06-02','YYYY-MM-DD'), TO_DATE('2025-06-04','YYYY-MM-DD'));
INSERT INTO delivery (delivery_id, order_id, delivery_check, delivery_date, delivery_fin_date) VALUES
(seq_delivery_id.nextval, 3, 0, TO_DATE('2025-06-03','YYYY-MM-DD'), TO_DATE('2025-06-05','YYYY-MM-DD'));
INSERT INTO delivery (delivery_id, order_id, delivery_check, delivery_date, delivery_fin_date) VALUES
(seq_delivery_id.nextval, 4, 0, TO_DATE('2025-06-04','YYYY-MM-DD'), TO_DATE('2025-06-06','YYYY-MM-DD'));
INSERT INTO delivery (delivery_id, order_id, delivery_check, delivery_date, delivery_fin_date) VALUES
(seq_delivery_id.nextval, 5, 0, TO_DATE('2025-06-05','YYYY-MM-DD'), TO_DATE('2025-06-07','YYYY-MM-DD'));


INSERT INTO question (question_id, member_id, question_date, question_title, question_text) VALUES
(seq_question_id.nextval, 1, SYSDATE, '문의사항1', '내용1');
INSERT INTO question (question_id, member_id, question_date, question_title, question_text) VALUES
(seq_question_id.nextval, 2, SYSDATE, '문의사항2', '내용2');
INSERT INTO question (question_id, member_id, question_date, question_title, question_text) VALUES
(seq_question_id.nextval, 3, SYSDATE, '문의사항3', '내용3');
INSERT INTO question (question_id, member_id, question_date, question_title, question_text) VALUES
(seq_question_id.nextval, 4, SYSDATE, '문의사항4', '내용4');
INSERT INTO question (question_id, member_id, question_date, question_title, question_text) VALUES
(seq_question_id.nextval, 5, SYSDATE, '문의사항5', '내용5');

INSERT INTO cart (cart_id, member_id, product_id, product_cnt) VALUES
(seq_cart_id.nextval, 1, 1, 2);
INSERT INTO cart (cart_id, member_id, product_id, product_cnt) VALUES
(seq_cart_id.nextval, 2, 2, 1);
INSERT INTO cart (cart_id, member_id, product_id, product_cnt) VALUES
(seq_cart_id.nextval, 3, 3, 3);
INSERT INTO cart (cart_id, member_id, product_id, product_cnt) VALUES
(seq_cart_id.nextval, 4, 4, 1);
INSERT INTO cart (cart_id, member_id, product_id, product_cnt) VALUES
(seq_cart_id.nextval, 5, 5, 5);

INSERT INTO review (review_id, order_detail_id, review_date, review_text) VALUES
(seq_review_id.nextval, 1, SYSDATE, '좋은 상품입니다.');
INSERT INTO review (review_id, order_detail_id, review_date, review_text) VALUES
(seq_review_id.nextval, 2, SYSDATE, '만족합니다.');
INSERT INTO review (review_id, order_detail_id, review_date, review_text) VALUES
(seq_review_id.nextval, 3, SYSDATE, '배송이 빨랐어요.');
INSERT INTO review (review_id, order_detail_id, review_date, review_text) VALUES
(seq_review_id.nextval, 4, SYSDATE, '포장이 꼼꼼했어요.');
INSERT INTO review (review_id, order_detail_id, review_date, review_text) VALUES
(seq_review_id.nextval, 5, SYSDATE, '재구매 의사 있습니다.');

INSERT INTO alter_message (alter_message_id, member_id, message_title, message_content) VALUES
(seq_alter_message_id.nextval, 1, '주문 배송 안내', '고객님의 주문이 배송 중입니다.');
INSERT INTO alter_message (alter_message_id, member_id, message_title, message_content) VALUES
(seq_alter_message_id.nextval, 2, '이벤트 당첨 소식', '축하합니다! 이벤트에 당첨되셨습니다.');
INSERT INTO alter_message (alter_message_id, member_id, message_title, message_content) VALUES
(seq_alter_message_id.nextval, 3, '비밀번호 변경 안내', '비밀번호가 성공적으로 변경되었습니다.');
INSERT INTO alter_message (alter_message_id, member_id, message_title, message_content) VALUES
(seq_alter_message_id.nextval, 4, '리뷰 작성 요청', '구매하신 상품에 대한 리뷰를 작성해주세요.');
INSERT INTO alter_message (alter_message_id, member_id, message_title, message_content) VALUES
(seq_alter_message_id.nextval, 5, '포인트 소멸 안내', '일부 포인트가 이번 달 말에 소멸됩니다.');

-- 커밋
commit;