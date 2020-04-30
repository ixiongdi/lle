package fun.xruo.lle.common;

import java.util.List;

/**
 * @author xiongdi (kotlin@qq.com)
 * @since 2020/4/30 16:04
 */
public interface BaseService<T extends Base> {
    T get(Long id);

    List<T> list(T t);

    void insert(T t);

    Long count(T t);

    void delete(Long id);

    void update(T t);
}
