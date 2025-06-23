package com.chacha.create.common.mapper.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chacha.create.common.entity.order.ReviewEntity;

/**
 * {@code review} 테이블에 대한 MyBatis 매퍼 인터페이스입니다.
 * 리뷰 등록, 조회, 수정, 삭제 기능을 제공합니다.
 */
@Mapper
public interface ReviewMapper {

    /**
     * 모든 리뷰를 조회합니다.
     *
     * @return 전체 리뷰 목록 ({@code List<ReviewEntity>})
     */
    List<ReviewEntity> selectAll();

    /**
     * 리뷰 ID로 단일 리뷰를 조회합니다.
     *
     * @param reviewId 리뷰 ID
     * @return 해당 리뷰 ID의 리뷰 객체
     */
    ReviewEntity selectById(int reviewId);

    /**
     * 주문 상세 ID로 리뷰를 조회합니다.
     * 하나의 주문 상세(order_detail)에 하나의 리뷰만 작성된다는 전제가 필요합니다.
     *
     * @param orderDetailId 주문 상세 ID
     * @return 해당 주문 상세에 대한 리뷰 객체
     */
    ReviewEntity selectByOrderDetailId(int orderDetailId);

    /**
     * 새로운 리뷰를 삽입합니다.
     * 리뷰 ID는 시퀀스(seq_review_id.NEXTVAL)로 생성됩니다.
     *
     * @param reviewEntity 추가할 리뷰 객체
     * @return 삽입된 행 수
     */
    int insert(ReviewEntity reviewEntity);

    /**
     * 기존 리뷰 정보를 수정합니다.
     *
     * @param reviewEntity 수정할 리뷰 객체
     * @return 수정된 행 수
     */
    int update(ReviewEntity reviewEntity);

    /**
     * 리뷰 ID로 리뷰를 삭제합니다.
     *
     * @param reviewId 삭제할 리뷰 ID
     * @return 삭제된 행 수
     */
    int delete(int reviewId);
    
    List<ReviewEntity> selectByMemberId(int memberId);
    
    
}
