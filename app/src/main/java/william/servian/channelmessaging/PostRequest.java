package william.servian.channelmessaging;

import java.util.HashMap;

/**
 * Created by servianw on 19/01/2018.
 */
public class PostRequest {
    private String URL;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    private HashMap<String, String> params;

    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    public PostRequest(String url, HashMap<String , String> params)
    {
        this.URL = url;
        this.params = params;
    }
}
