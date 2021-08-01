package com.appsdeveloperblog.ws.api.ResourceServer.controllers;

import org.springframework.security.oauth2.jwt.Jwt;

import com.appsdeveloperblog.ws.api.ResourceServer.response.UserRest;

import org.apache.catalina.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
public class UsersController {

    @GetMapping("/status/check")
    public String status() {
        return "Working...";
    }

    // @Secured("ROLE_developer")
    @PreAuthorize("hasRole('developer') or #id == #jwt.subject")
    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return "Deleted User with id " + id + " and JWT subject : " + jwt.getSubject();
    }

    @PostAuthorize("returnObject.userId == #jwt.subject")
    @GetMapping(path = "/{id}")
    public UserRest getUser(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return new UserRest("Shikhar", "Srivastava", "e31c6c8d-3622-4163-aacb-b6c458f5c025");
        // return "Jwt subject : " + jwt.getSubject();
    }
}
