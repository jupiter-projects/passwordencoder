# PasswordEncoder
**PasswordEncoder** is a Java framework for hashing password.

This framework targets to provide password encoder for the following crypto functions:
1. BCrypt
2. Scrypt
3. Argon2

So far, only `BCrypt` has been implemented.

Clone and install this project:

```bash
git clone https://github.com/jupiter-projects/passwordencoder
cd passwordencoder
git checkout 1.0.1
./mvnw install
```

## Add to your project:

### Maven

```xml
<dependency>
    <groupId>com.julianjupiter</groupId>
        <artifactId>passwordencoder</artifactId>
    <version>1.0.1</version>
</dependency>
```

### Gradle

```groovy
implementation 'com.julianjupiter:passwordencoder:1.0.1'
```

## BCrypt

This framework uses [jBcrypt](http://www.mindrot.org/projects/jBCrypt/) library.

To use `BCrypt` function, it needs an instance of `BCryptPasswordEncoder`. There are many ways to do so:

```java
PasswordEncoder passwordEncoder = BCryptPasswordEncoder.create();
```
```java
PasswordEncoder passwordEncoder = PasswordEncoderFactory.create()
        .get("bcrypt")
        .orElse(BCryptPasswordEncoder.create());
```
```java
PasswordEncoder passwordEncoder = PasswordEncoderFactory.create()
        .get(CryptoType.BCRYPT)
        .orElse(BCryptPasswordEncoder.create());
```
```java
// For this framework, BCryptPasswordEncoder is intended to be the default password encoder
PasswordEncoder passwordEncoder = PasswordEncoder.create();
```
```java
PasswordEncoder passwordEncoder = PasswordEncoder.create("bcrypt");
```
```java
PasswordEncoder passwordEncoder = PasswordEncoder.create(CryptoType.BCRYPT);
```

Then, use `hash(password)` method to get hashed password:

```java
String password = "mypassword";
String hashedPassword = passwordEncoder.hash(password);
```

To validate if given password and hashed password match, use `verify(password, hashedPassword)` method:
```java
String password = "mypassword";
String hashedPassword = // retrieve hashed password from database/storage
boolean matched = passwordEncoder.verify(password, hashedPassword);
```
