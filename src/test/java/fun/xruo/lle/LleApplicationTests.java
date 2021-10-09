package fun.xruo.lle;

import fun.xruo.lle.sys.pojo.SysMenu;
import fun.xruo.lle.sys.pojo.SysUser;
import fun.xruo.lle.sys.service.SysMenuService;
import fun.xruo.lle.sys.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
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
//            sysMenuService.save(sysMenu);
        }
    }

    @Test
    void insertSysUser() {
        List<SysUser> sysUserList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            SysUser sysUser = new SysUser();
            sysUser.setUsername(UUID.randomUUID().toString().substring(0, 10));
            sysUser.setPassword(UUID.randomUUID().toString());
            sysUserList.add(sysUser);
//            sysUserService.save(sysUser);
        }
        sysUserService.saveBatch(sysUserList);
    }
}
