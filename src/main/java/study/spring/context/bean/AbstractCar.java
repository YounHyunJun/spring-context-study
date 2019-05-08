package study.spring.context.bean;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractCar implements Car{

    private Engine engine;

    @Autowired
    private Wheel wheel;

    public void on() {
        System.out.println("시동을 켜다");
    }

    public void running() {
        engine.run();
        run();
    }

    public void changeWheel() {
        wheel.change();
    }

    protected abstract void run();

    public void off() {
        System.out.println("시동을 끄다");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheel getWheel() {
        return wheel;
    }

    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }
}