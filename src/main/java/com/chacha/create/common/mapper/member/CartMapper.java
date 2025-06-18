package com.chacha.create.common.mapper.member;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.entity.member.CartEntity;

/**
 * cart 테이블에 대한 CRUD 작업을 수행하는 MyBatis 매퍼 인터페이스입니다.
 */
@Mapper
public interface CartMapper {

    /**
     * 모든 장바구니 데이터를 조회합니다.
     * 
     * @return 장바구니 엔티티 리스트
     */
    List<CartEntity> selectAll();

    /**
     * cart_id로 특정 장바구니 데이터를 조회합니다.
     * 
     * @param cartId 조회할 장바구니 ID
     * @return 조회된 CartEntity 객체 (없으면 null)
     */
    CartEntity selectByCartId(int cartId);

    /**
     * 새로운 장바구니 데이터를 삽입합니다.
     * seq_cart_id 시퀀스를 사용하여 cart_id가 자동 생성됩니다.
     * 
     * @param entity 삽입할 CartEntity 객체
     * @return 삽입 성공 시 영향 받은 행 수
     */
    int insert(CartEntity entity);

    /**
     * 기존 장바구니 데이터를 수정합니다.
     * 
     * @param entity 수정할 CartEntity 객체
     * @return 수정 성공 시 영향 받은 행 수
     */
    int update(CartEntity entity);

    /**
     * cart_id로 장바구니 데이터를 삭제합니다.
     * 
     * @param cartId 삭제할 장바구니 ID
     * @return 삭제 성공 시 영향 받은 행 수
     */
    int delete(int cartId);
}
