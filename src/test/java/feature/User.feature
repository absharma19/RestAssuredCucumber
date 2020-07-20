Feature: Add User
Scenario: Add user and validate details

Given Add User Details "Gaurav Mishra" "gauravm" "Gaurav.mishra72@yahoo.com" "+91-9993261223"
When User Call "addUser" with "Post" HTTP Request
Then Verify Api Call Is success with Status code 201
And Verify field value for "name" is "Gaurav Mishra"
	And Verify field value for "username" is "gauravm"
		And Verify field value for "email" is "Gaurav.mishra72@yahoo.com"
			And Verify field value for "phone" is "+91-9993261223"

Scenario: Get User Details by ID and verify satue code

Given get User details where "id" is "1"
When User Call "getuser" with "Get" HTTP Request
Then Verify Api Call Is success with Status code 200