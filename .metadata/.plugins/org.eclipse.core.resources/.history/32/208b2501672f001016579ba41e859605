package train_service;



import train_entity.Train;
import custom_exception.TrainNotFoundException;
import train_repository.TrainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrainServiceImpl implements TrainService {

    private final TrainRepository trainRepository;

    @Override
    public Train saveTrain(Train train) {
        log.info("Saving new train: {}", train);
        return trainRepository.save(train);
    }

    @Override
    public List<Train> getAllTrains() {
        log.info("Fetching all trains");
        return trainRepository.findAll();
    }

    @Override
    public Train getTrainById(Long id) {
        log.info("Fetching train by id: {}", id);
        return trainRepository.findById(id)
                .orElseThrow(() -> new TrainNotFoundException("Train not found with id " + id));
    }

    @Override
    public Train updateTrain(Long id, Train train) {
        Train existing = getTrainById(id);
        existing.setTrainName(train.getTrainName());
        existing.setSource(train.getSource());
        existing.setDestination(train.getDestination());
        existing.setTotalSeats(train.getTotalSeats());
        log.info("Updating train: {}", existing);
        return trainRepository.save(existing);
    }

    @Override
    public void deleteTrain(Long id) {
        Train existing = getTrainById(id);
        trainRepository.delete(existing);
        log.info("Deleted train id: {}", id);
    }
}
