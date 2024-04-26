package basic;

public class B2 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select * from abc ");
        stringBuffer.append("where id=2");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.length());
        stringBuffer.delete(0,stringBuffer.length());
        System.out.println(stringBuffer);

    }
}
