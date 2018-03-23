package Prac;
/**  
 * @version V1.6 
 * @author jammy  
 * data 2018Äê3ÔÂ22ÈÕ 22:44:04
 **/
abstract public class Person {//every person have name, age, status, friend, image, father and mother attributes
	private String name;
	private int age;
	private String status;
	private String[] friend=new String[99999];//built a friend array for storing friends' name
	private String image;
	private Parent father;
	private Parent mother;

	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return this.age;
	}

	public void setStatus(String status) {
		this.status=status;
	}
	public String getStatus() {
		return this.status;
	}

	public void setFriend(String name,Person per) {
		for(int i=0;i<99999;i++) {
			if(name.equals(per.friend[i])) {//judge weather this person's friends list already have the input person 
				System.out.println("they already were friend");//if already have the input person, end of the loop
				return;
			}else if(per.friend[i]==null) {//if not, put it into this person's friends list
				per.friend[i]=name;
				return;
			}
		}
	}

	public String getFriend(int i) {//type the ith friend you want to show
		return this.friend[i];
	}

	public void setImage(String image) {
		this.image=image;
	}
	public String getImage() {
		return this.image;
	}

	public void setFather(Parent father) {
		this.father=father;
	}
	public Parent getFather() {
		return this.father;
	}

	public void setMother(Parent mother) {
		this.mother=mother;
	}
	public Parent getMother() {
		return this.mother;
	}

	public String toString() {//override the toString method for output person basic information
		String msg="\t"+this.name+"\t"+this.age+"\t"+this.image+"\t"+this.status+"\t";
		return msg;
	}
}
