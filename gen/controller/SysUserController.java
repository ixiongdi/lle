package fun.xruo.lle.sys.controller;

import fun.xruo.lle.common.BaseController;
import fun.xruo.lle.sys.pojo.SysUser;
import fun.xruo.lle.sys.service.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
* @author CodeGenerate (https://github.com/ixiongdi/lle)
* @since 2021年10月9日 下午7:16:11
* sys_user
*/
@RestController
@RequestMapping("/api/sys/sys_user")
public class SysUserController extends BaseController {

@Resource
SysUserService sysUserService;

@RequestMapping("index")
public Object index(Integer page, Integer size) {

return ok();
}

@RequestMapping("get")
public Object get(Long id) {

return ok(sysUserService.get(id));
}

@RequestMapping("list")
public Object list(SysUser sysUser) {

return ok(sysUserService.list(sysUser));
}

@RequestMapping("save")
public Object save(SysUser sysUser) {
sysUserService.save(sysUser);
return ok();
}

@RequestMapping("insert")
public Object insert(SysUser sysUser) {
sysUserService.insert(sysUser);
return ok();
}

@RequestMapping("count")
public Object count(SysUser sysUser) {
return ok(sysUserService.count(sysUser));
}

@RequestMapping("delete")
public Object delete(Long id) {
sysUserService.delete(id);
return ok();
}

@RequestMapping("remove")
public Object remove(Long id) {
sysUserService.remove(id);
return ok();
}

@RequestMapping("update")
public Object update(SysUser sysUser) {
sysUserService.update(sysUser);
return ok();
}
}
