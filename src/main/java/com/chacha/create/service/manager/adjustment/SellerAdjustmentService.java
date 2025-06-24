package com.chacha.create.service.manager.adjustment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.dto.manager.ManagerAdjustmentDTO;
import com.chacha.create.common.mapper.member.SellerMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SellerAdjustmentService {
	
	@Autowired
	SellerMapper sellerMapper;
	
	public List<ManagerAdjustmentDTO> sellerAdjustment(){
		return sellerMapper.sellerAdjustment();
	}
}
