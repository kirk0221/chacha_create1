package com.chacha.create.service.seller.shut_down;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chacha.create.common.entity.store.StoreEntity;
import com.chacha.create.common.enums.order.OrderStatusEnum;
import com.chacha.create.common.mapper.order.OrderInfoMapper;
import com.chacha.create.common.mapper.store.StoreMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ShutDownService {

	private final StoreMapper storeMapper;
	private final OrderInfoMapper orderInfoMapper;
	
	@Autowired
	public ShutDownService(StoreMapper storeMapper, OrderInfoMapper orderInfoMapper) {
		this.storeMapper = storeMapper;
		this.orderInfoMapper = orderInfoMapper;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int shutdown(String storeUrl) {
		StoreEntity thisStore = storeMapper.selectByStoreUrl(storeUrl);
		StoreEntity storeEntity = StoreEntity.builder()
		.storeId(thisStore.getStoreId())
		.sellerId(thisStore.getSellerId())
		.logoImg(null)
		.storeName(null)
		.storeDetail(null)
		.storeUrl(null)
		.saleCnt(null)
		.viewCnt(null)
		.build();
		
		List<OrderStatusEnum> orderStatuses = orderInfoMapper.selectForOrderStatus(storeUrl);
		
	    boolean hasOrderOk = orderStatuses.stream()
	            .anyMatch(status -> status == OrderStatusEnum.ORDER_OK);

        if (hasOrderOk) {
            throw new IllegalStateException("모든 주문이 처리 완료가 되지않아 폐점할 수 없습니다.");
        }
		
		return storeMapper.update(storeEntity);
	}
	
}
