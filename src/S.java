public class S implements Action {
    public void run() {
        if (!ASDFAnalysis.toggleFlag) {
            ASDFAnalysis.memPtr++;
        }
        if (ASDFAnalysis.toggleFlag) {
            ASDFAnalysis.toggleFlag = false;
            ASDFAnalysis.memPtr--;
        }
    }
}
