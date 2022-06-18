public class Result {
    boolean result;
    int failingLineNumber;
    String code;
    public Result(boolean result, int failingLineNumber, String code) {
        this.result  =result;
        this.failingLineNumber = failingLineNumber;
        this.code = code;
    }
}
