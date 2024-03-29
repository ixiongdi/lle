package fun.xruo.lle.sys.pojo;

import fun.xruo.lle.common.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 15:32
 * sys_user
 */
@Data
@EqualsAndHashCode
@Alias("sys_user")
public class SysUser extends BaseDO {
    /**
     *
     */
    private String username;
    /**
     *
     */
    private String password;
}
