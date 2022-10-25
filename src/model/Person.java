package model;

public abstract class Person{

	private int  document;
	private String name;
	private int cellphone;
	private TypePhone typePhone; 
	private String idBuilding;
	private int idApartment; 

	public Person(int document, String name, int cellphone, TypePhone typePhone, String idBuilding, int idApartment) {
		this.document = document;
		this.name = name;
		this.cellphone = cellphone;
		this.typePhone = typePhone; 
		this.idBuilding = idBuilding;
		this.idApartment = idApartment; 
	}

	public int getDocument(){
		return document;
	}
	public String getName(){
		return name;
	}
	public int getCellphone(){
		return cellphone;
	}
	public TypePhone getTypePhone(){
		return typePhone; 
	}
	public String getIdBuilding(){
		return idBuilding; 
	}
	public int getIdApartment(){
		return idApartment;
	}
}

	