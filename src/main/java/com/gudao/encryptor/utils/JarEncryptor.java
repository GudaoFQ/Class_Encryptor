package com.gudao.encryptor.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

/**
 * @Auther: Gudao
 * @Date: 2021/07/22
 * @Description: 加密jar包
 */
public class JarEncryptor {

  public static void encrypt(String fileName){
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      byte[] buf = new byte[1024];
      File srcFile = new File(fileName);
      // 加密后生成的包文件名
      File dstFile = new File(fileName.substring(0, fileName.indexOf("."))+"_encrypted.jar");
      FileOutputStream dstFos = new FileOutputStream(dstFile);
      JarOutputStream dstJar = new JarOutputStream(dstFos);
      JarFile srcJar = new JarFile(srcFile);
      for (Enumeration<JarEntry> enumeration = srcJar.entries(); enumeration.hasMoreElements();) {
          JarEntry entry = enumeration.nextElement();
          InputStream is = srcJar.getInputStream(entry);
          int len;
          while ((len = is.read(buf, 0, buf.length)) != -1) {
              baos.write(buf, 0, len);
          }
          byte[] bytes = baos.toByteArray();
          String name = entry.getName();
          // 需要加密的class路径过滤条件
          if(name.startsWith("com/gudao/jvmti/controller") && name.endsWith(".class")){
              try {
                  bytes = ByteCodeEncryptor.encrypt(bytes);
              } catch (Exception e) {
                  e.printStackTrace();
              }
          }
          JarEntry ne = new JarEntry(name);
          dstJar.putNextEntry(ne);
          dstJar.write(bytes);
          baos.reset();
      }
      srcJar.close();
      dstJar.close();
      dstFos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
}
