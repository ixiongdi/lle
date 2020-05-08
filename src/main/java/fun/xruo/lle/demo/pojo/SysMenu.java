package fun.xruo.lle.demo.pojo;

import fun.xruo.lle.common.BaseDO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since 2020-5-8 22:26:01
* sys_menu
*/
@Data
@Alias("sys_menu")
public class SysMenu extends BaseDO {
            private Long parentId;
            private String name;
            private String url;
            private String type;
            private String icon;
            private Integer orderNum;
            private String perms;
}
