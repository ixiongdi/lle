package fun.xruo.lle.sys.dao;

import fun.xruo.lle.common.BaseDAO;
import fun.xruo.lle.sys.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since 2021年10月9日 下午3:54:37
* sys_role
*/
@Mapper
@Component("sysRoleDAO")
public interface SysRoleDAO extends BaseDAO<SysRole> {
}
