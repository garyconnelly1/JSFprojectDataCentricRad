import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
@SessionScoped
public class CityController {
	
	ArrayList<City> cities;
	private DAO dao;
	
	//controller constructer
		public CityController() {
			cities = new ArrayList<City>();
			
			try {
				dao = new DAO();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//end constructor
		
		public CityController(ArrayList<City> cities) {
			super();
			this.cities = cities;
		}
		
		//getters
		public ArrayList<City> getCities() {
			return cities;
		}
		
		//setters
		public void setRegions(ArrayList<City> cities) {
			this.cities = cities;
		}
		
		//load cities
		
				public void loadCities() throws Exception {
					cities.clear();
					if (dao != null) {
						try {
							cities = dao.loadCities();
							//System.out.println(loadCountry.size());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
					
					
					
				
				
				}//end load cities
				
				
				
				//city details
				
				public String cityDetails() throws Exception {
					cities.clear();
					if (dao != null) {
						try {
							cities = dao.cityDetails();
							//System.out.println(loadCountry.size());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
					
					return null;
					
				
				
				}//end city details
				
				
				
				
				
				
				
				
				
	//add cities method
	public String addCity(City city) {
		if (dao != null) {
			try {
				dao.addCity(city);
				return "index";
			} catch (MySQLIntegrityConstraintViolationException e) {
				FacesMessage message = new FacesMessage("Error: City code " + city.getCity_code() + " has to exist");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (CommunicationsException e) {
				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (Exception e) {
				FacesMessage message = new FacesMessage("Error while trying to insert region " + city.getCity_code());
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
		}
		
		
		return null;
	}//end add cities
	
	
	
	
	//find cities method
		public String findCity(City city) {
			if (dao != null) {
				try {
					dao.findCity(city);
					return "index";
				} catch (MySQLIntegrityConstraintViolationException e) {
					FacesMessage message = new FacesMessage("Error: City code " + city.getPopulation() + " has to exist");
					FacesContext.getCurrentInstance().addMessage(null, message);
					return null;
				} catch (CommunicationsException e) {
					FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
					FacesContext.getCurrentInstance().addMessage(null, message);
					return null;
				} catch (Exception e) {
					FacesMessage message = new FacesMessage("Error while trying to insert region " + city.getCity_code());
					FacesContext.getCurrentInstance().addMessage(null, message);
					return null;
				}
			}
			
			cities.clear();
			if (dao != null) {
				try {
					cities = dao.findCity(city);
					//System.out.println(loadCountry.size());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			return null;
		}//end add region
	
	
	
	
	
	
	
		

}//end class
