package com.chacha.create.model.entity.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 하위 카테고리 엔티티 클래스
 * <p>
 * DB의 {@code d_category} 테이블과 매핑되는 클래스입니다.
 * 각 수공예 상품이 속한 세부 카테고리를 나타내며,
 * 상위 카테고리({@code u_category})와 외래키로 연결됩니다.
 * </p>
 *
 * <pre>
 * 예시 데이터:
 * DcategoryId: 3
 * UcategoryId: 2 (패션잡화)
 * DcategoryName: "가방"
 * </pre>
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DCategoryEntity {

    /** 하위 카테고리 고유 ID (기본 키) */
    private Integer dCategoryId;

    /** 상위 카테고리 ID (u_category 테이블의 외래키) */
    private Integer uCategoryId;

    /** 하위 카테고리 이름 (예: 가방, 반지 등) */
    private String dCategoryName;
}
