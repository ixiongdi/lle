package fun.xruo.lle.sys.pojo.query;

import fun.xruo.lle.common.BaseQuery;
import fun.xruo.lle.sys.pojo.SysMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysMenuQuery extends SysMenu {
    Long current;
    Long size;
}
