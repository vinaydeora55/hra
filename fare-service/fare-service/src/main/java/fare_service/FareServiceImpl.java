package fare_service;



import fare_entity.Fare;
import fare_repository.FareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FareServiceImpl implements FareService {

    private final FareRepository fareRepository;

    @Override
    public Fare createFare(Fare fare) {
        return fareRepository.save(fare);
    }

    @Override
    public Optional<Fare> getFareById(Long fareId) {
        return fareRepository.findById(fareId);
    }

    @Override
    public List<Fare> getAllFares() {
        return fareRepository.findAll();
    }

    @Override
    public Fare updateFare(Long fareId, Fare updatedFare) {
        return fareRepository.findById(fareId)
                .map(fare -> {
                    fare.setTrainId(updatedFare.getTrainId());
                    fare.setClassType(updatedFare.getClassType());
                    fare.setAmount(updatedFare.getAmount());
                    return fareRepository.save(fare);
                })
                .orElseThrow(() -> new RuntimeException("Fare not found"));
    }

    @Override
    public void deleteFare(Long fareId) {
        fareRepository.deleteById(fareId);
    }
}
