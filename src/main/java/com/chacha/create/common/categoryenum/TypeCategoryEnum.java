package com.chacha.create.common.categoryenum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 수공예 기법 카테고리 enum (type_category 테이블과 매핑)
 * <p>
 * 상품이 어떤 종류의 공예 기술로 제작되었는지를 구분합니다.
 * DB의 {@code type_category} 테이블과 연결되며,
 * 금속공예, 목공예, 도자기공예 등 다양한 수공예 유형을 정의합니다.
 * </p>
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT) // JSON 직렬화 시 객체 형태로 변환
public enum TypeCategoryEnum {

    /** 금속을 주재료로 하는 공예 */
    METAL(1, "금속공예"),

    /** 목재를 이용한 공예 */
    WOOD(2, "목공예"),

    /** 점토를 구워 만드는 도자기 형태의 공예 */
    CERAMIC(3, "도자기공예"),

    /** 유리를 이용하여 제작하는 공예 */
    GLASS(4, "유리공예"),

    /** 동물 가죽 등을 가공하여 만든 공예 */
    LEATHER(5, "가죽공예"),

    /** 레진(수지)를 활용한 공예 */
    RESIN(6, "레진공예"),

    /** 꽃, 식물 등을 활용한 공예 */
    PLANT(7, "식물공예"),

    /** 실을 이용해 손으로 짜는 뜨개질 공예 */
    KNITTING(8, "뜨개질공예"),

    /** 천을 재단하고 바느질하여 만드는 양재공예 */
    SEWING(9, "양재공예"),

    /** 기타 위 항목에 해당하지 않는 기타 공예 */
    TYPE_ETC(10, "기타");

    /** 수공예 기법 ID (기본 키) */
    private final int id;

    /** 수공예 기법 이름 (한글) */
    private final String name;

    /**
     * ID 값을 기반으로 해당하는 enum 상수를 반환합니다.
     *
     * @param id 수공예 기법 ID
     * @return 해당 ID를 갖는 {@link TypeCategoryEnum}
     * @throws IllegalArgumentException ID가 유효하지 않을 경우 예외 발생
     */
    @JsonCreator
    public static TypeCategoryEnum fromId(@JsonProperty("id") int id) {
        for (TypeCategoryEnum t : values()) {
            if (t.id == id) return t;
        }
        throw new IllegalArgumentException("Invalid TypeCategory id: " + id);
    }
}
