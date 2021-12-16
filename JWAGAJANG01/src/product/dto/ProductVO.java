package product.dto;

public class ProductVO {
	// 필드
	private int code;
	private String name;
	private int price;
	private	String pictureUrl;
	private String description;
	
	// 생성자
	public ProductVO() { }

	public ProductVO(int code, String name, int price, String pictureUrl, String description) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.pictureUrl = pictureUrl;
		this.description = description;
	}
	
	// Getter/Setter
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}