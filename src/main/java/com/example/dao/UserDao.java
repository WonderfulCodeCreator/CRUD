package com.example.dao;

import com.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


//@Repository注解修饰哪个类表明这个类具有对数据库CRUD的功能，用在持久层的接口上
@Repository
public interface UserDao extends JpaRepository<User,Long> {

    //用于直接在Repository接口上定义sql查询方法
    @Query(value = "select * from user where name like %?1%", nativeQuery = true)
    Page<User> findNameLike(String name, PageRequest pageRequest);
}
