package com.hong.py.agent;


import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtBehavior;
import javassist.CtClass;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * author: hongpy
 * create time: 2020-04-27 10:54
 * description:
 * life for code
 *
 * 字节码处理器
 * javaassit.jar 必须和生成的jar放在一起，不然会报错。
 * 但程序运行的 main 函数不一定要放在 premain 所在的这个 jar 文件里面。
 * java.lang.ClassNotFoundException: javassist.CannotCompileException
 *
 * addTransformer 方法并没有指明要转换哪个类。
 * 转换发生在 premain 函数执行之后，main 函数执行之前，
 * 这时每装载一个类，transform 方法就会执行一次。
 */
public class ClassFileTransformerDemo implements ClassFileTransformer {


    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        System.out.println("当前处理的类:" + className);
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass=null;
        try {
            ctClass= pool.makeClass(new ByteArrayInputStream(classfileBuffer));
            if (!ctClass.isInterface()) {
                CtBehavior[] declaredMethods = ctClass.getDeclaredBehaviors();
                for (CtBehavior ctMethod : declaredMethods) {
                    if (!ctMethod.isEmpty()&&"test".equalsIgnoreCase(ctMethod.getName())) {
                        //添加耗时打印
                        ctMethod.addLocalVariable("stime",CtClass.longType);
                        ctMethod.insertBefore("long stime=System.nanoTime();");
                        String methodName=ctMethod.getName();
                        String str="System.out.println(\"耗时:\"+(System.nanoTime() - stime));";
                        ctMethod.insertAfter(str);
                    }
                }
                return ctClass.toBytecode();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
        finally {
            if (ctClass != null) {
                ctClass.detach();
            }
        }

        return new byte[0];
    }
}
