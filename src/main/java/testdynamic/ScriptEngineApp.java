package testdynamic;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;

/**
 * @Param Created by Administrator on 2019/6/16 0016.
 */
public class ScriptEngineApp {

    public static void main(String[] args) {
        try {
            GroovyScriptEngine engine = new GroovyScriptEngine("dynamic/conf/");

            Binding binding1 = new Binding();
            engine.run("noargs.groovy", binding1);

            String[] arg = new String[]{"1", "2", "3"};
            Binding binding2 = new Binding();
//            binding2.setVariable("arg", "测试参数");
            binding2.setVariable("arg", arg);

            engine.run("hasargs.groovy", binding2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


