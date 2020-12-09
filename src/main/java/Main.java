import operationsAlg.BackPolish;

public class Main {
    public static void main(String[] args) throws Exception {
        String data = "2 3 5 * + 8 9 * + 4 -";
        BackPolish bracketParser = new BackPolish();
        bracketParser.setData(data);
        System.out.println(bracketParser.calc());
    }
}
