package move;

public class Hero {
    private String name;
    private MoveType moveStrategy;

    public Hero() {
    }

    public Hero(String name, MoveType moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setMoveStrategy(MoveType moveStrategy) {

        this.moveStrategy = moveStrategy;
    }

    MoveType getMoveStrategy() {
        return moveStrategy;
    }

    void move() {
        System.out.print(name + " ");
        moveStrategy.move();
    }

}
