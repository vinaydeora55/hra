package train_service;



import train_entity.Train;
import java.util.List;

public interface TrainService {
    Train saveTrain(Train train);
    List<Train> getAllTrains();
    Train getTrainById(Long id);
    Train updateTrain(Long id, Train train);
    void deleteTrain(Long id);
}
