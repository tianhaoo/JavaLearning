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
    	return "==================\n���֤�ţ�" + this.idNumber + "\n������" + this.name + (this.wife==null?"\n================\n":"\n���ӣ�\n" + this.wife + "\n");
    }

}