package model;

import model.Building;
import model.Apartment;
import model.Person;
import model.TypePhone; 

public class Property{

	public static final int ALL_BUILDING = 5; 
	public static final int ALL_APARTMENT = 50;
	public static final int ALL_PERSONS = 20; 

	private Building[] totalBuildings;
	private Apartment[] totalApartments; 
	private Person[] totalPersons; 
	private Building building;
	private Apartment apartment;
	private Person person; 
	private TypePhone typePhone; 

	public Property(){

		totalBuildings = new Building[ALL_BUILDING];
		totalApartments = new Apartment[ALL_APARTMENT];
		totalPersons =  new Person[ALL_PERSONS]; 
	}

	public Building getBuilding(){
		return building;
	}
	public Apartment getApartment(){
		return apartment;
	}
	public Person getperson(){
		return person;
	}
	public Building[] getBuildings(){
		return totalBuildings;
	}
	public Apartment[] getApartments(){
		return totalApartments;
	}
	public Person[] getPersons(){
		return totalPersons; 
	}
	public TypePhone getTypePhone(){
		return typePhone; 
	}
	public void setTypePhone(int typePhone){
		if(typePhone == 1 ){
			this.typePhone = TypePhone.HOME;
		} else if (typePhone ==2){
			this.typePhone = TypePhone.OFFICE;
		}else if(typePhone ==3){
			this.typePhone = TypePhone.MOVIL;
		}else if(typePhone ==4){
			this.typePhone = TypePhone.FAMILY;
		}else if(typePhone ==5){
			this.typePhone = TypePhone.OTHER; 
		}
	}
	/**
	 * registerBuilding: this method register a building.
	 * @param idBuilding: String: this is the id of the building.
	 * @param address: String: this is the  buidling addres.
	 * @return msj: String: a confirm message.
	 */
	public String registerBuilding(String idBuilding, String address){

		String msj = "Could not register the building"; 
		boolean isEmpty = false; 
		Building newBuilding = new Building(idBuilding, address);
		for(int i = 0; i <ALL_BUILDING && !isEmpty; i++){
			if(totalBuildings[i] == null){
				// I add the building to the first available array space 
				totalBuildings[i] = newBuilding; 
				isEmpty = true; 
				msj = "New building registed"; 
				
			}
		}

		return msj; 
	}

	public void registerApartment(String idBuilding, int idApartment, int numRooms, int numBathrooms, boolean balcony, int price){
		boolean isEmpty = false; 
		Apartment apartment = new Apartment(idBuilding, idApartment, numRooms, numBathrooms, balcony, price);
		for(int i = 0; i <ALL_APARTMENT && !isEmpty; i++){
			if(totalApartments[i] == null){
				// I add the apartment to the first available array space 
				totalApartments[i] = apartment; 
				isEmpty = true;  
			}
		}
 
	}
	/**
	 * registerApartmentToBuilding: This method receives some parameters to register an apartment to a specific building.
	 * @param idBuilding: String: this is the id of the builfing.
	 * @param idApartment: int: is the id of the apartment.
	 * @param numRooms: int: is the quantity of rooms.
	 * @param numBathrooms: int is the quantity of bathrooms.
	 * @param balcony: boolean: if have or not a balcony.
	 * @param price: int: the price of the apartment.
	 * @return  msj: a confirm message.
	 */

	public String registerApartmentToBuilding(String idBuilding, int idApartment, int numRooms, int numBathrooms, boolean balcony, int price){
		String msj = ""; 
		Apartment newAparment = new Apartment(idBuilding, idApartment, numRooms, numBathrooms, balcony, price); 
		int posBuilding = searchBuildingById(idBuilding); 
		if(posBuilding != -1 ){
			msj = totalBuildings[posBuilding].addApartmentWithObject(newAparment); 
		} else{
			msj = "this building  does not exist"; 
		}
		return msj; 
	}

	/**
	 * searchBuildingById: This method compares the ids of existing buildings to see if there is already one.
	 * @param idBuilding: String: the building id.
	 * @return pos: a position in the array. 
	 */
	public int searchBuildingById(String idBuilding){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < ALL_BUILDING && !isFound; i++ ){
			if(totalBuildings[i] != null && totalBuildings[i].getId().equalsIgnoreCase(idBuilding)){
				pos = i; 
				isFound = true; 
				 
			}
		}
		return pos; 
	}

	public void registerOwner(int document, String name, int cellPhone, int typePhone,String idBuilding, int idApartment, int count, String bank){
		boolean isEmpty = false; 
		setTypePhone(typePhone); 
		TypePhone phone = getTypePhone(); 
		Owner owner = new Owner(document, name, cellPhone, phone, idBuilding, idApartment, count, bank);
		for(int i = 0; i <ALL_PERSONS && !isEmpty; i++){
			if(totalPersons[i] == null){
				// I add the owner to the first available array space 
				totalPersons[i] = owner; 
				isEmpty = true;  
			}
		}
 
	}
	/**
	 * registerOwnerToApartment: This method receives some parameters to register an owner to a specific apartment.
	 * @param document: int: this is the id of the owner.
	 * @param name: String: is the name of the owner.
	 * @param cellPhone: int: is the cellphone of the owner.
	 * @param typePhone: int is the type  of phone of the owner.
	 * @param idBuilding: String: the building id.
	 * @param idApartment: int: is the id of the apartment.
	 * @param count: int the num of the bank count of the owner. 
	 * @param bank: String: the bank name.
	 * @return  msj: a confirm message.
	 */
	public String registerOwnerToApartment(int document, String name, int cellPhone, int typePhone,String idBuilding, int idApartment,int count, String bank){
		String msj = ""; 
		setTypePhone(typePhone); 
		TypePhone phone = getTypePhone(); 
		Owner newOwner = new Owner(document, name, cellPhone, phone, idBuilding, idApartment, count, bank); 
		int posBuilding = searchBuildingById(idBuilding); 
		if(posBuilding != -1 ){
			msj = totalBuildings[posBuilding].addOwnerWithObject(newOwner, idApartment); 
		} else{
			msj = "this building does not exist"; 
		}
		return msj; 
	}

	public void registerTenant(int document, String name, int cellPhone, int typePhone,String idBuilding, int idApartment){
		boolean isEmpty = false; 
		setTypePhone(typePhone); 
		TypePhone phone = getTypePhone(); 
		Tenant tenant = new Tenant(document, name, cellPhone, phone, idBuilding, idApartment);
		for(int i = 0; i <ALL_PERSONS && !isEmpty; i++){
			if(totalPersons[i] == null){
				// I add the tenant to the first available array space 
				totalPersons[i] = tenant; 
				isEmpty = true;  
			}
		}
 
	}
	/**
	 * registerTenantToApartment: This method receives some parameters to register an tenant to a specific apartment.
	 * @param document: int: this is the id of the tenant.
	 * @param name: String: is the name of the tenant.
	 * @param cellPhone: int: is the cellphone of the tenant.
	 * @param typePhone: int is the type  of phone of the tenant.
	 * @param idBuilding: String: the building id.
	 * @param idApartment: int: is the id of the apartment.
	 * @return  msj: a confirm message.
	 */
	public String registerTenantToApartment(int document, String name, int cellPhone, int typePhone,String idBuilding, int idApartment){
		String msj = ""; 
		setTypePhone(typePhone); 
		TypePhone phone = getTypePhone(); 
		Tenant newTenant = new Tenant(document, name, cellPhone, phone, idBuilding, idApartment); 
		int posBuilding = searchBuildingById(idBuilding); 
		if(posBuilding != -1 ){
			msj = totalBuildings[posBuilding].addTenantWithObject(newTenant, idApartment); 
		}else{
			msj = "this building does not exist"; 
		}
		return msj; 
	}
	/**
	 * apartmentsAvailable:this method gives us the number of apartments available in a certain building 
	 * @param idBuilding: String: the building id.
	 * @return msj: String: a confirm message.
	 */
	public String apartmentsAvailable(String idBuilding){

		String msj = "this building does not exist... "; 
		int posBuilding= searchBuildingById(idBuilding); 

		if(posBuilding >=0){
			int amount = totalBuildings[posBuilding].amountAvalible();
			msj = "the number of apartments available is... " + amount;
		}
		return msj; 
	}
	/**
	 * valueByApartmentsForBuilding: the money that is received for all rented apartments in a building. 
	 * @param idBuilding: String: the building id.
	 * @return msj: String: a confirm message.
	 */

	public String valueByApartmentsForBuilding(String idBuilding){
		String msj = "";
		int posBuilding = searchBuildingById(idBuilding); 
		
		if(posBuilding >=0){
			int price= totalBuildings[posBuilding].valueByApartments(); 
			msj = " the total value to receive for the apartments is ... " + price;
		}else{
			msj = "this building does not exist... "; 
		}
		
		return msj;
 	}
 	/**
	 * avalibleApartment: say if a specific apartment is available or not . 
	 * @param idBuilding: String: the building id.
	 * @param idApartment: int: is the id of the apartment.
	 * @return msj: String: a confirm message.
	 */

 	public String avalibleApartment(String idBuilding, int idApartment){

 		String msj = "";
		int posBuilding = searchBuildingById(idBuilding);
		if(posBuilding <0){
			msj = "this building does not exist"; 
		} else{
			msj = totalBuildings[posBuilding].availableApartment(idApartment);
		}
		
		return msj; 

 	}
 	/**
	 * apartmentForOwner: the number of apartments a specific owner has . 
	 * @param document: int: this is the id of the owner.
	 * @return count: int: a int valor.
	 */

 	public int apartmentForOwner(int document){
 		int count =0; 
 		for(int i =0; i <ALL_APARTMENT; i++){
 			if(totalApartments[i] != null && totalApartments[i].getTenant() != null && totalApartments[i].getOwner().getDocument() == document){
 				count++; 

 			}
 		}

 		return count; 
 	}
 	/**
	 * totalRentalForOwner: the amount of money you receive for owner apartments in specific . 
	 * @param document: int: this is the id of the owner.
	 * @return msj: a message.
	 */

 	public String totalRentalForOwner(int document){
 		String msj = ""; 
 		double price =0.0; 
 		for(int i =0; i<ALL_APARTMENT; i++){
 			if(totalApartments[i] != null && totalApartments[i].getOwner() != null && totalApartments[i].getOwner().getDocument() == document){
 				price += totalApartments[i].getPrice();
 			}
 		}
 		price = price * 0.9;
 		msj = "the total lease value the owner would receive is  " + price;

 		return msj; 
 	}


}