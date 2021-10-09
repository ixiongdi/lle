package fun.xruo.lle.demo.controller;

import fun.xruo.lle.common.BaseController;
import fun.xruo.lle.demo.pojo.SysRole;
import fun.xruo.lle.demo.service.SysRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since 2021年10月9日 上午11:53:50
* sys_role
*/
@RestController
@RequestMapping("/api/sys/sys_role")
public class SysRoleController extends BaseController {

@Resource
SysRoleService sysRoleService;

@RequestMapping("index")
public Object index(Integer page, Integer size) {

return ok();
}

@RequestMapping("get")
public Object get(Long id) {

return ok(sysRoleService.get(id));
}

@RequestMapping("list")
public Object list(SysRole sysRole) {

return ok(sysRoleService.list(sysRole));
}

@RequestMapping("save")
public Object save(SysRole sysRole) {
sysRoleService.save(sysRole);
return ok();
}

@RequestMapping("insert")
public Object insert(SysRole sysRole) {
sysRoleService.insert(sysRole);
return ok();
}

@RequestMapping("count")
public Object count(SysRole sysRole) {
return ok(sysRoleService.count(sysRole));
}

@RequestMapping("delete")
public Object delete(Long id) {
sysRoleService.delete(id);
return ok();
}

@RequestMapping("remove")
public Object remove(Long id) {
sysRoleService.remove(id);
return ok();
}

@RequestMapping("update")
public Object update(SysRole sysRole) {
sysRoleService.update(sysRole);
return ok();
}
}
