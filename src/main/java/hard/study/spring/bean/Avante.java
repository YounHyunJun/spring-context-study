package hard.study.spring.bean;

public class Avante extends AbstractCar {

    public Avante() {}

    public Avante(String name) {
        this.name = name;
    }

    private String name;

    private Engine engine;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void run() {
        System.out.println(getName() + " 달리다");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Avante{" +
                "name='" + name + '\'' +
                ", engine=" + engine +
                '}';
    }
}