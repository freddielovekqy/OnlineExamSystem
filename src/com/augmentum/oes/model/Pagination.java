package com.augmentum.oes.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.augmentum.oes.common.Constants;

public class Pagination<T> {

	// the page size of pagination, usually get number from constants and can be change.
    private int pageSize = Constants.PAGE_SIGE;  
	// the number of records.
    private int count;
	// current page
    private int currentPage = 1;
	// this url is not must
    private String url;
	// add some query condition.
    private Map<String, String> params = new HashMap<String, String>();
	// save the query result list
    private List<T> list = new ArrayList<T>();

    public Pagination() {

    }

    public Pagination(int count) {
        this.count = count;
    }

    public Pagination(int count, int currentPage) {
        super();
        this.currentPage = currentPage;
        this.count = count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {

        if (currentPage <= 0) {
            return 1;
        } else {
            return currentPage;
        }
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public void setCurrentPage(String currentPage) {

        try {
            if (currentPage == null || currentPage.equals("")) {

                this.currentPage = 1;
            } else if (Integer.parseInt(currentPage) <= 0) {

                this.currentPage = 1;
            } else {
                this.currentPage = Integer.parseInt(currentPage);
            }
        } catch (Exception e) {
            this.currentPage = 1;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        if (currentPage > getPageCount()) {
            currentPage = getPageCount();
        }
    }

    public int getPageCount() {

        if (count % pageSize == 0) {

            return count / pageSize;
        } else {
            return count / pageSize + 1;
        }
    }

    public int getBegin() {
        return (currentPage - 1) * pageSize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public void addParam(String key, String value) {
        if (params == null) {
            params = new HashMap<String, String>();
        }
        params.put(key, value);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public List<Integer> getPageNumbers() {

        List<Integer> pageNumbers = new ArrayList<Integer>();
        int pageCount = getPageCount();
        if (pageCount <= 5) {
            for (int i = 1; i <= pageCount; i++) {
                pageNumbers.add(i);
            }
        } else if (currentPage <= 3) {
            for (int i = 1; i <= 5; i++) {
                pageNumbers.add(i);
            }
        } else if (currentPage >= pageCount - 2) {
            for (int i = pageCount - 5; i <= pageCount; i++) {
                pageNumbers.add(i);
            }
        } else {
            for (int i = currentPage - 2; i <= currentPage + 2; i++) {
                pageNumbers.add(i);
            }
        }
        return pageNumbers;
    }
}
