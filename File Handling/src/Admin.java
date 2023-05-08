import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class Admin {
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws Exception {
		String Username = null, Password = null;
		int choice = 1;
		Scanner sc = new Scanner(System.in);

		while (choice == 1) {
			System.out.println("Enter the Username = ");
			Username = sc.next();
			System.out.println("Enter the Password = ");
			Password = sc.next();
			if (Username.equals("Admin") && Password.equals("1234")) {
				System.out.println("Welcome Admin:-)");
				boolean condition = true;
				ArrayList<cardetails> detail = new ArrayList<cardetails>();
				File file = new File("notice.txt");
				ObjectOutputStream oos = null;
				ObjectInputStream ois = null;
				ListIterator li = null;
				while (condition) {
					System.out.println("Choose one of the following command to do with notices:-\n1.View\n2.Add"
							+ "\n3.Update\n4.Delete\n5.Exit");
					int ListOption = sc.nextInt();
					switch (ListOption) {
					case 1:
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
						break;
					case 2:
//                        	cardetails cd = new cardetails(101,"xcv","vcx");
						System.out.println("enter how many records to enter");
						Scanner addc = new Scanner(System.in);
						int n = addc.nextInt();
						for (int i = 0; i < n; i++) {
							System.out.println("Write the details you want to add");

							System.out.println("enter id = ");
							int c_id = addc.nextInt();
							System.out.println("enter name = ");
							String c_name = addc.next();
							System.out.println("enter price= ");
							int c_price = addc.nextInt();
							detail.add(new cardetails(c_id, c_name, c_price));
						}

						try {
							FileOutputStream fos = new FileOutputStream(file);
							oos = new ObjectOutputStream(fos);
							oos.writeObject(detail);
							oos.close();
							fos.close();
							System.out.println("data added successfully");
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;

					case 3:
						if (file.isFile()) {
							FileInputStream readData = new FileInputStream(file);
							ois = new ObjectInputStream(readData);
							detail = (ArrayList<cardetails>) ois.readObject();

							ois.close();
							boolean found = false;
							System.out.println("enter id to update:");
							Scanner s = new Scanner(System.in);
							int cid = s.nextInt();
							System.out.println("-----------");
							li = detail.listIterator();
							while (li.hasNext()) {
								cardetails c = (cardetails) li.next();
								if (c.getId() == cid) {
									System.out.println(c);

									System.out.println("enter car name:");
									String cname = s.next();
									
									System.out.println("enter car price:");
									int cp = s.nextInt();
									li.set(new cardetails(cid,cname,cp));
									found = true;
								}
							}
							if (found) {
								oos = new ObjectOutputStream(new FileOutputStream(file));
								oos.writeObject(detail);
								oos.close();

								System.out.println("record updated successfully");

							} else {
								System.out.println("record not found");
							}
						} else {
							System.out.println("file not found");
						}
						break;
					case 4:
						if (file.isFile()) {
							FileInputStream readData = new FileInputStream(file);
							ois = new ObjectInputStream(readData);
							detail = (ArrayList<cardetails>) ois.readObject();

							ois.close();
							boolean found = false;
							System.out.println("enter id to delete:");
							Scanner s = new Scanner(System.in);
							int cid = s.nextInt();
							System.out.println("-----------");
							li = detail.listIterator();
							while (li.hasNext()) {
								cardetails c = (cardetails) li.next();
								if (c.getId() == cid) {
									System.out.println(c);
									li.remove();
									found = true;
								}
							}
							if (found) {
								oos = new ObjectOutputStream(new FileOutputStream(file));
								oos.writeObject(detail);
								oos.close();

								System.out.println("record deleted successfully");

							} else {
								System.out.println("record not found");
							}
						} else {
							System.out.println("file not found");
						}
						break;
					case 5:
						System.out.println("Thanks for using our Car Dealership System, have a great day ahead.");
						condition = false;
						break;

					default:
						System.out.println("Invalid choice!");

					}
					choice++;
				}
			} else {
				System.out.println("Invalid Username and Password");
				choice = 1;

			}
		}
	}
}
