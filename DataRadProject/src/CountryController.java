import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
//import javax.naming.NamingException;
//import javax.faces.application.FacesMessage;
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;

//import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
//import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
@SessionScoped
public class CountryController {
	//String myName = "Gary";
	ArrayList<Country> countries;
	private DAO dao;
	
	//controller constructer
	public CountryController() {
		countries = new ArrayList<Country>();
		
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end constructor
	
	public CountryController(ArrayList<Country> countries) {
		super();
		this.countries = countries;
	}
	
	//getters
	public ArrayList<Country> getCountries() {
		return countries;
	}
	
	//setters
	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}
	
	//load country
	public void loadCountries() throws Exception {
		countries.clear();
		if (dao != null) {
			try {
				countries = dao.loadCountries();
				//System.out.println(loadCountry.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	
	
	}
	
	//add country method
	public String addCountry(Country country) {
		if (dao != null) {
			try {
				dao.addCountry(country);
				return "index";
			} catch (MySQLIntegrityConstraintViolationException e) {
				FacesMessage message = new FacesMessage("Error: Country code " + country.getCode() + " already exists");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (CommunicationsException e) {
				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			} catch (Exception e) {
				FacesMessage message = new FacesMessage("Error while trying to insert country " + country.getCode());
				FacesContext.getCurrentInstance().addMessage(null, message);
				return null;
			}
		}
		return null;
	}
	//to delete country
	
	
	
	public String deleteCountry(Country country) {
		 		if (dao != null) {
		 			try {
		 				dao.deleteCountry(country);
		 				return "index";
		 			} catch (MySQLIntegrityConstraintViolationException e) {
		 				FacesMessage message = new FacesMessage("Error: Country ID " + country.getCode() + " not found");
		 				FacesContext.getCurrentInstance().addMessage(null, message);
		 				return null;
		 			} catch (CommunicationsException e) {
		 				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
		 				FacesContext.getCurrentInstance().addMessage(null, message);
		 				return null;
		 			} catch (Exception e) {
		 				FacesMessage message = new FacesMessage("Error while trying to delete Country " + country.getCode());
		 				FacesContext.getCurrentInstance().addMessage(null, message);
		 				return null;
		 			}
		 		}
		 		return null;
		 	}//end delete country
		 	
	
	
	
	//update country
	
		 	public String updateCountry(Country country) {
		 		if (dao != null) {
		 			try {
		 				System.out.println(country);
		 				dao.updateCountry(country);
		 				return "index";
					} catch (MySQLIntegrityConstraintViolationException e) {
		 				FacesMessage message = new FacesMessage("Error: Country ID " + country.getCode() + " not found");
		 				FacesContext.getCurrentInstance().addMessage(null, message);
		 				return null;
		 			} catch (CommunicationsException e) {
		 				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
		 				FacesContext.getCurrentInstance().addMessage(null, message);
		 				return null;
		 			} catch (Exception e) {
		 				FacesMessage message = new FacesMessage("Error while trying to update Country " + country.getCode());
		 				FacesContext.getCurrentInstance().addMessage(null, message);
		 				return null;
		 			}
		 		}
		 		return null;
		 	}//end update
		 	
		 	
	
	
	
	
	
	
	
	


}

/*


public ArrayList<Country> setCountries() throws Throwable {
	DAO dao = new DAO();
	loadCountry = dao.loadCountries();
	return loadCountry;
}
*/
/*
 import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
public class ProductController {
	
	ArrayList<Product> products;
	private DAO dao;


	public ProductController() {
		super();
		products = new ArrayList<Product>();
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ProductController(ArrayList<Product> products) {
		super();
		this.products = products;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	
	public void loadProducts() throws Exception {
		products.clear();
		if (dao != null) {
			try {
				products = dao.loadProducts();
				System.out.println(products.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
 */
