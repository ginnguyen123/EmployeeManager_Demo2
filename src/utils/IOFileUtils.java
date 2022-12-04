package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFileUtils {
    public static List<String> readFile(String pathFile){
        ArrayList<String> lineList = new ArrayList<>();
        String lines;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFile));
            while ((lines = bufferedReader.readLine()) != null){
                lineList.add(lines);
            }
            bufferedReader.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
        return lineList;
    }
    public static <T> void writeFile(List<T> list, String pathFile){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFile));
            for (T item : list){
                bufferedWriter.write(item + "\n");
            }
            bufferedWriter.close();
        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
