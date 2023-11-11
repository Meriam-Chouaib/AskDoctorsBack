package com.project.askdoctor.controllers;

import com.project.askdoctor.Exception.ResourceNotFoundException;
import com.project.askdoctor.entity.User;
import com.project.askdoctor.helper.ApiResponse;
import com.project.askdoctor.repository.UserRepository;
import com.project.askdoctor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;



    /**************** Get the list of users  **************/

    @GetMapping("list")
    public ApiResponse getUsers(){
        return userService.getAll();
    }
        /*****************  get user by id ***************/


    @GetMapping("{id}")
    public ApiResponse getUserById(@PathVariable Long id) {
        return userService.getUser(id);

    }
        /*****************  Update user ***************/

    @PutMapping("{id}")
    public ApiResponse updateUser(@PathVariable(value = "id") Long id,
                                           @Valid @RequestBody User userDetails) throws ResourceNotFoundException {

        return userService.updateUser(id, userDetails);
    }

     /*****************  delete user ***************/


    @GetMapping("delete/{id}")
    public ApiResponse deleteUser(@PathVariable("id") Long id) {

      return  userService.deleteById(id);


    }



    /*******************Auth user **************/





    /********************get List of doctors***************
     * @throws Exception*/
    @CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
    @GetMapping("doctors")
    public ApiResponse getAllDoctors() throws Exception {
        return userService.getAllDoctors();
    }
}


