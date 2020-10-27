package operationsAlg;

import java.util.Arrays;

public enum Operations {
    SUM(true, "+", Double::sum),
    SUB(true, "-", (a, b) -> a - b),
    MULT(true, "*", (a, b) -> a * b),
    DIV(true, "/", (a, b) -> a / b);

    private boolean isBinary;
    private String ch;
    private OperationFunc operationFunc;

    Operations(boolean isBinary, String ch, OperationFunc operationFunc) {
        this.ch = ch;
        this.isBinary = isBinary;
        this.operationFunc = operationFunc;
    }

    public static Operations getByChar(String var) {
        return Arrays.stream(Operations.values()).filter(op -> op.ch.equals(var)).findFirst().get();
    }

    public static boolean isInputStringOperation(String var) {
        return Arrays.stream(Operations.values()).anyMatch(op -> op.ch.equals(var));
    }

    public boolean isBinary() {
        return isBinary;
    }

    public void setBinary(boolean binary) {
        isBinary = binary;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public OperationFunc getOperationFunc() {
        return operationFunc;
    }

    public void setOperationFunc(OperationFunc operationFunc) {
        this.operationFunc = operationFunc;
    }
}


@FunctionalInterface
interface OperationFunc {
    double oper(double a, double b);
}
