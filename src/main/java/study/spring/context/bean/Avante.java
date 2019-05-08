package study.spring.context.bean;

public class Avante extends AbstractCar {

    public Avante() {}

    public Avante(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void run() {
        System.out.println(getName() + " 달리다");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Avante{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}