package scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;
import features.AuthFeature;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class AuthScenario {

    public static ScenarioBuilder CREATE_TOKEN_SCENARIO = scenario("Create token scenario")
            .exec(AuthFeature.createToken());
}
