public class Interface {

}


interface Pet {
    public abstract void beFriendly();
    public abstract void play();
    void sleep();
}


abstract class Mammals {

}

class Canine extends Mammals{

}

class Rabbits extends Canine implements Pet {
    @Override
    public void beFriendly() {

    }

    @Override
    public void play() {

    }
    public void sleep() {

    }
}