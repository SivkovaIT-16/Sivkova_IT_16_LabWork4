import java.util.List;
import java.util.ArrayList;
import static java.lang.Math.abs;

public class Number3 implements Function <Number, Number> {
    private List<Number> input;
    private List<Number> result;

    public List<Number> getInput() {
        return input;
    }

    public List<Number> getResult() {
        return result;
    }

    public void setInput(List<Number> input) {
        this.input = input;
    }

    public Number3() {
        this.input = new ArrayList<>();
        this.result = new ArrayList<>();
    }

    public Number3(List<Number> input) {
        this.input = input;
        this.result = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Список исходных чисел: \n" + input + "\n" + "Список положительных чисел: \n" + result;
    }

    public void transformation() {
        for (Number num : this.input) {
            this.result.add(apply(num));
        }
    }

    @Override
    public Number apply(Number obj) {
        String str = "" + obj;
        if (Validator.valIsInt(str)) {
            return abs(obj.intValue());
        }
        return abs(obj.doubleValue());
    }
}