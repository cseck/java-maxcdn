package tests;



import org.json.JSONException;

import com.maxcdn.Console;
import com.maxcdn.MaxCDN;
import com.maxcdn.MaxCDNObject;
import com.maxcdn.MaxCDNRequest;

public class ApiDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Console.log("Attempting Request ---");
		MaxCDN api = new MaxCDN("jvmstix" , //alias
				"0191654f5f1bec3dab351e5bfaee8c9605643fe53" , //Cons. key
				"fd68f9acb93f82fe7f0862890770068a");	// Cons. Secret
		
		    //Console.log(api.getAuthUrl(api.getRequestToken()));
			
	
			MaxCDNObject data = api.get("/account.json");
			if(!data.error)
			Console.log(data);
			else {
				Console.log("Error " + data.getErrorMessage());
			}
			
			
			try {
				MaxCDNObject post_example = api.post("", new MaxCDNRequest());
				if(post_example.error){
					Console.log(post_example.getErrorMessage());
					return;
				}
				Console.log(post_example);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

}