package com.cjwsjy.talents.dao;

import com.cjwsjy.talents.entity.Sm_user;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.sql.Blob;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xuli2
 * @since 2019-07-22
 */
public interface Sm_userMapper extends BaseMapper<Sm_user> {
    Map getPic(Map map);
}
