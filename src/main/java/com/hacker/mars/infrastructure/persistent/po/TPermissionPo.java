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
@TableName("t_permission")
@ApiModel(value = "TPermissionPo对象", description = "")
public class TPermissionPo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @ApiModelProperty("编号")
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限名称
     */
    @ApiModelProperty("权限名称")
    @TableField("permission_name")
    private String permissionName;

    /**
     * 权限标签
     */
    @ApiModelProperty("权限标签")
    @TableField("permission_tag")
    private String permissionTag;

    /**
     * 权限地址
     */
    @ApiModelProperty("权限地址")
    @TableField("permission_url")
    private String permissionUrl;


    /**
    * 编号
    */
    public static final String ID = "ID";

    /**
    * 权限名称
    */
    public static final String PERMISSION_NAME = "permission_name";

    /**
    * 权限标签
    */
    public static final String PERMISSION_TAG = "permission_tag";

    /**
    * 权限地址
    */
    public static final String PERMISSION_URL = "permission_url";

}
