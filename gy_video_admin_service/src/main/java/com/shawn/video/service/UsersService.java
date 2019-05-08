package com.shawn.video.service;

import com.shawn.video.pojo.Users;
import com.shawn.video.utils.PagedResult;

public interface UsersService {

	PagedResult queryUsers(Users user, Integer page, Integer pageSize);
	
}
