package com.julianjupiter.passwordencoder.crypto.bcrypt;

import com.julianjupiter.passwordencoder.PasswordEncoder;
import org.mindrot.jbcrypt.BCrypt;

public class BCryptPasswordEncoder implements PasswordEncoder {
    private BCryptPasswordEncoder() {

    }

    public static PasswordEncoder create() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public String hash(CharSequence password) {
        if (password == null || password.toString().isBlank()) {
            throw new IllegalArgumentException("Password must not be null or empty.");
        }

        return BCrypt.hashpw(password.toString(), BCrypt.gensalt());
    }

    @Override
    public boolean verify(CharSequence password, String hashedPassword) {
        if (password == null || password.toString().isBlank()) {
            throw new IllegalArgumentException("Password must not be null or empty.");
        }

        if (hashedPassword == null || hashedPassword.toString().isBlank()) {
            throw new IllegalArgumentException("Hashed password must not be null or empty.");
        }

        return BCrypt.checkpw(password.toString(), hashedPassword);
    }
}
