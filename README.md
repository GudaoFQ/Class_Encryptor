## 使用说明

1. 先将springboot的项目打包 package
2. 配置C++项目，生成.dll文件
3. 将.dll文件路径添加到idea的 VM options
4. 修改utils中的ByteCodeEncryptor的System.loadLibrary方法，参数改成自己生成的.dll文件名
5. 修改encryptor中的JarEncryptorTest的jar包路径
7. 如果修改了本项目中的springboot项目，请在JarEncryptor中重新指定你需要加密的内容，启动类不要修改
8. 通过命令运行jar包，注意不要改动jar包位置；java -agentpath:D:\Project\C\test\jvmti\x64\Debug\jvmti.dll【说明：这个是你的.dll文件位置】 -cp jvmti-0_encrypted.jar【说明：这个是你的加密后jar包】 com.gudao.jvmti.JvmtiApplication【说明：这个是你的启动类位置】

注意：2中的C++项目，请到我的github中找另一个C语言的项目，pull下来运行就ok了；或者看我的Ability_Note笔记中的jvmti