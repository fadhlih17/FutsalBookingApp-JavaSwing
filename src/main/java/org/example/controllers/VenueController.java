package org.example.controllers;

import org.example.dtos.ECategory;
import org.example.dtos.VenueResponse;
import org.example.models.Venue;
import org.example.services.VenueService;

import java.util.List;

public class VenueController {
    private VenueService service;
    public VenueController(VenueService service) {
        this.service = service;
    }

    public Venue createVenue(Venue venue) {
        return service.createVenue(venue);
    }
    public boolean updateVenue(Venue venue){
        return service.updateVenue(venue);
    }
    public List<VenueResponse> findAllVenues(){
        return service.findAllVenues();
    }
    public List<VenueResponse> findVenueByCategory(ECategory category){
        return service.findVenueByCategory(category);
    }
}
