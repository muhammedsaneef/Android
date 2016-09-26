package RetrofitClass.JsonModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by saneef on 19/9/16.
 */
public interface PeopleAPI {

    @GET("/v1/people/me/connections")
    @Headers({"Content-length: 0"})
    Call<ServerResponse> getContacts(@Query("requestMask.includeField") String request_mask,
                                     @Header("Authorization")String bearer_access);



}
