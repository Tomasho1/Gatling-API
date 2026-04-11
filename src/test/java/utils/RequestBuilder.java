package utils;

import io.gatling.javaapi.http.HttpRequestActionBuilder;

import static io.gatling.javaapi.core.CoreDsl.ElFileBody;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class RequestBuilder {

    public static HttpRequestActionBuilder post(String url, String body, int status) {
        return http("POST " + url)
                .post(url)
                .body(ElFileBody(body))
                .asJson()
                .check(status().is(status));

    }

    public static HttpRequestActionBuilder postWithAuth(String url, String body, int status) {
        return post(url, body, status)
                .header("Cookie", "token=#{token}");
    }

    public static HttpRequestActionBuilder get(String url, int status) {
        return http("GET " + url)
                .get(url)
                .check(status().is(status));

    }

    public static HttpRequestActionBuilder delete(String url, int status) {
        return http("DELETE " + url)
                .delete(url)
                .header("Cookie", "token=#{token}")
                .check(status().is(status));

    }
}
