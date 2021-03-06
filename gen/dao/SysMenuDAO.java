package fun.xruo.lle.demo.dao;

import fun.xruo.lle.common.BaseDAO;
import fun.xruo.lle.demo.pojo.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since 2020-8-7 1:01:49
* sys_menu
*/
@Mapper
@Component
public interface SysMenuDAO extends BaseDAO<SysMenu> {
}
