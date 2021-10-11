package fun.xruo.lle.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import fun.xruo.lle.common.BaseController;
import fun.xruo.lle.sys.pojo.SysRole;
import fun.xruo.lle.sys.pojo.query.SysRoleQuery;
import fun.xruo.lle.sys.service.SysRoleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author CodeGenerate (https://github.com/ixiongdi/lle)
 * @since 2021年10月9日 下午3:54:37
 * sys_role
 */
@RestController
@RequestMapping("/api/sys/sys_role")
public class SysRoleController extends BaseController {

    @Resource
    SysRoleService sysRoleService;

    @RequestMapping("get")
    public Object get(@RequestBody SysRoleQuery query) {
        return sysRoleService.get(query.getId());
    }

    @RequestMapping("list")
    public Object list(@RequestBody SysRoleQuery query, @RequestParam Long current, @RequestParam Long size) {
        return sysRoleService.page(query, new Page<>(current, size));
    }

    @RequestMapping("count")
    public Object count(@RequestBody SysRoleQuery query) {
        return sysRoleService.count(query);
    }

    @RequestMapping("save")
    public Object save(@RequestBody SysRole dto) {
        sysRoleService.save(dto);
        return "ok";
    }

    @RequestMapping("remove")
    public Object remove(@RequestBody SysRoleQuery query) {
        sysRoleService.remove(query.getIds());
        return "ok";
    }

    @RequestMapping("update")
    public Object update(@RequestBody SysRole dto) {
        dto.setUpdateTime(LocalDateTime.now());
        sysRoleService.update(dto);
        return "ok";
    }
}
