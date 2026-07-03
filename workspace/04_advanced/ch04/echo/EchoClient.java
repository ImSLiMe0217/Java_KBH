package ch04.echo;

import java.io.*;
import java.net.Socket;

public class EchoClient {
    void startClient() {
        try (
                // 서버에 접속 요청 (localhost:50000)
                Socket s = new Socket("localhost", 50000);
//                Socket s = new Socket("dain2.iptime.org", 50000);
        ) {
            BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
            // 연결 성공 시 Socket 객체 생성
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));    //  Socket 내의 InputStream을 생성
            PrintWriter out = new PrintWriter(new OutputStreamWriter(s.getOutputStream())); //  Socket 내의 OutputStream읆44  생성

            System.out.println("서버 접속 완료");
            String readLine = "";
            while ((readLine = key.readLine()) != null) {
                out.println(readLine);
                out.flush();
                String echoData = in.readLine();
                System.out.println(echoData);
            }
        } catch (IOException e) {
            System.err.println("네크워크 오류발생: " + e.getMessage());
        }
    }

    void main() {
        startClient();
    }
}
