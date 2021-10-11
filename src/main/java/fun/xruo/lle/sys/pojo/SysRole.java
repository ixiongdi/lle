package fun.xruo.lle.sys.pojo;

import fun.xruo.lle.common.BaseDO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author CodeGenerate (https://github.com/ixiongdi/lle)
 * @since 2021年10月9日 下午3:54:37
 * sys_role
 */
@Data
@Alias("sys_role")
public class SysRole extends BaseDO {
    private String name;
}
