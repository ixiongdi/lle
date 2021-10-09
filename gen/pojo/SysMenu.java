package fun.xruo.lle.demo.pojo;

import fun.xruo.lle.common.BaseDO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since 2021年10月9日 上午11:53:50
* sys_menu
*/
@Data
@Alias("sys_menu")
public class SysMenu extends BaseDO {
            private java.lang.Integer parentId;
            private java.lang.String name;
            private java.lang.String url;
            private java.lang.String icon;
            private java.lang.Integer orderNum;
}
