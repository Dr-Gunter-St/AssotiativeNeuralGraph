import java.util.ArrayList;
import java.util.List;

public class Item {

    private List<ParameterValue> values;
    private  String className;
    private int id;
    private double similarityValue;

    public Item(String className, int id){
        this.className = className;
        values = new ArrayList<>();
        this.id = id;
        similarityValue = 0.0;
    }

    public Item(List<ParameterValue> values, String className){
        this.values = values;
        this.className = className;
    }

    public List<ParameterValue> getValues() {
        return values;
    }

    public void setValues(List<ParameterValue> values) {
        this.values = values;
    }

    public int getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public double getSimilarityValue() {
        return similarityValue;
    }

    public void setSimilarityValue(double similarityValue) {
        this.similarityValue = similarityValue;
    }

    @Override
    public String toString() {
        return "Item{" +
                "values=" + values +
                ", className='" + className + '\'' +
                ", id=" + id +
                ", similarityValue=" + similarityValue +
                '}';
    }
}
