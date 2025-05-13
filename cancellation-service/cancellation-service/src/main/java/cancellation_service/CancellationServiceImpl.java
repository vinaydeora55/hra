package cancellation_service;


import cancellation_entity.Cancellation;
import cancellation_repository.CancellationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CancellationServiceImpl implements CancellationService {

    private final CancellationRepository cancellationRepository;

    @Override
    public Cancellation createCancellation(Cancellation cancellation) {
        cancellation.setCancelledAt(LocalDateTime.now());
        return cancellationRepository.save(cancellation);
    }

    @Override
    public Optional<Cancellation> getCancellationById(Long cancellationId) {
        return cancellationRepository.findById(cancellationId);
    }

    @Override
    public List<Cancellation> getAllCancellations() {
        return cancellationRepository.findAll();
    }

    @Override
    public void deleteCancellation(Long cancellationId) {
        cancellationRepository.deleteById(cancellationId);
    }
}
