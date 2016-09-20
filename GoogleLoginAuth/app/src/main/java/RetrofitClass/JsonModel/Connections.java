package RetrofitClass.JsonModel;

/**
 * Created by saneef on 16/9/16.
 */
public class Connections {
    private String etag;

    private Names[] names;

    private String resourceName;

    private EmailAddresses[] emailAddresses;

    public String getEtag ()
    {
        return etag;
    }

    public void setEtag (String etag)
    {
        this.etag = etag;
    }

    public Names[] getNames ()
    {
        return names;
    }

    public void setNames (Names[] names)
    {
        this.names = names;
    }

    public String getResourceName ()
    {
        return resourceName;
    }

    public void setResourceName (String resourceName)
    {
        this.resourceName = resourceName;
    }

    public EmailAddresses[] getEmailAddresses ()
    {
        return emailAddresses;
    }

    public void setEmailAddresses (EmailAddresses[] emailAddresses)
    {
        this.emailAddresses = emailAddresses;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [etag = "+etag+", names = "+names+", resourceName = "+resourceName+", emailAddresses = "+emailAddresses+"]";
    }
}
