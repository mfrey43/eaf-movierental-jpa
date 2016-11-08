package ch.fhnw.edu.rental.dto;

import ch.fhnw.edu.rental.mappers.DtoMapper;
import ch.fhnw.edu.rental.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DtoRentalServiceImpl implements DtoRentalService {
    @Autowired
    DtoMapper mapper;
    @Autowired
    RentalService rentalService;

    @Override
    public RentalDto getRentalById(Long id) {
        return mapper.rentalToRentalDto(rentalService.getRentalById(id));
    }

    @Override
    public List<RentalDto> getAllRentals() {
        return rentalService.getAllRentals().stream().map(mapper::rentalToRentalDto).collect(Collectors.toList());
    }

    @Override
    public int calcRemainingDaysOfRental(RentalDto rental, Date date) {
        return 0;
    }

    @Override
    public void deleteRental(RentalDto rental) {
        rentalService.deleteRental(rentalService.getRentalById(rental.getId()));
    }
}
