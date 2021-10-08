package fun.xruo.lle;

import fun.xruo.lle.sys.pojo.SysMenu;
import fun.xruo.lle.sys.pojo.SysUser;
import fun.xruo.lle.sys.service.SysMenuService;
import fun.xruo.lle.sys.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
class LleApplicationTests {

    @Resource
    SysMenuService sysMenuService;

    @Resource
    SysUserService sysUserService;

    @Test
    void contextLoads() {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setName("百度");
        sysMenu.setUrl("http://baidu.com");
        for (int i = 0; i < 10; i++) {
            sysMenuService.save(sysMenu);
        }
    }

    @Test
    void insertSysUser() {
        for (int i = 0; i < 10; i++) {
            SysUser sysUser = new SysUser();
            sysUser.setUsername(UUID.randomUUID().toString().substring(0, 10));
            sysUser.setPassword(UUID.randomUUID().toString());
            sysUserService.save(sysUser);
        }
    }
}
