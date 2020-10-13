package com.cjwsjy.talents.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CustomMapper {
    @Select("${sql}")
    List<Map> custom(@Param("sql") String sql);
}
