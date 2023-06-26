package com.booking.service.impl;

import com.booking.entities.User;
import com.booking.payload.UserDTO;

import com.booking.repository.UserRepository;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;



@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository; }
    private final String uploadDirectory = "src/main/resources/static/user_profile_image/";
    @Override
    public UserDTO createUser(UserDTO userDTO) { User user = dtoToUser(userDTO);
//it will save that time when you create user.setCreatedAt(new Date());
        //it will save that time when you update
        user.setUpdatedAt(new Date());
//this will get image
        MultipartFile profileImage = userDTO.getProfileImage(); //chack profile image not null & not empty
        if (profileImage != null && !profileImage.isEmpty()) {
            String fileName = saveProfileImage(profileImage);
            user.setProfilePicture(fileName); }
        User savedUser = userRepository.save(user);
        return userToDto(savedUser);
    }
    private String saveProfileImage(MultipartFile file) { try {
        byte[] bytes = file.getBytes();
        String originalFileName = file.getOriginalFilename();
        Path path = Paths.get(uploadDirectory + originalFileName); Files.write(path, bytes);
        return originalFileName;
    } catch (IOException e) {
        throw new RuntimeException("Failed to save profile image", e); }
    }
    private User dtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPasswordHash(userDTO.getPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        return user;
    }
    private UserDTO userToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setProfilePicture(user.getProfilePicture());
        userDTO.setCreatedAt(user.getCreatedAt());
        userDTO.setUpdatedAt(user.getUpdatedAt());
        return userDTO;
    }


    }
