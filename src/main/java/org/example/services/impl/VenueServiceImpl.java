package org.example.services.impl;

import org.example.dtos.ECategory;
import org.example.dtos.VenueResponse;
import org.example.exceptions.WarningException;
import org.example.models.Venue;
import org.example.repositories.VenueRepository;
import org.example.services.VenueService;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class VenueServiceImpl implements VenueService {
    private VenueRepository repository;
    public VenueServiceImpl(VenueRepository repository){
        this.repository = repository;
    }

    public Venue createVenue(Venue venue){
        Venue findId = repository.findVenueById(venue.getId());
        if(findId != null){
            try {
                throw new WarningException("Gagal membuat lapangan, kode lapangan sudah ada!");
            } catch (WarningException e) {
                throw new RuntimeException(e);
            }
        }
        return repository.createVenue(venue);
    }

    public boolean updateVenue(Venue venue){
        Venue findId = repository.findVenueById(venue.getId());
        if(findId == null){
            try {
                throw new WarningException("Gagal memperbarui Lapangan, kode lapangan tidak ditemukan");
            } catch (WarningException e) {
                throw new RuntimeException(e);
            }
        }
        return repository.updateVenue(venue);
    }

    public List<VenueResponse> findAllVenues() {
        List<Venue> venues = repository.findAllVenue();
        List<VenueResponse> result = new ArrayList<>();
        for (Venue venue : venues) {
            String id = venue.getId();
            String name = venue.getName();
            String description = venue.getDescription();
            Time open = venue.getOpen();
            Time close = venue.getClose();
            long price = venue.getPrice();
            ECategory category = venue.getCategory();
            String status = (venue.isActive() ? "Aktif" : "Tidak Aktif");
            result.add(new VenueResponse(id, name, description, open, close, price, category, status));
        }
        return result;
    }

    public List<VenueResponse> findVenueByCategory(ECategory category){
        List<Venue> venues = repository.findVenueByCategory(category);
        List<VenueResponse> result = new ArrayList<>();
        for (Venue venue : venues) {
            String id = venue.getId();
            String name = venue.getName();
            String description = venue.getDescription();
            Time open = venue.getOpen();
            Time close = venue.getClose();
            long price = venue.getPrice();
            ECategory categoryy = venue.getCategory();
            String status = (venue.isActive() ? "Buka" : "Tutup");
            result.add(new VenueResponse(id, name, description, open, close, price, categoryy, status));
        }
        return result;
    }
}
