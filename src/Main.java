import Training.TrainingSet;

import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        TrainingSet trainingSet = new TrainingSet(Paths.get("resources\\inputs2"));

        AssociativeGraph associativeGraph = new AssociativeGraph(trainingSet, Arrays.asList("1", "2", "3", "4"));

        System.out.println(associativeGraph.getParameters().get(0).toString());
        System.out.println(associativeGraph.getParameters().get(0).countValues());
    }
}
