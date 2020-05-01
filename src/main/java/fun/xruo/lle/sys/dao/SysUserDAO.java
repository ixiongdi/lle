package fun.xruo.lle.sys.dao;

import fun.xruo.lle.common.BaseDAO;
import fun.xruo.lle.sys.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 15:42
 */
@Mapper
@Component
public interface SysUserDAO extends BaseDAO<SysUser> {


}
