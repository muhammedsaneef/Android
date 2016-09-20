package RetrofitClass.JsonModel;

import java.util.ArrayList;

/**
 * Created by saneef on 16/9/16.
 */
public class ServerResponse {

    private String nextSyncToken;

    private String nextPageToken;

    private ArrayList<Connections> connections;

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

    public ArrayList<Connections> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Connections> connections) {
        this.connections = connections;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [nextSyncToken = "+nextSyncToken+", nextPageToken = "+nextPageToken+", connections = "+connections+"]";
    }
}
