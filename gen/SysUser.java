package fun.xruo.lle.sys.pojo;

import fun.xruo.lle.common.BaseDO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
* @author xiongdi (kotlin@qq.com)
* @since 2020/4/30 15:32
* sys_user
*/
@Data
@Alias("sys_user")
public class SysUser extends BaseDO {
    private java.lang.Long id;
    private java.lang.String username;
    private java.lang.String password;
    private java.time.LocalDateTime gmtCreate;
    private java.time.LocalDateTime gmtModified;
    private java.lang.Boolean isDeleted;
}
