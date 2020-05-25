package com.julianjupiter.passwordencoder;

import com.julianjupiter.passwordencoder.crypto.bcrypt.BCryptPasswordEncoder;

public interface PasswordEncoder {

    static PasswordEncoder create() {
        return BCryptPasswordEncoder.create();
    }

    static PasswordEncoder create(String cryptoType) {
        return PasswordEncoderFactory.create()
                .get(cryptoType)
                .orElseThrow(() -> new IllegalArgumentException("No PasswordEncoder is available for crypto " + cryptoType + "!"));
    }

    static PasswordEncoder create(CryptoType cryptoType) {
        return PasswordEncoderFactory.create()
                .get(cryptoType)
                .orElseThrow(() -> new IllegalArgumentException("No PasswordEncoder is available for crypto " + cryptoType.toString() + "!"));
    }

    String hash(CharSequence password);

    boolean verify(CharSequence password, String hashedPassword);
}
