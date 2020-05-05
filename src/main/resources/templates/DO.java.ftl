package ${packageName + ".pojo"};

import fun.xruo.lle.common.BaseDO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
* @author xiongdi (kotlin@qq.com)
* @since 2020/4/30 15:32
* sys_user
*/
@Data
@Alias("${name}")
public class ${upperCamelName} extends BaseDO {
<#list columns as column>
    private ${column.className} ${column.lowerCamelName};
</#list>
}
