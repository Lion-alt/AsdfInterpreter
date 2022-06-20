public class Result {
    boolean result;
    int failingLineNumber;
    StringBuilder code;
    public Result(boolean result, int failingLineNumber, StringBuilder code) {
        this.result  =result;
        this.failingLineNumber = failingLineNumber;
        this.code = code;
    }
}
