package Prac;
/**  
 * @version V1.6 
 * @author jammy  
 * data 2018Äê3ÔÂ22ÈÕ 22:44:04
 **/
public class Parent extends Person {//adult
	private Parent couple;//each parent has a couple
	private Children Children;//each parent has a child at least

	public void setCouple(Parent couple) {
		this.couple=couple;
	}
	public Parent getCouple() {
		return this.couple;
	}

	public void setChildren(Children children) {
		this.Children=children;
	}
	public Children getChildren() {
		return this.Children;
	}
}
