package fun.xruo.lle.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import fun.xruo.lle.sys.dao.SysMenuDAO;
import fun.xruo.lle.sys.pojo.SysMenu;
import fun.xruo.lle.sys.pojo.vo.SysMenuVO;
import fun.xruo.lle.sys.service.SysMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author xiongdi
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDAO, SysMenu> implements SysMenuService {
    @Override
    public List<SysMenuVO> tree() {
        List<SysMenu> list =  this.list();
        List<SysMenuVO> tree = new ArrayList<>();

        // level1
        list.forEach(e -> {
            if (null == e.getParentId()) {
                SysMenuVO vo = new SysMenuVO();
                BeanUtils.copyProperties(e, vo);
                vo.setChildren(new ArrayList<>());
                tree.add(vo);
            }
        });
        // level2
        list.forEach(e -> {
            if (null != e.getParentId()) {
                SysMenuVO vo = new SysMenuVO();
                BeanUtils.copyProperties(e, vo);
                Optional<SysMenuVO> parent = tree.stream().filter(p -> p.getId().equals(e.getParentId())).findFirst();
                parent.ifPresent(sysMenuVO -> sysMenuVO.getChildren().add(vo));
            }
        });
        return tree;
    }
}
