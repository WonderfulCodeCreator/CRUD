package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

//标注于类体上，声明该类是Controller（相当于告诉你我是控制器）
@RestController

//标注于方法体上，用于指定访问路径
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping
    public Result add(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PutMapping
    public Result update(@RequestBody User user) {
        userService.save(user);
        return Result.success();
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        userService.delete(id);
        return Result.success();
    }

    /**
     * 根据id查询用户信息
     */
    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable Long id) {
        return Result.success(userService.findById(id));
    }

    /**
     * 分页模糊查询
     */
    @GetMapping("/page")
    public Result<Page<User>> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       @RequestParam(required = false) String name){
        return Result.success(userService.fingPage(pageNum,pageSize,name));
    }
}
