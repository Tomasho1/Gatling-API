package simulations.functional;

import io.gatling.javaapi.core.OpenInjectionStep;
import io.gatling.javaapi.core.Simulation;
import scenarios.BookingScenario;
import utils.ProtocolBuilder;

public class BookingSimulation extends Simulation {

    {
        setUp(
                BookingScenario.BOOKING_E2E_SCENARIO.injectOpen(OpenInjectionStep.atOnceUsers(1))
        ).protocols(ProtocolBuilder.defaultProtocol());
    }
}
