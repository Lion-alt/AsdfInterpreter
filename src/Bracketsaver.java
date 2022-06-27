import java.util.Hashtable;
import java.util.Stack;

public class Bracketsaver {

    static Stack<Integer> bracketStack = new Stack<>();
    static Hashtable<Integer, Integer> bracketTable = new Hashtable<>();

    public static Result saveBrackets(char[] charArray, StringBuilder code) {
        int srcPointer;
        for (srcPointer = 0; srcPointer < charArray.length; srcPointer++) {
            if (charArray[srcPointer] == 'd') {
                bracketStack.add(srcPointer);
            } else if (charArray[srcPointer] == 'f') {
                if (!bracketStack.isEmpty()) {
                    Integer previousOpenBracket = bracketStack.pop();
                    bracketTable.put(previousOpenBracket, srcPointer);
                    bracketTable.put(srcPointer, previousOpenBracket);

                } else {
                    // tag::exception[]
                    return new Result(false, srcPointer,new StringBuilder("Wrong f at position" + srcPointer + "in" + code));
                    // end::exception[]
                }
            }
        }
        return new Result(true, 0, code);
    }
}
