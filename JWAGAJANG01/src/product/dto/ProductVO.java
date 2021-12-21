package product.dto;

import java.sql.Timestamp;

public class ProductVO {
	private int md_code;
	private String md_name;
	private int md_price;
	private int md_dc;
	private int dc_price;
	private String img_main;
	private String img_detail;
	private Timestamp md_regdate;
	private Timestamp md_editdate;
	private String category_main;
	private String category_sub;
	private int md_ordercnt;
	
	public ProductVO() {}

	public ProductVO(int md_code, String md_name, int md_price, int md_dc, int dc_price, String img_main, String img_detail,
			Timestamp md_regdate, Timestamp md_editdate, String category_main, String category_sub, int md_ordercnt) {
		super();
		this.md_code = md_code;
		this.md_name = md_name;
		this.md_price = md_price;
		this.md_dc = md_dc;
		this.dc_price = dc_price;
		this.img_main = img_main;
		this.img_detail = img_detail;
		this.md_regdate = md_regdate;
		this.md_editdate = md_editdate;
		this.category_main = category_main;
		this.category_sub = category_sub;
		this.md_ordercnt = md_ordercnt;
	}

	public int getMd_code() {
		return md_code;
	}

	public void setMd_code(int md_code) {
		this.md_code = md_code;
	}

	public String getMd_name() {
		return md_name;
	}

	public void setMd_name(String md_name) {
		this.md_name = md_name;
	}

	public int getMd_price() {
		return md_price;
	}

	public void setMd_price(int md_price) {
		this.md_price = md_price;
	}

	public int getMd_dc() {
		return md_dc;
	}

	public void setMd_dc(int md_dc) {
		this.md_dc = md_dc;
	}

	public int getDc_price() {
		return dc_price;
	}

	public void setDc_price(int dc_price) {
		this.dc_price = dc_price;
	}

	public String getImg_main() {
		return img_main;
	}

	public void setImg_main(String img_main) {
		this.img_main = img_main;
	}

	public String getImg_detail() {
		return img_detail;
	}

	public void setImg_detail(String img_detail) {
		this.img_detail = img_detail;
	}

	public Timestamp getMd_regdate() {
		return md_regdate;
	}

	public void setMd_regdate(Timestamp md_regdate) {
		this.md_regdate = md_regdate;
	}

	public Timestamp getMd_editdate() {
		return md_editdate;
	}

	public void setMd_editdate(Timestamp md_editdate) {
		this.md_editdate = md_editdate;
	}

	public String getCategory_main() {
		return category_main;
	}

	public void setCategory_main(String category_main) {
		this.category_main = category_main;
	}

	public String getCategory_sub() {
		return category_sub;
	}

	public void setCategory_sub(String category_sub) {
		this.category_sub = category_sub;
	}

	public int getMd_ordercnt() {
		return md_ordercnt;
	}

	public void setMd_ordercnt(int md_ordercnt) {
		this.md_ordercnt = md_ordercnt;
	}
	
}
