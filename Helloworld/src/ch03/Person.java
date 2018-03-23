package ch03;

import javax.swing.JOptionPane;

public class Person {
        String pid;
        String pname;
        int page;

        public void initial(){
            pid = JOptionPane.showInputDialog("身份证号");
            pname = JOptionPane.showInputDialog("姓名");
            String input = JOptionPane.showInputDialog("年龄");
            page = Integer.parseInt(input);
        }

        public void output(){
            System.out.println("身份证:" + pid);
            System.out.println("姓名:" + pname);
            System.out.printf("年龄:%-6d" , page);
        }

        public static void main(String[] args){
            Person p = new Person();
            p.initial();
            p.output();
        }
}
