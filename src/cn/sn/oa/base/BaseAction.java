package cn.sn.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import cn.sn.oa.service.IBookService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	@Resource
	protected IBookService bookService;
	
	protected T model;
	
	public BaseAction(){
		ParameterizedType type=(ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] types=type.getActualTypeArguments();
		Class<T> clazz=(Class<T>) types[0];
		try {
			model=clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return model;
	}

}
