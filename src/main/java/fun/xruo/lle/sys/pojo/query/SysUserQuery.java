package fun.xruo.lle.sys.pojo.query;

import fun.xruo.lle.sys.pojo.SysUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQuery extends SysUser {
    Set<Long> ids;

    Long current;
    Long size;

    String usernameLike;
}
