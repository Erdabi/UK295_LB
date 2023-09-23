package ch.csbe.backendlb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling authentication-related requests.
 */
@RequestMapping("authentication")
@RestController
public class AuthenticationController {

    /**
     * Handles the GET request for user login.
     *
     * @return A message indicating that the user is being logged in.
     */
    @GetMapping("/auth/login")
    public String userLogin() {
        return "Benutzer einloggen";
    }
}
