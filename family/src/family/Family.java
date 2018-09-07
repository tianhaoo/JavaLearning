package family;

import java.io. *;
import javax.swing. *;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class Family {
	public static void main(String [] args) throws IOException {
		
		// 获取族谱树
		Tree root = getTree();

		
		JFrame jf = new JFrame("族谱管理系统");
        jf.setSize(500, 600);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        // 创建内容面板，指定使用 流式布局
        JPanel panel = new JPanel(new FlowLayout());
        
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("zupu.jpg"));
        panel.add(label02);

        JButton btn01 = new JButton("第几代查询");
        JButton btn02 = new JButton("父母亲查询");
        JButton btn03 = new JButton("孩子查询");
        JButton btn04 = new JButton("祖先查询");
        JButton btn05 = new JButton("新生孩子插入");
        JButton btn06 = new JButton("结婚信息插入");
        
        btn01.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("第几代查询...");
        		String input = JOptionPane.showInputDialog("请输入要查询的身份证号");
        		if(!isNumeric(input)) { // 输入数据不合理
	                JOptionPane.showMessageDialog(
	                        jf,
	                        "请输入正确的身份证号",
	                        "警告",
	                        JOptionPane.WARNING_MESSAGE
	                );
	                System.out.println("查询失败");
        		} else {
        			Tree result = root.findNodeByIdNumber(input);
        			Tree testHusband = root.getHusband(input);
        			if (result == null && testHusband == null) {
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        "没有找到对应的人员信息",
    	                        "提示",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("查询成功");
        			}else {
        				String text = "第"+(result!=null?result.getDepth()+1:testHusband.getDepth()+1)+"代";
        				System.out.println(text);
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        text,
    	                        "提示",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("查询成功");
    	                
        			}
        				
        		}
        	}
        });
        
        btn02.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("父母亲查询...");
        		String input = JOptionPane.showInputDialog("请输入要查询的身份证号");
        		if(!isNumeric(input)) { // 输入数据不合理
	                JOptionPane.showMessageDialog(
	                        jf,
	                        "请输入正确的身份证号",
	                        "警告",
	                        JOptionPane.WARNING_MESSAGE
	                );
	                System.out.println("查询失败");
        		} else {
        			Tree result = root.findNodeByIdNumber(input);
        			Tree testHusband = root.getHusband(input);
        			if (result == null && testHusband == null) {
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        "没有找到对应的人员信息",
    	                        "提示",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("查询成功");
        			}else {
        				Tree temp = (result != null?result.parent:testHusband.parent);
        				String text= (temp!=null?"父亲:"+temp.getElem().getIdNumber()+" "+temp.getElem().getName()+"\n母亲:"+temp.getElem().getWife().getIdNumber()+" "+temp.getElem().getWife().getName():"族谱中没有记录该成员的父母信息");
        				System.out.println(text);
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        text,    
    	                        "提示",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("查询成功");
        			}
        				
        		}
        	}
        });
        
        btn03.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("孩子查询...");
        		String input = JOptionPane.showInputDialog("请输入要查询的身份证号");
        		if(!isNumeric(input)) { // 输入数据不合理
	                JOptionPane.showMessageDialog(
	                        jf,
	                        "请输入正确的身份证号",
	                        "警告",
	                        JOptionPane.WARNING_MESSAGE
	                );
	                System.out.println("查询失败");
        		} else {
        			Tree result = root.findNodeByIdNumber(input);
        			Tree testHusband = root.getHusband(input);
        			if (result == null && testHusband == null) {
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        "没有找到对应的人员信息",
    	                        "提示",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("查询成功");
        			}else {
        				Tree temp = (result != null?result.getFirstChild():testHusband.getFirstChild()); // 根据身份证号定位到的节点
        				String text;
        				if (temp == null) text = new String("没有孩子");
        				else {
        					text = new String(temp.getElem().getIdNumber()+" "+temp.getElem().getName()+"\n");
        					Tree subtree = temp;
        					while (subtree.getNextSibling() != null) {
        						text += (subtree.getNextSibling().getElem().getIdNumber()+" "+subtree.getNextSibling().getElem().getName()+"\n");
        						subtree = subtree.getNextSibling();
        					}
        				}
        				System.out.println(text);
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        text,    
    	                        "提示",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("查询成功");
        			}
        				
        		}
        	}
        });
        
        btn04.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("查询祖先...");
        		String input = JOptionPane.showInputDialog("请输入要查询的身份证号");
        		if(!isNumeric(input)) { // 输入数据不合理
	                JOptionPane.showMessageDialog(
	                        jf,
	                        "请输入正确的身份证号",
	                        "警告",
	                        JOptionPane.WARNING_MESSAGE
	                );
	                System.out.println("查询失败");
        		} else {
        			Tree result = root.findNodeByIdNumber(input);
        			Tree testHusband = root.getHusband(input);
        			if (result == null && testHusband == null) {
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        "没有找到对应的人员信息",
    	                        "提示",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("查询成功");
        			}else {
        				Tree temp = (result != null?result.getParent():testHusband.getParent()); // 根据身份证号定位到的节点
        				String text;
        				if (temp == null) text = new String("族谱中没有记录该成员的祖先信息");
        				else {
        					text = new String(temp.getElem().getIdNumber()+" "+temp.getElem().getName()+"\n");
        					Tree subtree = temp;
        					while (subtree.getParent()!= null) {
        						text += (subtree.getParent().getElem().getIdNumber()+" "+subtree.getParent().getElem().getName()+"\n");
        						subtree = subtree.getParent();
        					}
        				}
        				System.out.println(text);
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        text,    
    	                        "提示",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                ); 
        			}
        			System.out.println("查询成功");	
        		}
        	}
        });
        
        btn05.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("新生孩子插入...");
                JOptionPane.showMessageDialog(
                        jf,
                        "该功能未实现",
                        "警告",
                        JOptionPane.WARNING_MESSAGE
                );
                System.out.println("插入失败");	

        	}
        });
        
        btn06.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("结婚信息插入...");
                JOptionPane.showMessageDialog(
                        jf,
                        "该功能未实现",
                        "警告",
                        JOptionPane.WARNING_MESSAGE
                );
                System.out.println("插入失败");	

        	}
        });
        
        


        panel.add(btn01);
        panel.add(btn02);
        panel.add(btn03);
        panel.add(btn04);
        panel.add(btn05);
        panel.add(btn06);

        jf.setContentPane(panel);
        jf.setVisible(true);        // PS: 最后再设置为可显示(绘制), 所有添加的组件才会显示
		
		
	}
	
	
	/**
     * 读取文件中的内容，将结果按行分隔，保存在String数组里，并返回
     * @param string 
     * @return String []
     */
	public static String [] readFile(String fileName) throws IOException {	
        // 设置最多纪录为100条
        String [] array = new String [100];
        
		File file = new File(fileName);

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        
        // 读取文件中的内容，将数据存到数组里
        String s;
        int i = 0;
        while ((s = br.readLine()) != null) {
        	if(isNumeric(s)) {
        		int size = Integer.parseInt(s);
        		array = new String [size];
        		continue;
        	}
        	
        	array[i] = s;
			i++;
        }
        br.close();
        
        return array;

	}
	
	/**
     * 根据身份证号查询人
     * @param Person [], string 
     * @return Person
     */
	public static Person findByIdNumber(Person [] persons, String idNumber) {
        for(int i=0; i<persons.length; i++) {
        	if(persons[i].getIdNumber().equals(idNumber)) {
        		return persons[i];
        	}
        }
        return null;
	}
	
	/**
     * 利用自带的函数判断字符串是否是数字
     * @param str
     * @return boolean
     */
	public static boolean isNumeric(String str){
		// 循环判断字符串中的每个字符，判断是否都是数字
		for (int i = 0; i < str.length(); i++){
			// System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	
	/**
     * 根据三个文件得到族谱树
     * @param void
     * @return Tree
     */
	public static Tree getTree() throws IOException {
		// 将所有的人员信息从文件中读到persons数组里
				String [] personsArray = readFile("baseinfo.txt");		
				Person [] persons = new Person [personsArray.length];
				for (int i=0; i<personsArray.length; i++) {
					String [] onePerson = personsArray[i].split(" ");
					persons[i] = new Person(onePerson[0], onePerson[1]);
				}
				System.out.println("读取baseinfo.txt...");

				
		        // 读取结婚信息，设置wife
		        String [] marriages = readFile("marriageinfo.txt");
		        for(int i=0; i<marriages.length; i++) {
		        	// System.out.println(marriages[i]);
		        	String [] oneMarriage = marriages[i].split(" ");
		        	Person husband = findByIdNumber(persons, oneMarriage[0]);
		        	Person wife = findByIdNumber(persons, oneMarriage[1]);
		        	husband.setWife(wife);
		        }
		        System.out.println("读取marriageinfo.txt...");
		        
		      
		        // 读取childinfo文件中的内容, 并设置族谱树
		        String [] childs = readFile("childinfo.txt");
		        System.out.println("读取childifo.txt...");
		        
		        System.out.println("正在设置族谱树...");
		        // 先设置第一代人
		        String [] firstGap = childs[0].split(" ");
		        Tree root = new Tree();
		        root = new Tree(findByIdNumber(persons, firstGap[0]), null, null, null);
		        for(int i=1; i<firstGap.length; i++) {
		        	Tree subRoot = new Tree(findByIdNumber(persons, firstGap[i]), root, null, null);
		        	// 设置长子和最大的兄弟
		        	if(root.firstChild == null)
		        		root.firstChild = subRoot;
		        	else
		        		root.firstChild.nextSibling = subRoot;
		        }
		        
		        // 设置第二到最后一代人
		        // 从第二个开始遍历文件里的每一条记录
		        for(int i=1; i<childs.length; i++) {
		        	String [] onechild = childs[i].split(" ");
		        	// 从第二个开始遍历记录里的每一个孩子
		        	for(int j=1; j<onechild.length; j++) {
		        		Tree parent = root. findNodeByIdNumber(onechild[0]);
		        		// 设置父亲
		        		Tree subRoot = new Tree(findByIdNumber(persons, onechild[j]), parent, null, null);
		            	// 设置长子和最大的兄弟
		            	if(parent.firstChild == null)
		            		parent.firstChild = subRoot;
		            	else
		            		parent.firstChild.nextSibling = subRoot;
		        	}
		        }
		        System.out.println("设置完成\n");
		        
		        return root;
		        
		        
	}
	

	
	

}





