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
@Alias("sys_menu")
public class SysMenu extends BaseDO {
    private java.math.BigInteger id;
    private java.math.BigInteger parentId;
    private java.lang.String name;
    private java.lang.String icon;
    private java.sql.Timestamp gmtCreate;
    private java.sql.Timestamp gmtModified;
    private java.lang.Integer isDeleted;
}
