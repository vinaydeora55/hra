package availability_repository;


import availability_entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    Optional<Availability> findByTrainIdAndTravelDateAndClassType(Long trainId, String travelDate, String classType);
}
