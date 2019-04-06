import java.util.List;


public class Parameter {
    private String parameterName;
    private ParameterValue min, max;
    private double minValue, maxValue;

    public Parameter(String parameterName){
        this.parameterName = parameterName;
        min = null;
        max = null;
        minValue = 0.0;
        maxValue = 0.0;
    }

    public void addValue(double value, Item item){

        if (min == null && max == null){
            min = new ParameterValue(value, item);
            max = min;
            minValue = value;
            maxValue = value;
            return;
        }

        ParameterValue p = min;
        while (p.getValue() < value && p.getNext() != null) p = p.getNext();

        if (p.getValue() == value) {
            p.getItems().add(item);
            item.getValues().add(p);
            p.getItems().add(item);
            return;
        }

        ParameterValue newValue = new ParameterValue(value, item);

        if (value < p.getValue()){

            //TODO: check nulls
            p.getPrevious().setNext(newValue);
            p.setPrevious(newValue);

            newValue.getItems().add(item);
            item.getValues().add(newValue);
            recalculateWeights();
        }
        if (value > p.getValue()){

            //TODO: check nulls
            p.getNext().setPrevious(newValue);
            p.setNext(newValue);

            newValue.getItems().add(item);
            item.getValues().add(newValue);
            recalculateWeights();
        }



    }

    private void recalculateWeights(){
        Double currentWeight;
        ParameterValue p = min;

        while (p.getNext() != null){
            currentWeight = 1 - Math.abs(p.getNext().getValue() - p.getValue())/(maxValue-minValue);
            p.setNextWeight(currentWeight);
            p.getNext().setPreviousWeight(currentWeight);
            p = p.getNext();
        }

    }

    @Override
    public String toString() {


        ParameterValue p = min;
        String s = "Parameter{" + "min=" + p + "\n";

        while (p.getNext() != null){
            p = p.getNext();
            s += p.toString() + "\n";
        }

        return s + '}';
    }

    public int countValues(){
        ParameterValue p = min;
        int res = 0;

        if (p != null) res++;

        while (p.getNext() != null){
            p = p.getNext();
            res++;
        }

        return res;
    }
}
