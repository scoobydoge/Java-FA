import java.util.Scanner;


class Grocery{
	int itemid;
	String itemname;
	String itemdetail;
	String location;

	public void viewGroceryDetails(){
		System.out.println("Item name: "+itemname);	
		System.out.println("Item id: "+itemid);	
		System.out.println("Item detail: "+itemdetail);	
		System.out.println("Item location:" +itemlocation);									
	}
	
	public void generateGroceryReport(){     
        System.out.println("Item name: "+itemname);	
		System.out.println("Item id: "+itemid);	
		System.out.println("Item detail: "+itemdetail);	
		System.out.println("Item location:" +itemlocation);	
	}
		
	public void editGrocery(){
		
		
		
	}
	
	public void addGrocery(){
		
		
		
	}
}

class Sales{
	int[] sales = new sales[5000];
	public void recordSales(int x){            
        Scanner input = new Scanner(System.in);
		System.out.print("Enter sales for the day : ");
		sales[x] = input.nextInt();
    }

    public void listAllSales(){          

    }
	
	public void editSales(){
		
		
	}
	
	public void generateSalesReport(){
		int x = sales.length;

	}

}	

class Staff{
	String name;
	String userid;
	String userpassword;
	int staffid;
	String shift;
	double salary;
	
	
	public void viewShift(){
		System.out.println(name);       
		System.out.println(shift);
		
	}
}

class Administrator extends Staff{
    private String username = "admin";
    private String password="1234";
    
    public void addStaff(int counter){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter staff name: ");
		staff[counter].name = input.nextLine();
		
		System.out.print("Enter staff userpassword: ");
		staff[counter].userpassword = input.nextLine();
		
		System.out.print("Enter staff id: ");
		staff[counter].staffid = input.nextInt();
		
		System.out.print("Enter staff shift: ");
		staff[counter].shift = input.nextLine();
		
		System.out.print("Enter staff salary: ");
		staff[counter].salary = input.nextDouble();

    }

    public void editStaff(){                    
		Scanner input = new Scanner(System.in);
		System.out.print("What do you want to edit?\n1.Name\n2.Shift\n3.Salary\nYour input: ");
		int x = input.nextInt();
		switch(x){
			case 1:
			System.out.print("Change name to?: ");
			name = input.nextLine();
			break;
			case 2:
			System.out.print("Change shift to?: ");
			shift = input.nextLine();
			break;
			case 3:
			System.out.print("Change salary to?: ");
			salary = input.nextInt();
			break;
			default:
			System.out.println("Invalid input");
		}
	}

    public void deleteStaff(){
        Scanner input = new Scanner(System.in);
        System.out.print("Are you sure you want to delete this staff? (yes/no)");
        String choice = input.nextLine();

        if(choice.equals("yes")){
             staff[counter] = null;
        }
        
        else{
            continue;
        }
    }

    public void viewstaffShift(){
        System.out.println("Name:" + staff[counter].name);
        System.out.println("StaffID:" + staff[counter].staffID);
        System.out.println("Shift:" + staff[counter].shift);
    }

    public void generateReport(){ 				
          
    }

    public void listStaff(){   

        System.out.println("Staff's List");
        System.out.println("------------");

        for(int i=0;i<20;i++){
            System.out.println("Name:" + staff[i].name);
            System.out.println("StaffID:" + staff[i].staffID);
            System.out.println("Shift:" + staff[i].shift);
            System.out.println("Salary:" + staff[i].salary);
            System.out.println("\n");
        }                   
    }
	
	public void addGrocery(){            

    }

    public void editGrocery(){            

    }
}

class gsms{
	static Staff[] staff = new Staff[20];
    static Grocery[] item = new Grocery[100];
	int counter=0;
	int salescounter=0; 
    
	public static void main(String args[]) {
        Sales sales = new sales();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter user type [staff|admin]:");
        String user_type = input.nextLine();

        if(user_type.equals("admin")){
            System.out.println("Enter your userID: ");   
            int userID = input.nextInt(); 
           
            //input.nextLine();
           
            System.out.println("Enter your password: ");
            String password = input.nextLine();

            System.out.print("1.Add staff\n2.Edit staff\n3.Delete staff\n4.View staff's shift\n5.List all staff\n6.Record sales\n7.Edit sales\n8.View all sales\n9.Generate report of sales\n10.Add grocery item\n11.Edit grocery detail\n12.View grocery item details\n13.Generate report of grocery items\n\nYour input: ");
			int choice = input.nextInt();
			
			if(choice == 1){
				Administrator a1= new Administrator();
				staff[counter] = new Staff();
				a1.addStaff();
				staff[counter] = a1;
			}
			
			else if(choice == 2){
				Scanner input = new Scanner(System.in);
				Administrator a1 = new Administrator();
				System.out.print("Enter staff unique id that you want to edit: ");
				int x = input.nextInt();
				a1 = staff[x];
				a1.editStaff();
				staff[x] = a1;
			}
			
			else if(choice == 3){
                Scanner input = new Scanner(System.in);
				Administrator a1 = new Administrator();
                System.out.println("Enter staff userID: ");
                int y = input.nextInt();
                if(y == staff[counter].staffid){
                    a1 = staff[counter];
                    a1.deleteStaff();
                    staff[counter] = a1;
                }

                else{
                    System.out.println("Invalid");
                }	
			}
			
			else if(choice == 4){
                Scanner input = new Scanner(System.in);
				Administrator a1 = new Administrator();
                System.out.println("Enter staff userID: ");
				int z = input.nextInt();
                if(z == staff[counter].staffid){
                    a1 = staff[counter];
                    a1.viewstaffShift();
                    staff[counter] = a1;
                }

                else{
                    System.out.println("Invalid");
                }
			}
		
            else if(choice == 5){
               
            }
			
			else if(choice == 6){
				Administrator a1 = new Administrator();
				a1.listStaff();
			}
			
			else if(choice == 7){
				
				
			}

			else if(choice == 8){
                Administrator a1 = new Administrator();
				
                a1.generateReport();
			}
			
			else if(choice == 9){
				
			}
			
			else
			System.out.println("Invalid");
        }

        else if(user_type.equals("staff")){
            System.out.println("Enter your username: ");   
            int userID = input.nextInt(); 
           
            //input.nextLine();
           
            System.out.println("Enter your password: ");
            String password = input.nextLine();

            for(int i=0; i<20; i++){
                if(userID == staff[i].staffid && password == staff[i].userpassword){
                    System.out.print("1.View shift\n2.View grocery item details\n3.Generate report of grocery items\n4.Record sales\nYour Input: ");
			        int choice = input.nextInt();

                    if(choice == 1){
                        for(int i=0;i<staff.length;i++){
                        staff[i].viewshift();
                        }
                    }
                    
                    else if(choice == 2){
                        Scanner input = new Scanner(System.in);
                        System.out.print("Enter grocery id that you want to view: ");
                        int x = input.nextInt();
                        item[x].viewGroceryDetails();
                    }
                    
                    else if(choice == 3){
                        for(int i=0;i<item.length;i++)
                        item[i].generateGroceryReport();
                        
                    }
                    
                    else if(choice == 4({
                        sales.recordSales();
                        salescounter++;        
                    }
                    
                    else
                        System.out.println("Invalid");
                }

                else{
                    System.out.println("Invalid");
                }	
            } 
        }      
       }	   
    }



    