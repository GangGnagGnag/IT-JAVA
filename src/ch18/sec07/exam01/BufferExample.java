package ch18.sec07.exam01;

import java.io.*;

public class BufferExample {
    public static void main(String[] args) throws Exception {
//        입출력 스트림 생성
        String originalFilePath1 =
               "./game.jpg";
        String targetFilePath1 = "./targetgame.jpg";
        FileInputStream fis = new FileInputStream(originalFilePath1);
        FileOutputStream fos = new FileOutputStream(targetFilePath1);

//        입출력 스트림 + 버터 스트림 생성
        String originalFilePath2 =
               "./copygame.jpg";
        String targetFilePath2 = "./targetgame2.jpg";
        FileInputStream fis2 = new FileInputStream(originalFilePath2);
        FileOutputStream fos2 = new FileOutputStream(targetFilePath2);
        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);

//        버퍼를 사용하지 않고 복사
        long nonBufferTime = copy(fis, fos);
        System.out.println("버퍼 미사용:\t" + nonBufferTime + "ns" );

//        버퍼를 사용하고 복사
        long BufferTime = copy(bis, bos);
        System.out.println("버퍼사용:\t" + BufferTime + "ns");

        fis.close();
        fos.close();
        bis.close();
        bos.close();
    }
    public static long copy(InputStream is, OutputStream os)throws Exception {
//        시작 시간 저장
        long start = System.nanoTime();
//        1 바이트를 읽고 1바이트를 출력
        while (true) {
            int data = is.read();
            if (data == -1) break;
            os.write(data);
        }
        os.flush();
//        끝 시간 저장
        long end = System.nanoTime();
//        복사 시간 리턴
        return (end-start);
    }
}
