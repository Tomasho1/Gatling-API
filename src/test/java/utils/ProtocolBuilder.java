package utils;

import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.http.HttpDsl.http;

public class ProtocolBuilder {

    private static final String CONTENT_TYPE = "application/json";

    public static HttpProtocolBuilder defaultProtocol() {
        return http.baseUrl(ConfigLoader.getBaseUrl())
                .contentTypeHeader(CONTENT_TYPE)
                .acceptHeader(CONTENT_TYPE);
    }
}
