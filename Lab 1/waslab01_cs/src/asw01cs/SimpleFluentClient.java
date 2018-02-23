package asw01cs;



import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
//This code uses the Fluent API

public class SimpleFluentClient {

	private static String URI = "http://localhost:8080/waslab01_ss/";

	public final static void main(String[] args) throws Exception {
    	/* Insert code for Task #4 here */
		String Twid = Request.Post(URI).addHeader("accept","text/plain")
	    .bodyForm(Form.form().add("author",  "Aleix").add("tweet_text", "tweet des de client").build())
	    .execute().returnContent().asString();

    	System.out.println(Request.Get(URI).addHeader("accept","text/plain").execute().returnContent());
    	
    	/* Insert code for Task #5 here */
    	Request.Post(URI).addHeader("accept","esborrar").bodyForm(Form.form().add("Twid",  Twid).build())
	    .execute();
    }
}

