package william.servian.channelmessaging;

/**
 * Created by sacquind on 05/02/2018.
 */
public class Channel {
    public int channelID;
    public String name;
    public int connectedusers;

    public int getConnectedusers() {
        return connectedusers;
    }

    public void setConnectedusers(int connectedusers) {
        this.connectedusers = connectedusers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }
}
