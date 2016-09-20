package RetrofitClass.JsonModel;

/**
 * Created by saneef on 16/9/16.
 */
public class EmailAddresses {
    private String value;

    private Metadata metadata;

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
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
        return "ClassPojo [value = "+value+", metadata = "+metadata+"]";
    }
}
