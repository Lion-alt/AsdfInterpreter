public class D implements Action {
    public void run() {
        ASDFAnalysis.toggleFlag = false;
        ASDFAnalysis.srcPointer = Bracketsaver.bracketTable.get(ASDFAnalysis.srcPointer);
    }
}
