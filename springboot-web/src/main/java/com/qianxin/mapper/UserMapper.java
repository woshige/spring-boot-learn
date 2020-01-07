package com.qianxin.mapper;

import com.qianxin.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insert(User user);
    User findById(int id);
}
