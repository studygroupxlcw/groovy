package testdynamic;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import org.codehaus.groovy.control.CompilationFailedException;

import java.io.File;
import java.io.IOException;

/**
 * @Param Created by Administrator on 2019/6/16 0016.
 */
public class GroovyShellApp {
    public static void main(String[] args) {
        try {
            evaluate3();
            evaluate4();
            evaluate5();
            evaluate6();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void evaluate3() throws CompilationFailedException, IOException {
        Binding binding = new Binding();
        //和参数名称一致
        binding.setProperty("arg", "ookk");
        GroovyShell groovyShell = new GroovyShell(binding);
        String x =  (String)groovyShell.evaluate(new File("dynamic/conf/hasargs.groovy"));
        System.out.println(x);

//        System.out.println(binding.getVariable("a"));
//        System.out.println(binding.getVariable("b"));
//        System.out.println(binding.getVariable("c"));
//        System.out.println(binding.getVariables());
//
//        groovyShell.evaluate(new File("dynamic/conf/noargs.groovy"));
//        System.out.println(binding.getVariables());
//        System.out.println("over");
    }

    public static void evaluate4() throws CompilationFailedException, IOException {
        Binding binding = new Binding();
        GroovyShell groovyShell = new GroovyShell(binding);
        groovyShell.evaluate(new File("dynamic/conf/noargs.groovy"));
    }

    public static void evaluate5() throws CompilationFailedException, IOException {
        GroovyShell groovyShell = new GroovyShell();
        Script script = groovyShell.parse(new File("dynamic/conf/noargs.groovy"));
        script.invokeMethod("prints", null);
    }

    public static void evaluate6() throws CompilationFailedException, IOException {
        GroovyShell groovyShell = new GroovyShell();
        Script script = groovyShell.parse(new File("dynamic/conf/hasargs.groovy"));
        Object[] arg = {"1", "2", "3"};
        script.invokeMethod("prints", arg);
    }


}
