package ch03;

import java.io.*;

// 2. 파일() -> 파일(output.txt)
public class FileCopyTest {
    void main() {
        long start = System.currentTimeMillis();
//        copyFile("output.txt", "output-copy");
//        copyFileUseBuffer("output.txt", "output-copy");
//        copyFileCustomBuffer("output.txt", "output-copy.txt");

//        copyFile("lib/mysql-connector-j-9.7.0.jar", "mysql-connector-j-9.7.0.jar");
//        copyFileUseBuffer("lib/mysql-connector-j-9.7.0.jar", "mysql-connector-j-9.7.0.jar");
        copyFileCustomBuffer("lib/mysql-connector-j-9.7.0.jar", "mysql-connector-j-9.7.0.jar");

        long end = System.currentTimeMillis();
        System.out.println("소요시간: " + (end - start) + "ms");
    }

    /**
     * 1차 Stream (FileInputStream, FileOutputStream)을 이용해서 파일을 복사
     *
     * @param origin 원본 파일명
     * @param dest   새로 생성될 파일명
     */
    void copyFile(String origin, String dest) {
        try (
                InputStream fis = new FileInputStream(origin); // 없으면 새로 생성, 있으면 덮어씌우기
                OutputStream fos = new FileOutputStream(dest); // 없으면 새로 생성, 있으면 덮어씌우기
        ) {
            // 표준 입력 장치로부터 1byte 읽어옴
            int readData = 0;
            while ((readData = fis.read()) != -1) {
                // 표준 출력 장치로 1byte 출력
                fos.write(readData);
            }
        } catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }

    /**
     * 2차 Stream (BufferedInputStream, BufferedOutputStream)을 이용해서 파일을 복사
     *
     * @param origin 원본 파일명
     * @param dest   새로 생성될 파일명
     */
    void copyFileUseBuffer(String origin, String dest) {
        try (
                // 2차 스트림: 혼자서는 생성 못함 -> 생성자에 1차  스트림을 넘겨줘서 생성
                InputStream bis = new BufferedInputStream(new FileInputStream(origin));
                OutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))
        ) {
            // 표준 입력 장치로부터 1byte 읽어옴
            int readData = 0;
            while ((readData = bis.read()) != -1) {
                // 표준 출력 장치로 1byte 출력
                bos.write(readData);
            }
        } catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }

    /**
     * 1차 Stream (FIleInputStream, FIleOutputStream)을 이용해서 파일을 복사
     *
     * @param origin 원본 파일명
     * @param dest   새로 생성될 파일명
     */
    void copyFileCustomBuffer(String origin, String dest) {
        try (
                InputStream fis = new FileInputStream(origin);
                OutputStream fos = new FileOutputStream(dest)
        ) {
            byte[] buffer = new byte[1024 * 8]; // 8KB의 버퍼 생성
            int readSize = 0;
            while ((readSize = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, readSize);
            }
        } catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}
