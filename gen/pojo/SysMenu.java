package fun.xruo.lle.demo.pojo;

import fun.xruo.lle.common.BaseDO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since 2020-5-8 23:23:08
* sys_menu
*/
@Data
@Alias("sys_menu")
public class SysMenu extends BaseDO {
            private java.lang.Long parentId;
            private java.lang.String name;
            private java.lang.String url;
            private java.lang.String type;
            private java.lang.String icon;
            private java.lang.Integer orderNum;
            private java.lang.String perms;
}
