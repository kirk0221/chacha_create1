package com.chacha.create.common.enums.category;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 상위 카테고리 열거형(enum) 클래스.
 * <p>
 * u_category 테이블과 매핑되며, 수공예 상품의 대분류(공예, 패션잡화 등)를 정의합니다.
 * JSON 직렬화 시 {@code {id, name}} 형태의 객체로 반환되며,
 * 역직렬화 시 {@code id} 값을 기반으로 해당 enum 인스턴스를 반환할 수 있습니다.
 * </p>
 *
 * <pre>
 * 예시 JSON 응답:
 * {
 *   "id": 2,
 *   "name": "패션잡화"
 * }
 * </pre>
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UCategoryEnum {
    CRAFT(1, "공예"),
    FASHION(2, "패션잡화"),
    INTERIOR(3, "인테리어 소품"),
    ACCESSORY(4, "악세서리"),
    LIFESTYLE(5, "생활잡화"),
    ETC(6, "기타");

    /** 상위 카테고리 고유 ID (DB의 u_category_id와 매핑됨) */
    private final int id;

    /** 상위 카테고리 이름 */
    private final String name;

    /**
     * 주어진 ID에 해당하는 상위 카테고리 enum 값을 반환합니다.
     *
     * @param id 상위 카테고리 ID
     * @return ID에 해당하는 {@link UCategoryEnum} 값
     * @throws IllegalArgumentException 해당 ID에 대응하는 enum 값이 없는 경우 예외 발생
     */
    @JsonCreator
    public static UCategoryEnum fromId(@JsonProperty("id") int id) {
        for (UCategoryEnum category : values()) {
            if (category.id == id) return category;
        }
        throw new IllegalArgumentException("Invalid UCategory id: " + id);
    }
}
