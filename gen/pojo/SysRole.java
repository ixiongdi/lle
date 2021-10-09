package fun.xruo.lle.demo.pojo;

import fun.xruo.lle.common.BaseDO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since 2021年10月9日 上午11:53:50
* sys_role
*/
@Data
@Alias("sys_role")
public class SysRole extends BaseDO {
            private java.lang.String name;
}
