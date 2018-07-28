package cn.sn.oa.base;

import java.util.List;

public interface IbaseDao<T> {
	/*
	 * 添加
	 */
	public void save(T entity);
	
	/*
	 * 根据id删除
	 */
	public void delete(Long id);
	
	/*
	 * 根据id修改
	 */
	public void update(T entity);
	
	/*
	 * 根据id查询
	 */
	public T getById(Long id);
	
	/*
	 * 一次查询多个对象
	 */
	public List<T> getByIds(Long[] ids);
	/*
	 * 查询所有
	 */
	public List<T> findAll();
	
	
	
}
