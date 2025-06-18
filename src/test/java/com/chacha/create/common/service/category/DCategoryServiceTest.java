package com.chacha.create.common.service.category;

import com.chacha.create.common.entity.category.DCategoryEntity;
import com.chacha.create.common.enums.category.DCategoryEnum;
import com.chacha.create.common.enums.category.UCategoryEnum;
import com.chacha.create.common.mapper.category.DCategoryMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:spring/root-context.xml",   // Spring Bean 설정 파일 위치에 맞게 수정하세요.
    "classpath:spring/mybatis-config.xml"  // MyBatis 설정 파일 경로가 있다면 포함
})
@Transactional
@Rollback(true)  // 테스트 후 롤백 (DB 원상복구)
public class DCategoryServiceTest {

    @Autowired
    private DCategoryService dCategoryService;

    @Autowired
    private DCategoryMapper dCategoryMapper;

    @Test
    public void testInsertAndSelect() {
        // given
        DCategoryEnum dEnum = DCategoryEnum.BAG;
        UCategoryEnum uEnum = UCategoryEnum.FASHION;
        String name = "테스트 가방";

        // when
        dCategoryService.insertDCategory(dEnum, uEnum, name);

        // then
        DCategoryEntity result = dCategoryMapper.selectByDCategoryId(dEnum.ordinal());
        assertNotNull(result);
        assertEquals(dEnum, result.getDCategoryId());
        assertEquals(uEnum, result.getUCategoryId());
        assertEquals(name, result.getDCategoryName());
    }

    @Test
    public void testUpdate() {
        // given
        DCategoryEnum dEnum = DCategoryEnum.RING;
        dCategoryService.insertDCategory(dEnum, UCategoryEnum.FASHION, "반지");

        // when
        dCategoryService.updateDCategory(dEnum, UCategoryEnum.ACCESSORY, "수정된 반지");

        // then
        DCategoryEntity result = dCategoryMapper.selectByDCategoryId(dEnum.ordinal());
        assertEquals("수정된 반지", result.getDCategoryName());
        assertEquals(UCategoryEnum.ACCESSORY, result.getUCategoryId());
    }

    @Test
    public void testDelete() {
        // given
        DCategoryEnum dEnum = DCategoryEnum.NECKLACE;
        dCategoryService.insertDCategory(dEnum, UCategoryEnum.ACCESSORY, "목걸이");

        // when
        dCategoryService.deleteDCategory(dEnum);

        // then
        DCategoryEntity deleted = dCategoryMapper.selectByDCategoryId(dEnum.ordinal());
        assertNull(deleted);
    }

    @Test
    public void testSelectAll() {
        List<DCategoryEntity> list = dCategoryMapper.selectAll();
        assertNotNull(list);
        // assertFalse(list.isEmpty()); // 필요시
    }
}
