package model;


public class Owner extends Person {

	private int numCount;
	private String bank;

	public Owner(int document, String name, int cellphone, TypePhone typePhone,String idBuilding, int idApartment, int numCount, String bank) {
		super(document, name, cellphone, typePhone, idBuilding, idApartment);

		this.numCount = numCount;
		this.bank = bank; 
	}

	public int getNumCount(){
		return numCount;
	}
	public String getBank(){
		return bank; 
	}
		
		
}