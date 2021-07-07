package com.laptrinhjavaweb.paging;

import com.laptrinhjavaweb.sort.Sorter;

public interface IPageble {
	
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
	
}
