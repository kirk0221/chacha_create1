package com.chacha.create.common.enums.image;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 상품 이미지 타입 열거형 (p_img 테이블의 p_img_enum 컬럼과 매핑)
 * <p>
 * - THUMBNAIL: 상품 썸네일 이미지 (대표 이미지) - DESCRIPTION: 상품 상세 설명용 이미지
 * </p>
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ProductImageTypeEnum {

	/** 상품 썸네일 이미지 (대표 이미지) */
	THUMBNAIL("THUMBNAIL", "썸네일"),

	/** 상품 상세 설명 이미지 */
	DESCRIPTION("DESCRIPTION", "상세설명");

	/** DB 저장용 키 값 (문자열) */
	private final String code;

	/** 사용자에게 보여줄 이름 */
	private final String name;

	/**
	 * 문자열 코드로부터 enum 객체 생성 (역직렬화 시 사용)
	 * 
	 * @param code DB에 저장된 이미지 타입 문자열
	 * @return 대응되는 enum 객체
	 */
	@JsonCreator
	public static ProductImageTypeEnum fromCode(@JsonProperty("code") String code) {
		for (ProductImageTypeEnum type : values()) {
			if (type.code.equalsIgnoreCase(code)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Invalid image type code: " + code);
	}
}