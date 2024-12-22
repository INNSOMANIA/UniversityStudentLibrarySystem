package com.arcode.universitystudentlibrarysystem;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {

        "com.arcode.UniversityStudentLibrarySystem.manager",
        "com.arcode.UniversityStudentLibrarySystem.student",
        "com.arcode.UniversityStudentLibrarySystem.book",

})
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UniversityStudentLibrarySystemApplication.class);
    }

}
