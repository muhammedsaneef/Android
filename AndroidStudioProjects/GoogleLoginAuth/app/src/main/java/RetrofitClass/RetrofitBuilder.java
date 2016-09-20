package RetrofitClass;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by saneef on 16/9/16.
 */
public class RetrofitBuilder {




    public Retrofit getTokenRetrofit()
    {
        return new Retrofit.Builder()
                .baseUrl(Constants.token_base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    public Retrofit getContactsRetrofit()
    {
        return new Retrofit.Builder()
                .baseUrl(Constants.poeple_base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }




}
