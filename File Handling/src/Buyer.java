import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Buyer {

	public static void main(String[] args) throws ClassNotFoundException {
		String Username = null, Password = null;
		int choice = 1;
		Scanner sc = new Scanner(System.in);

		while (choice == 1) {
			System.out.println("Enter the Username = ");
			Username = sc.next();
			System.out.println("Enter the Password = ");
			Password = sc.next();
			if (Username.equals("User") && Password.equals("123")) {
				System.out.println("Welcome Buyer:-)");
				boolean condition = true;
				ArrayList<cardetails> detail = new ArrayList<cardetails>();
				File file = new File("notice.txt");
				ObjectOutputStream oos = null;
				ObjectInputStream ois = null;
				ListIterator li = null;
				try {
					FileInputStream readData = new FileInputStream(file);
					ois = new ObjectInputStream(readData);
					detail = (ArrayList<cardetails>) ois.readObject();

					ois.close();
					li = detail.listIterator();
					while (li.hasNext()) {
						System.out.println(li.next());
					}
					System.out.println("--------------------");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
