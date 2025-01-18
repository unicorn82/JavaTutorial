package com.unicorn.utils;

import java.io.IOException;
import java.nio.file.Path;

public class CryptoUtil {

    /**
     * Decrypt as Byte Array, if encrypted, else return the original file contents.
     *
     * @param inputFile encrypted file path
     * @return Decrypted Byte array of the content.
     */
    public static byte[] decryptAsByteArray(Path inputFile) {
        long lastArrayIndex = inputFile.toFile().length() -1;
        return decryptAsByteArray(inputFile, 0, lastArrayIndex);
    }

    public static byte[] decryptAsByteArray(Path inputFile, long from, long to) {
        byte[] decryptedData = null;
        try {
            decryptedData = verifyAndDecryptAsByteArray(inputFile);
        } catch (Exception baseException) {
           baseException.printStackTrace();
        }
        return decryptedData;
    }

    public static byte[] verifyAndDecryptAsByteArray(Path inputFile) throws Exception {
        byte[] decryptedData = null;

        return decryptedData;
    }


}
