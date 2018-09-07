package family;

import java.io. *;
import javax.swing. *;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class Family {
	public static void main(String [] args) throws IOException {
		
		// ��ȡ������
		Tree root = getTree();

		
		JFrame jf = new JFrame("���׹���ϵͳ");
        jf.setSize(500, 600);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);

        // ����������壬ָ��ʹ�� ��ʽ����
        JPanel panel = new JPanel(new FlowLayout());
        
        JLabel label02 = new JLabel();
        label02.setIcon(new ImageIcon("zupu.jpg"));
        panel.add(label02);

        JButton btn01 = new JButton("�ڼ�����ѯ");
        JButton btn02 = new JButton("��ĸ�ײ�ѯ");
        JButton btn03 = new JButton("���Ӳ�ѯ");
        JButton btn04 = new JButton("���Ȳ�ѯ");
        JButton btn05 = new JButton("�������Ӳ���");
        JButton btn06 = new JButton("�����Ϣ����");
        
        btn01.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("�ڼ�����ѯ...");
        		String input = JOptionPane.showInputDialog("������Ҫ��ѯ�����֤��");
        		if(!isNumeric(input)) { // �������ݲ�����
	                JOptionPane.showMessageDialog(
	                        jf,
	                        "��������ȷ�����֤��",
	                        "����",
	                        JOptionPane.WARNING_MESSAGE
	                );
	                System.out.println("��ѯʧ��");
        		} else {
        			Tree result = root.findNodeByIdNumber(input);
        			Tree testHusband = root.getHusband(input);
        			if (result == null && testHusband == null) {
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        "û���ҵ���Ӧ����Ա��Ϣ",
    	                        "��ʾ",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("��ѯ�ɹ�");
        			}else {
        				String text = "��"+(result!=null?result.getDepth()+1:testHusband.getDepth()+1)+"��";
        				System.out.println(text);
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        text,
    	                        "��ʾ",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("��ѯ�ɹ�");
    	                
        			}
        				
        		}
        	}
        });
        
        btn02.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("��ĸ�ײ�ѯ...");
        		String input = JOptionPane.showInputDialog("������Ҫ��ѯ�����֤��");
        		if(!isNumeric(input)) { // �������ݲ�����
	                JOptionPane.showMessageDialog(
	                        jf,
	                        "��������ȷ�����֤��",
	                        "����",
	                        JOptionPane.WARNING_MESSAGE
	                );
	                System.out.println("��ѯʧ��");
        		} else {
        			Tree result = root.findNodeByIdNumber(input);
        			Tree testHusband = root.getHusband(input);
        			if (result == null && testHusband == null) {
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        "û���ҵ���Ӧ����Ա��Ϣ",
    	                        "��ʾ",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("��ѯ�ɹ�");
        			}else {
        				Tree temp = (result != null?result.parent:testHusband.parent);
        				String text= (temp!=null?"����:"+temp.getElem().getIdNumber()+" "+temp.getElem().getName()+"\nĸ��:"+temp.getElem().getWife().getIdNumber()+" "+temp.getElem().getWife().getName():"������û�м�¼�ó�Ա�ĸ�ĸ��Ϣ");
        				System.out.println(text);
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        text,    
    	                        "��ʾ",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("��ѯ�ɹ�");
        			}
        				
        		}
        	}
        });
        
        btn03.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("���Ӳ�ѯ...");
        		String input = JOptionPane.showInputDialog("������Ҫ��ѯ�����֤��");
        		if(!isNumeric(input)) { // �������ݲ�����
	                JOptionPane.showMessageDialog(
	                        jf,
	                        "��������ȷ�����֤��",
	                        "����",
	                        JOptionPane.WARNING_MESSAGE
	                );
	                System.out.println("��ѯʧ��");
        		} else {
        			Tree result = root.findNodeByIdNumber(input);
        			Tree testHusband = root.getHusband(input);
        			if (result == null && testHusband == null) {
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        "û���ҵ���Ӧ����Ա��Ϣ",
    	                        "��ʾ",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("��ѯ�ɹ�");
        			}else {
        				Tree temp = (result != null?result.getFirstChild():testHusband.getFirstChild()); // �������֤�Ŷ�λ���Ľڵ�
        				String text;
        				if (temp == null) text = new String("û�к���");
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
    	                        "��ʾ",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("��ѯ�ɹ�");
        			}
        				
        		}
        	}
        });
        
        btn04.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("��ѯ����...");
        		String input = JOptionPane.showInputDialog("������Ҫ��ѯ�����֤��");
        		if(!isNumeric(input)) { // �������ݲ�����
	                JOptionPane.showMessageDialog(
	                        jf,
	                        "��������ȷ�����֤��",
	                        "����",
	                        JOptionPane.WARNING_MESSAGE
	                );
	                System.out.println("��ѯʧ��");
        		} else {
        			Tree result = root.findNodeByIdNumber(input);
        			Tree testHusband = root.getHusband(input);
        			if (result == null && testHusband == null) {
    	                JOptionPane.showMessageDialog(
    	                        jf,
    	                        "û���ҵ���Ӧ����Ա��Ϣ",
    	                        "��ʾ",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                );
    	                System.out.println("��ѯ�ɹ�");
        			}else {
        				Tree temp = (result != null?result.getParent():testHusband.getParent()); // �������֤�Ŷ�λ���Ľڵ�
        				String text;
        				if (temp == null) text = new String("������û�м�¼�ó�Ա��������Ϣ");
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
    	                        "��ʾ",
    	                        JOptionPane.INFORMATION_MESSAGE
    	                ); 
        			}
        			System.out.println("��ѯ�ɹ�");	
        		}
        	}
        });
        
        btn05.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("�������Ӳ���...");
                JOptionPane.showMessageDialog(
                        jf,
                        "�ù���δʵ��",
                        "����",
                        JOptionPane.WARNING_MESSAGE
                );
                System.out.println("����ʧ��");	

        	}
        });
        
        btn06.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("�����Ϣ����...");
                JOptionPane.showMessageDialog(
                        jf,
                        "�ù���δʵ��",
                        "����",
                        JOptionPane.WARNING_MESSAGE
                );
                System.out.println("����ʧ��");	

        	}
        });
        
        


        panel.add(btn01);
        panel.add(btn02);
        panel.add(btn03);
        panel.add(btn04);
        panel.add(btn05);
        panel.add(btn06);

        jf.setContentPane(panel);
        jf.setVisible(true);        // PS: ���������Ϊ����ʾ(����), ������ӵ�����Ż���ʾ
		
		
	}
	
	
	/**
     * ��ȡ�ļ��е����ݣ���������зָ���������String�����������
     * @param string 
     * @return String []
     */
	public static String [] readFile(String fileName) throws IOException {	
        // ��������¼Ϊ100��
        String [] array = new String [100];
        
		File file = new File(fileName);

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        
        // ��ȡ�ļ��е����ݣ������ݴ浽������
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
     * �������֤�Ų�ѯ��
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
     * �����Դ��ĺ����ж��ַ����Ƿ�������
     * @param str
     * @return boolean
     */
	public static boolean isNumeric(String str){
		// ѭ���ж��ַ����е�ÿ���ַ����ж��Ƿ�������
		for (int i = 0; i < str.length(); i++){
			// System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
	
	/**
     * ���������ļ��õ�������
     * @param void
     * @return Tree
     */
	public static Tree getTree() throws IOException {
		// �����е���Ա��Ϣ���ļ��ж���persons������
				String [] personsArray = readFile("baseinfo.txt");		
				Person [] persons = new Person [personsArray.length];
				for (int i=0; i<personsArray.length; i++) {
					String [] onePerson = personsArray[i].split(" ");
					persons[i] = new Person(onePerson[0], onePerson[1]);
				}
				System.out.println("��ȡbaseinfo.txt...");

				
		        // ��ȡ�����Ϣ������wife
		        String [] marriages = readFile("marriageinfo.txt");
		        for(int i=0; i<marriages.length; i++) {
		        	// System.out.println(marriages[i]);
		        	String [] oneMarriage = marriages[i].split(" ");
		        	Person husband = findByIdNumber(persons, oneMarriage[0]);
		        	Person wife = findByIdNumber(persons, oneMarriage[1]);
		        	husband.setWife(wife);
		        }
		        System.out.println("��ȡmarriageinfo.txt...");
		        
		      
		        // ��ȡchildinfo�ļ��е�����, ������������
		        String [] childs = readFile("childinfo.txt");
		        System.out.println("��ȡchildifo.txt...");
		        
		        System.out.println("��������������...");
		        // �����õ�һ����
		        String [] firstGap = childs[0].split(" ");
		        Tree root = new Tree();
		        root = new Tree(findByIdNumber(persons, firstGap[0]), null, null, null);
		        for(int i=1; i<firstGap.length; i++) {
		        	Tree subRoot = new Tree(findByIdNumber(persons, firstGap[i]), root, null, null);
		        	// ���ó��Ӻ������ֵ�
		        	if(root.firstChild == null)
		        		root.firstChild = subRoot;
		        	else
		        		root.firstChild.nextSibling = subRoot;
		        }
		        
		        // ���õڶ������һ����
		        // �ӵڶ�����ʼ�����ļ����ÿһ����¼
		        for(int i=1; i<childs.length; i++) {
		        	String [] onechild = childs[i].split(" ");
		        	// �ӵڶ�����ʼ������¼���ÿһ������
		        	for(int j=1; j<onechild.length; j++) {
		        		Tree parent = root. findNodeByIdNumber(onechild[0]);
		        		// ���ø���
		        		Tree subRoot = new Tree(findByIdNumber(persons, onechild[j]), parent, null, null);
		            	// ���ó��Ӻ������ֵ�
		            	if(parent.firstChild == null)
		            		parent.firstChild = subRoot;
		            	else
		            		parent.firstChild.nextSibling = subRoot;
		        	}
		        }
		        System.out.println("�������\n");
		        
		        return root;
		        
		        
	}
	

	
	

}





