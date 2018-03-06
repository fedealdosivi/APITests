package apitesting;

import apitesting.Model.PostCodeResponse;
import apitesting.Retrofit.PostCodes;
import org.junit.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ZippoRetrofit extends ApiTestRetrofit {

    @Test
    public void getMarDelPlataZipCodes(){
        try {
            PostCodes zippo = getRetrofit().create(PostCodes.class);
            Response<PostCodeResponse> response = zippo.get(7600).execute();
            assertThat("HTTP code is OK", response.code(), is(200));
        }catch (IOException e){
            e.getStackTrace();
            fail();
        }
    }
}
