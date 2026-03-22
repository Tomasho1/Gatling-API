package api;

import io.gatling.javaapi.core.ChainBuilder;
import net.datafaker.Faker;
import utils.RequestBuilder;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

import static io.gatling.javaapi.core.CoreDsl.*;

public class BookingApi {

    private static final String CREATE_BOOKING_URL = "/booking";
    private static final String CREATE_BOOKING_BODY = "bodies/createBooking.json";

    private static final Faker faker = new Faker();

    public static Iterator<Map<String, Object>> bookingData() {
        return Stream.generate(() -> {
            Map<String, Object> bookingData = new HashMap<>();

            bookingData.put("firstname", faker.name().firstName());
            bookingData.put("lastname", faker.name().lastName());
            bookingData.put("totalprice", faker.number().numberBetween(1000, 10000));
            bookingData.put("depositpaid", faker.bool().bool());
            bookingData.put("checkin", LocalDate.now().plusDays(faker.number().numberBetween(1, 30)).toString());
            bookingData.put("checkout", LocalDate.now().plusDays(faker.number().numberBetween(31, 60)).toString());
            bookingData.put("additionalneeds", faker.options().option("Breakfast", "Parking", "Late checkout"));

            return bookingData;
        }).iterator();
    }

    public static ChainBuilder createBooking() {
        return exec(
                feed(bookingData())
        )
                .exec(
                        RequestBuilder.postWithAuth(CREATE_BOOKING_URL, CREATE_BOOKING_BODY, 200)
                                .check(jsonPath("$.bookingid").ofInt().exists().saveAs("bookingid"))
                                .check(jsonPath("$.booking.firstname").ofString().isEL("#{firstname}"))
                                .check(jsonPath("$.booking.lastname").ofString().isEL("#{lastname}"))
                                .check(jsonPath("$.booking.totalprice").ofInt().isEL("#{totalprice}"))
                                .check(jsonPath("$.booking.depositpaid").ofBoolean().isEL("#{depositpaid}"))
                                .check(jsonPath("$.booking.bookingdates.checkin").ofString().isEL("#{checkin}"))
                                .check(jsonPath("$.booking.bookingdates.checkout").ofString().isEL("#{checkout}"))
                                .check(jsonPath("$.booking.additionalneeds").ofString().isEL("#{additionalneeds}"))
                );
    }
}
