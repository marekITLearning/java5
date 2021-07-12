package sk.itlearning.java5.biz.accframe;

import java.util.Date;

public class AccFrame {

	private String class1;
	private String className1;
	private String class2;
	private String className2;
	private String class3;
	private String className3;
	private String type1;
	private String type2;
	private Date validFrom;
	private Date validTo;

	public AccFrame(String c1, String n1, String c2, String n2, String c3, String n3, String t1, String t2, Date vf,
			Date vt) {
		setClass1(c1);
		setClassName1(n1);
		setClass2(c2);
		setClassName2(n3);
		setClass3(c3);
		setClassName3(n3);
		setType1(t1);
		setType2(t2);
		setValidFrom(vf);
		setValidTo(vt);
	}

	public String getClass1() {
		return class1;
	}

	public void setClass1(String class1) {
		this.class1 = class1;
	}

	public String getClassName1() {
		return className1;
	}

	public void setClassName1(String className1) {
		this.className1 = className1;
	}

	public String getClass2() {
		return class2;
	}

	public void setClass2(String class2) {
		this.class2 = class2;
	}

	public String getClassName2() {
		return className2;
	}

	public void setClassName2(String className2) {
		this.className2 = className2;
	}

	public String getClass3() {
		return class3;
	}

	public void setClass3(String class3) {
		this.class3 = class3;
	}

	public String getClassName3() {
		return className3;
	}

	public void setClassName3(String className3) {
		this.className3 = className3;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

}
