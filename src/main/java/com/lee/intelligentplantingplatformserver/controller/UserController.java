package com.lee.intelligentplantingplatformserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lee.intelligentplantingplatformserver.model.dto.UserLoginDTO;
import com.lee.intelligentplantingplatformserver.model.dto.UserSearchDTO;
import com.lee.intelligentplantingplatformserver.model.entity.User;
import com.lee.intelligentplantingplatformserver.model.result.R;
import com.lee.intelligentplantingplatformserver.model.vo.PageVO;
import com.lee.intelligentplantingplatformserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName UserController
 * @Description 用户控制层
 * @Author lee
 * @Date 2023/3/20 15:36
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    public R login(@RequestBody UserLoginDTO userLoginDTO){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userLoginDTO.getUsername());
        queryWrapper.eq("password",userLoginDTO.getPassword());
        User user = userService.getOne(queryWrapper);
        if (user != null){
            return R.success().message("登录成功！");
        }
        return R.error().message("对不起，用户名或密码错误！");
    }

    /**
     * 用户添加
     * @param user
     * @return
     */
    @PostMapping("/saveUser")
    public R saveUser(@RequestBody User user){
        // 设置默认值
        user.setAvatar("avatar:none");
        user.setRole("管理员");
        boolean flag = userService.save(user);
        if (flag){
            return R.success();
        }
        return R.error().message("添加用户信息失败！");
    }

    /**
     * 分页查询用户信息
     * @param current
     * @param size
     * @return
     */
    @GetMapping("pageUserList/{current}/{size}")
    public R pageUserList(@PathVariable("current") long current,
                          @PathVariable("size") long size){

        Page<User> page = new Page<>(current,size);
        Page<User> userPage = userService.page(page);
        if (userPage != null){
            PageVO pageVO = new PageVO();
            pageVO.setTotal(userPage.getTotal());
            pageVO.setPages(userPage.getPages());
            pageVO.setHasPrevious(userPage.hasPrevious());
            pageVO.setHasNext(userPage.hasNext());
            pageVO.setList(userPage.getRecords());

            log.info("userPageList:"+pageVO);
            return R.success()
                    .data("userPageVO",pageVO);
        }
        return R.error().message("用户信息查询失败！");
    }

    /**
     * 按照用户id删除用户信息（逻辑删除）
     * @param userId
     * @return
     */
    @DeleteMapping("/deleteUser/{userId}")
    public R deleteUser(@PathVariable("userId") String userId){
        boolean flag = userService.removeById(userId);
        if (flag){
            return R.success().message("删除用户信息成功！");
        }
        return R.error().message("删除用户信息失败！");
    }

    /**
     * 按照用户id查询用户信息
     * @param userId
     * @return
     */
    @GetMapping("/findUserById/{userId}")
    public R findUserById(@PathVariable("userId") String userId){
        User user = userService.getById(userId);
        if (user != null){
            return R.success().data("user",user);
        }
        return R.error().message("查询用户信息失败！");
    }

    /**
     * 按照用户id修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/modifyUser")
    public R modifyUser(@RequestBody User user){
        boolean flag = userService.updateById(user);
        if (flag){
            return R.success();
        }
        return R.error().message("修改用户信息失败！");
    }

    /**
     * 分页模糊查询
     * @param userSearchDTO
     * @return
     */
    @PostMapping("/pageUserListByLike")
    public R pageUserListByLike(@RequestBody UserSearchDTO userSearchDTO){
        Page<User> page = new Page<>(userSearchDTO.getCurrent(),userSearchDTO.getLimit());
        String type = userSearchDTO.getType();
        String content = userSearchDTO.getContent();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if ("username".equals(type)){
            queryWrapper.like("username",content);
        } else if ("telephone".equals(type)){
            queryWrapper.like("telephone",content);
        } else {
            queryWrapper.like("email",content);
        }
        Page<User> userPage = userService.page(page, queryWrapper);
        if (userPage != null){
            PageVO pageVO = new PageVO();
            pageVO.setTotal(userPage.getTotal());
            pageVO.setPages(userPage.getPages());
            pageVO.setHasPrevious(userPage.hasPrevious());
            pageVO.setHasNext(userPage.hasNext());
            pageVO.setList(userPage.getRecords());

            log.info("userPageList:"+pageVO);
            return R.success()
                    .data("userPageVO",pageVO);
        }
        return R.error();
    }
}
