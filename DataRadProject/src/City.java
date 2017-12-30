import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class City {
	private String city_code;
	private String co_code;
	private String reg_code;
	private String city_name;
	private int population;
	private boolean isCoastal;
	private float areaKM;
	
	private String region_name;
	private String country_name;
	
	//constructors
	public City() {
		
	}
	
	public City(String city_code, String city_name, String country_name,  String region_name,  int population, boolean isCoastal) {
		this.city_code = city_code;
		this.city_name = city_name;
		this.population = population;
		this.isCoastal = isCoastal;
		this.country_name = country_name;
		this.region_name = region_name;
		
		
	}
	
	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public City(String city_code,String co_code, String reg_code, String city_name, int population , boolean isCoastal, float areaKM) {
		this.city_code = city_code;
		this.co_code = co_code;
		this.reg_code = reg_code;
		this.city_name = city_name;
		this.population = population;
		this.isCoastal = isCoastal;
		this.areaKM = areaKM;
	}
	
	//generate getters and setters

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public String getCo_code() {
		return co_code;
	}

	public void setCo_code(String co_code) {
		this.co_code = co_code;
	}

	public String getReg_code() {
		return reg_code;
	}

	public void setReg_code(String reg_code) {
		this.reg_code = reg_code;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public boolean getCoastal() {
		return isCoastal;
	}

	public void setCoastal(boolean isCoastal) {
		this.isCoastal = isCoastal;
	}

	public float getAreaKM() {
		return areaKM;
	}

	public void setAreaKM(float areaKM) {
		this.areaKM = areaKM;
	}
	
	
	
	
	

}
