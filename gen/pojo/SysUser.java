package fun.xruo.lle.demo.pojo;

import fun.xruo.lle.common.BaseDO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since 2021年10月9日 上午11:53:50
* sys_user
*/
@Data
@Alias("sys_user")
public class SysUser extends BaseDO {
            private java.lang.String username;
            private java.lang.String password;
}
