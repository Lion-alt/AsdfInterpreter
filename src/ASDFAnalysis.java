
import java.util.*;


public class ASDFAnalysis {

    static char[] charArray = new char[65535];
    private static final List<Character> bfchars = List.of('a', 's', 'd', 'f', 'g', 'h');
    static int srcPointer;
    static int memPtr = 3;
    static byte[] mem = new byte[65535];
    static boolean toggleFlag = false;
    static StringBuilder output = new StringBuilder();
    static Stack<Action> actions = new Stack<>();

    static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String code = "aasaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasaahsgggsasagsaahsaaaaaaasaaahsaaasaahsgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggagsaahsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasaahsggggggggagsaahsaaasaahsggggggagsaahsggggggggagsaa";
        Result result = preprocess(code);
        interpret();
        System.out.println(runInterpretation());
    }




    private static Result preprocess(String code) {
        StringBuilder code2 = new StringBuilder(code).reverse();
        charArray = code2.toString().toCharArray();
        return Bracketsaver.saveBrackets(charArray, code2);
    }

    private static StringBuilder runInterpretation() {
        while(!actions.isEmpty()) {
            Action action = actions.pop();
            action.run();
        }
        return output;
    }


    private static void interpret() {
        for (srcPointer = 0; srcPointer < charArray.length; srcPointer++) {
            if (ASDFAnalysis.charArray.length <= srcPointer + 1) {
                continue;
            }
            if (bfchars.contains(charArray[srcPointer])) {
                if (charArray[srcPointer] == ('d') && mem[memPtr] == 1) {
                    actions.push(new D());
                }
                if (charArray[srcPointer] == ('f') && mem[memPtr] == 0) {
                    actions.push(new D());
                }
                if (charArray[srcPointer] == 's') {
                    actions.push(new S());
                }
                if (charArray[srcPointer] == 'h') {
                    actions.push(new H());
                }
                if (charArray[srcPointer] == 'g') {
                    actions.push(new G());
                }
                if (charArray[srcPointer] == 'a') {
                    actions.push(new A(charArray[srcPointer], charArray[srcPointer+1]));
                }
            }
        }
    }
}