package scenarios;

import io.gatling.javaapi.core.ScenarioBuilder;
import features.AuthFeature;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class AuthScenario {

    public static ScenarioBuilder AUTH_SCENARIO = scenario("Auth scenario")
            .exec(AuthFeature.createToken());
}
