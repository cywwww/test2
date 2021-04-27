package io;

import java.io.*;

/*
拷贝目录
 */
public class CopyAll {
    public static void main(String[] args){

        File srcFile = new File("/Users/macbookpro2019/Downloads/javase课件/001-JavaSE课堂笔记+思维导图");
        File destFile = new File("/Users/macbookpro2019/Desktop/index");
        // 调用方法拷贝
        copyDir(srcFile, destFile);
    }

    /**
     * 拷贝目录
     * @param srcFile 拷贝源
     * @param destFile 拷贝目标
     */
    private static void copyDir(File srcFile, File destFile) {
        if(srcFile.isFile()) {
            // srcFile如果是一个文件的话，递归结束。
            // 是文件的时候需要拷贝。
            // ....一边读一边写。
            FileInputStream in = null;
            FileOutputStream out = null;
            try {
                // 读这个文件
                // D:\course\02-JavaSE\document\JavaSE进阶讲义\JavaSE进阶-01-面向对象.pdf
                in = new FileInputStream(srcFile);
                // 写到这个文件中
                // C:\course\02-JavaSE\document\JavaSE进阶讲义\JavaSE进阶-01-面向对象.pdf
                String path = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\")  + srcFile.getAbsolutePath().substring(40);
                out = new FileOutputStream(path);
                // 一边读一边写
                byte[] bytes = new byte[1024 * 1024]; // 一次复制1MB
                int readCount = 0;
                while((readCount = in.read(bytes)) != -1){
                    out.write(bytes, 0, readCount);
                }
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
        // 获取源下面的子目录
        File[] files = srcFile.listFiles();
        for(File file : files){
            // 获取所有文件的（包括目录和文件）绝对路径
            //System.out.println(file.getAbsolutePath());
            if(file.isDirectory()){
                // 新建对应的目录
                //System.out.println(file.getAbsolutePath());
                //D:\course\02-JavaSE\document\JavaSE进阶讲义       源目录
                //C:\course\02-JavaSE\document\JavaSE进阶讲义       目标目录
                String srcDir = file.getAbsolutePath();
                String destDir = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\")  + srcDir.substring(40);
                File newFile = new File(destDir);
                if(!newFile.exists()){
                    newFile.mkdirs();
                }
            }
            // 递归调用
            copyDir(file, destFile);
        }
    }
}
