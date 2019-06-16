package testdynamic;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;

/**
 * @Param Created by Administrator on 2019/6/16 0016.
 */
public class ClassLoaderApp {
    private static GroovyClassLoader groovyClassLoader = null;


    public static void main(String[] args) {
        loadFromClass();
        loadFromFile();
    }

    /**
     * 通过类加载groovy
     */
    private static void loadFromClass() {
        GroovyObject groovyObject = null;
        try {
            groovyObject = (GroovyObject) ClassLoaderApp.class.getClassLoader().loadClass("groovy.TestGroovy").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 执行无参函数
        groovyObject.invokeMethod("prints", null);

        // 执行有参函数
        Object[] objects = new Object[]{"hj", "lklk", "gyyth"};
        groovyObject.invokeMethod("prints", objects);
    }


    private static boolean loadFromFile() {
        File groovyFile = new File("dynamic/src/main/groovy/groovy/TestGroovy.groovy");
        if (!groovyFile.exists()) {
            System.out.println("文件不存在");
            return false;
        }
//        CompilerConfiguration config = new CompilerConfiguration();
//        config.setSourceEncoding("UTF-8");
        groovyClassLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader());

        try {
            Class<?> groovyClass = groovyClassLoader.parseClass(groovyFile);
            GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
            groovyObject.invokeMethod("prints", new Object[]{"dsfdsf", "sdfgdfdhfh", "g", "sdg"});
            groovyObject.invokeMethod("prints", null);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}


