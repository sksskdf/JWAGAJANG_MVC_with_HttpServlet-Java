package goods.dto;

import java.sql.Timestamp;

public class GoodsVO {
	private Integer md_code;
	private String md_name;
	private Integer md_price;
	private Integer md_dc;
	private Integer md_stock;
	private String img_main;
	private String img_detail;
	private String category_main;
	private String category_sub;
	private Integer review_code;
	private String user_id;
	private String user_name;
	private Integer review_rate;
	private String review_content; 
	private Timestamp review_regdate;
	private String sort_name;
	
	public Integer getMd_code() {
		return md_code;
	}
	public void setMd_code(Integer md_code) {
		this.md_code = md_code;
	}
	public String getMd_name() {
		return md_name;
	}
	public void setMd_name(String md_name) {
		this.md_name = md_name;
	}
	public Integer getMd_price() {
		return md_price;
	}
	public void setMd_price(Integer md_price) {
		this.md_price = md_price;
	}
	public Integer getMd_dc() {
		return md_dc;
	}
	public void setMd_dc(Integer md_dc) {
		this.md_dc = md_dc;
	}
	public Integer getMd_stock() {
		return md_stock;
	}
	public void setMd_stock(Integer md_stock) {
		this.md_stock = md_stock;
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
	public Integer getReview_code() {
		return review_code;
	}
	public void setReview_code(Integer review_code) {
		this.review_code = review_code;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getReview_rate() {
		return review_rate;
	}
	public void setReview_rate(Integer review_rate) {
		this.review_rate = review_rate;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public Timestamp getReview_regdate() {
		return review_regdate;
	}
	public void setReview_regdate(Timestamp review_regdate) {
		this.review_regdate = review_regdate;
	}
	public String getSort_name() {
		return sort_name;
	}
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	
	
}
