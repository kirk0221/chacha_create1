package com.chacha.create.common.enums.order;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 주문 상태 열거형 (order_info 테이블의 order_status 컬럼과 매핑)
 * <p>
 * - ORDER_OK: 주문 완료
 * - CONFIRM: 구매 확정
 * - REFUND: 환불 요청
 * - REFUND_OK: 환불 완료
 * </p>
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderStatusEnum {

    /** 주문 완료 (기본 상태) */
    ORDER_OK("ORDER_OK", "주문 완료"),

    /** 구매 확정 */
    CONFIRM("CONFIRM", "구매 확정"),

    /** 환불 요청 */
    REFUND("REFUND", "환불 요청"),

    /** 환불 완료 */
    REFUND_OK("REFUND_OK", "환불 완료");

    /** DB 저장용 코드 */
    private final String code;

    /** 사용자에게 보여줄 이름 */
    private final String name;

    /**
     * 문자열 코드로부터 enum 객체 생성 (역직렬화 시 사용)
     *
     * @param code DB에 저장된 주문 상태 코드
     * @return 매칭되는 OrderStatusEnum
     */
    @JsonCreator
    public static OrderStatusEnum fromCode(@JsonProperty("code") String code) {
        for (OrderStatusEnum status : values()) {
            if (status.code.equalsIgnoreCase(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid order status code: " + code);
    }
}
