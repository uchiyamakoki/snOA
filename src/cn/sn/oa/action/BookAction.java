package cn.sn.oa.action;

import org.springframework.stereotype.Controller;

import cn.sn.oa.base.BaseAction;
import cn.sn.oa.domain.Book;

@Controller
public class BookAction extends BaseAction<Book>{

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(model);
		bookService.save(model);
		return NONE;
	}
}
