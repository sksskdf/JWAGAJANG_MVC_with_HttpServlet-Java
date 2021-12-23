package member.model;

import java.sql.Date;

public class Order {
	private String mdpic = null;
	private String mdname = null;
	private Date mdorderdate = null;
	private String mdprice = null;
	private String mdreview = null;
	private Integer mdcode = null;
	
	
	public Order() {
	}
	
	
	
	public Order(String mdpic, String mdname, Date mdorderdate, String mdprice) {
		super();
		this.mdpic = mdpic;
		this.mdname = mdname;
		this.mdorderdate = mdorderdate;
		this.mdprice = mdprice;
	}
	
	
	public Order(String mdpic, String mdname, Date mdorderdate, String mdprice,int mdcode) {
		super();
		this.mdpic = mdpic;
		this.mdname = mdname;
		this.mdorderdate = mdorderdate;
		this.mdprice = mdprice;
		this.mdcode = mdcode;
	}


	
	public String getMdpic() {
		return mdpic;
	}



	public void setMdpic(String mdpic) {
		this.mdpic = mdpic;
	}



	public String getMdname() {
		return mdname;
	}



	public void setMdname(String mdname) {
		this.mdname = mdname;
	}



	public Date getMdorderdate() {
		return mdorderdate;
	}



	public void setMdorderdate(Date mdorderdate) {
		this.mdorderdate = mdorderdate;
	}



	public String getMdprice() {
		return mdprice;
	}



	public void setMdprice(String mdprice) {
		this.mdprice = mdprice;
	}



	public String getMdreview() {
		return mdreview;
	}



	public void setMdreview(String mdreview) {
		this.mdreview = mdreview;
	}

	public Integer getMdcode() {
		return mdcode;
	}

	public void setMdcode(Integer mdcode) {
		this.mdcode = mdcode;
	}



	@Override
	public String toString() {
		return "Order [mdpic=" + mdpic + ", mdname=" + mdname + ", mdorderdate=" + mdorderdate + ", mdprice=" + mdprice
				+ ", mdreview=" + mdreview + "]";
	}
	
	
}
