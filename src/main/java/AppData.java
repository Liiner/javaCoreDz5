import java.io.*;
import java.util.Random;

public class AppData {

    public static void main(String[] args) throws IOException {
        File file = new File("tabl.csv");
        String[] header = new String[5];
        int[][] data = new int[5][5];
        initArray(header, data);
        printArray(header, data);
        saveArrayToFile(header, data, file);
        openArrayToFile(file);
    }

    private static void printArray(String[] header, int[][] data) {
        for (int i = 0; i < header.length; i++) {
            System.out.print(header[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void initArray(String[] header, int[][] data) {
        Random r = new Random();
        for (int i = 0; i < header.length; i++) {
            header[i] = "Value" + (i + 1);
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                data[i][j] = r.nextInt();
            }
        }
    }

    private static void saveArrayToFile(String[] header, int[][] data, File path) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < header.length; i++) {
                bufferedWriter.write(String.valueOf(header[i]) + "; ");
            }
            bufferedWriter.newLine();

            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length; j++) {
                    bufferedWriter.write(String.valueOf(data[i][j]) + "; ");
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openArrayToFile(File path){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String str;
            while ((str = bufferedReader.readLine()) != null){
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


