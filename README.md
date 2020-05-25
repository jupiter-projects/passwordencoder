# PasswordEncoder
**PasswordEncoder** is a Java framework for hashing password.

This framework targets to provide password encoder for the crypto functions:
1. BCrypt
2. Scrypt
3. Argon2

So far, only `BCrypt` has been implemented.

Clone this project and install:
```
git clone https://github.com/jupiter-projects/passwordencoder
cd passwordencoder
git checkout 1.0.x
./mvnw install
```

## BCrypt
This framework uses [jBcrypt](http://www.mindrot.org/projects/jBCrypt/) library.

To use `BCrypt` function, it needs an instance of `BCryptPasswordEncoder`: There are many ways to do so:

```java
PasswordEncoder passwordEncoder = BCryptPasswordEncoder.create();
```
```java
PasswordEncoder passwordEncoder = PasswordEncoderFactory.get("bcrypt")
        .orElse(null);
```
```java
PasswordEncoder passwordEncoder = PasswordEncoderFactory.get(CryptoType.BCRYPT)
        .orElse(null);
```
```java
PasswordEncoder passwordEncoder = PasswordEncoder.create(); // For this framework, BCryptPasswordEncoder is intended to be the default password encoder
```
```java
PasswordEncoder passwordEncoder = PasswordEncoder.create("bcrypt");
```
```java
PasswordEncoder passwordEncoder = PasswordEncoder.create(CryptoType.BCRYPT);
```

Then, use `hash(password)` method to get the hashed password:

```java
String password = "mypassword";
String hashedPassword = passwordEncoder.hash(password);
```

To validate if given password and hashed password are the same, use `verify(password, hashedPassword)` method:
```java
String password = "mypassword";
String hashedPassword = passwordEncoder.hash(password);
boolean matched = passwordEncoder.verify(password, hashedPassword);
```
