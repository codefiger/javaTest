namespace java com.zpeng.gen.thrift.pojo

	//基本数据类型
    //    bool：布尔值，true 或 false，对应 Java 的 boolean
    //    byte：8 位有符号整数，对应 Java 的 byte
    //    i16：16 位有符号整数，对应 Java 的 short
    //    i32：32 位有符号整数，对应 Java 的 int
    //    i64：64 位有符号整数，对应 Java 的 long
    //    double：64 位浮点数，对应 Java 的 double
    //    string：未知编码文本或二进制字符串，对应 Java 的 String
    //结构体类型：
    //    struct：定义公共的对象，类似于 C 语言中的结构体定义，在 Java 中是一个 JavaBean
    //容器类型：
    //    list：对应 Java 的 ArrayList
    //    set：对应 Java 的 HashSet
    //    map：对应 Java 的 HashMap
    //异常类型：
    //    exception：对应 Java 的 Exception
    //服务类型：
    //    service：对应服务的类

	//生成命令：在thrift文件路径下执行thrift --gen java:hashcode -out /home/peng.zhang/zpeng/test/testWorksapce/test-gradle-logback/src/main/java helloworld.thrift
struct Emotion{
	10:optional string name;
	20:optional string type;
}