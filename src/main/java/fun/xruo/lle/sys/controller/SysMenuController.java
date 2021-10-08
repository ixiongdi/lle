package fun.xruo.lle.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.xruo.lle.sys.pojo.SysMenu;
import fun.xruo.lle.sys.pojo.query.SysMenuQuery;
import fun.xruo.lle.sys.service.SysMenuService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;

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

    @RequestMapping("get")
    public Object get(@RequestBody SysMenuQuery query) {
        return sysMenuService.getById(query.getId());
    }

    @RequestMapping("list")
    public Object list(@RequestBody SysMenuQuery query) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>(query);
        if (Objects.nonNull(query.getNameLike())) {
            queryWrapper.like("name", query.getNameLike());
        }
        long total = sysMenuService.count(queryWrapper);
        Page<SysMenu> page = new Page<>(query.getCurrent(), query.getSize(), total);
        page.setOptimizeCountSql(false);
        page.setSearchCount(false);
        return sysMenuService.page(page, queryWrapper);
    }

    @RequestMapping("count")
    public Object count(@RequestBody SysMenuQuery query) {
        return sysMenuService.count(new QueryWrapper<>(query));
    }

    @RequestMapping("save")
    public Object save(@RequestBody SysMenu sysMenu) {
        return sysMenuService.save(sysMenu);
    }

    @RequestMapping("remove")
    public Object remove(@RequestBody SysMenuQuery query) {
        return sysMenuService.removeByIds(query.getIds());
    }

    @RequestMapping("update")
    public Object update(@RequestBody SysMenu sysMenu) {
        sysMenu.setUpdateTime(LocalDateTime.now());
        return sysMenuService.updateById(sysMenu);
    }

    @RequestMapping("tree")
    public Object tree() {
        return sysMenuService.tree();
    }
}
