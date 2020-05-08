package fun.xruo.lle.demo.controller;

import fun.xruo.lle.common.BaseController;
import fun.xruo.lle.demo.pojo.SysMenu;
import fun.xruo.lle.demo.service.SysMenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CodeGenerate (https://github.com/ixiongdi/lle)
 * @since 2020-5-8 22:26:01
 * sys_menu
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

        return ok(sysMenuService.list(sysMenu));
    }

    @RequestMapping("save")
    public Object save(SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
        return ok();
    }

    @RequestMapping("insert")
    public Object insert(SysMenu sysMenu) {
        sysMenuService.insert(sysMenu);
        return ok();
    }

    @RequestMapping("count")
    public Object count(SysMenu sysMenu) {
        return ok(sysMenuService.count(sysMenu));
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
        sysMenuService.update(sysMenu);
        return ok();
    }
}
