package features;

import io.gatling.javaapi.core.ChainBuilder;
import utils.RequestBuilder;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.jsonPath;

public class AuthFeature {

    private static final String AUTH_URL = "/auth";

    private static final String LOGIN_BODY = "bodies/login.json";

    public static ChainBuilder createToken() {
        return exec(
                RequestBuilder.sendPostRequestAndCheckStatus(AUTH_URL, LOGIN_BODY, 200)
                        .check(jsonPath("$.token").exists().saveAs("token"))
        );
    }
}

