// Source code is decompiled from a .class file using FernFlower decompiler.
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class macroProcessor {
   private static HashMap<String, Integer> mnt = new HashMap();
   private static ArrayList<String> mdt = new ArrayList();
   private static ArrayList<String> ala = new ArrayList();
   private static ArrayList<String> intermediateCode = new ArrayList();
   private static String fileContent;
   private static Pass1 pass1 = new Pass1();

   public macroProcessor() {
   }

   public static void main(String[] var0) throws IOException {
      System.out.println("******** Two Pass Macro-Processor **********\n\n");
      fileContent = getContentFrom("/Users/karankeche/Desktop/macro/2.txt");
      pass1.start();
      System.out.println("Contents of MNT (Macro Name Table): \n" + String.valueOf(mnt));
      System.out.println("Contents of MDT (Macro Definition Table): \n" + String.valueOf(mdt));
      System.out.println("Intermediate Code: \n" + String.valueOf(intermediateCode));
   }

   private static String getContentFrom(String var0) throws IOException {
      BufferedReader var1 = new BufferedReader(new FileReader(new File(var0)));
      StringBuilder var2 = new StringBuilder();

      String var3;
      while((var3 = var1.readLine()) != null) {
         var2.append(var3).append("\n");
      }

      var1.close();
      return var2.toString();
   }

   public static String getFileContent() {
      return fileContent;
   }

   public static void updateMnt(String var0, int var1) {
      mnt.put(var0, var1);
   }

   public static void updateMdt(String var0) {
      mdt.add(var0);
   }

   public static void updateAla(String var0) {
      ala.add(var0);
   }

   public static void updateIntermediateCode(String var0) {
      intermediateCode.add(var0);
   }

   public static HashMap<String, Integer> getMnt() {
      return mnt;
   }

   public static ArrayList<String> getMdt() {
      return mdt;
   }

   public static ArrayList<String> getIntermediateCode() {
      return intermediateCode;
   }
}