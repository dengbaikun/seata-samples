package io.seata.sample;

import java.io.*;
import java.util.UUID;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2022-09-05 20:10
 * @Created by DK
 */
public class Main {

    public static void main(String[] args) {
        try (PrintWriter p = new PrintWriter(new BufferedWriter(new FileWriter(new File("B:/p_p.sql"))))) {
            for (int i = 0; i < 3_000_000; i++) {
                String sql = "INSERT INTO `p_p`(`ID`, `C_TIME`, `P_CODE`, `P_NAME`, `P_TYPE`, `P_VALUE`, `P_VALUE_TYPE`, `P_VERSION`, `P_A_ID`, `UPDATE_TIME`) VALUES ('"+ UUID.randomUUID().toString() +"', '2022-03-22 11:22:45', 'areaStartTime', NULL, '00', '201904', 'string', 0, '93b6c441-89bf-48da-a07d-41d955fd3e43', NULL);";
                p.println(sql);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
