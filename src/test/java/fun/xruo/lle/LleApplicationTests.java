package fun.xruo.lle;

import fun.xruo.lle.sys.pojo.SysMenu;
import fun.xruo.lle.sys.service.SysMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class LleApplicationTests {

    @Resource
    SysMenuService sysMenuService;

    @Test
    void contextLoads() {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setName("百度");
        sysMenu.setUrl("http://baidu.com");
        for (int i = 0; i < 1000; i++) {
            sysMenuService.save(sysMenu);
        }

    }

}
