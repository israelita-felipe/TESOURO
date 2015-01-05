/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tesouro.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Cliente
 */
public class FileManager {

    /**
     * Transforma um arquivo em <code>bytes[]</code>
     *
     * @param f
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static byte[] getByteFromFile(File f) throws FileNotFoundException, IOException {

        //converte o objeto file em array de bytes
        InputStream is = new FileInputStream(f);
        byte[] bytes = new byte[(int) f.length()];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        return bytes;
    }

    /**
     * Retorna um arquivo por meio de conversão de <code>bytes[]</code> em
     * <code>File</code>
     *
     * @param bytes
     * @param fileName
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static File getFileFromByte(byte[] bytes, String fileName) throws FileNotFoundException, IOException {
        File f = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(f)) {
            fos.write(bytes);
        }
        return f;
    }
}
