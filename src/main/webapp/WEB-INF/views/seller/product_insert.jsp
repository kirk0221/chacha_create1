<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�߶���ȸ �Ǹ��� ��ǰ���</title>
<link rel="stylesheet" type="text/css" href="resources/css/authmain.css">
<link rel="stylesheet" type="text/css" href="resources/css/product_insert.css">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script src="https://code.iconify.design/iconify-icon/1.0.8/iconify-icon.min.js"></script>
</head>
<body>
<div class="wrapper">
  <header>
    <div class="header-inner">
      <div class="login-bar">
        <span>�������߰�� �ݰ����ϴ�.</span>
        <button class="logout-btn">�α׾ƿ�</button>
      </div>
    </div>
  </header>

  <div class="main-area">
    <div class="content-wrapper">
      <nav class="sidebar">
		  <div class="profile-section" onclick="#" role="button" tabindex="0" aria-label="�������� �������� �̵�">
		    <img src="_11.png" class="profile-img" />
		    <div class="store-name">�������߰�</div>
		  </div>
		  <ul class="menu-list">
		    <li><a href="#"><span class="menu-text">��ǰ���</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">�ǸŻ�ǰ����</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">�ֹ�/�߼�Ȯ��(���/ȯ��)</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">ȯ�Ұ���</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">�������</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">���Ǹ޽���</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">�������</span><span class="arrow">></span></a></li>
		    <li><a href="#"><span class="menu-text">��������</span><span class="arrow">></span></a></li>
		  </ul>
		  <div class="sidebar-footer">
		    <button class="btn-go-buyer" onclick="#">������������ �̵�</button>
		  </div>
		</nav>

      <main class="content">
        <div class="content-inner">
			<div class="frame-1075">
				<div class="top-bar">
				  <h2>��ǰ ���</h2>
				  <div class="top-action">
				    <button class="icon-button2">
				      <iconify-icon icon="mdi:plus" class="icon-plus"></iconify-icon>
				    </button>
				  </div>
				</div>
			 <div class="form-body-row">
	          <div class="frame-1076">
	            <button class="frame-817-btn" type="button" aria-label="�߰� ��ư">
				  <iconify-icon icon="mdi:plus" class="icon-plus"></iconify-icon>
				</button>
	            <div class="frame-1077">
				  <button class="frame-8152-btn">
				    <div class="frame-8152"></div>
				  </button>
				  <button class="frame-8152-btn">
				    <div class="frame-8152"></div>
				  </button>
				</div>
				<div class="frame-1078">
				  <button class="icon-button">
				    <iconify-icon icon="mdi:menu" class="icon-menu"></iconify-icon>
				  </button>
				  <button class="icon-button">
				    <iconify-icon icon="mdi:menu" class="icon-menu"></iconify-icon>
				  </button>
				</div>
	          </div>
	          <div class="frame-1196">
	            <div class="frame-1079">
	              <div class="text-area">
					  <div class="div17">��ǰ �̸�</div>
					  <input type="text" class="box" placeholder="������ �Է��ϼ���" />
					  <div class="counter-low">
					    <div class="_12">1</div>
					    <div class="_100">/50</div>
					  </div>
					</div>
	              <div class="text-input">
					  <div class="div17">��ǰ ����</div>
					  <input type="number" class="box2" placeholder="���� X, number 1�� ������" />
					</div>
	              <div class="text-area2">
	  <div class="div17">��ǰ ����</div>
	  <textarea class="box" placeholder="������ �Է��ϼ���"></textarea>
	  <div class="counter-low">
	    <div class="_12">1</div>
	    <div class="_100">/3000</div>
	  </div>
	</div>
	              <div class="group-90">
	                <div class="div20">��ǰ ī�װ�</div>
						<div class="frame-10772">
						  <div class="frame-8153">
						    <select class="category-select">
						      <option selected disabled>��з� ����</option>
						      <option>�ݼӰ���</option>
						      <option>�����</option>
						      <option>���ڱ����</option>
						      <option>��������</option>
						      <option>���װ���</option>
						      <option>��������</option>
						      <option>�Ĺ�����</option>
						      <option>�߰�������</option>
						      <option>�������</option>
						      <option>��Ÿ</option>
						    </select>
						  </div>
						  <div class="frame-816">
						    <select class="category-select">
						      <option selected disabled>�ߺз� ����</option>
						      <option>����</option>
						      <option>�м���ȭ</option>
						      <option>���׸��� ��ǰ</option>
						      <option>�Ǽ�����</option>
						      <option>��Ȱ��ȭ</option>
						      <option>��Ÿ</option>
						    </select>
						  </div>
						  <div class="frame-8172">
						    <select class="category-select">
						      <option selected disabled>�Һз� ����</option>
						      <option>����</option>
						      <option>����</option>
						      <option>����</option>
						      <option>����</option>
						      <option>��Ÿ(�񵵸�, ����, ��Ʈ ��)</option>
						    </select>
						  </div>
						</div>
	                </div>
	              <div class="text-input">
					  <div class="div17">��ǰ ������</div>
					  <input type="number" class="box2" placeholder="�ִ� 9,999��" />
					</div>
	              </div>
	              <div class="frame-774">
	              <div class="button2">
	                <div class="div21">����</div>
	              </div>
	         </div>
        </div>
      </main>
    </div>
  </div>

  <footer>&copy; 2025 �߶���ȸ</footer>
</div>
</body>
</html>