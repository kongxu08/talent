package com.cjwsjy.talents.service;

import com.cjwsjy.talents.entity.Sm_user;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.Blob;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xuli2
 * @since 2019-07-22
 */
public interface ISm_userService extends IService<Sm_user> {
    Map getPic(Map map);
}
