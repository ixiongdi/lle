package fun.xruo.lle.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.xruo.lle.sys.pojo.SysUser;
import fun.xruo.lle.sys.pojo.query.SysUserQuery;
import fun.xruo.lle.sys.service.SysUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author CodeGenerate (https://github.com/ixiongdi/lle)
 * @since 2020-5-8 22:26:01
 * sys_menu
 */
@RestController
@RequestMapping("/api/sys/sys_user")
public class SysUserController {

    @Resource
    SysUserService sysUserService;


    @RequestMapping("get")
    public Object get(@RequestBody SysUserQuery query) {
        return sysUserService.getById(query.getId());
    }

    @RequestMapping("list")
    public Object list(@RequestBody SysUserQuery query) {
        int total = sysUserService.count(Wrappers.query(query));
        Page<SysUser> page = new Page<>(query.getCurrent(), query.getSize(), total);
        page.setOptimizeCountSql(false);
        page.setSearchCount(false);
        return sysUserService.page(page, Wrappers.query(query));
    }

    @RequestMapping("count")
    public Object count(@RequestBody SysUserQuery query) {
        return sysUserService.count(new QueryWrapper<>(query));
    }

    @RequestMapping("save")
    public Object save(@RequestBody SysUser dto) {
        return sysUserService.save(dto);
    }

    @RequestMapping("remove")
    public Object remove(@RequestBody SysUserQuery query) {
        return sysUserService.removeByIds(query.getIds());
    }

    @RequestMapping("update")
    public Object update(@RequestBody SysUser dto) {
        return sysUserService.updateById(dto);
    }
}
