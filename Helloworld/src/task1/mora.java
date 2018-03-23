package task1;

import javax.swing.JOptionPane;
import java.util.Random;

public class mora {

    // 判断输赢
    public static int judge(int a, int b){
        if(a-b==-1 || a-b==2){
            // a获胜
            return 1;
        }
        else if(a-b==1 || a-b==-2){
            // a输了
            return 2;
        }
        // 代表平局
        return 0;
    }

    // 实际进行猜拳的函数
    public static int operate(int user, int computer){
        if(judge(user, computer)==1) {
            System.out.println("这一局你赢了！");
            // 用户赢了返回1
            return 1;
        }
        else if(judge(user, computer)==2) {
            System.out.println("这一局你输了！");
            // 用户输了返回2
            return 2;
        }
        else {
            System.out.println("这一局平局，再来一局");
            do{
                // 再次随机生成电脑的随机数
                Random rand = new Random();
                computer = rand.nextInt(3);

                // 获取用户的数字
                String input = JOptionPane.showInputDialog("请出拳：");
                user = Integer.parseInt(input);

                // 递归调用这个函数
                return operate(user, computer);
            }
            while (judge(user, computer) != 0);

        }
    }

    public static void main(String[] args) {
        // 存储用户和电脑获胜的局数
        int userWin=0;
        int computerWin=0;

        // 获取用户输入的局数
        String round = JOptionPane.showInputDialog("请输入你想玩的局数(五局三胜输入5，三局两胜输入3):");
        int round_n = Integer.parseInt(round);

        // 进行局数次猜拳
        for(int i=0; i<round_n; i++){
            Random rand = new Random();
            int computer = rand.nextInt(3);

            String input = JOptionPane.showInputDialog("请出拳：");
            int user = Integer.parseInt(input);

            // 记录获胜的总局数
            if(operate(user, computer) == 1)
                userWin ++;
            else
                computerWin ++;
        }

        // 比较谁取得了最终的胜利
        if(userWin>computerWin)
            System.out.println("你取得了最终的胜利");
        else
            System.out.println("电脑取得了最终的胜利");


    }


}
