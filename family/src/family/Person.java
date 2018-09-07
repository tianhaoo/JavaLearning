package family;

public class Person {
	private String idNumber;
	private String name;
	private Person wife;
	
	public Person (String idNumber, String name) {
		this.idNumber = idNumber;
		this.name = name;
	}
	
	public Person (String idNumber, String name, Person wife) {
		this.idNumber = idNumber;
		this.name = name;
		this.wife = wife;
	}
	
	public String getIdNumber() {
		return this.idNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Person getWife() {
		return this.wife;
	}
	
	public void setWife(Person wife) {
		this.wife = wife;
	}
	

	

    public String toString() {
    	return "==================\n身份证号：" + this.idNumber + "\n姓名：" + this.name + (this.wife==null?"\n================\n":"\n妻子：\n" + this.wife + "\n");
    }

}