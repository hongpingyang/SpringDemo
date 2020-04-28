package com.hong.py;

import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

/**
 * author: hongpy
 * create time: 2020-04-27 14:58
 * description:
 * life for code
 */
@BTrace  // 注明这是一个BTrace脚本
public class BtraceScript {

    @OnMethod(
            clazz = "com.hong.py.BtraceTest",
            method = "doAction",  // 指定拦截函数,
            location =@Location(Kind.ENTRY)
    )
    public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
        BTraceUtils.println("ClassName: " + pcn);
        BTraceUtils.println("MethodName: " + pmn);
        BTraceUtils.printArray(args);
        BTraceUtils.println();
    }
}
