package apitesting;

import okhttp3.OkHttpClient;
import org.junit.Before;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiTestRetrofit {

    private OkHttpClient client;
    private Retrofit retrofit;

    @Before
    public void init(){
        client = new OkHttpClient.Builder().build();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.zippopotam.us/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(client)
                .build();
    }

    public OkHttpClient getClient() {
        return client;
    }

    public void setClient(OkHttpClient client) {
        this.client = client;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }



}
