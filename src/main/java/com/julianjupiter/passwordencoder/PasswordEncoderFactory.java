package com.julianjupiter.passwordencoder;

import com.julianjupiter.passwordencoder.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class PasswordEncoderFactory {
    private final Map<CryptoType, Supplier<PasswordEncoder>> map = Map.of(
            CryptoType.BCRYPT, BCryptPasswordEncoder::create
    );

    private PasswordEncoderFactory() {

    }

    public static PasswordEncoderFactory create() {
        return new PasswordEncoderFactory();
    }

    public Optional<PasswordEncoder> get(String cryptoType) {
        if (cryptoType == null || cryptoType.isBlank()) {
            throw new IllegalArgumentException("Crypto type must not be null or empty.");
        }

        Supplier<PasswordEncoder> passwordEncoderSupplier = map.get(CryptoType.of(cryptoType));

        if (passwordEncoderSupplier != null) {
            return Optional.of(passwordEncoderSupplier.get());
        }

        return Optional.empty();
    }

    public Optional<PasswordEncoder> get(CryptoType cryptoType) {
        if (cryptoType == null) {
            throw new IllegalArgumentException("Crypto type must not be null.");
        }

        Supplier<PasswordEncoder> passwordEncoderSupplier = map.get(cryptoType);

        if (passwordEncoderSupplier != null) {
            return Optional.of(passwordEncoderSupplier.get());
        }

        return Optional.empty();
    }
}
