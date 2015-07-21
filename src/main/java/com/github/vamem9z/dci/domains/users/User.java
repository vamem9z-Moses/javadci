package main.java.com.github.vamem9z.dci.domains.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    @Getter private int id;
    @Getter private String name;        
}


