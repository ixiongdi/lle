package fun.xruo.lle.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.xruo.lle.sys.pojo.SysMenu;
import fun.xruo.lle.sys.pojo.query.SysMenuQuery;
import fun.xruo.lle.sys.service.SysMenuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CodeGenerate (https://github.com/ixiongdi/lle)
 * @since 2020-5-8 22:26:01
 * sys_menu
 */
@RestController
@RequestMapping("/api/sys/sys_menu")
public class SysMenuController {

    @Resource
    SysMenuService sysMenuService;

    @RequestMapping("index")
    public Object index(@RequestBody SysMenuQuery query) {
        int total = sysMenuService.count(Wrappers.query(query));
        Page<SysMenu> page = new Page<SysMenu>(query.getCurrent(), query.getSize(), total);
        page.setOptimizeCountSql(false);
        page.setSearchCount(false);
        return sysMenuService.page(page, Wrappers.query(query));
    }

    @RequestMapping("get")
    public Object get(Long id) {
        return sysMenuService.getById(id);
    }

    @RequestMapping("list")
    public Object list(@RequestBody SysMenu sysMenu) {
        return sysMenuService.list(Wrappers.query(sysMenu));
    }

    @RequestMapping("save")
    public void save(SysMenu sysMenu) {
        sysMenuService.updateById(sysMenu);
    }

    @RequestMapping("insert")
    public void insert(@RequestBody SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
    }

    @RequestMapping("count")
    public Object count(SysMenu sysMenu) {
        return sysMenuService.count(new QueryWrapper<>(sysMenu));
    }

    @RequestMapping("delete")
    public void delete(@RequestParam Long id) {
        sysMenuService.removeById(id);
    }

    @RequestMapping("tree")
    public Object tree() {
        return sysMenuService.tree();
    }

}
