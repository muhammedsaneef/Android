package RetrofitClass.JsonModel;

import java.util.ArrayList;

/**
 * Created by saneef on 21/9/16.
 */
public class ProfilePicture {
    private ArrayList<Photos> photos;

    private String etag;

    private String resourceName;



    public String getEtag ()
    {
        return etag;
    }

    public void setEtag (String etag)
    {
        this.etag = etag;
    }

    public String getResourceName ()
    {
        return resourceName;
    }

    public void setResourceName (String resourceName)
    {
        this.resourceName = resourceName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [photos = "+photos+", etag = "+etag+", resourceName = "+resourceName+"]";
    }
}
