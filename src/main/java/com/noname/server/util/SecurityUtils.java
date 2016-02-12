package com.noname.server.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.noname.server.entity.Credential;

/**
 * Created by lacau on 12/02/16.
 */
public final class SecurityUtils {

    private SecurityUtils() {
        throw new IllegalStateException("SecurityUtils class shouldn't be instantiated!");
    }

    public static String generateToken(Credential credential) {
        StringBuilder sb = new StringBuilder();
        sb.append(credential.getLogin());
        sb.append(":");
        sb.append(credential.getPassword());

        byte[] bytes = encryptValue(sb.toString(), "SHA-512");
        return convertToHex(bytes);
    }

    public static String generateSHA256Password(String password) {
        return convertToHex(encryptValue(password, "SHA-256"));
    }

    private static String convertToHex(byte[] raw) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < raw.length; i++) {
            sb.append(Integer.toString((raw[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    private static byte[] encryptValue(String value, String algorithm) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance(algorithm);
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return md.digest(value.getBytes());
    }
}
