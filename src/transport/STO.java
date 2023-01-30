package transport;

import java.util.List;
import java.util.Queue;

public class STO {

    private Queue<Transport> queue;

    public STO(Queue<Transport> queue) {
        this.queue = queue;
    }

    public void addCarYoQueue(Transport transport) {
        if (transport.checkTransportNeedSTO()) {
            queue.add(transport);
        }
    }

    public void carryOutAVehicleInspection(Queue<Transport> queue) {
        if (queue.isEmpty()) {
            System.out.println("У данного транспортного средства нет механиков");
        } else {
            for (int i = 0; i < queue.size(); i++ ) {
                Mechanic mechanic = (Mechanic) queue.poll().getMechanics().get(0);
                mechanic.maintenance();
            }
        }


    }
}
