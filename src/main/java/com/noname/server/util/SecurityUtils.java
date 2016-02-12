package com.noname.server.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.noname.server.entity.Credential;

/**
 * Created by lacau on 12/02/16.
 */
public class SecurityUtils {

    private SecurityUtils() {
    }

    public static String generateToken(Credential credential) {
        StringBuilder sb = new StringBuilder();
        sb.append(credential.getLogin());
        sb.append(":");
        sb.append(credential.getPassword());

        byte[] bytes = generateSHA512(sb.toString());
        return convertToHex(bytes);
    }

    private static String convertToHex(byte[] raw) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < raw.length; i++) {
            sb.append(Integer.toString((raw[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    private static byte[] generateSHA512(String value) {
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return md.digest(value.getBytes());
    }
}
