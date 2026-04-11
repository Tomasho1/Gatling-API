package scenarios;

import api.AuthApi;
import api.BookingApi;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.scenario;

public class BookingScenario {

    public static ScenarioBuilder BOOKING_E2E_SCENARIO = scenario("Booking E2E scenario")
            .exec(AuthApi.createToken())
            .exec(BookingApi.createBooking())
            .exec(BookingApi.getBooking())
            .exec(BookingApi.deleteBooking());
}
