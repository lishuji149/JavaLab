public class PrivateFunctions {

    @Show
    private static void secret(int arg) {
        System.out.println("Super secret information " + arg);
    }

    private static void superMegaSecret() {
        System.out.println("This one won't be accessed. I mean it.");
    }

    @Show(4)
    private static void superSecret() {
        System.out.println("This is an even more secret info");
    }

}
