package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import core.mate.academy.producers.BulldozerProducer;
import core.mate.academy.producers.ExcavatorProducer;
import core.mate.academy.producers.TruckProducer;
import java.util.ArrayList;
import java.util.List;

public class MachineServiceImpl implements MachineService<Machine> {

    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {
        if (type == Bulldozer.class) {
            return new ArrayList<>(new BulldozerProducer().get());
        }
        if (type == Excavator.class) {
            return new ArrayList<>(new ExcavatorProducer().get());
        }
        if (type == Truck.class) {
            return new ArrayList<>(new TruckProducer().get());
        }
        return new ArrayList<>();
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i,value);
        }
    }
}
