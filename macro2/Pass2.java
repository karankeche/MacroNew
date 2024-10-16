package macro2;

import java.util.ArrayList;
class Pass2 {
    public void start() {
        System.out.println("Starting Pass 2...");

        ArrayList<String> intermediateCode = MacroProcessor.getIntermediateCode();

        for (String line : intermediateCode) {
            String[] parts = line.split("\\s+");
            String macroName = parts[0];

            if (MacroProcessor.getMnt().containsKey(macroName)) {
                // Macro found, expand it
                int mdtIndex = MacroProcessor.getMnt().get(macroName);
                expandMacro(mdtIndex);
            } else {
                // Normal line, print it
                System.out.println(line);
            }
        }

        System.out.println("Pass 2 complete.");
    }

    private void expandMacro(int mdtIndex) {
        while (!MacroProcessor.getMdt().get(mdtIndex).equals("MEND")) {
            String macroLine = MacroProcessor.getMdt().get(mdtIndex);
            System.out.println(macroLine);
            mdtIndex++;
        }
    }
}

