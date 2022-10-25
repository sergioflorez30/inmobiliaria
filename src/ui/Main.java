package ui; 

import java.util.Scanner;
import model.Property; 

public class Main{

	//initialization of the Scanner and model. 
	private Scanner reader; 
	private Property property; 

	public Main(){
		//object creation 
		reader = new Scanner(System.in); 
		property  = new Property(); 

	}
	
	//returns the class, that is, the class becomes visible to the main method.
	public Property getProperty(){
		return property; 
	}

	//returns the class, that is, the class becomes visible to the main method.
	public Scanner getReader(){
		return reader;
	}

	public static void main(String[] args){
		// creación del objeto. 
		Main main = new Main(); 
		int option = 0; 
		do{

			option = main.getOptionShowMenu(); 
			main.executeOption(option);
					

		}while(option != 0);

		main.getReader().close();
	}

	/**
	getOptionShowMenu: This method shows all the options available in the menu, 
					after having the user enter an option.
	@return option: int: this parameter read the option entered by the user. 
	*/
	
	public int getOptionShowMenu(){
		//initialization of the variables
		int option = 0; 
		System.out.println(printMenu());
		option = validateIntegerOption();
		return option; 
	}
	public String printMenu(){
		return 
		"<---o+o--->welcome to the Real Estate <---o+o--->\n\n" +
				"1. Register a bulding,\n" +
				"2. Register apartment.\n" +
				"3. Register owner.\n" + 
				"4. Register tenant.\n" +
				"5. consult how many apartments are available in a building.\n" +
				"6. consult the monthly value to receive for the rented apartments in a building.\n" +
				"7. consult if a particular apartment is available.\n" +
				"8. consult the number of apartments that a person has leased.\n" +
				"9. consult the total rental value a landlord would receive for the apartments he owns.\n" +
				"0. Exit. "; 

	}
	public void executeOption(int option){
		String msj = "";
		String name = "";
		String id = "";  
		String address = ""; 
		String bank ="";   
		int idApartment = 0;
		int numRooms = 0; 
		int numBathrooms =0;
		int balcony =0; 
		int document =0; 
		int cellphone =0; 
		int count =0; 
		int cellphoneType=0; 
		boolean hasBalcony = false;
		int priceApartment =0;  

		switch(option){
	
			case 1: 
				System.out.println("we will register a building\n");
				System.out.println("type the building id");
				id = reader.next();
				System.out.println("type the apartments address");
				address = reader.next(); 
				msj = property.registerBuilding(id, address);
				
				System.out.println(msj); 

				break; 

			case 2:  
				
				System.out.println(" we will register a apartment\n");
				System.out.println(" type the id  of the building where the apartment is");
				id = reader.next();
				System.out.println("type the apartment id");
				idApartment = validateIntegerOption();
				if(idApartment<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}
				System.out.println("type the quantity rooms");
				numRooms = validateIntegerOption();  

				if(numRooms<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}
				System.out.println("type the quantity bathrooms");
				numBathrooms = validateIntegerOption(); 
				if(numBathrooms<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}
				System.out.println("the apartment has balcony, 1 yes or 2 not"); 
				balcony = validateIntegerOption(); 

				if(balcony>2 || balcony<= 0){
					System.out.println("this isnot a valid option\n"); 
					break; 
				} else if( balcony == 1){
					hasBalcony = true; 

				} else if( balcony == 2 ){
					hasBalcony = false; 
				}
				System.out.println("type the rental price.");
				priceApartment = validateIntegerOption(); 

				if(priceApartment<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}


				msj = property.registerApartmentToBuilding(id, idApartment, numRooms, numBathrooms,hasBalcony, priceApartment);
				property.registerApartment(id, idApartment, numRooms, numBathrooms,hasBalcony, priceApartment);
				
				System.out.println(msj);
			
				break; 

			case 3: 
				
				System.out.println("we will register a owner\n");
				System.out.println("type the document number ");
				document = validateIntegerOption();

				if(document<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}
				System.out.println("type the owner name \n");
				name = reader.next();
				System.out.println("Type cellphone number");
				cellphone = validateIntegerOption();

				if(cellphone<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}
				System.out.println("type the cellphone type, 1 home, 2 office, 3 movil, 4 family, 5 other"); 
				cellphoneType= validateIntegerOption(); 

				if(cellphoneType >5 || cellphoneType <=0){
					System.out.println("this isnot a valid option\n");
					break;
				}
				System.out.println("type the count number");
				count = validateIntegerOption(); 

				if(count<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}
				System.out.println("type the bank name");
				bank = reader.next();
				System.out.println("type the building id where is the apartment");
				id= reader.next();
				System.out.println("type the apartment id.");
				idApartment = validateIntegerOption();

				if(idApartment<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				} 
				
	
				msj = property.registerOwnerToApartment(document, name, cellphone, cellphoneType, id, idApartment, count, bank);
				property.registerOwner(document, name, cellphone, cellphoneType, id, idApartment, count, bank);
				
				System.out.println(msj);
			
				break;

			case 4:

				System.out.println("we will register a tenant\n");
				System.out.println("type the document number ");
				document = validateIntegerOption();

				if(document<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}
				System.out.println("type the tenant name ");
				name = reader.next();
				System.out.println("Type cellphone number");
				cellphone = validateIntegerOption();
				if(cellphone<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}
				System.out.println("type the cellphone type, 1 home, 2 office, 3 movil, 4 family, 5 other"); 
				cellphoneType= validateIntegerOption(); 

				if(cellphoneType >5 || cellphoneType <=0){
					System.out.println("this isnot a valid option\n");
					break;
				}

				System.out.println("type the building id where is the apartment");
				id= reader.next();
				System.out.println("type the apartment id.");
				idApartment = validateIntegerOption();

				if(idApartment<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}

				msj = property.registerTenantToApartment(document, name, cellphone, cellphoneType, id, idApartment);
				System.out.println(msj); 


				break;

			case 5:
				System.out.println("number of apartments available\n");
				System.out.println("type id building");
				id = reader.next(); 

				msj = property.apartmentsAvailable(id);
				System.out.println(msj);

				break; 

			case 6:
				System.out.println(" the total monthly value to receive for the apartments\n"); 
				System.out.println("type id building");
				id = reader.next();

				msj = property.valueByApartmentsForBuilding(id);
				System.out.println(msj); 

				break;

			case 7: 
				System.out.println("an apartment is available.\n"); 
				System.out.println("type id building where is the apartment");
				id = reader.next();
				System.out.println("type id apartment");
				idApartment = validateIntegerOption();

				if(idApartment<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}

				msj = property.avalibleApartment(id, idApartment);
				System.out.println(msj); 

				break;

			case 8: 
				System.out.println("the number of apartments a person has rented\n");
				System.out.println("type the document of the owner of the apartments.. "); 
				document = validateIntegerOption(); 
				if(document<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}
				count = property.apartmentForOwner(document);
				msj = "the number of apartments rented by the owner is..." + count; 
				System.out.println(msj); 
				 
				break; 

			case 9:
				System.out.println("the total rental value that an owner would receive\n");
				System.out.println("type the document of the owner of the apartments.. ");
				document = validateIntegerOption(); 
				if(document<0){
					System.out.println("enter a valid option.... xD"); 
					break;
				}

				msj = property.totalRentalForOwner(document);
				System.out.println(msj); 

				break; 

			case 0: 
				System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}
	/**
	 * validateIntegerOption: this method validates that the option entered by the user is actually an integer data type
	 * @return option: is a int option. 
	 */
	public int validateIntegerOption(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}
	
}