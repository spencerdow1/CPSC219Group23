package Logic;

import java.io.*;

public class FileIO {
    private static File file = new File("src\\Logic\\Winners.txt");

    public static String[] Read() {
        FileInputStream fileInputStream = null;
        byte[] bytes = null;
        try {
            fileInputStream = new FileInputStream(file);
            bytes = new byte[(int) file.length()];
            fileInputStream.read(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = new String(bytes);
        String[] data = new String[4];
        data = s.split("\n");
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void Write(String name){
        String[] data = Read();
        String[] newData = new String[5];
        newData[0] = name;
        newData[1] = data[0];
        newData[2] = data[1];
        newData[3] = data[2];
        newData[4] = data[3];
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write( newData[0] + "\n" + newData[1] + "\n" + newData[2] + "\n" + newData[3] + "\n" + newData[4]);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String args[]){
        Write("Russ");
    }


}
