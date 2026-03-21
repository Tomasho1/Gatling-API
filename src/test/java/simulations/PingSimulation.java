package simulations;

import io.gatling.javaapi.core.OpenInjectionStep;
import io.gatling.javaapi.core.Simulation;
import scenarios.PingScenario;
import utils.ProtocolBuilder;

public class PingSimulation extends Simulation {

    {
        setUp(
                PingScenario.HEALTH_CHECK_SCENARIO.injectOpen(OpenInjectionStep.atOnceUsers(1))
        ).protocols(ProtocolBuilder.defaultProtocol());
    }
}
