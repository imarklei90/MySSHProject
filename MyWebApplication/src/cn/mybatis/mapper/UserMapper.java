package cn.mybatis.mapper;

import cn.mybatis.entity.User;

public interface UserMapper {
	public User findUserById(int id);
}
