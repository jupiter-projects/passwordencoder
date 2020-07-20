package com.julianjupiter.passwordencoder;

import com.julianjupiter.passwordencoder.crypto.bcrypt.BCryptPasswordEncoder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordEncoderTests {

    @Test
    public void passwordEncoderDefaultCryptoBCrypt() {
        var passwordEncoder = PasswordEncoder.create();
        var hashedPassword = passwordEncoder.hash("admin123");
        var matched = passwordEncoder.verify("admin123", hashedPassword);
        assertEquals(true, matched);
    }

    @Test
    public void passwordEncoderStringCryptoBCrypt() {
        var passwordEncoder = PasswordEncoder.create("bcrypt");
        var hashedPassword = passwordEncoder.hash("admin123");
        var matched = passwordEncoder.verify("admin123", hashedPassword);
        assertEquals(true, matched);
    }

    @Test
    public void passwordEncoderEnumCryptoBCrypt() {
        var passwordEncoder = PasswordEncoder.create(CryptoType.BCRYPT);
        var hashedPassword = passwordEncoder.hash("admin123");
        var matched = passwordEncoder.verify("admin123", hashedPassword);
        assertEquals(true, matched);
    }

    @Test
    public void bCryptPasswordEncoderCryptoBCrypt() {
        var passwordEncoder = PasswordEncoder.create();
        var hashedPassword = passwordEncoder.hash("admin123");
        var matched = passwordEncoder.verify("admin123", hashedPassword);
        assertEquals(true, matched);
    }

    @Test
    public void passwordEncoderFactoryStringCryptoBCrypt() {
        var passwordEncoder = PasswordEncoderFactory.create().get("bcrypt")
                .orElse(BCryptPasswordEncoder.create());
        var hashedPassword = passwordEncoder.hash("admin123");
        var matched = passwordEncoder.verify("admin123", hashedPassword);
        assertEquals(true, matched);
    }

    @Test
    public void passwordEncoderFactoryEnumCryptoBCrypt() {
        var passwordEncoder = PasswordEncoderFactory.create().get(CryptoType.BCRYPT)
                .orElse(BCryptPasswordEncoder.create());
        var hashedPassword = passwordEncoder.hash("admin123");
        var matched = passwordEncoder.verify("admin123", hashedPassword);
        assertEquals(true, matched);
    }
}
