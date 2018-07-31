package cn.sn.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDaoImpl<T> implements IBaseDao<T>{

	@Resource
	private SessionFactory sessionFactory;

	private Class<T> clazz;
	
	public BaseDaoImpl(){
		//获得实体类型 有<>能用
		ParameterizedType genericSuperclass=(ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types=genericSuperclass.getActualTypeArguments();
		clazz=(Class<T>) types[0];
	}
	
	@Override
	public void save(T entity) {
		// TODO Auto-generated method stub
		getSession().save(entity);
	}
	
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		getSession().delete(getSession().get(clazz, id));
	}
	
	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		getSession().update(entity);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		String hql="FROM "+clazz.getSimpleName();
		return getSession().createQuery(hql).list();
	}

	@Override
	public T getById(Long id) {
		// TODO Auto-generated method stub
		
		return (T)getSession().get(clazz, id);
	}

	@Override
	public List<T> getByIds(Long[] ids) {
		// TODO Auto-generated method stub
		String hql="FROM "+clazz.getSimpleName()+" WHERE id in (:ids)";
		Query query=getSession().createQuery(hql);
		query.setParameterList("ids", ids);//一次赋值多个
		return query.list();
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	

	
	
}
