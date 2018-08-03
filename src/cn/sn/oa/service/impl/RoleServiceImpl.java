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

}
