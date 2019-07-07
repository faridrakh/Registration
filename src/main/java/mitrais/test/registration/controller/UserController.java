package mitrais.test.registration.controller;

import mitrais.test.registration.model.UserModel;
import mitrais.test.registration.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sl/user")
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/doAddUser", method = RequestMethod.POST)
    public ResponseEntity<?> doAddUser(@RequestBody UserModel request) {
        String result = userService.registerUser(request);
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = "/doCheckRegisteredEmail", method = RequestMethod.POST)
    public ResponseEntity<?> doCheckRegisteredEmail(@RequestBody UserModel request) {
        String result = userService.checkRegisteredEmail(request.getEmail());
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(value = "/doCheckRegisteredMobile", method = RequestMethod.POST)
    public ResponseEntity<?> doCheckRegisteredMobile(@RequestBody UserModel request) {
        String result = userService.checkRegisteredMobileNo(request.getMobileNumber());
        return ResponseEntity.ok().body(result);
    }
}
