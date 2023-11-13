package com.hacker.mars.application.api.product;

import com.hacker.mars.infrastructure.persistent.mapper.TProductMapper;
import com.hacker.mars.infrastructure.persistent.po.TProductPo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-11-12
 */
@Controller
@RequestMapping("/product")
public class ProductApi {

    @Resource
    private TProductMapper productMapper;

    /**
     * 查询所有商品
     *
     * @param model 模型
     * @return list
     */
    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<TProductPo> productList = productMapper.selectList(null);
        model.addAttribute("productList", productList);
        return "product_list";
    }


    /**
     * 商品修改页面跳转
     *
     * @return 商品
     */
    @RequestMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        TProductPo productPo = productMapper.selectById(id);
        model.addAttribute("product", productPo);
        return "product_update";
    }

    /**
     * 商品添加页面跳转
     *
     * @return 页面
     */
    @RequestMapping("/add")
    public String add() {
        return "product_add";
    }

    /**
     * 商品添加或修改
     *
     * @return 页面
     */
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(TProductPo product) {
        // 主键不为空执行修改,为空执行保存
        if (product.getId() == null) {
            product.setIsShow(0);//设置是否展示 0 - 默认不展示
            product.setCreateTime(new Date());
            productMapper.insert(product);
        }
        productMapper.updateById(product);
        return "redirect:/product/findAll";
    }

    /**
     * 商品删除
     *
     * @return 商品
     */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productMapper.deleteById(id);
        return "redirect:/product/findAll";
    }

    /**
     * 商品是否显示
     *
     * @return 商品
     */
    @GetMapping("/show/{id}/{isShow}")
    public String show(@PathVariable Integer id, @PathVariable Integer isShow) {
        TProductPo product = productMapper.selectById(id);
        product.setIsShow(isShow);
        productMapper.updateById(product);
        return "redirect:/product/findAll";
    }

}
