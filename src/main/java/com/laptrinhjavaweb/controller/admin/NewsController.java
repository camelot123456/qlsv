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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewsModel newsModel = FormUtil.toModel(NewsModel.class, req);// thay thế cho hàm req.getParameters vì giả sử có 10 param thì có 10 hàm req.getParam... ,còn dùng bean common sẽ giúp làm gọn code
		IPageble pageable = new PageRequest(newsModel.getPage(), newsModel.getMaxPageItem(), new Sorter(newsModel.getSortName(), newsModel.getSortBy()));
		newsModel.setListResult(newsService.findAll(pageable));
		newsModel.setTotalItem(newsService.getTotalItem());
		newsModel.setTotalPage((int) Math.ceil((double) newsModel.getTotalItem() / newsModel.getMaxPageItem()));
		req.setAttribute(SystemConstant.MODEL, newsModel);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/news/list.jsp");
		rd.forward(req, resp);
	}
}
