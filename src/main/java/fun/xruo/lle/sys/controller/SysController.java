package fun.xruo.lle.sys.controller;

import fun.xruo.lle.common.BaseController;
import fun.xruo.lle.sys.pojo.SysUser;
import fun.xruo.lle.sys.service.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 15:55
 */
@RestController
@RequestMapping("/api/sys/sysUser")
public class SysController extends BaseController {

    @Resource
    SysUserService sysUserService;

    @RequestMapping("/get")
    public Object get(Long id) {
        return ok(sysUserService.get(id));
    }

    @RequestMapping("list")
    public Object list(SysUser sysUser) {
        return ok(sysUserService.list(sysUser));
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

    @RequestMapping("update")
    public Object update(SysUser sysUser) {
        return ok(sysUserService.list(sysUser));
    }
}
