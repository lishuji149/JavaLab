package Matrix;

public class FileDoesNotExistException extends Exception {
    public FileDoesNotExistException(String str){
        super(str);
    }
}
