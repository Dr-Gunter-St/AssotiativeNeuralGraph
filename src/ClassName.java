
public class ClassName {
    private String className;

    public ClassName(String className){
        this.className = className;
    }

    public  String getClassName(){
        return className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClassName className1 = (ClassName) o;

        return className.equals(className1.className);

    }

    @Override
    public int hashCode() {
        return className.hashCode();
    }
}
