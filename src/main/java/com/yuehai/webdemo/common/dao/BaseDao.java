package com.yuehai.webdemo.common.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 数据库公共操作接口
 * Created by 月海 2018/5/10
 */
@Repository
public interface BaseDao<T> {
    /**
     *
     *
     * @param id
     * @usage 根据id获取数据库中唯一纪录，封装成java对象并返回
     * @return T
     */
    public T getById(Serializable id);

    /**
     *
     *
     * @param id
     * @usage 根据id懒加载数据库中唯一纪录，封装成java对象并返回
     * @return T
     */
    public T load(Serializable id);

    /**
     *
     *
     * @param columnName
     *
     * @param value
     *
     * @usage 根据列名，以及对应的值获取数据库中惟一纪录，封装成Java对象并返回
     *
     * @return
     */
    public T getByUniqueKey(String columnName, Object value);

    /**
     *
     *
     * @param nameValuePairs
     *
     * @return T
     */
    public T getUniqueResult(Map<String, Object> nameValuePairs);

    /**
     *
     *
     * @param columnName
     *
     * @param value
     *
     * @param sort
     *
     * @param order
     *            asc/desc
     * @return List<T>
     */
    public List<T> getListByColumn(String columnName, Object value,
                                   String sort, String order);

    public List<T> getListByColumn(String columnName, Object value);

    /**
     * ͨ
     *
     * @param nameValuePairs
     *
     * @param sort
     *
     * @param order
     *            asc/desc
     * @return List<T>
     */
    public List<T> getListByColumns(Map<String, Object> nameValuePairs,
                                    String sort, String order);

    public List<T> getListByColumns(Map<String, Object> nameValuePairs);

    /**
     *
     *
     * @return List<T>
     */
    public List<T> getAll();

    /**
     *
     *
     * @param t
     * @return Serializable id
     */
    public Serializable save(T t);

    /**
     *
     *
     * @param t
     */
    public void update(T t);

    /**
     *
     *
     * @param t
     */
    public void delete(T t);

    /**
     * QBC
     * @return
     */
    public Criteria createCriteria();

    /**
     * @param <E>
     * @param <D>
     * @param criteria
     * @param pageNo
     * @param pageSize
     * @param dtoClazz
     * @return
     */
//    public <E, D extends Dto> DtoResultWithPageInfo<D> queryPageListByCriteria(
//            Criteria criteria, int pageNo, int pageSize, Class<D> dtoClazz);


    /**
     * @param <E>
     * @param <D>
     * @param criteria
     * @param qo
     * @param class1
     * @return
     */
//    public <E, D extends Dto> DtoResultWithPageInfo<D> queryPageListByCriteriaWithQo(PageQo qo, Class<D> dtoClazz);
}
