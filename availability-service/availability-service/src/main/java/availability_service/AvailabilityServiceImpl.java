package availability_service;


import availability_entity.Availability;
import availability_repository.AvailabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AvailabilityServiceImpl implements AvailabilityService {

    private final AvailabilityRepository availabilityRepository;

    @Override
    public Availability saveAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    @Override
    public Optional<Availability> getAvailability(Long trainId, String travelDate, String classType) {
        return availabilityRepository.findByTrainIdAndTravelDateAndClassType(trainId, travelDate, classType);
    }

    @Override
    public List<Availability> getAllAvailability() {
        return availabilityRepository.findAll();
    }

    @Override
    public void updateAvailableSeats(Long availabilityId, int newAvailableSeats) {
        availabilityRepository.findById(availabilityId).ifPresent(availability -> {
            availability.setAvailableSeats(newAvailableSeats);
            availabilityRepository.save(availability);
        });
    }
}
