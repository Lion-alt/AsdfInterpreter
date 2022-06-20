public class  A implements Action {
    char aToken;
    char aToken2;
    public A(char aToken, char aToken2) {
        this.aToken = aToken;
        this.aToken2 = aToken2;
    }

    public void run() {
        if (this.aToken == 'a'){
            ASDFAnalysis.toggleFlag = true;
            ASDFAnalysis.mem[ASDFAnalysis.memPtr]++;

            if (this.aToken2 == 'a' && ASDFAnalysis.memPtr == 1) {
                // Convert integer value into char
                char aChar2 = (char) ASDFAnalysis.mem[2];
                ASDFAnalysis.output.append(aChar2);

            }
            if (this.aToken2  == 'a' && ASDFAnalysis.memPtr == 0) {
                ASDFAnalysis.mem[2] = ASDFAnalysis.input.nextByte();
            }
        }
    }
}
