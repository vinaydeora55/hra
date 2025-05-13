package cancellation_service;


import cancellation_entity.Cancellation;

import java.util.List;
import java.util.Optional;

public interface CancellationService {
    Cancellation createCancellation(Cancellation cancellation);
    Optional<Cancellation> getCancellationById(Long cancellationId);
    List<Cancellation> getAllCancellations();
    void deleteCancellation(Long cancellationId);
}
