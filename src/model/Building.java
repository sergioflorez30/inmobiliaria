package model;

import model.Apartment;

public class Building{

	public static int TOTAL_APARTMENT = 10;

	private String id;
	private String address;

	private Apartment[] apartments;
	private Apartment apartment;

	public Building(String id, String address){

		this.id = id;
		this.address = address;

		apartments = new Apartment[TOTAL_APARTMENT];

	}

	public Apartment[] getApartments(){
		return apartments; 
	}

	public Apartment getApartment(){
		return apartment; 
	}
	public String getId(){
		return id; 
	}
	/**
	 * addApartmentWithObject: this methos add a apartment. 
	 * @param apartment: Apartment: The method enters the apartment type object with its corresponding attributes.
	 * @return String: confirmation message.
	 */

	public String addApartmentWithObject(Apartment apartment){

		String msj = "Maximum capacity reached in this Building."; 
		boolean isEmpty = false; 
		for(int i = 0; i <TOTAL_APARTMENT && !isEmpty; i++){
			if(apartments[i] == null){
				// I add the apartment to the first available array space 
				apartments[i] = apartment; 
				isEmpty = true; 
				msj = "New apartment registed"; 
			}
		}

		return msj; 
	}
	/**
	 * addOwnerWithObject: this methos add a owner for a apartment. 
	 * @param owner: Owner: The method enters the owner type object with its corresponding attributes.
	 * @param idApartment: int: is the id of the apartment.
	 * @return  msj: String: confirmation message.
	 */

	public String addOwnerWithObject(Owner owner, int idApartment){

		String msj = "Maximum capacity reached in this Building."; 
		boolean isEmpty = false; 
		for(int i = 0; i <TOTAL_APARTMENT && !isEmpty; i++){
			if(apartments[i] != null && apartments[i].getIdApartment() == idApartment){
				// I add the apartment to the first available array space 
				apartments[i].setOwner(owner); 
				isEmpty = true; 
				msj = "New owner registed"; 
			} else{
				msj = "this apartment does not exist"; 
			}
		}

		return msj; 
	}
	/**
	 * addTenantWithObject: this methos add a tenant for a apartment. 
	 * @param tenant: Tenant: The method enters the tenant type object with its corresponding attributes.
	 * @param idApartment: int: is the id of the apartment.
	 * @return  msj: String: confirmation message.
	 */

	public String addTenantWithObject(Tenant tenant, int idApartment){

	String msj = "Maximum capacity reached in this Building."; 
	boolean isEmpty = false; 
	for(int i = 0; i <TOTAL_APARTMENT && !isEmpty; i++){
		if(apartments[i] != null && apartments[i].getIdApartment() == idApartment){
			// I add the apartment to the first available array space 
			apartments[i].setTenant(tenant); 
			isEmpty = true; 
			msj = "New owner registed"; 
		} else{
			msj = "this apartment does not exist"; 
			}
	}

		return msj; 
	}

	/**
	 * amountAvalible: tells us the available number of apartments 
	 * @return amount: the available number of apartments.
	 */

	public int amountAvalible(){
		int amount =0; 
		for(int i=0; i < TOTAL_APARTMENT; i++){
			if(apartments[i] == null){
				amount++; 
			}
		}
		return amount; 
	}
	/**
	 * valueByApartments: tells us the value for apartments 
	 * @return int: the total price of theapartments.
	 */

	public int valueByApartments(){
		int price = 0; 
		for(int i=0;i <TOTAL_APARTMENT; i++){
			if(apartments[i] != null){
				price += apartments[i].getPrice(); 
			}
		}
		return price; 
	}
	/**
	 * avalibleApartment: say if a specific apartment is available or not . 
	 * @param idApartment: int: is the id of the apartment.
	 * @return msj: String: a confirm message.
	 */

	public String availableApartment(int idApartment){
		String msj = ""; 
		int posApartment = searchApartmentById(idApartment); 
		if(posApartment < 0){
			msj = "this apartment does not exist"; 
		} else if( apartments[posApartment] != null &&  apartments[posApartment].getTenant() == null){
			msj= "the apartment is available";
		} else{
			msj = "the apartment isnot available"; 
		}

		return msj; 

	}

	/**
	 * searchApartmentById: This method compares the ids of existing apartment to see if there is already one.
	 * @param idApartment: String: the aparment id.
	 * @return pos: a position in the array. 
	 */

	public int searchApartmentById(int idApartment){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < TOTAL_APARTMENT && !isFound; i++ ){
			if( apartments[i] != null && apartments[i].getIdApartment() == idApartment){
				pos = i; 
				isFound = true; 

			}
		}

		return pos; 
	}

}