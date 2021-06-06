package com.citic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonUtils {

    /**
     * 发起方流水号规则为：流水号前缀（可以是任意字符，不一定是系统编号，视情况而定）+17位时间戳（YYYYMMDDhhmmssSSS）+8位随机数字
     * @param sysCode
     * @return
     * @throws Exception
     */
    public static String getQrySeq(String sysCode) throws Exception{
        byte[] randomSerial = new byte[8];
        String charactors = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";
        int charactorsLen = charactors.length();

        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 13; i++){
            int part = random.nextInt(10);
            str.append(part);
        }

        Long seed = Long.parseLong(str.toString());
        Random randomNum = new Random(seed);
        for (int i = 0; i < 8; i++){
            randomNum.setSeed(seed);
            int index =(int)(randomNum.nextFloat() * charactorsLen);
            randomSerial[i] = (byte) charactors.charAt(index);
            seed = seed * randomNum.nextInt();
        }

        String randomNumber = "";
        try {
            randomNumber = new String(randomSerial, "UTF-8");
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        Date date = new Date();
        //17位时间戳
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String datePart = format.format(date);
        String qrySeq = sysCode + datePart + randomNumber;
        return qrySeq;
    }
}
