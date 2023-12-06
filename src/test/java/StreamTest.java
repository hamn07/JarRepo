import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class StreamTest {
	
	@Test
	public void test() {
		System.out.println(
		Stream.of("{ \"color\": \"#F6921E\", \"name\": \"Glow and Shine Spa\", \"productLink\": \"/pr?pid=B6HWF\", \"lon\": 18.443094, \"lat\": -66.02581 }",
				"{ \"color\": \"#F6921E\", \"name\": \"Marilyn Med Aesthetics\", \"productLink\": \"/pr?pid=B6HVE\", \"lon\": 18.397811, \"lat\": -66.095634 }",
				"{ \"color\": \"#F6921E\", \"name\": \"Hacienda Tres Casitas\", \"productLink\": \"/pr?pid=B6HUD\", \"lon\": 18.081667, \"lat\": -67.105898 }",
				"{ \"color\": \"#F6921E\", \"name\": \"Tripaso® AV-139 Lic. 209\", \"productLink\": \"/pr?pid=B6I4X\", \"lon\": 18.416503, \"lat\": -66.062129 }", 
				"{ \"color\": \"#F6921E\", \"name\": \"Dorado Esthetic Center & Salon\", \"productLink\": \"/pr?pid=B6HTC\", \"lon\": 18.461129, \"lat\": -66.267919 }",
				"{ \"color\": \"#F6921E\", \"name\": \"Dorado Esthetic Center & Salon\", \"productLink\": \"/pr?pid=B6HTC\", \"lon\": 18.461129, \"lat\": -66.267919 }",
				"{ \"color\": \"#F6921E\", \"name\": \"Dorado Esthetic Center & Salon\", \"productLink\": \"/pr?pid=B6HTC\", \"lon\": 18.461129, \"lat\": -66.267919 }",
				"{ \"color\": \"#F6921E\", \"name\": \"Dorado Esthetic Center & Salon\", \"productLink\": \"/pr?pid=B6I2V\", \"lon\": 18.461129, \"lat\": -66.267919 }")
		.collect(Collectors.groupingBy(this::coordinates, Collectors.collectingAndThen(Collectors.toList(), this::combind)))
		.values().stream()
		.collect(Collectors.joining(",\n"))
		);
	}
	
    private String coordinates(String jsonString) {
    	try {
			JSONObject jsonObject = new JSONObject(jsonString);
			return jsonObject.get("lon") + ", " + jsonObject.get("lat");
		} catch (JSONException e) {
			return "18.219231, -66.672195";
		}
    }
    
    private String combind(List<String> list) {
    	
        JSONArray productLinks = new JSONArray(list.stream()
        		.map(JSONObject::new)
                .map(jsonObject -> jsonObject.getString("productLink"))
                .collect(Collectors.toList()));

        JSONObject result = new JSONObject(list.get(0));
        result.put("productLinks", productLinks);

        return result.toString();
    }
    
    private String combind(String json1, String json2) {
    	JSONObject jsonObject1 = new JSONObject(json1);
    	JSONObject jsonObject2 = new JSONObject(json2);
    	
        JSONArray productLinksArray = new JSONArray()
        	.put(jsonObject1.get("productLink"))
        	.put(jsonObject2.get("productLink"));
    	
    	return jsonObject1.put("productLink", productLinksArray).toString();
    }
}
