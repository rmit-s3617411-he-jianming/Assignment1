package Prac;
/**  
 * @version: V1.6 
 * @author Sam  
 * data 2018��3��22�� 22:44:04
 **/
public class DriverClass {//this class for setting the menu
	public void menu(Control admin,Children[] per) {
		System.out.println("----BasicData in the System----");
		System.out.println("=============================================================");
		for(int i=0;i<4;i++) {
			System.out.println(per[i]);
		}//just for understand this programming easily.
		System.out.println();
		System.out.println("MiniNet Menu");
		System.out.println("=============================================================");
		System.out.println("----Choose what you want to do----");
		System.out.println("----1.Add a person into network----");
		System.out.println("----2.Display the profile of the selected person----");
		System.out.println("----3.Update the profile infromation of the selected person----");
		System.out.println("----4.Delect the selected person----");
		System.out.println("----5.Connect two person in a meaningful way----");
		System.out.println("----6.Find out whether a person is a direct friend of another person----");
		System.out.println("----7.Find out the name(s) of a person��s child(ren) or the names of the parents----");
		System.out.println("----8.Show all people profile----");
		System.out.println("----9.According to the selected name,display the list of friedns----");
		System.out.println("----0.Exit----");
	}
}
