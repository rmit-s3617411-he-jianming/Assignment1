package Prac;
import java.util.*;
public class Drive {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Children [] per = new Children[9999];//built a primary Children array
		Control admin = new Control();
		while(true) {
			System.out.println("MiniNet Menu");
			System.out.println("===================================");
			System.out.println("----Choose what you want to do----");
			System.out.println("----1.Add a person into network----");
			System.out.println("----2.Display the profile of the selected person----");
			System.out.println("----3.Update the profile infromation of the selected person----");
			System.out.println("----4.Delete the selected person----");
			System.out.println("----5.Connect two person in a meaningful way----");
			System.out.println("----6.Find out whether a person is a direct friend of another person----");
			System.out.println("----7.Find out the name(s) of a person¡¯s child(ren) or the names of the parents----");
			System.out.println("----8.Show all people information----");
			System.out.println("----9.According to the selected name,display the list of friedns----");
			System.out.println("----0.Exit----");

			String number = in.next();
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
				admin.print(per);
			}else if(number.equals("9")) {
				System.out.println("----Now according to the selected name,display the list of friedns----");
				System.out.println("----Please type the name of person you want to display his/her friends' list----");
				String name = in.next();
				admin.display(name, per);
			}else if(number.equals("0")) {
				System.out.println("end of program");
				System.exit(0);
			}
		}
	}
}
