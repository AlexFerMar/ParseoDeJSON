
import org.json.JSONArray;
import org.json.JSONObject;

public class Test {

    static String json = "{\n" +
            "    \"pageInfo\": {\n" +
            "            \"pageName\": \"Homepage\",\n" +
            "            \"logo\": \"https://www.example.com/logo.jpg\"\n" +
            "    },\n" +
            "    \"posts\": [\n" +
            "            {\n" +
            "                \"post_id\": \"0123456789\",\n" +
            "                \"actor_id\": \"1001\",\n" +
            "                \"author_name\": \"Jane Doe\",\n" +
            "                \"post_title\": \"How to parse JSON in Java\",\n" +
            "                \"comments\": [\"JSON\",\"JAVA\"],\n" +
            "                \"time_of_post\": \"1234567890\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"post_id\": \"13415134131\",\n" +
            "                \"actor_id\": \"1001\",\n" +
            "                \"author_name\": \"Jane Doe\",\n" +
            "                \"post_title\": \"How to parse JSON in Java\",\n" +
            "                \"comments\": [\"Casa\",\"Pato\"],\n" +
            "                \"time_of_post\": \"1234567890\"\n" +
            "            }\n" +
            "    ]\n" +
            "}";

    public static void main(String args[]) {

        JSONObject obj = new JSONObject(json);
        String pageName = obj.getJSONObject("pageInfo").getString("pageName");

        System.out.println(pageName);

        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post = arr.getJSONObject(i).getString("post_id");
            JSONArray coments = arr.getJSONObject(i).getJSONArray("comments");
            for (int j = 0; j < coments.length(); j++) {

                post += "\n  --->" + coments.get(j);

            }

            System.out.println(post+"\n");
        }
    }
}