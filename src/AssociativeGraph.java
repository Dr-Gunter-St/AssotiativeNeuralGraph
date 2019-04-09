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
    
    public double similarityOf2Items(Item from, Item to){

        double similarity = 0.0;

        for (int i = 0; i < parameters.size(); i++) {
            ParameterValue valueFrom = from.getValues().get(i);
            ParameterValue p = valueFrom;
            ParameterValue valueTo = to.getValues().get(i);

            double weight = 1.0;

            if (valueFrom.getValue() > valueTo.getValue()){
                while (p.getValue() - valueTo.getValue()  > 0.000000000001){
                    p = p.getPrevious();
                    weight *= p.getNextWeight();
                }
                similarity += weight*(1.0/parameters.size());
            } else if (valueFrom.getValue() < valueTo.getValue()){
                while (p.getValue() - valueTo.getValue() > 0.000000000001){
                    p = p.getNext();
                    weight *= p.getPreviousWeight();
                }
                similarity += weight*(1.0/parameters.size());
            } else {
                similarity += weight*(1.0/parameters.size());
            }

        }

        return similarity;
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
