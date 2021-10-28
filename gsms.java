import java.util.Scanner;

class Grocery{
	int itemid;
	String itemname;
	String itemdetail;
	String itemlocation;
	double itemprice;
	int itemstock;

	public void viewGroceryDetails(){
		System.out.println("Item name: "+itemname);	
		System.out.println("Item id: "+itemid);	
		System.out.println("Item detail: "+itemdetail);	
		System.out.println("Item location:" +itemlocation);		
		System.out.println("Item price:" +itemprice);	
		System.out.println("Item stock:" +itemstock);			
	}
	
	public void generateGroceryReport(){     
        System.out.println("Item name: "+itemname);	
		System.out.println("Item id: "+itemid);	
		System.out.println("Item detail: "+itemdetail);	
		System.out.println("Item location:" +itemlocation);	
		System.out.println("Item price:" +itemprice);
		System.out.println("Item stock:" +itemstock);	
	}
}

class Sales extends Grocery{
	Sales[] sales = new Sales[5000];
	Scanner input = new Scanner(System.in);

	public void recordSales(int x){            
        
		System.out.print("Enter sales for the day : ");
		sales[x] = input.nextInt();
    }

    public void viewAllSales(){          
		for(int i=0;i<sales.length;i++)
			System.out.println("Sales for day " + (i+1) + ": RM" +sales[i]);  
		
    }
	
	public void editSales(int day){
		System.out.print("Enter new sales:");
		sales[day] = input.nextInt();
	}
	
	public void generateSalesReport(){
		Scanner input = new Scanner(System.in);
		int x = sales.length;
		System.out.print("1.In a week    2.In a month\n Your input: ");
		int y = input.nextInt();
		
		if(y==1){
			if(x<7)
			System.out.print("Not enough days to generate weekly/monthly report");
			
			else{
			int day=1;
			int output=0;
			int week=1;
			for(int i=0;i<=x;i++){
				output+=sales[i];
				if(day%7==0){
					System.out.println("Week " + week + " profit : RM" +output);
					week++;
					}
					day++;
				}
			}
		}
	
		
		else if(y==2){
			if(x<30)
			System.out.println("Not enough day to generate monthly report");
			
			else{
			int day=1;
			int output=0;
			int month=1;
			for(int i=0;i<=x;i++){
				output+=sales[i];
				if(day%30==0){
					System.out.println("Month : " + month + " profit : RM" +output);
					month++;
					}
					day++;
				}
			}
			
		}
		
		else 
			System.out.println("Invalid Input.");
	}


}	

class Staff extends Sales{
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
   
    public void addStaff(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter staff name: ");
		name = input.nextLine();
		
		System.out.print("Enter staff userpassword: ");
		userpassword = input.nextLine();
		
		System.out.print("Enter staff id: ");
		staffid = input.nextInt();
		
		System.out.print("Enter staff shift: ");
		shift = input.nextLine();
		
		System.out.print("Enter staff salary: ");
		salary = input.nextDouble();

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
             name = null;
             userid = null;
             shift = null;
             userpassword = null;
             salary = 0;

             System.out.println("Staff deleted.");
    }
	
	public void addGrocery(int id){            
		itemid = id;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Item name: ");
		itemname = input.nextLine();
		
		System.out.print("Item detail: ");	
		itemdetail = input.nextLine();
		
		System.out.print("Item location: ");		
		itemlocation = input.nextLine();
		
		System.out.print("Item price: ");		
		itemprice = input.nextDouble();
		
		System.out.print("Item stock: ");
		itemstock = input.nextInt();
    }


    public void editGrocery(){            
		Scanner input = new Scanner(System.in);
		System.out.print("Edit\n1.Name\n2.Detail\n3.Location\n4.Price\n5.Stock\nYour input: ");
		int x = input.nextInt();
		switch(x){
			case 1:
			System.out.print("Enter new name: ");
			itemname = input.nextLine();
			break;
			
			case 2:
			System.out.print("Enter new detail: ");
			itemdetail = input.nextLine();
			break;
			
			case 3:
			System.out.print("Enter new location: ");
			itemlocation = input.nextLine();
			break;
			
			case 4:
			System.out.print("Enter new price: ");
			itemprice= input.nextDouble();
			
			case 5:
			System.out.print("Enter new stocks: ");
			itemstock= input.nextInt();
			
			default:
			System.out.println("Invalid input");
			
		}
		
    }
}

class gsms{
	static Staff[] staff = new Staff[20];
    static Grocery[] item = new Grocery[100];
	static int counter=0;
	int salescounter=0; 
	int grocerycounter=0;
    
	public static void main(String args[]) {
        Sales sales = new Sales();
        Scanner input = new Scanner(System.in);

        String username = "admin";
        String password = "1234";

        System.out.print("Enter user type [staff|admin]:");
        String user_type = input.nextLine();

        if(user_type.equals("admin")){
            System.out.println("Enter your username: ");   
            username = input.nextLine(); 
           
            System.out.println("Enter your password: ");
            password = input.nextLine();

            if(username == "admin" && password == "1234"){

            System.out.print("1.Add staff\n2.Edit staff\n3.Delete staff\n4.View staff's shift\n5.List all staff\n6.Record sales\n7.Edit sales\n8.View all sales\n9.Generate report of sales\n10.Add grocery item\n11.Edit grocery detail\n12.View grocery item details\n13.Generate report of grocery items\n\nYour input: ");
			int choice = input.nextInt();
			
			if(choice == 1){
				Administrator a1= new Administrator();
				staff[counter] = new Staff();
				a1.addStaff();
				staff[counter] = a1;
				counter++;
			}
			
			else if(choice == 2){
				Administrator a1 = new Administrator();
				System.out.print("Enter staff userid: ");
				int x = input.nextInt();

				if(x == staff[counter].staffid){
				a1.editStaff();
				staff[counter] = a1;
                }
			}
			
			else if(choice == 3){
				Administrator a1 = new Administrator();
                System.out.println("Enter staff userID: ");
                int y = input.nextInt();

                if(y == staff[counter].staffid){
                    a1.deleteStaff();
                    staff[counter] = a1;
                }

                else{
                    System.out.println("Invalid");
                }	
			}
			
			else if(choice == 4){
				Administrator a1 = new Administrator();
                System.out.println("Enter staff no.: ");
				int z = input.nextInt();
				System.out.println("Name:" + staff[z].name);
				System.out.println("StaffID:" + staff[z].staffid);
				System.out.println("Shift:" + staff[z].shift);
			}
		
            else if(choice == 5){
               Administrator a1 = new Administrator();
			   System.out.println("Staff's List");
			   System.out.println("------------");	   
			   for(int i=0;i<20;i++){
				System.out.println("Name:" + staff[i].name);
				System.out.println("StaffID:" + staff[i].staffid);
				System.out.println("Shift:" + staff[i].shift);
				System.out.println("Salary:" + staff[i].salary);
				System.out.println("\n");
			}   
            }
			
			else if(choice == 6){
				Administrator a1 = new Administrator();
				a1.recordSales(salescounter);
                salescounter++;   
			}
			
			else if(choice == 7){
				Administrator a1 = new Administrator();
				System.out.print("Which day of sales you want to edit?");
				int day = input.nextInt();
				a1.editSales(day-1);
				
			}

			else if(choice == 8){
                Administrator a1 = new Administrator();
				a1.viewAllSales();
			}
			
			else if(choice == 9){
				Administrator a1 = new Administrator();
				a1.generateSalesReport();
			}
			
			else if(choice == 10){
				Administrator a1 = new Administrator();
				a1.addGrocery(grocerycounter);
				item[grocerycounter] = a1;
				grocerycounter++;
				
			}
			
			else if(choice == 11){
				Scanner input = new Scanner(System.in);
				Administrator a1 = new Administrator();
				
				System.out.print("Enter grocery id to edit: ");
				int x = input.nextInt();
				
				a1.editGrocery(x);
				
			}
			
			else if(choice == 12){
				System.out.print("Enter grocery id that you want to view: ");
                int x = input.nextInt();
                item[x].viewGroceryDetails();
			}
			
			else if(choice == 13){
				for(int i=0;i<item.length;i++)
                item[i].generateGroceryReport();
			}
			
			else
			System.out.println("Invalid");
        }
    

    else{
        System.out.println("Invalid");
    }
}

        else if(user_type.equals("staff")){
            System.out.println("Enter your username: ");   
            int userID = input.nextInt(); 
           
           
            System.out.println("Enter your password: ");
            String userpassword = input.nextLine();

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
						Staff s1 = new Staff();
                        s1.recordSales(salescounter);
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



    