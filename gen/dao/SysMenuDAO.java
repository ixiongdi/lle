package fun.xruo.lle.sys.dao;

import fun.xruo.lle.common.BaseDAO;
import fun.xruo.lle.sys.pojo.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since 2021年10月9日 下午7:16:11
* sys_menu
*/
@Mapper
@Component
public interface SysMenuDAO extends BaseDAO<SysMenu> {
}
