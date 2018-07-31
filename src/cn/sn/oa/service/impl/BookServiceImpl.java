package cn.sn.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sn.oa.dao.IBookDao;
import cn.sn.oa.domain.Book;
import cn.sn.oa.service.IBookService;

@Service
@Transactional
public class BookServiceImpl implements IBookService{

	@Resource
	private IBookDao bookDao;

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		bookDao.delete(id);
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}

	@Override
	public Book getById(Long id) {
		// TODO Auto-generated method stub
		return bookDao.getById(id);
	}

	@Override
	public List<Book> getByIds(Long[] ids) {
		// TODO Auto-generated method stub
		return bookDao.getByIds(ids);
	}

	@Override
	public void save(Book book) {
		// TODO Auto-generated method stub
		bookDao.save(book);
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		bookDao.update(book);
	}
	
	

}
