package fun.xruo.lle.sys.pojo;

import fun.xruo.lle.common.Base;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 15:32
 * sys_user
 */
@Data
@Alias("sysUser")
public class SysUser extends Base {

    /**
     * id, bigint unsigned
     */
    private Long id;

    /**
     *
     */
    private String username;
    /**
     *
     */
    private String password;

    /**
     * gmt_create, datetime
     */
    private LocalDateTime gmtCreate;
    /**
     * gmt_modified, datetime
     */
    private LocalDateTime gmtModified;

    /**
     * is_deleted, unsigned tinyint
     */
    private Boolean deleted;
}
