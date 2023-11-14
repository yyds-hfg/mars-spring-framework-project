package com.hacker.mars.application.api.user;

import com.hacker.mars.infrastructure.persistent.mapper.TUserMapper;
import com.hacker.mars.infrastructure.persistent.po.TUserPo;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-13
 */
@Controller
@RequestMapping("/user")
public class UserApi {

    @Resource
    private TUserMapper userMapper;

    /**
     * 查询所有用户
     *
     * @return 所有用户
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<TUserPo> userList = userMapper.selectList(null);
        model.addAttribute("userList", userList);
        return "user_list";
    }

    /**
     * 查询所有用户-返回json数据
     *
     * @return 所有用户
     */
    @RequestMapping("/findAllTOJson")
    @ResponseBody
    public List<TUserPo> findAllTOJson() {
        return userMapper.selectList(null);
    }

    /**
     * 用户修改页面跳转
     *
     * @return 页面跳转路径
     */
    @RequestMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        TUserPo user = userMapper.selectById(id);
        model.addAttribute("user", user);
        return "user_update";
    }

    /**
     * 用户添加或修改
     *
     * @return 用户添加或修改
     */
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(TUserPo user) {
        if (user.getId() == null) {
            userMapper.insert(user);
        }
        userMapper.updateById(user);
        return "redirect:/user/findAll";
    }

    /**
     * 用户添加页面跳转
     *
     * @return 用户添加页面跳转
     */
    @RequestMapping("/add")
    public String add() {
        return "user_add";
    }

    /**
     * 用户删除
     *
     * @return 用户删除
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        userMapper.deleteById(id);
        return "redirect:/user/findAll";
    }

    /**
     * 用户删除-多选删除
     *
     * @return 多选删除
     */
    @GetMapping("/delByIds")
    public String delByIds(@RequestParam(value = "id") List<Integer> ids) {
        for (Integer id : ids) {
            System.out.println(id);
        }
        return "redirect:/user/findAll";
    }


    /**
     * 根据用户ID查询用户
     *
     * @return 根据用户ID查询用户
     */
    @GetMapping("/{id}")
    @ResponseBody
    public TUserPo getById(@PathVariable Integer id) {
        //获取认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //如果返回是True,代表登录来源于自动登录
        if (RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
            throw new RememberMeAuthenticationException("认证来源于RememberMe!");
        }
        return userMapper.selectById(id);
    }


}
