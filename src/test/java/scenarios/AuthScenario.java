package scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;
import api.AuthApi;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class AuthScenario {

    public static ScenarioBuilder CREATE_TOKEN_SCENARIO = scenario("Create token scenario")
            .exec(AuthApi.createToken());
}
