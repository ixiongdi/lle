package fun.xruo.lle.demo.dao;

import fun.xruo.lle.common.BaseDAO;
import fun.xruo.lle.demo.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since 2021年10月9日 上午11:53:50
* sys_role
*/
@Mapper
@Component
public interface SysRoleDAO extends BaseDAO<SysRole> {
}
