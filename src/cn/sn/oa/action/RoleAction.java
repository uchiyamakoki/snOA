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
	/*
	 * 跳转到修改页面
	 */
	public String editUI(){
		//根据id查询岗位，用于回显
		Role role=roleService.getById(model.getId());
		
		getValueStack().push(role);
		
		return "editUI";
	}
	/*
	 * 修改岗位
	 */
	public String edit(){
		//先查询，然后在修改
		Role role=roleService.getById(model.getId());
		
		role.setName(model.getName());
		role.setDescription(model.getDescription());
		
		roleService.update(role);
		
		return "toList";
	}
}
