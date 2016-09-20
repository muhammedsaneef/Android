package RetrofitClass.JsonModel;

/**
 * Created by saneef on 16/9/16.
 */
public class Metadata {
    private Source source;

    private String primary;

    public Source getSource ()
    {
        return source;
    }

    public void setSource (Source source)
    {
        this.source = source;
    }

    public String getPrimary ()
    {
        return primary;
    }

    public void setPrimary (String primary)
    {
        this.primary = primary;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [source = "+source+", primary = "+primary+"]";
    }
}
