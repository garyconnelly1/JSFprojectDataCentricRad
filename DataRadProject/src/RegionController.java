import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


@ManagedBean
@SessionScoped
public class RegionController {
	
	ArrayList<Region> regions;
	private DAO dao;
	
	//controller constructer
		public RegionController() {
			regions = new ArrayList<Region>();
			
			try {
				dao = new DAO();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//end constructor
		
		public RegionController(ArrayList<Region> regions) {
			super();
			this.regions = regions;
		}
		
		//getters
		public ArrayList<Region> getRegions() {
			return regions;
		}
		
		//setters
		public void setRegions(ArrayList<Region> regions) {
			this.regions = regions;
		}
		
		//load regions
		public void loadRegions() throws Exception {
			regions.clear();
			if (dao != null) {
				try {
					regions = dao.loadRegions();
					//System.out.println(loadCountry.size());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			
			
		
		
		}//end load regions
		
		//add region method
		public String addRegion(Region region) {
			if (dao != null) {
				try {
					dao.addRegion(region);
					return "index";
				} catch (MySQLIntegrityConstraintViolationException e) {
					FacesMessage message = new FacesMessage("Error: Country code " + region.getCo_code() + " has to exist");
					FacesContext.getCurrentInstance().addMessage(null, message);
					return null;
				} catch (CommunicationsException e) {
					FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
					FacesContext.getCurrentInstance().addMessage(null, message);
					return null;
				} catch (Exception e) {
					FacesMessage message = new FacesMessage("Error while trying to insert region " + region.getCo_code());
					FacesContext.getCurrentInstance().addMessage(null, message);
					return null;
				}
			}
			return null;
		}//end add region
		
		/*
		//delete region
		public String deleteRegion(Region region) {
	 		if (dao != null) {
	 			try {
	 				dao.deleteRegion(region);
	 				return "index";
	 			} catch (MySQLIntegrityConstraintViolationException e) {
	 				FacesMessage message = new FacesMessage("Error: Country ID " + region.getCo_code() + " not found");
	 				FacesContext.getCurrentInstance().addMessage(null, message);
	 				return null;
	 				
	 			} catch (CommunicationsException e) {
	 				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
	 				FacesContext.getCurrentInstance().addMessage(null, message);
	 				return null;
	 			} catch (Exception e) {
	 				FacesMessage message = new FacesMessage("Error while trying to delete Country " + region.getReg_code());
	 				FacesContext.getCurrentInstance().addMessage(null, message);
	 				return null;
	 			}
	 		}
	 		return null;
	 	}//end delete country
	 	*/
		
		
		

}//end class
