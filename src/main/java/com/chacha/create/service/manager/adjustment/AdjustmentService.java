package com.chacha.create.service.manager.adjustment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.manager.ManagerAdjustmentDTO;
import com.chacha.create.common.mapper.manage.ManageMapper;
import com.chacha.create.common.mapper.member.SellerMapper;
import com.chacha.create.common.mapper.product.PImgMapper;
import com.chacha.create.common.mapper.product.ProductManageMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdjustmentService {
	
	private final ManageMapper manageMapper;
	
	public List<ManagerAdjustmentDTO> sellerAdjustment(){
		return manageMapper.sellerAdjustment();
	}
	
	public List<ManagerAdjustmentDTO> storeAdjustment(){
		return manageMapper.storeAdjustment();
	}
}
