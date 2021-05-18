package com.ruoyi.quartz.task;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import com.ruoyi.common.utils.StringUtils;
import java.io.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务调度测试
 * 
 * @author ruoyi
 */
@Component("ryTask")
public class RyTask {
    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i) {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void ryParams(String params) {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams() {
        System.out.println("执行无参方法");
    }


    public boolean dbBackUp() {
        //最终文件名
        String finalFileName = System.currentTimeMillis() + "-test.sql";
        //String pathSql = "D:\\sjkbf\\" + finalFileName;
        String pathSql = "/root/backup/" + finalFileName;

        File fileSql = new File(pathSql);
        //创建备份sql文件
        if (!fileSql.exists()) {
            try {
                fileSql.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        StringBuffer mysqldumpCmd = new StringBuffer();
        //mysqldumpCmd.append("D:\\Mysql\\mysql-8.0.23-winx64\\mysql-8.0.23-winx64\\bin\\" + "mysqldump");
        mysqldumpCmd.append("mysqldump");
        mysqldumpCmd.append(" -h" + "localhost");
        mysqldumpCmd.append(" -u" + "root");
        //mysqldumpCmd.append(" -p" + "123456");
        mysqldumpCmd.append(" -p" + "12345678");
        mysqldumpCmd.append(" --databases " + "rouyi-vue" + " > ");
        mysqldumpCmd.append(pathSql);
        System.out.println("cmd命令为：" + mysqldumpCmd.toString());
        System.out.println("开始备份：" + "rouyi-vue");
        //String[] cmd = {"cmd","/c", mysqldumpCmd.toString()};
        String[] cmd = {"sh","-c", mysqldumpCmd.toString()};

        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(cmd);
            if (process != null) {
                process.waitFor();
            }
            try (
                    BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "utf-8"));){
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println("cmd message " + line);
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void dbRestore(String fileName) {

        //String filePath = "D:\\sjkbf\\" + fileName;
        String filePath = "/root/backup/" + fileName;

        StringBuilder sb1 = new StringBuilder();

        //sb1.append("D:\\Mysql\\mysql-8.0.23-winx64\\mysql-8.0.23-winx64\\bin\\" + "mysql");
        sb1.append("mysql");

        sb1.append(" -h" + "localhost");

        sb1.append(" -u" + "root");

        //sb1.append(" -p" + "123456");
        sb1.append(" -p" + "12345678");

        sb1.append(" < ");

        sb1.append(filePath);

        System.out.println("cmd命令为：" + sb1.toString());

        Runtime runtime = Runtime.getRuntime();

        System.out.println("开始还原数据");

        //String[] cmd = {"cmd","/c",sb1.toString()};
        String[] cmd = {"sh","-c",sb1.toString()};

        try {

            //插入数据库备份恢复记录表
            Process process = runtime.exec(cmd);

            InputStream is = process.getInputStream();

            BufferedReader bf = new BufferedReader(new InputStreamReader(is, "utf8"));

            String line = null;

            while ((line = bf.readLine()) != null) {

                System.out.println(line);

            }

            is.close();

            bf.close();

        } catch (IOException e) {

            e.printStackTrace();



        }
        System.out.println("数据恢复成功");

    }

}


