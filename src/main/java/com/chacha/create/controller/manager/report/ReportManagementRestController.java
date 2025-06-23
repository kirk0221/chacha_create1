package com.chacha.create.controller.manager.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chacha.create.common.entity.member.AlterMessageEntity;
import com.chacha.create.common.entity.store.ReportEntity;
import com.chacha.create.service.manager.report.ReportManagementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/manager")
public class ReportManagementRestController {
	
	@Autowired
	ReportManagementService reportManagementService;
	
	@GetMapping("/reportlist")
	public List<ReportEntity> reportlist(){
		return reportManagementService.selectAll();
	}
	
	@PostMapping("/altermessage")
	public int altermessage(AlterMessageEntity alterMessageEntity) {
		int result = 0;
		log.info("altermessage : " + alterMessageEntity.toString());
		result = reportManagementService.insert(alterMessageEntity);
		return result;
	}
}
