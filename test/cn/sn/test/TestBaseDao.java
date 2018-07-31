package cn.sn.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sn.oa.domain.Book;
import cn.sn.oa.service.IBookService;
import cn.sn.oa.service.impl.BookServiceImpl;

public class TestBaseDao {
	/*
	 * 测试save
	 */
	@Test
	public void test1(){
		//初始化spring
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService=(IBookService) ctx.getBean("bookServiceImpl");
		
		Book book=new Book();
		book.setName("c");
		
		bookService.save(book);
	}
	/*
	 * 测试delete
	 */
	@Test
	public void test2(){
		//初始化spring
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService=(IBookService) ctx.getBean("bookServiceImpl");
		
		bookService.delete(1L);
	}
	
	/*
	 * 测试update
	 */
	@Test
	public void test3(){
		//初始化spring
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService=(IBookService) ctx.getBean("bookServiceImpl");
		
		Book book=new Book();
		book.setId(2L);
		book.setName("php");
		
		bookService.update(book);
	}
	
	/*
	 * 测试getByid
	 */
	@Test
	public void test4(){
		//初始化spring
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService=(IBookService) ctx.getBean("bookServiceImpl");
		
		Book book=bookService.getById(2L);
		System.out.print(book.toString());
		
	}
	
	/*
	 * 测试getbyids
	 */
	@Test
	public void test5(){
		//初始化spring
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService=(IBookService) ctx.getBean("bookServiceImpl");
		
		Long[] ids=new Long[]{2L,3L,4L};
		List<Book> list=bookService.getByIds(ids);
		for(Book book:list){
			System.out.println(book);
		}
		
	}
	
	/*
	 * 测试findall
	 */
	@Test
	public void test6(){
		//初始化spring
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IBookService bookService=(IBookService) ctx.getBean("bookServiceImpl");
		
		
		List<Book> list=bookService.findAll();
		for(Book book:list){
			System.out.println(book);
		}
		
	}


}
