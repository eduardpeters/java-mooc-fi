
public class A implements IA {

}

public class B extends A implements IB {

}

import java.util.ArrayList;

public class C extends B implements IC {

    private ArrayList<E> es;
}

import java.util.ArrayList;

public class E {

    private ArrayList<C> cs;
}

public class D {

    private IA interfaceIA;
}

public interface IA {
    
}

public interface IB {
    
}

public interface IC {
    
}
