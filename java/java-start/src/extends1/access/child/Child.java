package extends1.access.child;

import extends1.access.parent.Parent;

public class Child extends Parent {
    public void call() {
        publicValue = 1;
        protectedValue = 1;
//        defaultValue = 1;//err
//        privateValue = 1;//err
        publicMethod();
        protectedMehtod();
//        defaultMethod();//err
//        privateMethod();//err
        printParent();
    }

}
