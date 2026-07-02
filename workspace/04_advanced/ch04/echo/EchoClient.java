package ch04.echo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {
    void startClient() {
        try (
                // 서버에 접속 요청 (localhost:50000)
                Socket s = new Socket("localhost", 50000);
//                Socket s = new Socket("dain2.iptime.org", 50000);
                // 연결 성공 시 Socket 객체 생성
                InputStream in = s.getInputStream();    //  Socket 내의 InputStream을 생성
                OutputStream out = s.getOutputStream()  //  Socket 내의 OutputStream읆44  생성
        ) {
            int readData = 0;
            while ((readData = System.in.read()) != -1) {
                out.write(readData);
                int echoData = in.read();
                System.out.write(echoData);
            }
        } catch (IOException e) {
            System.err.println("네크워크 오류발생: " + e.getMessage());
        }
    }

    void main() {
        startClient();
    }
}
