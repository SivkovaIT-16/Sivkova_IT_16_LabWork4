import java.util.List;
import java.util.ArrayList;

public class String3 implements Function <String, Integer> {
    private List<String> input;
    private List<Integer> result;

    public List<String> getInput() {
        return input;
    }

    public List<Integer> getResult() {
        return result;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }

    public String3(List<String> input) {
        this.input = input;
        this.result = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Список входных строк: \n" + input + "\n" + "Список длин строк: \n" + result;
    }

    public void transformation() {
        for (String str : this.input) {
            this.result.add(apply(str));
        }
    }

    @Override
    public Integer apply(String obj) {
        return obj.length();
    }
}
