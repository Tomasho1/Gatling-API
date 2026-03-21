package scenarios;

import features.AuthFeature;
import features.BookingFeature;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class BookingScenario {

    public static ScenarioBuilder CREATE_BOOKING_SCENARIO = scenario("Create booking scenario")
            .exec(AuthFeature.createToken())
            .exec(BookingFeature.createBooking());
}
