package RetrofitClass;

import RetrofitClass.JsonModel.TokenExchangeResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by saneef on 16/9/16.
 */
public interface ServiceAPI {

    @FormUrlEncoded
    @Headers({"Content-length: 233","content-type: application/x-www-form-urlencoded","User-Agent: GoogleLoginAuth"})
    @POST("/oauth2/v4/token")
    Call<TokenExchangeResponse> getAccessToken(@Field("code") String auth_code,
                                               @Field("redirect_uri") String r_Url,
                                               @Field("client_id") String client_id,
                                               @Field("client_secret") String client_secret,
                                               @Field("grant_type") String grant_type);


}
