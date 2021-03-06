package cn.sn.oa.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import cn.sn.oa.service.IBookService;
import cn.sn.oa.service.IRoleService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T>{

	@Resource
	protected IBookService bookService;
	@Resource
	protected IRoleService roleService;
	
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
	
	/**
	 * 获得值栈
	 * @return
	 */
	protected ValueStack getValueStack(){
		return ActionContext.getContext().getValueStack();
	}
	

}
