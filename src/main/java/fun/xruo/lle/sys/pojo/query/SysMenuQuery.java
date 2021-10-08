package fun.xruo.lle.sys.pojo.query;

import fun.xruo.lle.sys.pojo.SysMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysMenuQuery extends SysMenu {
    Set<Long> ids;

    Long current = 1L;
    Long size = 10L;

    String nameLike;
}
