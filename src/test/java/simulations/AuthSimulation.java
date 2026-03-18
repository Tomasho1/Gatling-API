package simulations;

import io.gatling.javaapi.core.OpenInjectionStep;
import io.gatling.javaapi.core.Simulation;
import scenarios.AuthScenario;
import utils.ProtocolBuilder;

public class AuthSimulation extends Simulation {

    {
        setUp(
                AuthScenario.AUTH_SCENARIO.injectOpen(OpenInjectionStep.atOnceUsers(1))
        ).protocols(ProtocolBuilder.defaultProtocol());
    }
}
