package apitesting.Resteasy;

import apitesting.Model.PostCodeResponse;
import org.junit.Test;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class ZippoResteasy extends ApiTestResteasy{
    @Test
    public void getCommentsRestEasy() throws IOException {
        PostCodes api = getTarget().proxy(PostCodes.class);
        PostCodeResponse response=api.get(7600);
    }

}
