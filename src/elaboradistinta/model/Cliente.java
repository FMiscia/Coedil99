package elaboradistinta.model;

import almonds.ParseObject;

public class Cliente extends ParseObject{
	
	public Cliente(){
		super(Cliente.class.getName());
		// TODO Auto-generated constructor stub
	}
	
	public String getName()
	{
		return this.getString("name");
	}

	public void setName(String name)
	{
		this.put("name", name);
	}
	
	public String getFamilyName()
	{
		return this.getString("familyName");
	}

	public void setFamilyName(String familyName)
	{
		this.put("familyName", familyName);
	}
}
