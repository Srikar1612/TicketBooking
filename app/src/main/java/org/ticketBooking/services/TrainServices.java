package org.ticketBooking.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ticketBooking.entities.Train;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class TrainServices {
    private Train train;
    private List<Train> trains;
    private final ObjectMapper mapper = new ObjectMapper();
    private final String trainFilePath="app\\src\\main\\java\\org\\ticketBooking\\DataBase\\Trains.json";
    public TrainServices(Train train) throws IOException {
        this.train = train;
        loadTrains();
    }
    public TrainServices() throws IOException {
        loadTrains();
    }
    public void loadTrains() throws IOException {
        trains=mapper.readValue(new File(trainFilePath), new TypeReference<List<Train>>() {
        });
    }
    public void addTrain(Train train) throws IOException {
        Optional<Train> train1=trains.stream().filter(t-> train != null && t.getTrainID().equals(train.getTrainID())).findFirst();
        if(train1.isPresent()){
            updateTrain(train1.get());
        }
        else {
            trains.add(train);
            saveTrains();
        }
    }
    public void updateTrain(Train train) throws IOException {
        OptionalInt index= IntStream.range(0,trains.size()).filter(i->trains.get(i).getTrainID().equals(train.getTrainID())).findFirst();
        if(index.isPresent()){
            trains.set(index.getAsInt(),train);
            mapper.writeValue(new File(trainFilePath), trains);
        }
    }
    public void saveTrains() throws IOException {
        mapper.writeValue(new File(trainFilePath), trains);
    }
    public boolean validateTrain(Train train, String source, String destination) throws IOException {
        if (train == null || train.getTrainID() == null) {
            return false;
        }

        List<String> stations = train.getStations();
        if (stations == null || !stations.contains(source) || !stations.contains(destination)) {
            return false;
        }

        int sourceIndex = stations.indexOf(source);
        int destinationIndex = stations.indexOf(destination);

        return sourceIndex < destinationIndex;
    }

    public List<Train> searchTrains(String source, String destination) throws IOException {
        return trains.stream().filter(train1 -> {
            try {
                return validateTrain(train1, source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}
