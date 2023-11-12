package com.hacker.mars.infrastructure.persistent.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("t_user")
@ApiModel(value = "TUserPo对象", description = "")
public class TUserPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    /**
     * 用户状态1-启用 0-关闭
     */
    @ApiModelProperty("用户状态1-启用 0-关闭")
    @TableField("status")
    private Integer status;


    /**
    * 
    */
    public static final String ID = "id";

    /**
    * 
    */
    public static final String USERNAME = "username";

    /**
    * 
    */
    public static final String PASSWORD = "password";

    /**
    * 用户状态1-启用 0-关闭
    */
    public static final String STATUS = "status";

}
