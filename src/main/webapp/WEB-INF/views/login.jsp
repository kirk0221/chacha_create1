<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
    <link rel="stylesheet" type="text/css" href="resources/css/login_vars.css">
    <link rel="stylesheet" type="text/css" href="resources/css/login_style.css">
</head>
<body>
<div class="div">
    <div class="login_entire">
        <form action="${pageContext.request.contextPath}/login" method="post">
            <img class="logo_frame" src="resources/images/logo/logo_green.png" alt="Logo"/>
            <div class="div3">
                <div class="frame-758">
                    <div class="frame-757">
                        <div class="email_password_frame">
                            <input type="email" name="email" class="input-box" placeholder="이메일" required>
                        </div>
                        <div class="email_password_frame">
                            <input type="password" name="password" class="input-box" placeholder="비밀번호" required>
                        </div>
                        <div class="checkbox">
                            <div class="checkbox2">
                                <div class="item">
                                    <input type="checkbox" id="rememberId" name="rememberId" class="checkbox-item">
                                </div>
                                <div class="label">
                                    <label for="rememberId" class="rememberId_frame">아이디 기억하기</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="frame-752">
                        <button type="submit" class="component_login">
                            <div class="div6">로그인</div>
                        </button>
                        <div class="frame-751">
						    <div class="div7">비밀번호를 잊으셨나요?</div>
						    <a href="${pageContext.request.contextPath}/signup" class="div8">회원가입</a>
						</div>
                    </div>
                </div>
            </div>
            <div class="div9">
			    <div class="line"></div>
			    <div class="div10">소셜로그인</div>
			    <div class="line"></div>
			</div>

            <div class="social-login">
		    <a href="#" class="naver-btn">
			  <img src="resources/images/login/naver_icon.png" alt="네이버" style="width:24px; height:24px; margin-right:10px;">
			  네이버 로그인
			</a>

			<a href="#" class="kakao-btn">
			  <img src="resources/images/login/kakao_icon.png" alt="카카오" style="width:24px; height:24px; margin-right:10px;">
			  카카오 로그인
			</a>

		</div>
        </form>
    </div>
</div>
</body>
</html>
