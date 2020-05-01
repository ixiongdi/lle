package fun.xruo.lle.common;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 16:06
 */
@Slf4j
public class BaseServiceImpl<T extends BaseDO> implements BaseService<T> {


    @Resource
    BaseDAO<T> dao;


    /**
     * 根据ID获取单个对象
     *
     * @param id
     * @return
     */
    @Override
    public T get(Long id) {
        return dao.selectById(id);
    }

    /**
     * 根据查询条件获取单个对象，如果有多个，默认取第一个
     *
     * @param t
     * @return
     */
    @Override
    public T get(T t) {
        List<T> list = dao.select(t);
        if (list.isEmpty()) {
            log.warn("get null by query: {}", t);
            return null;
        }
        return list.get(0);
    }

    /**
     * 根据IDs获取多个对象
     *
     * @param ids
     * @return
     */
    @Override
    public List<T> list(List<Long> ids) {
        return dao.selectBatchByIds(ids);
    }

    /**
     * 根据查询条件获取多个对象
     *
     * @param t
     * @return
     */
    @Override
    public List<T> list(T t) {
        return dao.select(t);
    }

    /**
     * 保存对象，等同于insert
     *
     * @param t
     */
    @Override
    public void save(T t) {
        insert(t);
    }

    /**
     * 插入对象
     *
     * @param t
     */
    @Override
    public void insert(T t) {
        dao.insert(t);
    }

    /**
     * 插入对象
     *
     * @param list
     */
    @Override
    public void insert(List<T> list) {
        dao.insertBatch(list);
    }

    /**
     * 查询满足条件的对象数量
     *
     * @param t
     * @return
     */
    @Override
    public Long count(T t) {
        return dao.count(t);
    }

    /**
     * 逻辑删除，根据ID
     *
     * @param id
     */
    @Override
    public void remove(Long id) {
        try {
            T t = getClazz().newInstance();
            t.setDeleted(true);
            dao.updateById(id, t);
        } catch (IllegalAccessException | InstantiationException e) {
            log.error("remove id: {}, error: {}", id, e.getMessage());
        }
    }


    private Class<T> getClazz() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * 逻辑删除，更具IDs
     *
     * @param ids
     */
    @Override
    public void remove(List<Long> ids) {
        try {
            Map<String, Object> args = new HashMap<>(1);
            args.put("ids", ids);
            T t = getClazz().newInstance();
            t.setDeleted(true);
            dao.updateBatchByArgs(args, t);
        } catch (IllegalAccessException | InstantiationException e) {
            log.error("remove ids: {}, error: {}", ids, e.getMessage());
        }

    }

    /**
     * 逻辑删除，根据条件
     *
     * @param t
     */
    @Override
    public void remove(T t) {
        t.setDeleted(true);
        dao.update(t);
    }

    /**
     * 物理删除，根据ID
     *
     * @param id
     */
    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    /**
     * 物理删除，根据IDs
     *
     * @param ids
     */
    @Override
    public void delete(List<Long> ids) {
        dao.deleteBatchByIds(ids);
    }

    /**
     * 物理删除，根据条件
     *
     * @param t
     */
    @Override
    public void delete(T t) {
        dao.delete(t);
    }

    /**
     * 更新对象，必须有ID
     *
     * @param t
     */
    @Override
    public void update(T t) {
        dao.update(t);
    }

    /**
     * 根据Ids更新对象
     *
     * @param ids
     * @param t
     */
    @Override
    public void update(List<Long> ids, T t) {
        dao.updateBatchByIds(ids, t);
    }


}
