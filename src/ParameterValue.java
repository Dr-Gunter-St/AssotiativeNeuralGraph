import java.util.ArrayList;
import java.util.List;

/**
 * Created by Влад on 26.03.2019.
 */
public class ParameterValue {

    private double value;
    private ParameterValue previous, next;
    private double previousWeight, nextWeight;
    private double outerWeight;
    private List<Item> items;


    public ParameterValue(double value, Item item){
        this.value = value;
        previous = null;
        next = null;
        previousWeight = 0.0;
        nextWeight = 0.0;

        items = new ArrayList<>();
        items.add(item);

    }

    public Double getValue(){
        return value;
    }

    public ParameterValue getPrevious() {
        return previous;
    }

    public void setPrevious(ParameterValue previous) {
        this.previous = previous;
    }

    public ParameterValue getNext() {
        return next;
    }

    public void setNext(ParameterValue next) {
        this.next = next;
    }

    public Double getPreviousWeight() {
        return previousWeight;
    }

    public void setPreviousWeight(Double previousWeight) {
        this.previousWeight = previousWeight;
    }

    public Double getNextWeight() {
        return nextWeight;
    }

    public void setNextWeight(Double nextWeight) {
        this.nextWeight = nextWeight;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getOuterWeight() {
        return outerWeight;
    }

    public void updateOuterWeight(){
        outerWeight = 1.0/items.size();
    }

    @Override
    public String toString() {
        return "ParameterValue{" +
                "value=" + value +
                ", previousWeight=" + previousWeight +
                ", nextWeight=" + nextWeight +
                '}';
    }
}
