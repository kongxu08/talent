package com.cjwsjy.talents.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cjwsjy.talents.entity.Dm_num_cube;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuli2
 * @since 2019-07-15
 */
public interface IDm_num_cubeService extends IService<Dm_num_cube> {
    IPage<Dm_num_cube> highLevevlQuery(IPage page, Wrapper<Dm_num_cube> wrapper);
}
