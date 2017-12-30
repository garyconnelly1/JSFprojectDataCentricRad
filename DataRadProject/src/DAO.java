import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.PreparedStatement;

//import com.mysql.jdbc.PreparedStatement;


//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class DAO {
 private DataSource mysqlDS;


 public DAO() throws Exception {
  Context context = new InitialContext();
  String jndiName = "java:comp/env/jdbc/geography";
  mysqlDS = (DataSource) context.lookup(jndiName);
 }

// load countries
 public ArrayList<Country> loadCountries() throws Exception {
		ArrayList<Country> countries = new ArrayList<Country>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from country";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);

		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String code = myRs.getString("co_code");
			String name = myRs.getString("co_name");
			String details = myRs.getString("co_details");

			// create new student object
			Country country = new Country(code, name, details);

			countries.add(country);
		}	
		return countries;
	}
 
 //to add country
 public void addCountry(Country country) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into country values (?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, country.getCode());
		myStmt.setString(2, country.getName());
		myStmt.setString(3, country.getDetails());
		myStmt.execute();			
	}
 
//to delete country
public void deleteCountry(Country country) throws Exception {
	 		Connection myConn = null;
	 		PreparedStatement myStmt = null;
	 		//ResultSet myRs = null;
	 		
	 		myConn = mysqlDS.getConnection();
	 		String sql = "delete from country where co_code=?";
	 		myStmt = myConn.prepareStatement(sql);
	 		myStmt.setString(1, country.getCode());
	 		myStmt.execute();
	 	}



//to update country
public void updateCountry(Country country) throws Exception {
	 	
	 		Connection myConn = null;
	 		PreparedStatement myStmt = null;
	 		ResultSet myRs = null;
	 		
	 		myConn = mysqlDS.getConnection();
	 		String sql = "UPDATE COUNTRY SET co_name=?, co_details=? WHERE co_code=?";
	 		
	 		
	 		
	 		myStmt = myConn.prepareStatement(sql);
	 		myStmt.setString(3, country.getCode());
	 		myStmt.setString(1, country.getName());
	 		myStmt.setString(2, country.getDetails());
	 		myStmt.execute();		
	 		
	 		
	 	}//end update









	
 
 
 //load regions
 
 public ArrayList<Region> loadRegions() throws Exception {
		ArrayList<Region> regions = new ArrayList<Region>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from region";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);

		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String co_code = myRs.getString("co_code");
			String reg_code = myRs.getString("reg_code");
			String reg_name = myRs.getString("reg_name");
			String reg_desc = myRs.getString("reg_desc");
			

			// create new student object
			Region region = new Region(co_code, reg_code, reg_name, reg_desc);

			regions.add(region);
		}	
		return regions;
	}
 
 
//to add region
public void addRegion(Region region) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into region values (?, ?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, region.getCo_code());
		myStmt.setString(2, region.getReg_code());
		myStmt.setString(3, region.getReg_name());
		myStmt.setString(4, region.getReg_desc());
		myStmt.execute();			
	}//end add region

/*
//to delete region
public void deleteRegion(Region region) throws Exception {
	 		Connection myConn = null;
	 		PreparedStatement myStmt = null;
	 		//ResultSet myRs = null;
	 		
	 		myConn = mysqlDS.getConnection();
	 		String sql = "delete from region where co_code=? and where reg_code=?";
	 		myStmt = myConn.prepareStatement(sql);
	 		myStmt.setString(1, region.getCo_code());
	 		myStmt.setString(2, region.getReg_code());
	 		myStmt.execute();
	 	}//end delete region
	 	*/





//load cities
public ArrayList<City> loadCities() throws Exception {
		ArrayList<City> cities = new ArrayList<City>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from city";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);

		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String city_code = myRs.getString("cty_code");
			String co_code = myRs.getString("co_code");
			String reg_code = myRs.getString("reg_code");
			String city_name = myRs.getString("cty_name");
			int population = myRs.getInt("population");
			boolean isCoastal = myRs.getBoolean("isCoastal");
			float areaKM = myRs.getFloat("areaKM");
			

			// create new student object
			City city = new City(city_code, co_code, reg_code, city_name,population,isCoastal,areaKM);

			cities.add(city);
		}	
		return cities;
	}

//to add city
public void addCity(City city) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();
		String sql = "insert into city values (?, ?, ?, ?, ?, ?, ?)";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1, city.getCity_code());
		myStmt.setString(2, city.getCo_code());
		myStmt.setString(3, city.getReg_code());
		myStmt.setString(4, city.getCity_name());
		myStmt.setInt(5, city.getPopulation());
		myStmt.setString(6, city.getCoastal()?"true":"false");
		myStmt.setFloat(7, city.getAreaKM());
		myStmt.execute();			
	}//end add region

/*
//load cities details
public ArrayList<City> cityDetails(City city1) throws Exception {
		ArrayList<City> cities = new ArrayList<City>();
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select ct.cty_code, ct.cty_name, cy.co_name, r.reg_name, ct.population, ct.isCoastal FROM city ct INNER join region r on ct.reg_code = r.reg_code inner join country cy on r.co_code = cy.co_code where r.co_code = ?";

		myStmt = myConn.prepareStatement(sql);

		myRs = myStmt.executeQuery(sql);
		myStmt.setString(1, city1.getReg_code());
		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String city_code = myRs.getString("cty_code");
			String city_name = myRs.getString("cty_name");
			String country_name = myRs.getString("co_name");
			String region_name = myRs.getString("reg_name");
			int city_population = myRs.getInt("population");
			boolean isCoastal = myRs.getBoolean("isCoastal");
			
			// create new city object
			City city = new City(city_code, city_name,country_name,region_name,city_population,isCoastal);

			cities.add(city);
		}	
		return cities;
	}
*/



//load cities details with seperate queries
public ArrayList<City> cityDetails() throws Exception {
		ArrayList<City> cities = new ArrayList<City>();
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		Statement myStmt1 = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		//String sql = "select ct.cty_code, ct.cty_name, cy.co_name, r.reg_name, ct.population, ct.isCoastal FROM city ct INNER join region r on ct.reg_code = r.reg_code inner join country cy on r.co_code = cy.co_code where r.co_code = ?";
		String sql = "select ct.cty_code, ct.cty_name, cy.co_name, r.reg_name, ct.population, ct.isCoastal FROM city ct INNER join region r on ct.reg_code = r.reg_code inner join country cy on r.co_code = cy.co_code where r.co_code = ?";
		myStmt = myConn.prepareStatement(sql);
		myStmt1 = myConn.createStatement();

		myRs = myStmt1.executeQuery(sql);
		
		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String city_code = myRs.getString("cty_code");
			String city_name = myRs.getString("cty_name");
			String country_name = myRs.getString("co_name");
			String region_name = myRs.getString("reg_name");
			int city_population = myRs.getInt("population");
			boolean isCoastal = myRs.getBoolean("isCoastal");
			
			
			
			// create new city object
			City city = new City(city_code, city_name,country_name,region_name,city_population,isCoastal);
			
			myStmt.setString(1, city.getCity_code());
			myStmt.execute();

			cities.add(city);
		}	
		return cities;
	}//end all details



//to find all cities
public ArrayList<City> findCity(City city) throws Exception {
	ArrayList<City> cities = new ArrayList<City>();
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
	//	Connection myConn = null;
		Statement myStmt1 = null;
		//ResultSet myRs = null;
		
		//myConn = mysqlDS.getConnection();
		
		myStmt1 = myConn.createStatement();

		
		
		myConn = mysqlDS.getConnection();
		//String sql = "insert into country values (?, ?, ?)";
		String sql = "select * from city where population = ?";
		

		myStmt = myConn.prepareStatement(sql);
		myStmt.setInt(1, city.getPopulation());
		myStmt.execute();
		
		myRs = myStmt1.executeQuery(sql);
		
		// process result set
				while (myRs.next()) {
						
					// retrieve data from result set row
					String city_code = myRs.getString("cty_code");
					String co_code = myRs.getString("co_code");
					String reg_code = myRs.getString("reg_code");
					String city_name = myRs.getString("cty_name");
					int population = myRs.getInt("population");
					boolean isCoastal = myRs.getBoolean("isCoastal");
					float areaKM = myRs.getFloat("areaKM");
					

					// create new student object
					 city = new City(city_code, co_code, reg_code, city_name,population,isCoastal,areaKM);

					cities.add(city);
				}	
		
		
		
		return cities;
	}//end find cities




	
}
	







