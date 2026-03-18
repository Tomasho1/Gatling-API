package utils;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.core.CoreDsl.ElFileBody;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class RequestBuilder {

    public static HttpRequestActionBuilder sendPostRequestAndCheckStatus(String url, String body, int status) {
        return http("POST " + url)
                .post(url)
                .body(ElFileBody(body))
                .asJson()
                .check(status().is(status));

    }
}
