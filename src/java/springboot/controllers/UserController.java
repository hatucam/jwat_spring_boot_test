package src.java.springboot.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.model.User;
import com.springboot.service.UserService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@Controller
public class UserController {
	@Autowired
	private UserService UserService;
	
	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map){
		User User = new User();
		map.put("User", User);
		map.put("UserList", UserService.getAllUser());
		return "User";
	}
	
	
	@RequestMapping("/list")
	public List<User> getAll(Map<String, Object> map){
		 List<User> Users = new ArrayList<User>();
		 Users= UserService.getAllUser();
		 System.out.println("*********** "+Users.size());
		return Users;
	}
	
	
	@RequestMapping(value="/User.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute User User, BindingResult result, @RequestParam String action, Map<String, Object> map){
		User UserResult = new User();
		switch(action.toLowerCase()){	
		case "add":
			UserService.add(User);
			UserResult = User;
			break;
		case "edit":
			UserService.edit(User);
			UserResult = User;
			break;
		case "delete":
			UserService.delete(User.getId());
			UserResult = new User();
			break;
        case "update":
			UserService.update(User.getId());
			UserResult = new User();
			break;
		case "search":
			User searchedUser = UserService.getUser(User.getId());
			UserResult = searchedUser!=null ? searchedUser : new User();
			break;
		}
		map.put("User", UserResult);
		map.put("UserList", UserService.getAllUser());
		return "User";
	}
}
