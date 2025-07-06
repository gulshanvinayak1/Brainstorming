//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ghanshyam.Brainstroming.Controller;

import com.ghanshyam.Brainstroming.Dto.LoginDto;
import com.ghanshyam.Brainstroming.Service.UserService;
import com.ghanshyam.Brainstroming.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginsignupController {
    @Autowired
    private UserService userService;

    public LoginsignupController() {
    }

    @PostMapping({"/signup"})
    public String signup(@RequestBody User user) {
        return this.userService.signUp(user);
    }

    @PostMapping({"/signin"})
    public String signin(@RequestBody LoginDto loginDto) {
        return this.userService.signIn(loginDto.getUserId(), loginDto.getPassword());
    }
}
