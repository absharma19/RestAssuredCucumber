package resources;

public enum APIResources {
	
	addUser("/users"),
	getuser("/users");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
