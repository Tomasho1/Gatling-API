package api;

import io.gatling.javaapi.core.ChainBuilder;
import utils.RequestBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;

public class PingApi {

    private static final String PING_URL = "/ping";

    public static ChainBuilder healthCheck() {
        return exec(
                RequestBuilder.get(PING_URL, 201)
                        .check(bodyString().is("Created"))
        );
    }
}
