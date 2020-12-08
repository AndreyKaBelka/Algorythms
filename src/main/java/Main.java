import operationsAlg.BackPolish;

public class Main {
    public static void main(String[] args) {
        String data = "6 5 * 9 +";
        BackPolish backPolish = new BackPolish();
        backPolish.setData(data);
        System.out.println(backPolish.calc());
    }
}
