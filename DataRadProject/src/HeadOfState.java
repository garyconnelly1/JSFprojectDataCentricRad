import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HeadOfState {
	private String _id;
	private String headOfState;
	
	
	//constructors
	public HeadOfState() {
		
	}
	
	public HeadOfState(String _id, String headOfState) {
		this._id = _id;
		this.headOfState= headOfState;
		
	}

	//generate getters and setters
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	
	
	

}
