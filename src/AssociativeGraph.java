import Training.TrainingInput;
import Training.TrainingSet;

import java.util.ArrayList;
import java.util.List;


public class AssociativeGraph {
    private List<Parameter> parameters;
    private List<String> parameterNames;
    private List<Item> items;

    public AssociativeGraph(TrainingSet set, List<String> parameterNames){
        this.parameterNames = parameterNames;

        parameters = new ArrayList<>();
        items = new ArrayList<>();

        for (int i = 0; i < set.getInputs().get(0).getInputs().length; i++) {
            parameters.add(new Parameter(parameterNames.get(i)));
        }

        int id = 1;
        for (TrainingInput i: set.getInputs()) {
            Item newItem = new Item(i.getClassName(), id);
            items.add(newItem);
            for (int j = 0; j < i.getInputs().length; j++) {
                parameters.get(j).addValue(i.getInputs()[j], newItem);
            }
            id++;
        }


    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public List<String> getParameterNames() {
        return parameterNames;
    }

    public List<Item> getItems() {
        return items;
    }
}
