package org.example.services;

import org.example.dtos.ECategory;
import org.example.dtos.VenueResponse;
import org.example.models.Venue;

import java.util.List;

public interface VenueService {
    Venue createVenue(Venue venue);
    boolean updateVenue(Venue venue);
    List<VenueResponse> findAllVenues();
    List<VenueResponse> findVenueByCategory(ECategory category);
}
