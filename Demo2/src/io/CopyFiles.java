package io;

import java.io.*;

/**
 * @Author 王承尧
 * @Date 2021/4/3 11:23 下午
 */
public class CopyFiles {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("/Users/macbookpro2019/Downloads/javase课件/001-JavaSE课堂笔记+思维导图");
        File destFile = new File("/Users/macbookpro2019/Desktop/index");
        copy(srcFile,destFile);
        System.out.println("复制成功");
    }

    public static void copy(File srcFile,File destFile) {
        if (srcFile.isFile()){
            FileInputStream fs = null;
            FileOutputStream fo = null;
            try {
                fs = new FileInputStream(srcFile);

                String path = (destFile.getAbsolutePath().endsWith("/") ? destFile.getAbsolutePath() : destFile.getAbsolutePath() + "/")  + srcFile.getAbsolutePath().substring(41);
//            System.out.println(path);
                File destDir = new File(path);

             fo = new FileOutputStream(destDir);

            byte[] buff = new byte[1024*1024];
            int counts = 0;
            while((counts=fs.read(buff))!=-1){
                fo.write(buff,0,counts);
            }
                fo.flush();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fs != null) {
                    try {
                        fs.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fo != null) {
                    try {
                        fo.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
        //获取源文件下的子目录
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
                String destDir = (destFile.getAbsolutePath().endsWith("/") ? destFile.getAbsolutePath() : destFile.getAbsolutePath() + "/")  + srcDir.substring(41);
                File newFile = new File(destDir);
                if(!newFile.exists()){
                    newFile.mkdirs();
                }
            }
            // 递归调用
            copy(file, destFile);
        }

    }
}
