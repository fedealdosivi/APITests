package apitesting;

import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.BeforeClass;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiTestRetrofit {

    protected OkHttpClient client;
    protected Retrofit retrofit;

    @BeforeClass
    public void init(){
        client = new OkHttpClient.Builder().build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://http://api.zippopotam.us/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();
    }


}
