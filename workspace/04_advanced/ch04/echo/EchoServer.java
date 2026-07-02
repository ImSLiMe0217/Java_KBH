package ch04.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트로부터 수신된 메세지를 그대로 반송
// 네트워크 프로그램 개발 시 가장 먼저 만들어 클라이언트와 서버 간의 통신 상태를 확인할 때 사용
public class EchoServer {
    void startServer() {
        try (
                // 서버소켓 생성
                ServerSocket ss = new ServerSocket(50000);
        ) {
            System.out.println("ServerSocket 생성 완료.");
            // 클라이언트의 접속 대기
            Socket s = ss.accept(); // 블로킹 작업 (이 위치에서 멈춤)
            System.out.println("클라이언트 접속: " + s.getInetAddress().getHostAddress());

            // 클라이언트의 메세지를 수신하는 InputStream을 생성
            InputStream in = s.getInputStream();
            // 클라이언트에 메세지를 송신하는 OutputStream 생성
            OutputStream out = s.getOutputStream();

            int readData = 0;
            while ((readData = in.read()) != -1) {
                // 표준 출력 장치로 1byte 출력
                out.write(readData);    // 클라이언트에 메세지를 반송
                System.out.write(readData); // 클라이언트의 메세지를 서버에도 출력
            }
        } catch (IOException e) {
            System.err.println("네트워크 오류: " + e.getMessage());
        }
    }

    void main() {
        startServer();
    }
}
