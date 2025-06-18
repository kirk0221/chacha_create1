package com.chacha.create.common.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chacha.create.common.entity.category.DCategoryEntity;
import com.chacha.create.common.enums.category.DCategoryEnum;
import com.chacha.create.common.enums.category.UCategoryEnum;
import com.chacha.create.common.mapper.category.DCategoryMapper;

@Service
public class DCategoryService {

    @Autowired
    private DCategoryMapper dCategoryMapper;

    /**
     * 전체 상세 카테고리 조회
     */
    public List<DCategoryEntity> getAllCategories() {
        return dCategoryMapper.selectAll();
    }

    /**
     * 상세 카테고리 ID로 조회
     */
    public DCategoryEntity getByDCategoryId(DCategoryEnum dCategory) {
        return dCategoryMapper.selectByDCategoryId(dCategory.ordinal());
    }

    /**
     * 상위 카테고리 ID로 조회
     */
    public List<DCategoryEntity> getByUCategoryId(UCategoryEnum uCategory) {
        return dCategoryMapper.selectByUCategoryId(uCategory.ordinal());
    }

    /**
     * 상세 카테고리 등록
     */
    public void insertDCategory(DCategoryEnum dCategory, UCategoryEnum uCategory, String name) {
        DCategoryEntity entity = DCategoryEntity.builder()
                .dCategoryId(dCategory)
                .uCategoryId(uCategory)
                .dCategoryName(name)
                .build();
        dCategoryMapper.insert(entity);
    }

    /**
     * 상세 카테고리 수정
     */
    public void updateDCategory(DCategoryEnum dCategory, UCategoryEnum uCategory, String name) {
        DCategoryEntity entity = DCategoryEntity.builder()
                .dCategoryId(dCategory)
                .uCategoryId(uCategory)
                .dCategoryName(name)
                .build();
        dCategoryMapper.update(entity);
    }

    /**
     * 상세 카테고리 삭제
     */
    public void deleteDCategory(DCategoryEnum dCategory) {
        dCategoryMapper.delete(dCategory.ordinal());
    }
}
