package tree;

/**
 * @author tufei
 * @date 2018/1/10.
 */

public class EmptyTreeException extends RuntimeException{
    public EmptyTreeException(){
        super("Tree Empty!");
    }
}
