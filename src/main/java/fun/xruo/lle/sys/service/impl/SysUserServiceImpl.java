package fun.xruo.lle.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.xruo.lle.sys.dao.SysUserDAO;
import fun.xruo.lle.sys.pojo.SysUser;
import fun.xruo.lle.sys.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * @author xiongdi
 */
@Service
public class SysUserServiceImpl  extends ServiceImpl<SysUserDAO, SysUser> implements SysUserService {
}
