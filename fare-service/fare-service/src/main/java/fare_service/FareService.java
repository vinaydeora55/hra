package fare_service;



import fare_entity.Fare;

import java.util.List;
import java.util.Optional;

public interface FareService {
    Fare createFare(Fare fare);
    Optional<Fare> getFareById(Long fareId);
    List<Fare> getAllFares();
    Fare updateFare(Long fareId, Fare fare);
    void deleteFare(Long fareId);
}
