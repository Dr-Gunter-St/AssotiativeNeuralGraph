import java.util.ArrayList;
import java.util.List;

public class Item {

    private List<ParameterValue> values;
    private  String className;
    private int id;

    public Item(String className, int id){
        this.className = className;
        values = new ArrayList<>();
        this.id = id;
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

    @Override
    public String toString() {
        return "Item{" +
                "values=" + values +
                ", className='" + className + '\'' +
                ", id=" + id +
                '}';
    }
}
