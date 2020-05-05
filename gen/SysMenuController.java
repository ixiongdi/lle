package fun.xruo.lle.sys.controller;

import fun.xruo.lle.common.BaseController;
import fun.xruo.lle.sys.pojo.SysMenu;
import fun.xruo.lle.sys.service.%{upperCamelName}Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @author xiongdi (kotlin@qq.com)
* @since 2020/4/30 15:55
*/
@RestController
@RequestMapping("/api/sys/sys_menu")
public class SysMenuController extends BaseController {

@Resource
SysMenuService sysMenuService;

@RequestMapping("index")
public Object index(Integer page, Integer size) {

return ok();
}

@RequestMapping("get")
public Object get(Long id) {

return ok(sysMenuService.get(id));
}

@RequestMapping("list")
public Object list(SysMenu sysMenu) {

return ok(sysMenuService.list(sysUser));
}

@RequestMapping("save")
public Object save(SysMenu sysMenu) {
sysMenuService.save(sysUser);
return ok();
}

@RequestMapping("insert")
public Object insert(SysMenu sysMenu) {
sysMenuService.insert(sysUser);
return ok();
}

@RequestMapping("count")
public Object count(SysMenu sysMenu) {
return ok(sysMenuService.count(sysUser));
}

@RequestMapping("delete")
public Object delete(Long id) {
sysMenuService.delete(id);
return ok();
}

@RequestMapping("remove")
public Object remove(Long id) {
sysMenuService.remove(id);
return ok();
}

@RequestMapping("update")
public Object update(SysMenu sysMenu) {
sysMenuService.update(sysUser);
return ok();
}
}
