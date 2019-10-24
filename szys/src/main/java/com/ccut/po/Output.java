package com.ccut.po;

import java.io.*;

public class Output {
    public static void createTxt(String path, String fileName, String content) throws IOException {
        File report = new File(path + fileName + ".txt");
        Writer write = new OutputStreamWriter(new FileOutputStream(report), "UTF-8");
        write.write(content);
        write.flush();
        write.close();
    }
}
