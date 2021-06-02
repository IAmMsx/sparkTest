public class Msxtest {
    public static void main(String[] args) {
        byte b = 10;
        test(b);
        // 自动类型转换原则：找最近的上类型
//        byte ->short ->int
//        char ->int

    }

    private static void test(byte b) {
        System.out.println("byte");
    }

    private static void test(short b) {
        System.out.println("short");
    }

    private static void test(int b) {
        System.out.println("int");
    }

    private static void test(char b) {
        System.out.println("char");
    }

    public void printTest() {
        System.out.println("hello test");
    }
}
