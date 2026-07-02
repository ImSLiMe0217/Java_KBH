package ch03;

import java.io.FileOutputStream;
import java.io.IOException;

public class KeyboardToFile {
    // 2. 표준입력장치(키보드) -> 파일(output.txt)
    void main() {
        try (
                FileOutputStream fos = new FileOutputStream("output.txt"); // 없으면 새로 생성, 있으면 덮어씌우기
        ) {
            // 표준 입력 장치로부터 1byte 읽어옴
            int readData = 0;
            while ((readData = System.in.read()) != -1) {
                // 표준 출력 장치로 1byte 출력
                fos.write(readData);
            }
        } catch (IOException e) {
            System.err.println("입출력 예외 발생: " + e.getMessage());
        }
    }
}
