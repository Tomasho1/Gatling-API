package scenarios;

import api.PingApi;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class PingScenario {

    public static ScenarioBuilder HEALTH_CHECK_SCENARIO = scenario("Health check scenario")
            .exec(PingApi.healthCheck());
}
