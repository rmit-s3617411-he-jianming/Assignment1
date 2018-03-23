package Prac;
/**  
 * @version V1.6  
 * @author jammy  
 * data 2018Äê3ÔÂ22ÈÕ 22:44:04
 **/
import java.util.*;
public class Control implements Print,BasicData{
	Scanner in = new Scanner(System.in);

	//set some basic data
	public void set(Children[] per) {//invoke the BasicDate interface
		Control admin = new Control();//invoke the control class
		admin.create("Alice", 24, "working at KFC", "xx.photo", per);//create some basic person
		admin.create("Bob", 20, "student at RMIT","xxx.photr", per);
		admin.create("Don", 26, "Freelance", "xy.photo", per);
		admin.create("Cathy", 21,"looking for jobs", "yy.photo", per);
		per[0].setFriend("Bod", per[0]);per[0].setFriend("Don", per[0]);
		per[1].setFriend("Alice", per[1]);
		per[2].setFriend("Alice", per[2]);per[2].setFriend("Cathy", per[2]);
		per[3].setFriend("Don", per[3]);
	}

	/*detect the person whether the age under 16 */
	public boolean detectAge(Children per,Children per2) {//for detect the children weather conform the situation
		boolean a=true;//if a = true the system will judge the person is over 16 age
		if(2<per.getAge()&&per.getAge()<16&&2<per2.getAge()&&per2.getAge()<16&&per.getFather()!=per2.getFather()
				&&per.getAge()-per2.getAge()<3||per2.getAge()-per.getAge()<3) {
			a =true;
		}else if(per.getAge()>16&&per2.getAge()>16){
			a=true;
		}else {
			System.out.println("Maybe there are something worng :1.they are come from same family or 2.one children over 16 and one children under 16"
					+ " 3.The age difference between these two young friends cannot be more than 3 years");
			a=false;
		}
		return a;
	}

	//for judge the name whether exist.prevent a system have two same name
	public boolean judge(String name,Children[] per) {
		boolean a =true;//if a is true, there is only input name in System.
		for(int i=0; i<per.length;i++) {
			if(per[i]==null) {
				a =true;
				return a;
			}
			else if(name.equals(per[i].getName())) {
				a= false;
			}
		}
		return a;
	}

	//for judge whether the children[] array is full, if full return 999999
	public int index(Children[] per) {//for detect the whether the array is null or not.
		for(int i=0;i<per.length;i++) {
			if(per[i]==null) {
				return i;
			}
		}
		return 999999;
	}

	//1.Add a person into network
	public void create(String name, int age, String status,String image,Children[] per) {//for create a new person
		if(this.judge(name, per)) {//if the name already exist, the person cannot be added.
			if(age<16) {//if the person under 16 age ,there parent must be added at the same time
				Children father = new Children();
				Children mother = new Children();
				Children children = new Children();
				System.out.println("you must add your parent's name due to under 16 years old");
				System.out.print("please type your dad' name");
				father.setName(in.next());
				System.out.print("please type your mum' name");
				mother.setName(in.next()); 
				father.setCouple(mother);
				mother.setCouple(father);
				children.setChildrenProfile(name, age, status, image);//set children's profile
				System.out.println(children.getName()+"'s mother: "+mother.getName()+"  and children's father: "+father.getName()+" be a couple ");
				children.setFather(father);
				children.setMother(mother);
				father.setChildren(children);
				mother.setChildren(children);
				int i = this.index(per);
				if(i==99999) {
					System.out.println("students number are full");
				}else {
					per[i]=father;
				}
				int j = this.index(per);
				if(j==99999) {
					System.out.println("students number are full");
				}else {
					per[j]=mother;
				}
				int k = this.index(per);
				if(k==99999) {
					System.out.println("students number are full");
				}else {
					per[k]=children;
				}
			}else {
				Children per1 = new Children();
				per1.setName(name);
				per1.setAge(age);
				per1.setStatus(status);
				per1.setImage(image);
				int i = this.index(per);//for detect if the person[] array still have available sapce
				if(i==99999) {
					System.out.println("students number are full");
				}else {
					per[i]=per1;
				}
			}
		}
	}

	//2.Display the profile of the selected person
	public void show(String name,Children[] per) {//show the profile about your selected person.
		for(int i=0; i<per.length;i++) {
			if(name.equals(per[i].getName())) {
				System.out.println(msg);
				System.out.println(per[i]);
				return;
			}
			else  {
				System.out.println("the person is no exist");//if the person cannot be fond,end of the loop
				return ;
			}
		}
	}

	//3.Update the profile information of the selected person
	public void updateProfile(int no,String name,Children[] per) {//update the profile information about your selected person.
		for(int i=0; i<per.length;i++) {
			if(name.equals(per[i].getName())) {
				if(no==1) {
					System.out.println("Please type the new name");
					per[i].setName(in.next());
					System.out.println("upadated successful");
					return;
				}
				if(no==2) {
					System.out.println("Please type the new age");
					per[i].setAge(in.nextInt());
					System.out.println("upadated successful");
					return;
				}
				if(no==3) {
					System.out.println("Please type the new status");
					per[i].setStatus(in.next());
					System.out.println("upadated successful");
					return;
				}
				if(no==4){
					System.out.println("Please type the new image");
					per[i].setStatus(in.next());
					System.out.println("upadated successful");
					return;
				}
			}
		}
		System.out.println("updateed unsuccessful, there is no this person");
	}

	//4.Delect the selected person
	public void delect(String name,Children[] per) {//delect the person 
		for(int i=0;i<per.length;i++) {
			if(per[i]==null){//if the array is null, the system will skip
				continue;
			}else if(name.equals(per[i].getName())) {
				per[i]=null;
				System.out.println("delected successful");
				return;
			}
			System.out.println("delected unsuccessful,the name is not exist");
			return;
		}
	}

	//5.Connect two person in a meaningful way
	public void connect(String name,String name2,Children[] per) {//connect two person in a meaningful way
		for(int i=0;i<per.length;i++) {
			if(name.equals(per[i].getName())) {//judge if the first person is in the system
				for(int j=0;j<per.length;j++) {
					if(name2.equals(per[j].getName())) {//judge if the second person is in the system
						System.out.println("please type what kind of realtionship you want to add 1.friend 2.parent");
						int relationship=in.nextInt();
						if(relationship==1) {//make friends
							if(this.detectAge(per[i],per[j])) {
								per[i].setFriend(name2,per[i]);//put person2(name2/per[j]) into person1's(name/per[i]) friends' list 
								per[j].setFriend(name,per[j]);//put person1(name/per[i]) into person2's(name/per[j]) friends' list 
								System.out.println("built relationship successful");
								return;
							}else {
								System.out.println("they cannot be friend, update unsuccessful");
							}
						}else if(relationship==2) {//set the parent
							System.out.println("please choose:who is child:1."+name+"2."+name2);
							int choose =in.nextInt();
							if(choose==1) {//choose the first person  is a child
								per[j].setChildren(per[i]);
								System.out.println("please choose:"+"1."+name2+" is father "+"2."+name2+" is mother");
								int no =in.nextInt();
								if(no==1) {//choose the second person is a father
									per[i].setFather(per[j]);
								}else if (no==2) {//choose the second person is a mother
									per[i].setMother(per[j]);
								}else {
									System.out.println("please type correct number");
								}
								System.out.println("built relationship successful");
							}else if(choose==2) {//choose the second person  is a child
								per[i].setChildren(per[j]);
								System.out.println("please choose:"+"1."+name+" is father "+"2."+name+" is mother ");
								if(in.nextInt()==1) {//choose the first person is a father
									per[j].setFather(per[i]);
								}else {//choose the second person is a father
									per[j].setMother(per[i]);
								}
								System.out.println("built relationship successful");
							}
						}
						return;
					}
				}
			}
			}
		}

	//6.Find out whether a person is a direct friend of another person
	public void findOut(String name1,String name2,Children[] per) {//for find out what the relationship between two person
		for(int i=0;i<per.length;i++) {
			if(name1.equals(per[i].getName())) {//judge if the first person is in the system
				for(int j=0;j<per.length;j++) {
					if(name2.equals(per[j].getName())) {//judge if the second person is in the system
						for(int k=0;k<9999;i++) {
							if(name2.equals(per[i].getFriend(k))){////judge if the first person's friends list has the second person
								System.out.println(name1+" is the direct friend of "+name2);
								return;
							}
						}
					}
					System.out.println("the person"+name2+" is not exist");
					return;
				}
			}
		}
		System.out.println(name1+" is not the direct friend of "+name2);
		return;
	}

	//7.Find out the name(s) of a person¡¯s child(ren) or the names of the parent
	public void findParent(String name, Parent[] per) {
		for(int i=0;i<per.length;i++) {
			if(name.equals(per[i].getName())) {//judge if the first person is in the system
				System.out.println("please choose:according to the name, findout 1.the names of a person's children 2.the name of the parents");
				int no =in.nextInt();
				if(no==1) {//find out the input person's children
					if(per[i].getChildren()==null) {
						System.out.println("this person has not children");
						return;
					}else {
						System.out.println(per[i].getName()+"'s children is "+per[i].getChildren().getName());
						return;
					}
				}else if(no==2) {//find out the input person's parent
					if(per[i].getFather()==null) {
						System.out.println("this person's father name is not be registed");
						System.out.println(per[i].getName()+"'s father is "+per[i].getMother().getName());
						return;
					}else if(per[i].getMother()==null) {
						System.out.println("this person's mother name is not be registed");
						System.out.println(per[i].getName()+"'s father is "+per[i].getFather().getName());
						return;
					}else if(per[i].getMother()==null&&per[i].getFather()==null) {
						System.out.println("this person's father name is not be registed");
						System.out.println("this person's mother name is not be registed");
						return;
					}
					else {
						System.out.println(per[i].getName()+"'s father is "+per[i].getFather().getName());
						System.out.println(per[i].getName()+"'s father is "+per[i].getMother().getName());
						return;
					}
				}
			}
		}
	}

	//8.Show all people profile
	public void print(Children[] per) {
		System.out.println(msg);
		for(int i =0;i<per.length;i++) {
			if(per[i]==null) {//if per[i] is null
				continue;//skip the null 
			}
			System.out.println(per[i]);
		}
	}

	public int detectFriend(String name,Children[] per) {//for detect if the array has this person
		for(int i=0;i<per.length;i++) {
			if(name.equals(per[i].getName())) {//if the person is in the system, return the current array position
				return i;
			}
		}return 99999;
	}

	//9.According to the selected name,display the list of friends
	public void display(String name, Children[] per) {
		if(this.detectFriend(name, per)==99999) {//according to detectFriend method to continue this method
			System.out.println("the person is not exist");
		}else {
			int i =this.detectFriend(name, per);//if the person is exist, the system will continue
			for(int j=0;j<10;j++) {
				if(per[i].getFriend(j)!=null) {//list all friends from the input person
					System.out.println(per[i].getFriend(j));
				}else {
					break;
				}
			}
			System.out.println();
		}
	}
}
