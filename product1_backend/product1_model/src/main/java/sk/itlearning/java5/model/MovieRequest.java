package sk.itlearning.java5.model;

public class MovieRequest {

	private Integer page = Integer.valueOf(0);

	private Integer pageSize = Integer.valueOf(100);

	private String[] order;

	private Boolean asc = Boolean.TRUE;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String[] getOrder() {
		return order;
	}

	public void setOrder(String[] order) {
		this.order = order;
	}

	public Boolean getAsc() {
		return asc;
	}

	public void setAsc(Boolean asc) {
		this.asc = asc;
	}

}
