package william.servian.channelmessaging;

/**
 * Created by sacquind on 26/02/2018.
 */
public class Message {
    public String message;
    public int userID;
    public String date;
    public String imageURL;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Message(String message, int userID, String date, String imageURL) {
        this.message = message;
        this.userID = userID;
        this.date = date;
        this.imageURL = imageURL;
    }
}
