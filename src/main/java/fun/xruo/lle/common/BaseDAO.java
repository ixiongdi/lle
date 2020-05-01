package fun.xruo.lle.common;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 16:07
 */
public interface BaseDAO<T> {
    void insert(T t);

    void insertBatch(List<T> list);

    List<T> select(T t);

    T selectById(Long id);

    List<T> selectBatchByIds(@Param("ids") List<Long> ids);

    List<T> selectBatchByArgs(Map<String, Object> args);

    Long count(T t);

    Long countByArgs(Map<String, Object> args);

    void update(T t);

    void updateById(@Param("id") Long id, T t);

    void updateBatchByIds(@Param("ids") List<Long> ids, T t);

    void updateBatchByArgs(@Param("args") Map<String, Object> args, T t);

    void delete(T t);

    void deleteById(Long id);

    void deleteBatchByIds(List<Long> ids);

    void deleteBatchByArgs(Map<String, Object> args);
}
