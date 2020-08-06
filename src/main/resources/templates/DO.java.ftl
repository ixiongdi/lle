package ${packageName + ".pojo"};

import fun.xruo.lle.common.BaseDO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since ${.now}
* ${name}
*/
@Data
@Alias("${name}")
public class ${upperCamelName} extends BaseDO {
<#list columns as column>
    <#switch column.name>
        <#case 'id'>
            <#break>
        <#case 'create_time'>
            <#break>
        <#case 'update_time'>
            <#break>
        <#case 'deleted'>
            <#break>
        <#default>
            private ${column.javaType} ${column.lowerCamelName};
    </#switch>
</#list>
}
