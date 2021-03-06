package com.kpics.web.rest.vm;

import com.kpics.domain.StudentInfo;
import com.kpics.domain.TeacherInfo;
import com.kpics.service.dto.UserDTO;

import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * View Model extending the UserDTO, which is meant to be used in the user management UI.
 */
public class ManagedUserVM extends UserDTO {

    public static final int PASSWORD_MIN_LENGTH = 4;

    public static final int PASSWORD_MAX_LENGTH = 100;

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    public ManagedUserVM() {
        // Empty constructor needed for Jackson.
    }

    public ManagedUserVM(String id, String password, String firstName, String lastName,
                         String email, String linkedin, boolean activated, String imageUrl,
                         String langKey, String createdBy, ZonedDateTime createdDate,
                         String lastModifiedBy, ZonedDateTime lastModifiedDate, Set<String> authorities,
                         StudentInfo studentInfo, TeacherInfo teacherInfo) {

        super(id, firstName, lastName, email, linkedin, imageUrl, activated, langKey,
              createdBy, createdDate, lastModifiedBy, lastModifiedDate, authorities,
              studentInfo, teacherInfo);

        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ManagedUserVM{" +
            "} " + super.toString();
    }
}
