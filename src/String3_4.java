import java.util.List;
import java.util.Map;

public class String3_4 implements Collecting {
    private List<String> input;
    private Map<Integer, List<String>> resultCollecting;

    public List<String> getInput() {
        return input;
    }

    public Map<Integer, List<String>> getResultCollecting() {
        return resultCollecting;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }

    public String3_4(List<String> input) {
        this.input = input;
        this.resultCollecting = "";
    }

    @Override
    public String toString() {
        return "Список входных строк: " + input + "\n"
                + "Сформированные коллекции: " + resultCollecting;
    }

    public void collecting() {
        for (String str : this.input) {
            this.resultCollecting = collect(this.resultCollecting, str);
        }
    }

    @Override
    public String collect(String str, String obj) {
        return str + obj;
    }
}
