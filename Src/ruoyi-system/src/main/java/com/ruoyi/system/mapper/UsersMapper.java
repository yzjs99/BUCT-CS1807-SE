package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Users;

/**
 * 用户Mapper接口
 * 
 * @author ruoyi
 * @date 2021-05-10
 */
public interface UsersMapper 
{
    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    public Users selectUsersById(Long id);
    public Users selectUsersByPhone(String phone);
    /**
     * 查询用户列表
     * 
     * @param users 用户
     * @return 用户集合
     */
    public List<Users> selectUsersList(Users users);

    /**
     * 新增用户
     * 
     * @param users 用户
     * @return 结果
     */
    public int insertUsers(Users users);

    /**
     * 修改用户
     * 
     * @param users 用户
     * @return 结果
     */
    public int updateUsers(Users users);

    /**
     * 删除用户
     * 
     * @param id 用户ID
     * @return 结果
     */
    public int deleteUsersById(Long id);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUsersByIds(Long[] ids);
}
