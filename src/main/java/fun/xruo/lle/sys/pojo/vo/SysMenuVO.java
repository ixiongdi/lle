package fun.xruo.lle.sys.pojo.vo;

import fun.xruo.lle.sys.pojo.SysMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
public class SysMenuVO extends SysMenu {
    List<SysMenu> children;
}
