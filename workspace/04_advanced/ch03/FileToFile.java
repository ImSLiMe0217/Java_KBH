package ch03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 2. 파일() -> 파일(output.txt)
public class FileToFile {
    void main() {
        try (
                FileInputStream fis = new FileInputStream("output.txt");
                FileOutputStream fos = new FileOutputStream("output-copy.txt")
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
}
