package com.springbootMock.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootMock.doMain.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {

}
