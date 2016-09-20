package RetrofitClass.JsonModel;

/**
 * Created by saneef on 16/9/16.
 */
public class Names {
    private String familyName;

    private String displayNameLastFirst;

    private String givenName;

    private String displayName;

    private Metadata metadata;

    public String getFamilyName ()
    {
        return familyName;
    }

    public void setFamilyName (String familyName)
    {
        this.familyName = familyName;
    }

    public String getDisplayNameLastFirst ()
    {
        return displayNameLastFirst;
    }

    public void setDisplayNameLastFirst (String displayNameLastFirst)
    {
        this.displayNameLastFirst = displayNameLastFirst;
    }

    public String getGivenName ()
    {
        return givenName;
    }

    public void setGivenName (String givenName)
    {
        this.givenName = givenName;
    }

    public String getDisplayName ()
    {
        return displayName;
    }

    public void setDisplayName (String displayName)
    {
        this.displayName = displayName;
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
        return "ClassPojo [familyName = "+familyName+", displayNameLastFirst = "+displayNameLastFirst+", givenName = "+givenName+", displayName = "+displayName+", metadata = "+metadata+"]";
    }
}
