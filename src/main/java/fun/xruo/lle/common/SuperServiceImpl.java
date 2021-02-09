package fun.xruo.lle.common;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtQueryChainWrapper;
import com.baomidou.mybatisplus.extension.kotlin.KtUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author xiongdi
 */
public class SuperServiceImpl<T> implements IService<T> {
    @Override
    public boolean save(T entity) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<T> entityList) {
        return false;
    }

    @Override
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean removeById(Serializable id) {
        return false;
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {
        return false;
    }

    @Override
    public boolean remove(Wrapper<T> queryWrapper) {
        return false;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return false;
    }

    @Override
    public boolean updateById(T entity) {
        return false;
    }

    @Override
    public boolean update(Wrapper<T> updateWrapper) {
        return false;
    }

    @Override
    public boolean update(T entity, Wrapper<T> updateWrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<T> entityList) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(T entity) {
        return false;
    }

    @Override
    public T getById(Serializable id) {
        return null;
    }

    @Override
    public List<T> listByIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    public List<T> listByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    public T getOne(Wrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public T getOne(Wrapper<T> queryWrapper, boolean throwEx) {
        return null;
    }

    @Override
    public Map<String, Object> getMap(Wrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int count(Wrapper<T> queryWrapper) {
        return 0;
    }

    @Override
    public List<T> list(Wrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public List<T> list() {
        return null;
    }

    @Override
    public <E extends IPage<T>> E page(E page, Wrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public <E extends IPage<T>> E page(E page) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps(Wrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public List<Map<String, Object>> listMaps() {
        return null;
    }

    @Override
    public List<Object> listObjs() {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public List<Object> listObjs(Wrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public <V> List<V> listObjs(Wrapper<T> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page, Wrapper<T> queryWrapper) {
        return null;
    }

    @Override
    public <E extends IPage<Map<String, Object>>> E pageMaps(E page) {
        return null;
    }

    @Override
    public BaseMapper<T> getBaseMapper() {
        return null;
    }

    @Override
    public Class<T> getEntityClass() {
        return null;
    }

    @Override
    public QueryChainWrapper<T> query() {
        return null;
    }

    @Override
    public LambdaQueryChainWrapper<T> lambdaQuery() {
        return null;
    }

    @Override
    public KtQueryChainWrapper<T> ktQuery() {
        return null;
    }

    @Override
    public KtUpdateChainWrapper<T> ktUpdate() {
        return null;
    }

    @Override
    public UpdateChainWrapper<T> update() {
        return null;
    }

    @Override
    public LambdaUpdateChainWrapper<T> lambdaUpdate() {
        return null;
    }

    @Override
    public boolean saveOrUpdate(T entity, Wrapper<T> updateWrapper) {
        return false;
    }
}
