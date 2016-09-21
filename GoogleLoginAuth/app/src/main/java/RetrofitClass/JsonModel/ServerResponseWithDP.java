package RetrofitClass.JsonModel;

import java.util.ArrayList;

/**
 * Created by saneef on 21/9/16.
 */
public class ServerResponseWithDP {

    private String nextSyncToken;

    private String nextPageToken;

    private ArrayList<ConnectionsDP> connections;

    public String getNextSyncToken ()
    {
        return nextSyncToken;
    }

    public void setNextSyncToken (String nextSyncToken)
    {
        this.nextSyncToken = nextSyncToken;
    }

    public String getNextPageToken ()
    {
        return nextPageToken;
    }

    public void setNextPageToken (String nextPageToken)
    {
        this.nextPageToken = nextPageToken;
    }

    public ArrayList<ConnectionsDP> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<ConnectionsDP> connections) {
        this.connections = connections;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [nextSyncToken = "+nextSyncToken+", nextPageToken = "+nextPageToken+", connections = "+connections+"]";
    }
}
