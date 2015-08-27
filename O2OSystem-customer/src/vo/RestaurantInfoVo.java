package vo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.g04.o2o.entity.Address;
import com.g04.o2o.entity.MenuItem;
import com.g04.o2o.entity.MenuType;
import com.g04.o2o.entity.Order;

public class RestaurantInfoVo {

	private Integer id;
	private String name;
	private String type;
	private Integer playPrice;
	private Double grade;
	private Double actualArrivalTime;
	private String notice;
	private Address address;
	
	private List<MenuTypeVo> menuTypes = new ArrayList<MenuTypeVo>();
	private Set<MenuItemVo> menus=new HashSet<MenuItemVo>();
	
	public RestaurantInfoVo(Integer id, String name, String type,
			Integer playPrice, Double grade, Double actualArrivalTime,
			String notice, List<MenuTypeVo> menuTypes,
			Set<MenuItemVo> menus) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.playPrice = playPrice;
		this.grade = grade;
		this.actualArrivalTime = actualArrivalTime;
		this.notice = notice;
		this.menuTypes = menuTypes;
		this.menus = menus;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getPlayPrice() {
		return playPrice;
	}
	public void setPlayPrice(Integer playPrice) {
		this.playPrice = playPrice;
	}
	public Double getGrade() {
		return grade;
	}
	public void setGrade(Double grade) {
		this.grade = grade;
	}
	public Double getActualArrivalTime() {
		return actualArrivalTime;
	}
	public void setActualArrivalTime(Double actualArrivalTime) {
		this.actualArrivalTime = actualArrivalTime;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<MenuTypeVo> getMenuTypes() {
		return menuTypes;
	}
	public void setMenuTypes(List<MenuTypeVo> menuTypes) {
		this.menuTypes = menuTypes;
	}
	public Set<MenuItemVo> getMenus() {
		return menus;
	}
	public void setMenus(Set<MenuItemVo> menus) {
		this.menus = menus;
	}
	
}
