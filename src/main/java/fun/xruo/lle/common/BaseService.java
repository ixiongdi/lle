package fun.xruo.lle.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 16:04
 */
public interface BaseService<T> {


    /**
     * 根据ID获取单个对象
     *
     * @param id
     * @return
     */
    T get(Long id);

    /**
     * 根据查询条件获取单个对象，如果有多个，默认取第一个
     *
     * @param t
     * @return
     */
    T get(T t);

    /**
     * 根据IDs获取多个对象
     * @param ids
     * @return
     */
    List<T> list(List<Long> ids);

    /**
     * 根据查询条件获取多个对象
     * @param t
     * @return
     */
    List<T> list(T t);

    /**
     * 保存对象，等同于insert
     * @param t
     */
    void save(T t);

    /**
     * 插入对象
     * @param t
     */
    void insert(T t);

    /**
     * 插入对象
     * @param list
     */
    void insert(List<T> list);

    /**
     * 查询满足条件的对象数量
     * @param t
     * @return
     */
    Long count(T t);

    /**
     *  逻辑删除，根据ID
     * @param id
     */
    void remove(Long id);

    /**
     *  逻辑删除，更具IDs
     * @param ids
     */
    void remove(List<Long> ids);

    /**
     * 逻辑删除，根据条件
     * @param t
     */
    void remove(T t);

    /**
     * 物理删除，根据ID
     * @param id
     */
    void delete(Long id);

    /**
     * 物理删除，根据IDs
     * @param ids
     */
    void delete(List<Long> ids);

    /**
     * 物理删除，根据条件
     * @param t
     */
    void delete(T t);

    /**
     * 更新对象，必须有ID
     * @param t
     */
    void update(T t);

    /**
     * 根据Ids更新对象
     * @param ids
     * @param t
     */
    void update(List<Long> ids, T t);


    IPage<T> page(T t, Page<T> page);
}
