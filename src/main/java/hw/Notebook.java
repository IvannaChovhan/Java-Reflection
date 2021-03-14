package hw;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Notebook extends Computer implements MemoryInterface {
    private String OC;
    private double diagonal;
    private int batteryCapacity;

    @CustomNotation
    public String makePhoto() {
        return "The photo was done";
    }

    @CustomNotation
    public String charge() {
        return "Charging...";
    }

    public Notebook compareByDiagonal(Notebook n){
        if (n.getDiagonal() > this.diagonal)
            return n;
        else
            return this;
    }

    public Notebook compareByBattery(Notebook n){
        if (n.getBatteryCapacity() > this.batteryCapacity)
            return n;
        else
            return this;
    }
}
