import java.util.ArrayList;

import com.google.gson.Gson;
//import com.mongodb.*;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;


public class MongoDAO {
	
	//connect to database
	MongoClient mongoClient = new MongoClient();
	
	MongoDatabase database = mongoClient.getDatabase("headsOfStateDB");
	
	MongoCollection<Document> headsOfState =  database.getCollection("headsOfState");
	
	//FindIterable<Document> headsOfStateDB = headsOfState.find();
	/*
	for (Document d : headsOfStateDB) {
		System.out.println(d.toJson());
	  }
	  */
	  
	//  mongoClient.close();




	public ArrayList<HeadOfState> loadHeadOfState() throws Exception{
		
	
	
	ArrayList<HeadOfState> headOfStateList = new ArrayList<HeadOfState>();
	
	Gson gson = new Gson();
	
	FindIterable<Document> headsOfStateDB = headsOfState.find();
	
	//add to list 
	for (Document d : headsOfStateDB) {
		HeadOfState headOfState = gson.fromJson(d.toJson(), HeadOfState.class);
		headOfStateList.add(headOfState);
		}
	
		return headOfStateList;
	
	}//end loadHeadOfState
	
	//mongoClient.close();

	

}
