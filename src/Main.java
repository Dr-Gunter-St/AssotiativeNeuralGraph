import Training.TrainingSet;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TrainingSet trainingSet = new TrainingSet(Paths.get("resources\\inputs"));

        AssociativeGraph associativeGraph = new AssociativeGraph(trainingSet, Arrays.asList("1", "2", "3", "4"));

        //System.out.println(associativeGraph.getParameters().get(0).toString());
        //System.out.println(associativeGraph.getParameters().get(0).countValues());

        //System.out.println(associativeGraph.getItems().get(0).toString());

        System.out.println(associativeGraph.similarityOf2Items(associativeGraph.getItems().get(0), associativeGraph.getItems().get(1)));


    }
}
