package resources;

import POJO.AddUser;

public class DataBuild {
	
	public AddUser AddUserPayload(String name, String username,String email,String phone)
	{
		AddUser p =new AddUser();
		p.setName(name);
		p.setUsername(username);
		p.setEmail(email);
		p.setPhone(phone);
		return p;
	}

}
