package com.chacha.create.util;

public class ServiceUtil {

    // 카드 번호 보안(뒤 네 자리만 나오도록)
    public static String maskCardNumber(String cardNum) {
        if (cardNum == null || cardNum.length() < 4) return "";
        return "****-****-****-" + cardNum.substring(cardNum.length() - 4);
	}
}
