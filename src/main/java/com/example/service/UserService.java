package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

//标注于Service接口的实现类上，将当前类自动注入到Spring容器中
@Service
public class UserService  {

    @Resource
    private UserDao userDao;
    /**
     * 新增和修改
     * @param user
     */
    public void save(User user) {
        String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setCreateTime(now);
        userDao.save(user);
    }
//    public void save(User user) {
//        userDao.save(user);
//    }

    /**
     * 删除
     */
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User findById(Long id){
        return userDao.findById(id).orElse(null);
    }

    /**
     * 分页查询用户
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    public Page<User> fingPage(Integer pageNum, Integer pageSize, String name){
        //构建分页查询条件
        Sort sort=Sort.by(Sort.Direction.DESC,"create_time");
        PageRequest request= PageRequest.of(pageNum-1,pageSize);
        return userDao.findNameLike(name,request);
    }
}
