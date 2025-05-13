package availability_service;


import availability_entity.Availability;

import java.util.List;
import java.util.Optional;

public interface AvailabilityService {
    Availability saveAvailability(Availability availability);
    Optional<Availability> getAvailability(Long trainId, String travelDate, String classType);
    List<Availability> getAllAvailability();
    void updateAvailableSeats(Long availabilityId, int newAvailableSeats);
}
