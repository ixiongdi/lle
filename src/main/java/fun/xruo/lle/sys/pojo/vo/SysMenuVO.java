package fun.xruo.lle.sys.pojo.vo;

import fun.xruo.lle.sys.pojo.SysMenu;
import lombok.Data;

import java.util.List;

@Data
public class SysMenuVO extends SysMenu {
    List<SysMenu> children;
}
