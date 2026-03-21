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

    public static HttpRequestActionBuilder sendGetRequestAndCheckStatus(String url, int status) {
        return http("GET " + url)
                .get(url)
                .check(status().is(status));

    }
}
