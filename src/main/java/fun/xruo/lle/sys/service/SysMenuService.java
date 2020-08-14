package fun.xruo.lle.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import fun.xruo.lle.sys.pojo.SysMenu;
import fun.xruo.lle.sys.pojo.vo.SysMenuVO;

import java.util.List;

public interface SysMenuService extends IService<SysMenu> {
    List<SysMenuVO> tree();
}
