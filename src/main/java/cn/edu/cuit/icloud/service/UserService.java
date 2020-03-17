package cn.edu.cuit.icloud.service;

import java.util.List;

import cn.edu.cuit.icloud.pojo.User;

/**
 * TODO
 * @date: 2020年3月10日
 * @author: flfan
 */
public interface UserService {
	/**
	 * 根据用户ID查找用户
	 * @param userId
	 * @return 用户信息
	 */
	public User findUserById(int userId);
	
	/**
	 * 查找所有用户
	 * @return
	 */
	public List<User> findAllUser();
	/**
	 * 注册或添加用户
	 * @param user 用户信息
	 * @return 是否成功状态值
	 */
	public int addUser(User user);
	/**
	 * 删除用户
	 * @param user 用户信息
	 * @return 是否成功状态值
	 */
	public int deleteUserById(int userId);
	/**
	 * 更新用户
	 * @param user 用户信息
	 * @return 是否成功状态值
	 */
	public int updateUser(User user);
	
}
