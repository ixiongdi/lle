package fun.xruo.lle.common;

import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 16:06
 */
public class BaseServiceImpl<T extends Base> implements BaseService<T> {

    private static final String SUFFIX_DAO_CLASS = "DAO";
    private static final String GENERIC_DAO_NAME = "dao";

    @Resource
    protected BaseDAO<T> dao;

//    @Resource
//    private ApplicationContext context;
//
//    @PostConstruct
//    private void init() throws Exception {
//
//        Class<T> beanClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        String daoName = beanClass.getSimpleName();
//        daoName = Character.toLowerCase(daoName.charAt(0)) + daoName.substring(1) + SUFFIX_DAO_CLASS;
//
//        Object obj = null;
//        if (null == context) {
//            Field daoNameField = this.getClass().getDeclaredField(daoName);
//            daoNameField.setAccessible(true);
//            obj = daoNameField.get(this);
//        } else {
//            obj = context.getBean(daoName);
//        }
//
//        //多继承下, 查找有dao属性的基类
//        Field baseDaoNameField = null;
//        Class clazz = this.getClass();
//        while (true) {
//            if (null == clazz || null == clazz.getSuperclass() || clazz.getSuperclass().getName().equals("java.lang.Object")) {
//                break;
//            }
//
//            if (clazz.getName().equals("fun.xruo.lle.common.BaseServiceImpl")) {
//                baseDaoNameField = clazz.getDeclaredField(GENERIC_DAO_NAME);
//                break;
//            }
//
//            clazz = clazz.getSuperclass();
//        }
//
//        if (null == baseDaoNameField) {
//            baseDaoNameField = this.getClass().getSuperclass().getDeclaredField(GENERIC_DAO_NAME);
//        }
//        baseDaoNameField.set(this, obj);
//    }


    @Override
    public T get(Long id) {
        return dao.get(id);
    }

    @Override
    public List<T> list(T t) {
        return dao.list(t);
    }

    @Override
    public void insert(T t) {
        t.setGmtCreate(LocalDateTime.now());
        t.setDeleted(false);
        dao.insert(t);
    }

    @Override
    public Long count(T t) {
        return dao.count(t);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public void update(T t) {
        dao.update(t);
    }
}
