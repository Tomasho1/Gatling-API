package simulations.functional;

import io.gatling.javaapi.core.OpenInjectionStep;
import io.gatling.javaapi.core.Simulation;
import scenarios.AuthScenario;
import scenarios.PingScenario;
import utils.ProtocolBuilder;

public class SmokeSimulation extends Simulation {

    {
        setUp(
                PingScenario.HEALTH_CHECK_SCENARIO.injectOpen(OpenInjectionStep.atOnceUsers(1))
                        .andThen(
                                AuthScenario.CREATE_TOKEN_SCENARIO.injectOpen(OpenInjectionStep.atOnceUsers(1)))
        ).protocols(ProtocolBuilder.defaultProtocol());
    }
}

