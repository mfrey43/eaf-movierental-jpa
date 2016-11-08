package ch.fhnw.edu.rental.dto;

import java.util.Date;
import java.util.List;

public interface DtoRentalService {
    RentalDto getRentalById(Long id);
    List<RentalDto> getAllRentals();
    int calcRemainingDaysOfRental(RentalDto rental, Date date);
    void deleteRental(RentalDto rental);
}
