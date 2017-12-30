import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HeadOfStateController {
	
	ArrayList<HeadOfState> headOfState;
	private MongoDAO mongodao;
	
	//controller constructer
			public HeadOfStateController() {
				headOfState = new ArrayList<HeadOfState>();
				
				try {
					mongodao = new MongoDAO();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}//end constructor
			
			public HeadOfStateController(ArrayList<HeadOfState> headOfState) {
				super();
				this.headOfState = headOfState;
			}
			
			//getters
			public ArrayList<HeadOfState> getHeadOfState() {
				return headOfState;
			}
			
			//setters
			public void setHeadOfState(ArrayList<HeadOfState> headOfState) {
				this.headOfState = headOfState;
			}
			
			//load head of state
			
			public void loadHeadOfState() throws Exception {
				headOfState.clear();
				if (mongodao != null) {
					try {
						headOfState = mongodao.loadHeadOfState();
						//System.out.println(loadCountry.size());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			
			}//end loadHeadOfState	
			
			

}
