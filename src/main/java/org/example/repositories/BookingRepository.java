package org.example.repositories;

import org.example.dtos.BookedVenuesResponse;
import org.example.dtos.BookingDetail;
import org.example.dtos.ECategory;
import org.example.models.Booking;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface BookingRepository {
    Booking createBooking(Booking book);
    boolean updateStatusBooked(boolean status);
    String findBookingTransaction(String venueId, String dateBooking, Time startTime, Time endTime);
    Booking findBookingWhereId(String idVenue);
    List<BookedVenuesResponse> findBookedVenues();
    List<BookedVenuesResponse> findBookedVenuesByDateCategory(String date, String categoryReq);
    List<BookingDetail> findBookedVenuesStatusByUserId(String userId);
    List<BookingDetail> userBookingHistoriesSuccess(String userId);
    List<BookingDetail> userBookingHistoriesFailed(String userId);
    List<BookingDetail> reportBookings();
    List<BookedVenuesResponse> findBookedVenuesByCategory(String categoryReq);
    List<BookedVenuesResponse> findBookedVenuesByDate(String date);
    List<BookingDetail> userBookingHistoriesSuccessByDate(String userId, int month, int year);
    List<BookingDetail> userBookingHistoriesSuccessByYear(String userId, int year);
    BookingDetail reportBookingStruck(String bookingId);

}
