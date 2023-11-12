package com.hacker.mars.infrastructure.persistent.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zero
 * @since 2023-11-05
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_product")
@ApiModel(value = "TProductPo对象", description = "")
public class TProductPo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    @TableField("name")
    private String name;

    /**
     * 商品价格
     */
    @ApiModelProperty("商品价格")
    @TableField("price")
    private BigDecimal price;

    /**
     * 库存
     */
    @ApiModelProperty("库存")
    @TableField("stock")
    private Integer stock;

    /**
     * 是否展示
     */
    @ApiModelProperty("是否展示")
    @TableField("is_show")
    private Integer isShow;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;


    /**
    * id
    */
    public static final String ID = "id";

    /**
    * 商品名称
    */
    public static final String NAME = "name";

    /**
    * 商品价格
    */
    public static final String PRICE = "price";

    /**
    * 库存
    */
    public static final String STOCK = "stock";

    /**
    * 是否展示
    */
    public static final String IS_SHOW = "is_show";

    /**
    * 创建时间
    */
    public static final String CREATE_TIME = "create_time";

}
