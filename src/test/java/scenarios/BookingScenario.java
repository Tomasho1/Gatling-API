package scenarios;

import api.AuthApi;
import api.BookingApi;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class BookingScenario {

    public static ScenarioBuilder CREATE_BOOKING_SCENARIO = scenario("Create booking scenario")
            .exec(AuthApi.createToken())
            .exec(BookingApi.createBooking());
}
