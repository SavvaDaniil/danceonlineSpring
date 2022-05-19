package com.dancestudioSpring.Controller.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dancestudioSpring.DTO.User.UserIdDTO;
import com.dancestudioSpring.DTO.User.UserNewDTO;
import com.dancestudioSpring.DTO.User.UserProfileByAdminDTO;
import com.dancestudioSpring.DTO.User.UserProfileByUserDTO;
import com.dancestudioSpring.DTO.User.UserSearchDTO;
import com.dancestudioSpring.DTO.User.UserSearchLiteDTO;
import com.dancestudioSpring.DTO.User.UserUpdateStatusOfAdminDTO;
import com.dancestudioSpring.Facade.UserFacade;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;

@RestController
@RequestMapping("/api/user")
public class ApiUserController {

	@Autowired
	UserFacade userFacade;
	
	@PostMapping("/add")
    public JsonAnswerStatus add(UserNewDTO userNewDTO)
    {
		if(!userNewDTO.isValid())return JsonAnswerStatus.noData();
		return userFacade.add(userNewDTO.getSecondname(), userNewDTO.getFirstname(), userNewDTO.getPhone(), userNewDTO.getComment()) != null
				? new JsonAnswerStatus("success")
						: new JsonAnswerStatus("error");
    }

	@PostMapping("/delete")
    public JsonAnswerStatus delete(UserIdDTO userIdDTO)
    {
		if(!userIdDTO.isValid())return JsonAnswerStatus.noData();
		return userFacade.delete(userIdDTO.getId_of_user())
				? new JsonAnswerStatus("success")
						: new JsonAnswerStatus("error");
    }

	@PostMapping("/search")
    public JsonAnswerStatus search(UserSearchDTO userSearchDTO)
    {
		return userFacade.search(userSearchDTO.getPage(), userSearchDTO.getQueryString());
    }

	@PostMapping("/search_lite")
    public JsonAnswerStatus searchLite(UserSearchLiteDTO userSearchLiteDTO)
    {
		return userFacade.searchLite(userSearchLiteDTO.getQueryString());
    }

	@PostMapping("/get_edit")
    public JsonAnswerStatus getEdit(UserIdDTO userIdDTO)
    {
		return userFacade.getEdit(userIdDTO.getId_of_user());
    }
	
	


	@PostMapping("/app/profile")
    public JsonAnswerStatus appProfile()
    {
		return null;
    }
	

	@PostMapping("/update_status_of_admin")
    public JsonAnswerStatus updateStatusOfAdmin(UserUpdateStatusOfAdminDTO userUpdateStatusOfAdminDTO)
    {
		return userFacade.updateUserStatusOfAdmin(userUpdateStatusOfAdminDTO.getId_of_user(), userUpdateStatusOfAdminDTO.getStatus());
    }
	
	@PostMapping("/update_by_admin")
    public JsonAnswerStatus updateByAdmin(UserProfileByAdminDTO userProfileByAdminDTO)
    {
		return userFacade.updateByAdmin(userProfileByAdminDTO) != null
                ? new JsonAnswerStatus("success")
                : new JsonAnswerStatus("error");
    }
	
	@PostMapping("/update_by_user")
    public JsonAnswerStatus updateByUser(UserProfileByUserDTO userProfileByUserDTO)
    {
		return null;
    }
	
	@PostMapping("/app/admin/status")
    public JsonAnswerStatus appCheckOfAdminStatus()
    {
		return null;
    }
	
	
	
}
