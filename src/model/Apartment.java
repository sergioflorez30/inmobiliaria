package model;

import model.Owner;
import model.Tenant;

public class Apartment{

	private String idBuilding;
	private int idApartment;
	private int numRooms;
	private int numBathrooms;
	private boolean balcony;
	private int price; 
	private Owner owner;
	private Tenant tenant; 

	public Apartment(String idBuilding, int idApartment, int numRooms, int numBathrooms, boolean balcony, int price){

		this.idBuilding = idBuilding
	;	this.idApartment = idApartment;
		this.numRooms = numRooms;
		this.numBathrooms = numBathrooms;
		this.balcony = balcony; 
		this.price = price; 

	}

	public String getIdBuilding(){
		return idBuilding; 
	}

	public int getIdApartment(){
		return idApartment;
	}

	public int getNumRooms(){
		return numRooms;
	}

	public int getnumBathrooms(){
		return numBathrooms;
	}

	public boolean getBalcony(){
		return balcony;
	}
	public int getPrice(){
		return price; 
	}
	public Owner getOwner(){
		return owner;
	} 
	public Tenant getTenant(){
		return tenant; 
	}
	public void setOwner(Owner owner){
		this.owner = owner; 
	}
	public void setTenant(Tenant tenant){
		this.tenant = tenant;
	}
}