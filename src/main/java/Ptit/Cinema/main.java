package Ptit.Cinema;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Timestamp;

public class main {
    private Timestamp timestamp;

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // Strength set as 12
        String encodedPassword = encoder.encode("admin");
        System.out.println(encodedPassword);
    }
}
