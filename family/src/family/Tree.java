package family;

public class Tree {
	public Person element;//树根节点
	public Tree parent, firstChild, nextSibling;//父亲、长子及最大的弟弟

	//（单节点树）构造方法
	public Tree()
	{	this(null, null, null, null); }

	//构造方法
	public Tree(Person e, Tree p, Tree c, Tree s) {
		element = e;
		parent = p;
		firstChild = c;
		nextSibling = s;
	}

	//返回当前节点中存放的对象
	public Person getElem()
	{ return element; }


	//将对象obj存入当前节点，并返回此前的内容
	public Person setElem(Person obj)
	{	Person bak = element;	element = obj;	return bak; }


	//返回当前节点的父节点；对于根节点，返回null
	public Tree getParent()
	{ return parent; }

	//返回当前节点的长子；若没有孩子，则返回null
	public Tree getFirstChild()
	{ return firstChild; }

	//返回当前节点的最大弟弟；若没有弟弟，则返回null
	public Tree getNextSibling()
	{ return nextSibling; }

	//返回当前节点后代元素的数目，即以当前节点为根的子树的规模
	public int getSize() {
		int	size = 1;//当前节点也是自己的后代
		Tree subtree = firstChild;//从长子开始
		while (null != subtree) {//依次
			size += subtree.getSize();//累加
			subtree = subtree.getNextSibling();//所有孩子的后代数目
		}
		return size;//即可得到当前节点的后代总数
	}

//返回当前节点的高度
	public int getHeight() {
		int	height = -1;
		Tree subtree = firstChild;//从长子开始
		while (null != subtree) {//依次
			height = Math.max(height, subtree.getHeight());//在所有孩子中取最大高度
			subtree = subtree.getNextSibling();
		}
		return height+1;//即可得到当前节点的高度
	}

	//返回当前节点的深度
	public int getDepth() {
		int	depth = 0;
		Tree p = parent;//从父亲开始
		while (null != p) {//依次
			depth++;	
			p = p.getParent();//访问各个真祖先
		}
		return depth;//真祖先的数目，即为当前节点的深度
	}
	
	// 从当前节点开始往下寻找和给定身份证号相同的节点，并返回
	public Tree findNodeByIdNumber(String idNumber) {
		Tree subtree = this;//从当前节点开始
		while (null != subtree) {//依次
			if (subtree.getElem().getIdNumber().equals(idNumber)) { // 寻找身份证号相同的人
				return subtree;
			}
			if(subtree.nextSibling != null) subtree = subtree.nextSibling;
			else subtree = subtree.firstChild;
		}
		return null;
	}
	
	/**
     * 根据身份证号寻找丈夫
     * @param String[], String
     * @return Tree;
     */
	public Tree getHusband(String idNumber) {
		Tree subtree = this;//从当前节点开始
		while (null != subtree) {//依次
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
		return "当前节点元素：\n" + this.element + 
				(this.parent == null?"\n没有父亲元素":"\n父亲："+this.parent.getElem().getName()) +
				(this.firstChild == null?"\n没有长子元素":"\n长子："+this.firstChild.getElem().getName()) +
				(this.nextSibling == null?"\n没有最大的兄弟元素":"\n最大的兄弟"+this.nextSibling.getElem().getName()) +
				"\n当前元素及后代元素的数目:" + this.getSize() +
				"\n当前节点的高度" + this.getHeight() +
				"\n当前节点的深度" + this.getDepth() + "\n";
	}
}                        