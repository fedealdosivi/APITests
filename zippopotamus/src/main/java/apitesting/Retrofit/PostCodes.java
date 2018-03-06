package apitesting.Retrofit;

import apitesting.Model.PostCodeResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface PostCodes {


    @GET("/ar/{postId}")
    Call<PostCodeResponse> get(@Path("postId") int postId);
}
