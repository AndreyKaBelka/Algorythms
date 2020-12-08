package operationsAlg;

import java.util.LinkedList;

public class BackPolish {
    private String data;

    public BackPolish() {
    }

    public String getData() {
        if (data == null || data.isEmpty()) {
            return "";
        }
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double calc() {
        LinkedList<Double> stack = new LinkedList<>();
        String[] data = getData().split(" ");
        for (String var : data) {
            if (Operations.isInputStringOperation(var)) {
                Operations operation = Operations.getByChar(var);
                double secondOperand = stack.pop();
                stack.push(operation.getOperationFunc().oper(stack.pop(), secondOperand));
            } else {
                stack.push(Double.valueOf(var));
            }
        }

        return stack.pop();
    }
}
