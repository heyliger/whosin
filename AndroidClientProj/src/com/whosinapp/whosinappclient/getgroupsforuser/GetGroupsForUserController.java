package com.whosinapp.whosinappclient.getgroupsforuser;

import java.util.ArrayList;
import com.whosinapp.whosinappclient.ServiceGateway;

public class GetGroupsForUserController {

	private ServiceGateway gateway = new ServiceGateway();
	public ArrayList<String> ReturnGroupsForUser() {
		return gateway.Retrieve(new GetGroupsForUserDto());
	}
}
