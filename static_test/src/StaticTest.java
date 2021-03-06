
public class StaticTest {

	static {
        System.out.println("This is first static block");
    }

    public StaticTest(){
        System.out.println("This is constructor");
    }

    public static String staticString = "Static Variable";

    static {
        System.out.println("This is second static block and "
		                                        + staticString);
    }

    public static void main(String[] args){
    	StaticTest st1 = new StaticTest();
    	StaticTest.staticMethod2();
    	StaticTest st2 = new StaticTest();
    	StaticTest st3 = new StaticTest();
    	StaticTest st4 = new StaticTest();
    	StaticTest st = new StaticTest();
    }

    static {
        staticMethod();
        System.out.println("This is third static block");
    }

    public static void staticMethod() {
        System.out.println("This is static method");
    }

    public static void staticMethod2() {
        System.out.println("This is static method2");
    }
}
