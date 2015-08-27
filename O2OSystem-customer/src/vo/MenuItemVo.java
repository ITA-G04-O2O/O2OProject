package vo;

public class MenuItemVo {

	private Integer id;
	private String itemName;
	private Double price;
	private String description;
	public MenuItemVo(Integer id, String itemName, Double price,
			String description) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.price = price;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
