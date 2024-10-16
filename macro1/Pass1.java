// Source code is decompiled from a .class file using FernFlower decompiler.
class Pass1 {
    Pass1() {
    }
 
    public void start() {
       System.out.println("Starting Pass 1...");
       String[] var1 = macroProcessor.getFileContent().split("\\n");
       boolean var2 = false;
       String var3 = null;
       String[] var4 = var1;
       int var5 = var1.length;
 
       for(int var6 = 0; var6 < var5; ++var6) {
          String var7 = var4[var6];
          String[] var8 = var7.trim().split("\\s+");
          if (var8[0].equals("MACRO")) {
             var2 = true;
          } else if (var2) {
             if (var3 == null) {
                var3 = var8[0];
                macroProcessor.updateMnt(var3, macroProcessor.getMdt().size());
                if (var8.length > 1) {
                   String[] var9 = var8[1].split(",");
                   String[] var10 = var9;
                   int var11 = var9.length;
 
                   for(int var12 = 0; var12 < var11; ++var12) {
                      String var13 = var10[var12];
                      macroProcessor.updateAla(var13);
                   }
                }
             } else if (var8[0].equals("MEND")) {
                var2 = false;
                var3 = null;
                macroProcessor.updateMdt("MEND");
             } else {
                macroProcessor.updateMdt(var7);
             }
          } else {
             macroProcessor.updateIntermediateCode(var7);
          }
       }
 
       System.out.println("Pass 1 complete.");
    }
 }