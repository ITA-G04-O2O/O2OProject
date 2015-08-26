package vo;

public class RestaurantVo {

	private Integer id;
	private String name;
	private String type;
	private Integer sum;
	private Integer playPrice;
	private Double grade;
	private Double actualArrivalTime;
	
	public RestaurantVo(Integer id, String name, String type, Integer sum,
			Integer playPrice, Double grade, Double actualArrivalTime) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.sum = sum;
		this.playPrice = playPrice;
		this.grade = grade;
		this.actualArrivalTime = actualArrivalTime;
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

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
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
	
}
