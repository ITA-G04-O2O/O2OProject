package vo;

import java.util.Set;

public class MenuTypeVo {

	private Integer id;
	private String menuTypeName;
	private Set<MenuItemVo> menuItems;
	public MenuTypeVo(Integer id, String menuTypeName, Set<MenuItemVo> menuItems) {
		super();
		this.id = id;
		this.menuTypeName = menuTypeName;
		this.menuItems = menuItems;
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
	public Set<MenuItemVo> getMenuItems() {
		return menuItems;
	}
	public void setMenuItems(Set<MenuItemVo> menuItems) {
		this.menuItems = menuItems;
	}
	
	
}
