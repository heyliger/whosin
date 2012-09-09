package com.whosinapp.whosinappclient.getusersforgroup;

import java.util.ArrayList;
import com.whosinapp.whosinappclient.ServiceGateway;


public class GetUsersForGroupController {
	private ServiceGateway gateway = new ServiceGateway();
	
	public ArrayList<String> ReturnUsersForGroup(String group) {
		GetUsersForGroupDto dto = new GetUsersForGroupDto();
		dto.setGroup(group);
		return gateway.Retrieve(dto);
	}
}
