package rc.bootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rc.bootsecurity.model.User;
import rc.bootsecurity.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("api/public/")
public class PublicRestApiController {

    @Autowired
    UserRepository userRepository;

    public PublicRestApiController(){}

    @GetMapping("/test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("/test2")
    public String test2(){
        return "API Test 2";
    }

    @GetMapping("/users")
    public List<User> users(){
        return userRepository.findAll();
    }

}
