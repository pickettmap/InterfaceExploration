import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierJunk implements Supplier <String>, Consumer<String> {

    private String field = "";

    @Override
    public String get() {
        return field;
    }

    //Like a setter
    @Override
    public void accept(String s) {
        this.field = s;
    }

    public void doStuff(){
        SupplierJunk s = new SupplierJunk();

        s.accept("Equal");
        System.out.println(s.get());
    }
}
