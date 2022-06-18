
import java.util.*;


public class BFAnalysis {
    static int memPtr = 3;
    static byte[] mem = new byte[65535];
    static char[] charArray = new char[65535];
    static int srcPointer;
    static boolean toggleFlag = false;
    static StringBuilder output = new StringBuilder();
    static Stack<Integer> bracketStack = new Stack<>();
    static Hashtable<Integer, Integer> bracketTable = new Hashtable<>();
    private static final Scanner input = new Scanner(System.in);
    private static final List<Character> bfchars = List.of('a', 's', 'd', 'f', 'g', 'h');
    public static void main(String[] args) {
        String code = "aasaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasaahsgggsasagsaahsaaaaaaasaaahsaaasaahsgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggagsaahsaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasaahsggggggggagsaahsaaasaahsggggggagsaahsggggggggagsaa";
        Result result = preprocess(code);
        System.out.println(interpret(result.code));

    }

    // Function to convert
    // byte value to String value
    public static String
    convertByteToString(byte byteValue)
    {

        // Convert byte value to String value
        // using + operator method

        return ("" + byteValue);
    }


    public static Result preprocess(String code) {
        charArray = code.toCharArray();
        for (srcPointer = 0; srcPointer < charArray.length; srcPointer++) {
            if (charArray[srcPointer] == 'd') {
                bracketStack.add(srcPointer);
            } else if (charArray[srcPointer] == 'f') {
                if (!bracketStack.isEmpty()) {
                    Integer previousOpenBracket = bracketStack.pop();
                    bracketTable.put(previousOpenBracket, srcPointer);
                    bracketTable.put(srcPointer, previousOpenBracket);

                } else {
                    return new Result(false, srcPointer, code);
                }
            }
        }
        return new Result(true, 0, code);
    }

    public static StringBuilder interpret(String code) {
        for (srcPointer = 0; srcPointer < charArray.length; srcPointer++) {
            if (bfchars.contains(charArray[srcPointer])) {
                if (charArray[srcPointer] == ('d') && mem[memPtr] == 1) {
                    toggleFlag = false;
                    srcPointer = bracketTable.get(srcPointer);
                }
                if (charArray[srcPointer] == ('f') && mem[memPtr] == 0) {
                    toggleFlag = false;
                    srcPointer = bracketTable.get(srcPointer);
                }
                if (charArray[srcPointer] == 's' && !toggleFlag) {
                    memPtr++;
                }
                if (charArray[srcPointer] == 's' && toggleFlag) {
                    toggleFlag = false;
                    memPtr--;
                }
                if(charArray[srcPointer] == 'h') {
                    toggleFlag = false;
                }
                if (charArray[srcPointer] == 'g') {
                    mem[memPtr]--;
                }
                if (charArray[srcPointer] == 'a') {
                    toggleFlag = true;
                    mem[memPtr]++;
                    if (charArray.length <= srcPointer + 1) {
                        continue;
                    }
                    if (charArray[srcPointer + 1] == 'a' && memPtr == 1) {
                        // Convert integer value into char
                        char aChar2 = (char) mem[2];
                        output.append(aChar2);

                    }
                    if (charArray[srcPointer + 1] == 'a' && memPtr == 0) {
                        mem[2] = input.nextByte();
                    }
                }
            }
        }
        return output;
    }
}