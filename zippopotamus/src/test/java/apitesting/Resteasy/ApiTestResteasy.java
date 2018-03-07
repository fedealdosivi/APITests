package apitesting.Resteasy;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Before;

public class ApiTestResteasy {

    private ResteasyClient client;
    private ResteasyWebTarget target;

    @Before
    public void init(){
        client = new ResteasyClientBuilder().build();
        target = client.target("http://api.zippopotam.us/");
    }

    public ResteasyWebTarget getTarget() {
        return target;
    }

    public void setTarget(ResteasyWebTarget target) {
        this.target = target;
    }

    public ResteasyClient getClient() {
        return client;
    }

    public void setClient(ResteasyClient client) {
        this.client = client;
    }
}
