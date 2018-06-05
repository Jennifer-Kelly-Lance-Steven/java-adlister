public class StackTraceExample {
    private static void a() throws Exception {
        b();
    }

    private static void b() throws Exception {
        c();
    }

    private static void c() throws Exception {
        d();
    }

    private static void d() throws Exception {
        throw new Exception("Something Bad Happened!");
    }

    public static void main(String[] args) throws Exception {
        a();
    }

//    private static void x() {
//        y();
//    }
//
//    private static void y() {
//        z();
//    }
//
//    private static void z() {
//        try {
//            a();
//        } catch (Exception e) {
//            throw new RuntimeException("Ahhhhhh!!!!", e);
//        }
//    }
}
