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

	public String apartmentsAvailable(String idBuilding){

		String msj = "this building does not exist... "; 
		int posBuilding= searchBuildingById(idBuilding); 

		if(posBuilding >=0){
			int amount = totalBuildings[posBuilding].amountAvalible();
			msj = "the number of apartments available is... " + amount;
		}
		return msj; 
	}

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

 	public int apartmentForOwner(int document){
 		int count =0; 
 		for(int i =0; i <ALL_APARTMENT; i++){
 			if(totalApartments[i] != null && totalApartments[i].getTenant() != null && totalApartments[i].getOwner().getDocument() == document){
 				count++; 

 			}
 		}

 		return count; 
 	}

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