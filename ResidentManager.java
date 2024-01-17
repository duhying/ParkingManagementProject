package Project3;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


class ResidentManager {
    String name1;
    String name2;
    String name3;
    String PhoneNo1;
    String PhoneNo2;
    String PhoneNo3;
    String result;

    int count;

    String[][] res_arr = new String[3][2];   

    // txt파일을 로드하는 메서드 : ' ' 단위로 나눠서 배열로 저장
    public void getTxt() throws IOException {
        try {
            /*
             * File : data.txt 파일을 부르고
             * FileReader : data.txt 파일의 내용을 읽고
             * BufferedReader : 효율적으로 data.txt의 내용을 읽기 위해 (readLine)
             */
            BufferedReader br = new BufferedReader(new FileReader(new File("res.txt")));
            String str = "";

            //  res.txt의 첫 번째 한 줄(정수 부분)을 읽음
            String countStr = br.readLine();

            // count 정수로 변환 
            count = Integer.parseInt(countStr);

            // res.txt의 두번째줄부터 마지막줄까지(String 부분) 읽는 Loop문.
            int i = 0;
            while ((str = br.readLine()) != null && i < 3) { // 한줄을 읽었을때 null값이 나올때까지 계속 반복
                // System.out.println("readline결과 : "+ str);
                this.res_arr[i] = str.split(" ");
                for (int j = 0; j < res_arr[i].length; j++) {
                    //System.out.println("\t배열저장값 ["+ i +"]["+ j + "] : "+res_arr [i][j]);
                } // end for
                i++;
            } // end while

        } catch (FileNotFoundException e) {
            System.out.println("파일명을 찾을 수 없습니다.");
        } catch (NullPointerException e) {
            System.out.println("Err : " + e);
        } // end try-catch
    } // end getTxt()

    public void getname(int i){ //resident 코드 (1 : 홍길동, 2 : 이순신, 3 : 강감찬)
        this.name1=res_arr[i][1];
        this.name2=res_arr[i][1];
        this.name3=res_arr[i][1];
       } //end getScr()
       
    public void getPhoneNo(int i){ //resident 코드 (1 : 010-1111-1111, 2 : 010-2222-2222, 3 : 010-3333-3333)
        this.PhoneNo1=res_arr[i][0];
        this.PhoneNo2=res_arr[i][0];
        this.PhoneNo3=res_arr[i][0];
       } //end getScr()

    // 최종결과 문자열 정리
    public void getResStr(){
        result = name1 + "\t"+ PhoneNo1 + "\n" + name2 + "\t"+ PhoneNo2 + "\n" + name3 + "\t"+ PhoneNo3 + "\n";
    }

    // res_arr 배열을 반환하는 getter 메서드
    public String[][] getResArr() {
        return res_arr;
    }
 
      
    public static void main(String[] args) throws Exception {

        ResidentManager obj=new ResidentManager();
        obj.getTxt();

        for (int i = 0; i < obj.count; i++) {
            obj.getname(i);
            obj.getPhoneNo(i);
            obj.getResStr();
            System.out.println(obj.result);
        }
  
    }
}
