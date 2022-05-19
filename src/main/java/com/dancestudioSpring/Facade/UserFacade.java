package com.dancestudioSpring.Facade;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dancestudioSpring.Component.RandomComponent;
import com.dancestudioSpring.DTO.User.UserForgetDTO;
import com.dancestudioSpring.DTO.User.UserProfileByAdminDTO;
import com.dancestudioSpring.DTO.User.UserProfileByUserDTO;
import com.dancestudioSpring.DTO.User.UserRegistrationDTO;
import com.dancestudioSpring.Entity.User;
import com.dancestudioSpring.Model.User.UserLoginResult;
import com.dancestudioSpring.Model.User.UserSaveProfileResult;
import com.dancestudioSpring.Service.UserService;
import com.dancestudioSpring.ViewModel.JsonAnswerStatus;
import com.dancestudioSpring.ViewModel.User.*;

@Component
public class UserFacade {

	@Autowired
	UserService userService;
	

    public User add(String secondname, String firstname)
    {
        User user = new User();
        user.setSecondname(secondname);
        user.setFirstname(firstname);
        user.setActive(1);
        
        Date dateOfAdd = new Date();
        user.setDateOfAdd(dateOfAdd);
        user.setDateOfUpdate(dateOfAdd);
        
        user = userService.add(user);

        return user;
    }
    
    public User add(String secondname, String firstname, String phone, String comment)
    {
        User user = new User();
        user.setSecondname(secondname);
        user.setFirstname(firstname);
        user.setPhone(phone);
        user.setComment(comment);
        user.setActive(1);
        
        Date dateOfAdd = new Date();
        user.setDateOfAdd(dateOfAdd);
        user.setDateOfUpdate(dateOfAdd);
        
        user = userService.add(user);

        return user;
    }
    

    public UserLoginResult registration(UserRegistrationDTO userRegistrationDTO)
    {
        if (userRegistrationDTO.getUsername() == null) return new UserLoginResult("error","no_data");
        
        if(userService.findByUsername(userRegistrationDTO.getUsername()) != null)return new UserLoginResult("error", "username_already_exist");

        
        Date dateOfBirthday = new Date();
    	try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            dateOfBirthday = formatter.parse(userRegistrationDTO.getDateOfBirthdayStr());

    	} catch(ParseException ex) {
    		ex.printStackTrace();
            return new UserLoginResult("error", "wrong_date_of_birthday");
    	}
        
    	BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();
    	String password = passwordEcorder.encode(userRegistrationDTO.getPassword());
    	
    	Date dateNow = new Date();
    	User user = new User();
    	user.setUsername(userRegistrationDTO.getUsername());
    	user.setPassword(password);
    	user.setDateOfAdd(dateNow);
    	user.setSecondname(userRegistrationDTO.getSecondname());
    	user.setFirstname(userRegistrationDTO.getFirstname());
    	user.setPhone(userRegistrationDTO.getPhone());
    	user.setSex(userRegistrationDTO.getSex());
    	user.setDateOfBirthday(dateOfBirthday);
    	user.setParentFio(userRegistrationDTO.getParentFio());
    	user.setParentPhone(userRegistrationDTO.getParentPhone());

    	user = userService.add(user);
    	if(user == null)return new UserLoginResult("error", "try_add");

        return new UserLoginResult("success", null, user);
    }
	

    public UserLoginResult forget(UserForgetDTO userForgetDTO, boolean isNeedJWTAuth)
    {

        if (userForgetDTO.getStep() == 0)
        {
            if (userForgetDTO.getUsername() == null) return new UserLoginResult("error", "no_username");
            User user = userService.findByUsername(userForgetDTO.getUsername());
            if (user == null) return new UserLoginResult("error", "not_found");
            
            Calendar dateNow = Calendar.getInstance();
            long timeInSecs = dateNow.getTimeInMillis();
            Date datePlus20Minutes = new Date(timeInSecs + (20 * 60 * 1000));
            
            if (user.getForgetDateOfLastTry() == null) user.setForgetDateOfLastTry(dateNow.getTime());
            if (user.getForgetDateOfLastTry().compareTo(datePlus20Minutes) < 0)
            {
                if (user.getForgetCount() > 2) return new UserLoginResult("error", "max_limit_try");
            }
            
            String code = RandomComponent.RandomIntAsString(6);
            user.setForgetCode(code);
            
            if(!userService.update(user))return new UserLoginResult("error", "try_save_code");

            //sendCodeToUser(user.username, code);

            return new UserLoginResult("success", null, user.getId());
        }
        else if (userForgetDTO.getStep() == 1)
        {
            if (userForgetDTO.getCode() == null || userForgetDTO.getForget_id() == 0) return new UserLoginResult("error", "no_data");
            User user = userService.findById(userForgetDTO.getForget_id());
            
            if (user == null) return new UserLoginResult("error", "not_found");

            if (user.getForgetCode() != userForgetDTO.getCode())
            {
                if (user.getForgetCount() > 2)
                {
                    return new UserLoginResult("error", "wrong_max_limit");
                }
                else if (user.getForgetCount() > 1)
                {
                	user.setForgetCount(3);
                	userService.update(user);
                    return new UserLoginResult("error", "wrong_2");
                }
                else if (user.getForgetCount() > 0)
                {
                	user.setForgetCount(2);
                	userService.update(user);
                    return new UserLoginResult("error", "wrong_1");
                }
                else
                {
                	user.setForgetCount(1);
                	userService.update(user);
                    return new UserLoginResult("error", "wrong");
                }
            }
            
            String newPassword = RandomComponent.RandomString(6);

        	BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();
        	String newPasswordHash = passwordEcorder.encode(newPassword);
        	
            user.setPassword(newPasswordHash);
            user.setAuthKey(RandomComponent.RandomString(32));
            
            if (!userService.update(user)) return new UserLoginResult("error", "when_update_password");

            //отправляем письмо с новым паролем
            //sendNewPasswordToUser(user.username, newPassword);

            if (isNeedJWTAuth) return new UserLoginResult("success", null, user);


            return new UserLoginResult("success", null);
        }

        return new UserLoginResult("error", null);
    }


    public boolean delete(int id)
    {
        return userService.delete(id);
    }

    public JsonAnswerStatus getEdit(int id)
    {
        User user = userService.findById(id);
        if (user == null) return new JsonAnswerStatus("error", "not_found");

        JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
        jsonAnswerStatus.setUserProfileViewModel(new UserProfileViewModel(
                user.getId(),
                user.getSecondname(),
                user.getFirstname(),
                user.getPhone(),
                user.getSex(),
                user.getDateOfBirthday(),
                user.getUsername(),
                user.getComment(),
                user.getParentFio(),
                user.getParentPhone(),
                user.getStatusOfAdmin()
            ));
        
        return jsonAnswerStatus;
    }

    public JsonAnswerStatus getProfile(int id_of_user)
    {
        User user = userService.findById(id_of_user);
        if (user == null) return new JsonAnswerStatus("error", "not_found");

        JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
        jsonAnswerStatus.setUserProfileViewModel(new UserProfileViewModel(
                user.getId(),
                user.getSecondname(),
                user.getFirstname(),
                user.getPhone(),
                user.getSex(),
                user.getDateOfBirthday(),
                user.getUsername(),
                user.getParentFio(),
                user.getParentPhone()
            ));
        
        return jsonAnswerStatus;
    }
    

    public UserLoginResult login(String username, String password)
    {
        User user = userService.findByUsername(username);
        if (user == null) return new UserLoginResult("error", "not_found");
        
    	BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();
    	if(passwordEcorder.matches(password, user.getPassword()))return new UserLoginResult("success", null, user);

        return new UserLoginResult("error", "wrong");
    }
    
    

    public JsonAnswerStatus search(int page, String queryString)
    {
        List<User> usersSearchResult = userService.searchUsers(page, queryString);
        int searchCount = userService.searchCount(queryString);

        ArrayList<UserSearchPreviewViewModel> userSearchPreviewViewModels = new ArrayList<UserSearchPreviewViewModel>();
        for (User user : usersSearchResult)
        {
            userSearchPreviewViewModels.add(new UserSearchPreviewViewModel(
                user.getId(),
                user.getSecondname(),
                user.getFirstname(),
                user.getPhone(),
                user.getDateOfAdd(),
                user.getDateOfLastVisit()
                )
            );
        }
        
        JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
        jsonAnswerStatus.setUserSearchPreviewViewModels(userSearchPreviewViewModels);
        jsonAnswerStatus.setUsersSearchCount(searchCount);

        return jsonAnswerStatus;
    }
    

    public JsonAnswerStatus searchLite(String queryString)
    {
        List<User> usersSearchResult = userService.searchUsers(0, queryString);

        ArrayList<UserSearchPreviewViewModel> userSearchPreviewViewModels = new ArrayList<UserSearchPreviewViewModel>();
        for (User user : usersSearchResult)
        {
            userSearchPreviewViewModels.add(new UserSearchPreviewViewModel(
                user.getId(),
                user.getSecondname(),
                user.getFirstname(),
                user.getPhone(),
                user.getDateOfAdd(),
                user.getDateOfLastVisit()
                )
            );
        }

        JsonAnswerStatus jsonAnswerStatus = new JsonAnswerStatus("success");
        jsonAnswerStatus.setUserSearchPreviewViewModels(userSearchPreviewViewModels);
        return jsonAnswerStatus;
    }
    
    

    public UserSaveProfileResult updateByAdmin(UserProfileByAdminDTO userProfileByAdminDTO)
    {
        User user = userService.findById(userProfileByAdminDTO.getId_of_user());
        if (user == null) return null;

        if (userProfileByAdminDTO.getUsername() != user.getUsername())
        {
            if (userService.findByUsernameExceptId(user.getId(), userProfileByAdminDTO.getUsername()) != null)
            {
                return new UserSaveProfileResult("error", "username_already_exist");
            }
        }


        UserSaveProfileResult userSaveProfileResult = new UserSaveProfileResult(user);
        if (userProfileByAdminDTO.getPasswordNew() != null || userProfileByAdminDTO.getUsername() != user.getUsername()) 
        	userSaveProfileResult.isNeedRelogin = true;

        user.setSecondname(userProfileByAdminDTO.getSecondname());
        user.setFirstname(userProfileByAdminDTO.getFirstname());
        user.setSex(userProfileByAdminDTO.getSex());
        user.setUsername(userProfileByAdminDTO.getUsername());
        user.setComment(userProfileByAdminDTO.getComment());
        user.setParentFio(userProfileByAdminDTO.getParentFio());
        user.setParentPhone(userProfileByAdminDTO.getParentPhone());
        
        if(userProfileByAdminDTO.getPasswordNew() != null) {
        	BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();
        	String password = passwordEcorder.encode(userProfileByAdminDTO.getPasswordNew());
        	user.setPassword(password);
        }
        
        if (userService.update(user)
        )
        {
            userSaveProfileResult.status = "success";
        }
        else
        {
            userSaveProfileResult.status = "error";
        }

        return userSaveProfileResult;
    }
    
    
    

    public UserSaveProfileResult updateByUser(int id_of_user, UserProfileByUserDTO userProfileByUserDTO)
    {
        User user = userService.findById(id_of_user);
        if (user == null) return new UserSaveProfileResult("error", "not_found");

        if (userProfileByUserDTO.getUsername() != user.getUsername())
        {
            if (userService.findByUsernameExceptId(user.getId(), userProfileByUserDTO.getUsername()) != null)
            {
                return new UserSaveProfileResult("error", "username_already_exist");
            }
        }

        UserSaveProfileResult userSaveProfileResult = new UserSaveProfileResult();

        Date dateOfBirthday = new Date();
    	try {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            dateOfBirthday = formatter.parse(userProfileByUserDTO.getDateOfBirthday());

    	} catch(ParseException ex) {
    		ex.printStackTrace();
            return new UserSaveProfileResult("error", "wrong_date_of_birthday");
    	}
        
    	Calendar calendarNow = Calendar.getInstance();
    	Calendar calendarDateOfBirthday = Calendar.getInstance();
    	calendarDateOfBirthday.setTime(dateOfBirthday);

    	//calendarNow.get(Calendar.YEAR) - calendarNDateOfBirthday.get(Calendar.YEAR);
        int age = Period.between(
        		LocalDateTime.ofInstant(calendarDateOfBirthday.toInstant(), calendarDateOfBirthday.getTimeZone().toZoneId()).toLocalDate(), 
        		LocalDateTime.ofInstant(calendarNow.toInstant(), calendarNow.getTimeZone().toZoneId()).toLocalDate()
        		).getYears();
        		
        if(age < 18 && (userProfileByUserDTO.getParentFio() == null || userProfileByUserDTO.getParentPhone() == null))
        {
            return new UserSaveProfileResult("error", "need_parent_info");
        }

        String passwordNew = null;
        if (!userProfileByUserDTO.getPasswordNew().isEmpty())
        {
            if(userProfileByUserDTO.getPasswordCurrent() == null) return new UserSaveProfileResult("error", "wrong");

        	BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();
        	if(!passwordEcorder.matches(userProfileByUserDTO.getPasswordCurrent(), user.getPassword()))return new UserSaveProfileResult("error", "wrong");
        	
            userSaveProfileResult.setNeedRelogin(true);
            
            
            passwordNew = passwordEcorder.encode(userProfileByUserDTO.getPasswordNew());
            user.setPassword(passwordNew);
        }
        if (userProfileByUserDTO.getUsername() != user.getUsername())
        {
            userSaveProfileResult.setNeedRelogin(true);
        }

        user.setSecondname(userProfileByUserDTO.getSecondname());
        user.setFirstname(userProfileByUserDTO.getFirstname());
        user.setPhone(userProfileByUserDTO.getPhone());
        user.setSex(userProfileByUserDTO.getSex());
        user.setDateOfBirthday(dateOfBirthday);
        user.setUsername(userProfileByUserDTO.getUsername());
        user.setParentFio(userProfileByUserDTO.getParentFio());
        user.setParentPhone(userProfileByUserDTO.getParentPhone());
        
        if(!userService.update(user)) {
        	userSaveProfileResult.setStatus("success");
        } else {
        	userSaveProfileResult.setStatus("error");
        }

        userSaveProfileResult.setUser(user);

        return userSaveProfileResult;
    }


    public JsonAnswerStatus updateUserStatusOfAdmin(int id_of_user, int status)
    {
        User user = userService.findById(id_of_user);
        if (user == null) return new JsonAnswerStatus("error", "not_found");

        if(status != 0 && status != 1)status = 0;
        user.setStatusOfAdmin(status);
        if(! userService.update(user))return new JsonAnswerStatus("error", "unknown");
        
        return new JsonAnswerStatus("success", null);
    }
    


    public JsonAnswerStatus checkStatusOfAdmin(int id_of_user)
    {
        User user = userService.findById(id_of_user);
        if (user == null) return new JsonAnswerStatus("error", "not_auth");
        return (user.getStatusOfAdmin() == 1
            ? new JsonAnswerStatus("success", null)
            : new JsonAnswerStatus("error", "denied")
        );
    }

    public User updateLastTimeVisit(User user, Date dateOfVisit) {
    	user.setDateOfLastVisit(dateOfVisit);
    	if(!userService.update(user))return null;
    	return user;
    }
    
	/*
	

        public void sendCodeToUser(string username, string code)
        {
            if (username == null || code == null) return;
            MailSender mailSender = new MailSender();
            mailSender.sendMailToUser(
                username,
                "Код восстановление пароля",
                "Код:  <b>" + code + "</b>"
            );
        }

        public void sendNewPasswordToUser(string username, string password)
        {
            if (username == null || password == null) return;
            MailSender mailSender = new MailSender();
            mailSender.sendMailToUser(
                username,
                "Установлен новый пароль",
                "Новый пароль: <b>" + password + "</b>"
            );
        }










        public async Task<JsonUserQRCode> generateCheckQR(HttpContext httpContext)
        {
            User user = await getCurrentOrNull(httpContext);
            if (user == null) return new JsonUserQRCode("error", "not_auth");

            string checkQRNew = RandomComponent.RandomString(32);
            UserService userService = new UserService(_dbc);
            if (! await userService.updateCheckQR(user, checkQRNew)) return new JsonUserQRCode("error", "when_trying_save_qr_code");

            string qrCodeAsBase64 = generateQRCodeAsBase64(user.id, checkQRNew);
            if(qrCodeAsBase64 == null) return new JsonUserQRCode("error", "when_trying_generate_qr_code");

            return new JsonUserQRCode("success", null, qrCodeAsBase64);
        }

        private string generateQRCodeAsBase64(int id_of_user, string checkQR)
        {
            UserQRCode userQRCode = new UserQRCode(id_of_user, checkQR);

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(userQRCode.ToString(), BarcodeFormat.QR_CODE, 500, 500);

            try
            {
                int scale = 1;
                Bitmap result = new Bitmap(bitMatrix.Width * scale, bitMatrix.Height * scale);
                for (int x = 0; x < bitMatrix.Height; x++)
                {
                    for (int y = 0; y < bitMatrix.Width; y++)
                    {
                        Color pixel = bitMatrix[x, y] ? Color.Black : Color.White;
                        for (int i = 0; i < scale; i++)
                            for (int j = 0; j < scale; j++)
                                result.SetPixel(x * scale + i, y * scale + j, pixel);
                    }
                }
                System.IO.MemoryStream ms = new MemoryStream();
                result.Save(ms, ImageFormat.Jpeg);
                byte[] byteImage = ms.ToArray();
                string sigBase64 = Convert.ToBase64String(byteImage);

                return sigBase64;

            } catch
            {
                return null;
            }
        }

        public async Task<JsonAnswerStatus> checkUserQRByAdmin(HttpContext httpContext, int id_of_user, string checkQR)
        {
            User user = await getCurrentOrNull(httpContext);
            if (user == null) return new JsonAnswerStatus("error", "not_auth");
            if(user.statusOfAdmin != 1) return new JsonAnswerStatus("error", "not_admin");

            UserService userService = new UserService(_dbc);
            User userForCheck = await userService.findById(id_of_user);
            if (userForCheck == null) return new JsonAnswerStatus("error", "not_found");
            if(userForCheck.checkQr != checkQR) return new JsonAnswerStatus("error", "wrong");

            return new JsonAnswerStatus("success", null);
        }



	 */
}
