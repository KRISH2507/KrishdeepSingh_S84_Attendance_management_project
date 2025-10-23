package com.school;

import java.io.*;
import java.util.*;
import java.util.function.Function;

public class FileStorageService {

    public <T> List<T> loadData(String filename, Function<String, T> parser) {
        List<T> list = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(parser.apply(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveData(List<? extends Storable> data, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Storable s : data) {
                bw.write(s.toDataString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
