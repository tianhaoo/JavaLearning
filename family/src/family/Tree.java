package family;

public class Tree {
	public Person element;//�����ڵ�
	public Tree parent, firstChild, nextSibling;//���ס����Ӽ����ĵܵ�

	//�����ڵ��������췽��
	public Tree()
	{	this(null, null, null, null); }

	//���췽��
	public Tree(Person e, Tree p, Tree c, Tree s) {
		element = e;
		parent = p;
		firstChild = c;
		nextSibling = s;
	}

	//���ص�ǰ�ڵ��д�ŵĶ���
	public Person getElem()
	{ return element; }


	//������obj���뵱ǰ�ڵ㣬�����ش�ǰ������
	public Person setElem(Person obj)
	{	Person bak = element;	element = obj;	return bak; }


	//���ص�ǰ�ڵ�ĸ��ڵ㣻���ڸ��ڵ㣬����null
	public Tree getParent()
	{ return parent; }

	//���ص�ǰ�ڵ�ĳ��ӣ���û�к��ӣ��򷵻�null
	public Tree getFirstChild()
	{ return firstChild; }

	//���ص�ǰ�ڵ�����ܵܣ���û�еܵܣ��򷵻�null
	public Tree getNextSibling()
	{ return nextSibling; }

	//���ص�ǰ�ڵ���Ԫ�ص���Ŀ�����Ե�ǰ�ڵ�Ϊ���������Ĺ�ģ
	public int getSize() {
		int	size = 1;//��ǰ�ڵ�Ҳ���Լ��ĺ��
		Tree subtree = firstChild;//�ӳ��ӿ�ʼ
		while (null != subtree) {//����
			size += subtree.getSize();//�ۼ�
			subtree = subtree.getNextSibling();//���к��ӵĺ����Ŀ
		}
		return size;//���ɵõ���ǰ�ڵ�ĺ������
	}

//���ص�ǰ�ڵ�ĸ߶�
	public int getHeight() {
		int	height = -1;
		Tree subtree = firstChild;//�ӳ��ӿ�ʼ
		while (null != subtree) {//����
			height = Math.max(height, subtree.getHeight());//�����к�����ȡ���߶�
			subtree = subtree.getNextSibling();
		}
		return height+1;//���ɵõ���ǰ�ڵ�ĸ߶�
	}

	//���ص�ǰ�ڵ�����
	public int getDepth() {
		int	depth = 0;
		Tree p = parent;//�Ӹ��׿�ʼ
		while (null != p) {//����
			depth++;	
			p = p.getParent();//���ʸ���������
		}
		return depth;//�����ȵ���Ŀ����Ϊ��ǰ�ڵ�����
	}
	
	// �ӵ�ǰ�ڵ㿪ʼ����Ѱ�Һ͸������֤����ͬ�Ľڵ㣬������
	public Tree findNodeByIdNumber(String idNumber) {
		Tree subtree = this;//�ӵ�ǰ�ڵ㿪ʼ
		while (null != subtree) {//����
			if (subtree.getElem().getIdNumber().equals(idNumber)) { // Ѱ�����֤����ͬ����
				return subtree;
			}
			if(subtree.nextSibling != null) subtree = subtree.nextSibling;
			else subtree = subtree.firstChild;
		}
		return null;
	}
	
	/**
     * �������֤��Ѱ���ɷ�
     * @param String[], String
     * @return Tree;
     */
	public Tree getHusband(String idNumber) {
		Tree subtree = this;//�ӵ�ǰ�ڵ㿪ʼ
		while (null != subtree) {//����
			if(subtree.getElem().getWife()!=null) {
				if (subtree.getElem().getWife().getIdNumber().equals(idNumber)) { // 
					return subtree;
				}
			}
			if(subtree.nextSibling != null) subtree = subtree.nextSibling;
			else subtree = subtree.firstChild;
		}
		return null;
	}
	
	
	public String toString() {
		return "��ǰ�ڵ�Ԫ�أ�\n" + this.element + 
				(this.parent == null?"\nû�и���Ԫ��":"\n���ף�"+this.parent.getElem().getName()) +
				(this.firstChild == null?"\nû�г���Ԫ��":"\n���ӣ�"+this.firstChild.getElem().getName()) +
				(this.nextSibling == null?"\nû�������ֵ�Ԫ��":"\n�����ֵ�"+this.nextSibling.getElem().getName()) +
				"\n��ǰԪ�ؼ����Ԫ�ص���Ŀ:" + this.getSize() +
				"\n��ǰ�ڵ�ĸ߶�" + this.getHeight() +
				"\n��ǰ�ڵ�����" + this.getDepth() + "\n";
	}
}                        