package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.models.NewsModel;
import com.laptrinhjavaweb.paging.IPageble;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewsService;
import com.laptrinhjavaweb.sort.Sorter;
import com.laptrinhjavaweb.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewsController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private INewsService newsService;
	
	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewsModel newsModel = FormUtil.toModel(NewsModel.class, req);// thay thế cho hàm req.getParameters vì giả sử có 10 param thì có 10 hàm req.getParam... ,còn dùng bean common sẽ giúp làm gọn code
		String view = "";
		if (newsModel.getType().equals(SystemConstant.LIST)) {
			IPageble pageable = new PageRequest(newsModel.getPage(), newsModel.getMaxPageItem(), new Sorter(newsModel.getSortName(), newsModel.getSortBy()));
			newsModel.setListResult(newsService.findAll(pageable));
			newsModel.setTotalItem(newsService.getTotalItem());
			newsModel.setTotalPage((int) Math.ceil((double) newsModel.getTotalItem() / newsModel.getMaxPageItem()));
			req.setAttribute(SystemConstant.MODEL, newsModel);
			view = "/views/admin/news/list.jsp";
		} else if (newsModel.getType().equals(SystemConstant.EDIT)) {
			if (newsModel.getId() != null) {
				newsModel = newsService.findOne(newsModel.getId());
			} else {
				
			}
			req.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/news/edit.jsp";
		}
		req.setAttribute(SystemConstant.MODEL, newsModel);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
