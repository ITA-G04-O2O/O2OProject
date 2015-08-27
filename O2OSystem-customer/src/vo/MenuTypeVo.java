package vo;

public class MenuTypeVo {

	private Integer id;
	private String menuTypeName;
	private MenuItemVo menuIttem;
	
	public MenuTypeVo(Integer id, String menuTypeName, MenuItemVo menuIttem) {
		super();
		this.id = id;
		this.menuTypeName = menuTypeName;
		this.menuIttem = menuIttem;
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
	public MenuItemVo getMenuIttem() {
		return menuIttem;
	}
	public void setMenuIttem(MenuItemVo menuIttem) {
		this.menuIttem = menuIttem;
	}
}
