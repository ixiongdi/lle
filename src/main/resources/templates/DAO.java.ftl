package ${packageName}.dao;

import fun.xruo.lle.common.BaseDAO;
import ${packageName}.pojo.${upperCamelName};
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since ${.now}
* ${name}
*/
@Mapper
@Component
public interface ${upperCamelName}DAO extends BaseDAO<${upperCamelName}> {
}
