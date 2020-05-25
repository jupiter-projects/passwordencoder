package com.julianjupiter.passwordencoder;

import java.util.stream.Stream;

public enum CryptoType {
    ARGON2("argon2"),
    BCRYPT("bcrypt"),
    SCRYPT("scrypt");

    private final String value;

    CryptoType(String type) {
        this.value = type;
    }

    public static CryptoType of(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Crypto type must not be null or empty.");
        }

        return Stream.of(values())
                .filter(cryptoType -> cryptoType.value.equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid crypto type: " + type));
    }

    @Override
    public String toString() {
        return value;
    }
}
