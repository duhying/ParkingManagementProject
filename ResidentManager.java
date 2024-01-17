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

    // txt������ �ε��ϴ� �޼��� : ' ' ������ ������ �迭�� ����
    public void getTxt() throws IOException {
        try {
            /*
             * File : data.txt ������ �θ���
             * FileReader : data.txt ������ ������ �а�
             * BufferedReader : ȿ�������� data.txt�� ������ �б� ���� (readLine)
             */
            BufferedReader br = new BufferedReader(new FileReader(new File("res.txt")));
            String str = "";

            //  res.txt�� ù ��° �� ��(���� �κ�)�� ����
            String countStr = br.readLine();

            // count ������ ��ȯ 
            count = Integer.parseInt(countStr);

            // res.txt�� �ι�°�ٺ��� �������ٱ���(String �κ�) �д� Loop��.
            int i = 0;
            while ((str = br.readLine()) != null && i < 3) { // ������ �о����� null���� ���ö����� ��� �ݺ�
                // System.out.println("readline��� : "+ str);
                this.res_arr[i] = str.split(" ");
                for (int j = 0; j < res_arr[i].length; j++) {
                    //System.out.println("\t�迭���尪 ["+ i +"]["+ j + "] : "+res_arr [i][j]);
                } // end for
                i++;
            } // end while

        } catch (FileNotFoundException e) {
            System.out.println("���ϸ��� ã�� �� �����ϴ�.");
        } catch (NullPointerException e) {
            System.out.println("Err : " + e);
        } // end try-catch
    } // end getTxt()

    public void getname(int i){ //resident �ڵ� (1 : ȫ�浿, 2 : �̼���, 3 : ������)
        this.name1=res_arr[i][1];
        this.name2=res_arr[i][1];
        this.name3=res_arr[i][1];
       } //end getScr()
       
    public void getPhoneNo(int i){ //resident �ڵ� (1 : 010-1111-1111, 2 : 010-2222-2222, 3 : 010-3333-3333)
        this.PhoneNo1=res_arr[i][0];
        this.PhoneNo2=res_arr[i][0];
        this.PhoneNo3=res_arr[i][0];
       } //end getScr()

    // ������� ���ڿ� ����
    public void getResStr(){
        result = name1 + "\t"+ PhoneNo1 + "\n" + name2 + "\t"+ PhoneNo2 + "\n" + name3 + "\t"+ PhoneNo3 + "\n";
    }

    // res_arr �迭�� ��ȯ�ϴ� getter �޼���
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
