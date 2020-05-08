package fun.xruo.lle.demo.service.impl;

import fun.xruo.lle.common.BaseServiceImpl;
import fun.xruo.lle.demo.dao.SysMenuDAO;
import fun.xruo.lle.demo.pojo.SysMenu;
import fun.xruo.lle.demo.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since 2020-5-8 22:26:01
* sys_menu
*/
@Service
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenu> implements SysMenuService {
    @Resource
    SysMenuDAO dao;
}
