package task1;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class test {
    public static void main(String[] args) throws Exception {
        String expr = "(1+2/5)*3";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = engine.eval(expr);
        String title=String.valueOf(result);
        System.out.println(title);
    }
}

