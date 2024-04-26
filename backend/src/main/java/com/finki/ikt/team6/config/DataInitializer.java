package com.finki.ikt.team6.config;

import com.finki.ikt.team6.model.Role;
import com.finki.ikt.team6.model.dto.job.JobCreateDTO;
import com.finki.ikt.team6.model.dto.user.UserRegisterDTO;
import com.finki.ikt.team6.service.CategoryService;
import com.finki.ikt.team6.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class DataInitializer {
    private final UserService userService;
    private final CategoryService categoryService;

    public DataInitializer(UserService userService, CategoryService categoryService) {
        this.userService = userService;
        this.categoryService = categoryService;
    }

    /**
        Create dummy data for testing purposes
     */
    @PostConstruct
    public void init(){
        // Users
        UserRegisterDTO adminDTO = new UserRegisterDTO();
        adminDTO.setUsername("admin");
        adminDTO.setPassword("admin");
        adminDTO.setRepeatPassword("admin");
        adminDTO.setName("Admin");
        adminDTO.setSurname("Admin");
        adminDTO.setEmail("admin@kindly.com");
        adminDTO.setAddress("home");
        userService.register(adminDTO, Role.ADMIN);
        UserRegisterDTO userDTO = new UserRegisterDTO();
        userDTO.setUsername("user");
        userDTO.setPassword("user");
        userDTO.setRepeatPassword("user");
        userDTO.setName("Test");
        userDTO.setSurname("User");
        userDTO.setEmail("testuser@email.com");
        userDTO.setAddress("");
        userService.register(userDTO, Role.USER);

        //Categories
        categoryService.create("Childcare");
        categoryService.create("Eldercare");
        categoryService.create("Pet care");


        //Jobs
        JobCreateDTO createDTO = new JobCreateDTO();
        createDTO.setTitle("New job");
        createDTO.setDescription("Test job description");
        createDTO.setSalary(7650.00);
        createDTO.setLocation("Somewhere, everywhere");
        createDTO.setExperienceRequired(1);
        createDTO.setCategories(Arrays.asList(1L, 2L, 3L));
        createDTO.setPostedBy("admin");
    }

}
