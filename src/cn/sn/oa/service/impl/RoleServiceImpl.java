package cn.sn.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sn.oa.dao.IRoleDao;
import cn.sn.oa.domain.Role;
import cn.sn.oa.service.IRoleService;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService{

	@Resource
	private IRoleDao roleDao; 
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleDao.findAll();
	}

	@Override
	public void delete(Role model) {
		// TODO Auto-generated method stub
		roleDao.delete(model.getId());
		
	}

	@Override
	public Role getById(Long id) {
		// TODO Auto-generated method stub
		return roleDao.getById(id);
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		roleDao.update(role);
	}

	@Override
	public void save(Role model) {
		// TODO Auto-generated method stub
		roleDao.save(model);
	}

}
