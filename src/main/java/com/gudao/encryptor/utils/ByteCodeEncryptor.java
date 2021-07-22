package com.gudao.encryptor.utils;

/**
 * @Auther: Gudao
 * @Date: 2021/07/22
 * @Description: 原生加密方法
 */
public class ByteCodeEncryptor {
    static {
        // C++ 项目生成的.dll文件位置（在idea中需要添加 VM options）
        System.loadLibrary("jvmti");
    }

    public native static byte[] encrypt(byte[] text);

}
