package fun.xruo.lle.sys.pojo.query;

import fun.xruo.lle.sys.pojo.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysRoleQuery extends SysRole {
    List<Long> ids;

    Long current = 1L;
    Long size = 10L;
}
