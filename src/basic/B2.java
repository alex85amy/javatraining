package basic;

public class B2 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from abc ");
        sb.append("where id=2");
//        System.out.println("StringBuffer : " + sb);
//        System.out.println(sb.length());
//        sb.delete(0, sb.length());
//        System.out.println("StringBuffer : " + sb);
        String s1 = "select * from abc ";
        String s2 = "where id=2";
        String s3 = " and name=a";
        s1 = s1 + s2 + s3;//利用buffer append 實現
        sb.append(s3);
        System.out.println("StringBuffer : " + sb);
        System.out.println(s1);

    }
}
