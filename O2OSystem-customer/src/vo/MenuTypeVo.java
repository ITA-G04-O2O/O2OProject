package vo;

public class MenuTypeVo {

	private Integer id;
	private String menuTypeName;
	public MenuTypeVo(Integer id, String menuTypeName) {
		super();
		this.id = id;
		this.menuTypeName = menuTypeName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuTypeName() {
		return menuTypeName;
	}
	public void setMenuTypeName(String menuTypeName) {
		this.menuTypeName = menuTypeName;
	}
	
	
}
