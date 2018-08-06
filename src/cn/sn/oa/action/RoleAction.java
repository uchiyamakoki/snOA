package cn.sn.oa.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.util.ValueStack;

import cn.sn.oa.base.BaseAction;
import cn.sn.oa.domain.Role;

/*
 * 岗位管理Action
 */
@Controller
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	
        /*
         * 查询岗位列表
         */
	public String list(){
		List<Role> list=roleService.findAll();
		
		ValueStack vs=getValueStack();
		vs.set("list",list);
		
		return "list";
	}
	
	/*
	 * 根据id删除岗位
	 */
	public String delete(){
		roleService.delete(model);
		return "toList";
	}
}
