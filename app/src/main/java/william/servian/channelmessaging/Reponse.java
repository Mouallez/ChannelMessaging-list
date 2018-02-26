package william.servian.channelmessaging;

/**
 * Created by sacquind on 22/01/2018.
 */
public class Reponse {
    private String response;
    private String code;
    private String accesstoken;

    public String getResponse() {
        return response;
    }

    Reponse(){
    }

    public String getCode() {
        return code;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
