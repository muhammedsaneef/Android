package RetrofitClass;

import com.google.api.services.people.v1.People;
import com.google.api.services.people.v1.PeopleScopes;

/**
 * Created by saneef on 16/9/16.
 */

public class Constants {

    public static final String android_client_id  ="130005812202-50b0iipk6mqe4koqgb12qvgoad6tt6m1.apps.googleusercontent.com" ;
    public static final String web_client_id  ="130005812202-ijp4aqdusen2bojmm77c0afmtpgmvj3p.apps.googleusercontent.com" ;
    public static final String web_client_secret="Mcs7BMd_ZlVYFwCwBzId41yA";
    public static final String poeple_base_url= "https://people.googleapis.com";
    public static final String token_base_url= "https://www.googleapis.com";
    public static final String root_url=People.DEFAULT_ROOT_URL;
    public static final String required_Scope= PeopleScopes.CONTACTS_READONLY;
    public static final String OAUTH_URL="https://accounts.google.com/o/oauth2/auth";
    public  static  final String REDIRECT_URI="http://localhost";


}
