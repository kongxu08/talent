package com.cjwsjy.talents.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cjwsjy.talents.entity.Dm_num_cube;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuli2
 * @since 2019-07-15
 */
public interface Dm_num_cubeMapper extends BaseMapper<Dm_num_cube> {
    IPage<Dm_num_cube> highLevevlQuery(IPage page, @Param("ew")Wrapper<Dm_num_cube> wrapper);
}
