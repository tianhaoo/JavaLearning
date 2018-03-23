package task1;

import javax.swing.JOptionPane;
import java.util.Random;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class calculator {
    int range;
    String ops;
    int pa1;
    int pa2;
    String fo;
    int result;

    public void initial(){
        // 初始化一些值
        String in2 = JOptionPane.showInputDialog("请输入操作数范围 ：");
        range = Integer.parseInt(in2);
        String in3 = JOptionPane.showInputDialog("请输入运算符的范围（仅输入运算符组成的字符串）：");
        ops = in3;
        pa1 = 0;
        pa2 = 0;
        result = 0;
    }

    public String generate(){
        Random rand = new Random();                // 生成一个随机数对象

        int times = rand.nextInt(10);       // 随机生成运算项数
        int opsLen = ops.length();                 // 记录运算符字符串的长度 ，为之后生成随机数提供范围；

        pa1 = rand.nextInt(range+1);        // 随机生成第一个操作数
        fo += pa1;
        result += pa1;
        for(int i=0; i<times; i++){
            pa2 = rand.nextInt(range+1);    // 生成第二个操作数
            int opNum = rand.nextInt(opsLen);      // 生成一个随机数，用以决定这一个循环里使用哪一个操作符

            char op = ops.charAt(opNum);           // 根据这个随机数取出来对应的操作符

            fo = fo + op + pa2;
//            这种写法在大于两项时不能保证运算优先级正确
//            if(op == '+')
//                result += pa2;
//            else if(op == '-')
//                result -= pa2;
//            else if(op == '*')
//                result *= pa2;
//            else if(op == '/')
//                result /= pa2;
        }

        return fo.substring(4);                                  // 返回运算表达式字符串


    }



    public boolean judge(double result) {           // 判断结果是否正确
        System.out.println(fo.substring(4));
        String in4 = JOptionPane.showInputDialog("请输入正确答案 ：");
        float userAnswer = Float.parseFloat(in4);

        if(userAnswer == result){
            System.out.println("回答正确！");
            return true;
        }else{
            System.out.println("回答错误, 正确答案为："+result);
            return false;
        }
    }




    public static void main(String[] args) throws Exception {
        String in1 = JOptionPane.showInputDialog("请输入题目的数量：");
        int number = Integer.parseInt(in1);
        String formula;           // 存储运算表达式字符串

        int rightAnswer= 0;
        float score = 0;

        for (int i=0; i<number; i++){
            // 实例化计算器对象
            calculator ca = new calculator();
            // 初始化
            ca.initial();
            // 生成算数表达式字符串
            formula = ca.generate();

            //利用js引擎解析生成的算术表达式，将正确结果储存到temp里面
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            Object temp = engine.eval(formula);
            // 先将Object类型的temp转化为字符串，然后转化为double，便于后续的判断
            String temp2=String.valueOf(temp);
            double ultimate = Double.parseDouble(temp2);

            // 判断结果是否正确
            if(ca.judge(ultimate))
                rightAnswer ++;
    }
    score = 100 * (Float.parseFloat("" + rightAnswer)/number);
        System.out.println("您的得分是" + score);
    }
}
