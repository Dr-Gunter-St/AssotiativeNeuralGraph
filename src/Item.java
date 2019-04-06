import java.util.ArrayList;
import java.util.List;

public class Item {

    private List<ParameterValue> values;
    private  String className;

    public Item(String className){
        this.className = className;
        values = new ArrayList<>();
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


}
