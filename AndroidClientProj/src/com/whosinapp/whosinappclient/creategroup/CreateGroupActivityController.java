package com.whosinapp.whosinappclient.creategroup;

import android.content.Intent;

import com.whosinapp.whosinappclient.ServiceGateway;
import com.whosinapp.whosinappclient.adduserstogroup.AddUsersToGroupActivity;

public class CreateGroupActivityController {

	public CreateGroupActivityController(CreateGroupActivity createGroupActivity) {
		myActivity = createGroupActivity;
	}
	CreateGroupActivity myActivity;
	public void CreateGroupAndTransitionToAddUsers(String groupName) {
		ServiceGateway theGate = new ServiceGateway();
		CreateGroupDto dto = new CreateGroupDto();
		theGate.Send(dto);
		Intent transitionToAddUsersToGroups = new Intent(myActivity, AddUsersToGroupActivity.class);
		transitionToAddUsersToGroups.putExtra("groupName", groupName);
		myActivity.startActivity(transitionToAddUsersToGroups);
	}

}
