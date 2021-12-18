import com.sun.security.jgss.GSSUtil;

public class Test {

    @MyAnnotation()
    private void method01(){

        System.out.println("method01");
    }

    @MyAnnotation(3)
    private void method02(){

        System.out.println("method02");
    }

    @MyAnnotation(5)
    private void method03(){

        System.out.println("method03");
    }

    private void method04(){

        System.out.println("method04");
    }

}
