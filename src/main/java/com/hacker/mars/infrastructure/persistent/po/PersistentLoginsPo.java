package com.hacker.mars.infrastructure.persistent.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
 * @since 2023-11-13
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("persistent_logins")
@ApiModel(value = "PersistentLoginsPo对象", description = "")
public class PersistentLoginsPo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    /**
     * 序号
     */
    @ApiModelProperty("序号")
    @TableId(value = "series", type = IdType.ASSIGN_ID)
    private String series;

    /**
     * TOKEN
     */
    @ApiModelProperty("TOKEN")
    @TableField("token")
    private String token;

    /**
     * 最近使用时间
     */
    @ApiModelProperty("最近使用时间")
    @TableField("last_used")
    private LocalDateTime lastUsed;


    /**
    * 用户名
    */
    public static final String USERNAME = "username";

    /**
    * 序号
    */
    public static final String SERIES = "series";

    /**
    * TOKEN
    */
    public static final String TOKEN = "token";

    /**
    * 最近使用时间
    */
    public static final String LAST_USED = "last_used";

}
