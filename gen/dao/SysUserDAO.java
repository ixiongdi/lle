package fun.xruo.lle.sys.dao;

import fun.xruo.lle.common.BaseDAO;
import fun.xruo.lle.sys.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since 2021年10月9日 下午7:16:11
* sys_user
*/
@Mapper
@Component
public interface SysUserDAO extends BaseDAO<SysUser> {
}
