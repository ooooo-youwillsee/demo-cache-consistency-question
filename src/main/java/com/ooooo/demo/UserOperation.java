package com.ooooo.demo;

/**
 * @author <a href="https://github.com/ooooo-youwillsee">ooooo</a>
 * @since 1.0.0
 */
public interface UserOperation {

    /**
     * 根据id来查询用户名
     *
     * @param id
     * @return
     */
    String queryUserNameById(Long id);

    /**
     * 根据id来设置用户名
     *
     * @param id
     * @param userName
     */
    void setUserNameById(Long id, String userName);
}
