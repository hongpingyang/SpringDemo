package com.hong.py.agent;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * author: hongpy
 * create time: 2020-04-27 11:05
 * description:
 * life for code
 */
public class AgentDemo {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("Premain 执行");
        ClassFileTransformer fileTransformer=new ClassFileTransformerDemo();
        instrumentation.addTransformer(fileTransformer);
        System.out.println("字节码处理器加载到jvm中");
    }
}
