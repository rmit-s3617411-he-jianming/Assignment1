package Prac;
/**  
 * @version: V1.6 
 * @author jammy  
 * data 2018Äê3ÔÂ22ÈÕ 22:44:04
 **/
import java.util.*;
public class MiniNet {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Children [] per = new Children[999];//initialize a Children array.
		Control admin = new Control();
		admin.set(per);//built some basic data for testing this programming.
		while(true) {
			DriverClass menu = new DriverClass();
			menu.menu(admin, per);//invoke menu method in DriverClass class

			String number = in.next();
			//for giving the tips to user what they can do
			if(number.equals("1")) {
				System.out.println("----Now add a person into network----");
				System.out.println("Please type the name of person you want to add");
				String name = in.next();
				System.out.println("Please type the age of person you want to add");
				int age = in.nextInt();
				System.out.println("Please type the status of person you want to add");
				String status=in.next();
				System.out.println("Please type the image name of the person you want to add,if you donot want to add,please type null");
				String image = in.next();
				admin.create(name, age, status, image, per);	
			}else if(number.equals("2")) {
				System.out.println("----Now display the profile of the selected person----");
				System.out.println("Please type the name of person you want to select");
				String name = in.next();
				admin.show(name, per);
			}else if(number.equals("3")) {
				System.out.println("----Now update the profile infromation of the selected person----");
				System.out.println("Please type the name of person you want to upadate");
				String name = in.next();
				System.out.println("choose what kind of information you want to update 1.name 2.age 3.status 4.image");
				int no = in.nextInt();
				admin.updateProfile(no, name, per);
			}else if(number.equals("4")) {
				System.out.println("----Now delect the selected person----");
				System.out.println("please type the name of person you want to delect");
				String name = in.next();
				admin.delect(name, per);
			}else if(number.equals("5")) {
				System.out.println("----Now connect two person in a meaningful way----");
				System.out.println("please type the name of the first person you want to connect");
				String name = in.next();
				System.out.println("please type the name of the second person you want to connect");
				String name2 = in.next();
				admin.connect(name, name2, per);
			}else if(number.equals("6")) {
				System.out.println("----Now find out whether a person is a direct friend of another person----");
				System.out.println("please type the name of the first person you want to find out");
				String name1 =in.next();
				System.out.println("please type the name of the second person you want to find out");
				String name2 =in.next();
				admin.findOut(name1, name2, per);
			}else if(number.equals("7")) {
				System.out.println("----Now find out the name(s) of a person¡¯s child(ren) or the names of the parents----");
				System.out.println("please type the name of person you want to find out");
				String name = in.next();
				admin.findParent(name, per);
			}else if(number.equals("8")) {
				System.out.println("----Now show all the person profile----");
				admin.print(per);
			}else if(number.equals("9")) {
				System.out.println("----Now according to the selected name,display the list of friedns----");
				System.out.println("----Please type the name of person you want to display his/her friends' list----");
				String name = in.next();
				System.out.println(name+"'s list of friends");
				admin.display(name, per);
			}else if(number.equals("0")) {
				System.out.println("end of program");
				System.exit(0);
			}else {
				System.out.println("please type right number");
			}
		}
	}
}
