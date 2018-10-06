package sk.itlearning.java5.flow.customer.view.overview.model;

import java.io.Serializable;

public class Overview implements Serializable {

	private static final long serialVersionUID = 1L;

	private Header header;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public static class Header {
		private String label;
		private String text;

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}

}
