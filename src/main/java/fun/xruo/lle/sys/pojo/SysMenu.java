package fun.xruo.lle.sys.pojo;

import fun.xruo.lle.common.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SysMenu extends BaseDO {
    Long parentId;
    String name;
    String url;
    String icon;
    Integer orderNum;
}
