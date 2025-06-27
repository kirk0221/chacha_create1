package com.chacha.create.util.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chacha.create.common.entity.member.MemberEntity;
import com.chacha.create.common.entity.member.SellerEntity;
import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.common.enums.error.ResponseCode;
import com.chacha.create.common.mapper.member.SellerMapper;
import com.chacha.create.common.mapper.store.StoreMapper;

public class LoginAuthorizationFilter implements Filter {

    private SellerMapper sellerMapper;
    private StoreMapper storeMapper;

    public LoginAuthorizationFilter(SellerMapper sellerMapper, StoreMapper storeMapper) {
        this.sellerMapper = sellerMapper;
        this.storeMapper = storeMapper;
    }

    @Override
    public void init(FilterConfig filterConfig) { /* 필요시 사용 */ }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        HttpSession session = req.getSession(false);
        MemberEntity loginMember = (session != null) ? (MemberEntity) session.getAttribute("loginMember") : null;

        // 로그인 체크
        if (loginMember == null) {
            res.sendError(ResponseCode.UNAUTHORIZED.getStatus(), "로그인이 필요합니다.");
            return;
        }

        Integer memberId = loginMember.getMemberId();

        // /sell 하위 경로 - 개인 판매자만 접근
        if (uri.startsWith("/sell")) {
            SellerEntity seller = sellerMapper.selectByMemberId(memberId);
            if (seller == null || seller.getPersonalCheck() != 1) {
                res.sendError(ResponseCode.FORBIDDEN.getStatus(), "개인 판매자만 접근 가능합니다.");
                return;
            }
        }

        // /seller/{storeUrl} 하위 경로 - 해당 스토어 판매자만 접근
        else if (uri.startsWith("/seller/")) {
            String[] parts = uri.split("/");
            if (parts.length >= 3) {
                String storeUrl = parts[2];
                StoreEntity store = storeMapper.selectByStoreUrl(storeUrl);
                if (store == null || !isStoreOwner(store, memberId)) {
                    res.sendError(ResponseCode.FORBIDDEN.getStatus(), "해당 스토어의 판매자만 접근 가능합니다.");
                    return;
                }
            }
        }

        // /admin 경로 - 관리자(memberId == 1)만 접근
        else if (uri.startsWith("/manager")) {
            if (!memberId.equals(1)) {
                res.sendError(ResponseCode.FORBIDDEN.getStatus(), "관리자만 접근 가능합니다.");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    private boolean isStoreOwner(StoreEntity store, Integer memberId) {
        SellerEntity seller = sellerMapper.selectBySellerId(store.getSellerId());
        return seller != null && seller.getMemberId().equals(memberId);
    }

    @Override
    public void destroy() { /* 필요시 사용 */ }
}