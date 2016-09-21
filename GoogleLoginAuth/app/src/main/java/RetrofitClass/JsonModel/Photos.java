package RetrofitClass.JsonModel;

/**
 * Created by saneef on 21/9/16.
 */
public class Photos {

    private String url;

    private Metadata metadata;

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public Metadata getMetadata ()
    {
        return metadata;
    }

    public void setMetadata (Metadata metadata)
    {
        this.metadata = metadata;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [url = "+url+", metadata = "+metadata+"]";
    }
}
