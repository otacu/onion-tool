
package com.egoist.oniontool.service;

public class TestGzEPort {
    public static void main(String[] args)throws Exception {
        String orignalXml = "密文";
        String result = new String(java.util.Base64.getDecoder().decode(orignalXml.getBytes("UTF-8")), "UTF-8");
        System.out.println("###########################################################");
        System.out.println(result);
    }
}
