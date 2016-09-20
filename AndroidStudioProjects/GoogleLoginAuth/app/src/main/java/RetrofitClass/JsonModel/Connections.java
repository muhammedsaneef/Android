package RetrofitClass.JsonModel;

import java.util.ArrayList;

/**
 * Created by saneef on 16/9/16.
 */
public class Connections {
    private String etag;

    private ArrayList<Names> names;

    private String resourceName;

    private ArrayList<EmailAddresses> emailAddresses;

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


    public ArrayList<Names> getNames() {
        return names;
    }

    public void setNames(ArrayList<Names> names) {
        this.names = names;
    }

    public ArrayList<EmailAddresses> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(ArrayList<EmailAddresses> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [etag = "+etag+", names = "+names+", resourceName = "+resourceName+", emailAddresses = "+emailAddresses+"]";
    }
}
