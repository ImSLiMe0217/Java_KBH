package ch03;

import java.io.FileInputStream;
import java.io.IOException;

// 3. 파일(output.txt) -> 표준출력장치(콘솔)
public class FileToConsole {
    void main() {
        try (
                FileInputStream fis = new FileInputStream("output.txt"); // 없으면 새로 생성, 있으면 덮어씌우기
        ) {
            // 표준 입력 장치로부터 1byte 읽어옴
            int readData = 0;
            while ((readData = fis.read()) != -1) {
                // 표준 출력 장치로 1byte 출력
                System.out.write(readData);
            }
        } catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}
