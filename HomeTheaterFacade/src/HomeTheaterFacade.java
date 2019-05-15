import Subsystem.*;

public class HomeTheaterFacade {
    /*
     * 组合：列出需要的子系统
     */
    Amplifier amp;
    Tuner tuner;
    DvdPlayer dvd;
    CdPlayer cd;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;

    public HomeTheaterFacade (Amplifier amp,
                              Tuner tuner,
                              DvdPlayer dvd,
                              CdPlayer cd,
                              Projector projector,
                              TheaterLights lights,
                              Screen screen,
                              PopcornPopper popper) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvd = dvd;
        this.cd = cd;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }

    /*
     * 将一组动作统一包装成一个统一的对外的方法，
     * 以实现“一键启动”
     */
    public void watchMovie (String movie) {
        System.out.println("Get ready to watch a " + movie + " ...");
        amp.on();
        tuner.on();
        dvd.on();
        cd.on();
        projector.on();
        lights.on();
        screen.up();
        popper.on();
        System.out.println();
    }

    /*
     * 虽然这一组动作被打包后，可以统一对外，
     * 但外部依然可以分别调用每一个子系统的方法；
     * 同时，一组子系统也可以有多个外观模式（即：按找不同的使用需求打包成不同的外观方法）
     */
    public void endMovie () {
        System.out.println("Shutting movie theater down...");
        amp.off();
        tuner.off();
        dvd.off();
        cd.off();
        projector.off();
        lights.off();
        screen.down();
        popper.off();
    }
}

/*
 * 外观模式：
 * 提供了一个统一的接口，用来访问子系统中的一群接口。
 * 外观定义了一个高层接口，让子系统更容易使用（简化接口）。
 *
 * 最少知识原则：
 * 减少对象之间的交互，只留下几个“密友”。
 * 在对象的方法内应用最少知识原则，应该只调用：
 * 1、该对象本身（this）；
 * 2、被当做方法的参数而传递进来的对象（形参）；
 * 3、此方法所创建或实例化的任何对象（局部变量）；
 * 4、对象的任何组件（成员变量）；
 */