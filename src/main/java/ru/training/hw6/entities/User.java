package ru.training.hw6.entities;

import com.epam.jdi.tools.DataClass;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User extends DataClass<User> {
    public String username;
    public String password;
}
