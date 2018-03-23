package Prac;
/**  
 * @version V1.6   
 * @author jammy  
 * data 2018Äê3ÔÂ22ÈÕ 22:44:04
 **/
public class Children extends Parent {
	private Parent father;//each child has father
	private Parent mother;//each child has mother
	private String name;
	private int age;
	private String status;
	private String image;

	public void setFather(Parent father) {
		this.father=father;
	}
	public Parent getFather() {
		return  this.father;
	}

	public void setMother(Parent mother) {
		this.mother=mother;
	}
	public Parent getMother() {
		return this.mother;
	}

	public void setChildrenProfile(String name, int age, String status, String image) {//set child attributes
		super.setName(name);
		super.setAge(age);
		super.setStatus(status);
		super.setImage(image);
	}

}
