package hw;

import hw.exception.CPUFrequencyException;
import hw.exception.CoresException;
import hw.exception.RAMException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotebookTest {

    Notebook obj;

    @BeforeEach
    void initEach() {
        obj = new Notebook();
    }

    @DisplayName("Should return instruction that photo was made")
    @Test
    void makePhotoTest() {
        assertEquals("The photo was done", obj.makePhoto());
    }

    @DisplayName("Should return charging instruction")
    @Test
    void chargeTest() {
        assertEquals("Charging...", obj.charge());
    }

    @DisplayName("Should return notebook with larger diagonal")
    @Test
    void compareByDiagonalTest(){
        Notebook n = new Notebook();

        obj.setDiagonal(15);
        n.setDiagonal(7);
        assertEquals(obj, obj.compareByDiagonal(n));

        n.setDiagonal(15);
        assertEquals(obj, obj.compareByDiagonal(n));

        n.setDiagonal(17);
        assertEquals(n, obj.compareByDiagonal(n));
    }

    @DisplayName("Should return notebook with larger battery capacity")
    @Test
    void compareByBatteryTest(){
        Notebook n = new Notebook();

        obj.setBatteryCapacity(5000);
        n.setBatteryCapacity(7000);
        assertEquals(n, obj.compareByBattery(n));

        n.setBatteryCapacity(1500);
        assertEquals(obj, obj.compareByBattery(n));

        n.setBatteryCapacity(5000);
        assertEquals(obj, obj.compareByBattery(n));
    }

    @DisplayName("Should return notebook with more memory")
    @Test
    void compareByMemoryTest(){
        Notebook n = new Notebook();

        obj.setMemory(2000);
        n.setDiagonal(1000);
        assertEquals(obj, obj.compareByMemory(n));

        n.setMemory(2000);
        assertEquals(obj, obj.compareByMemory(n));

        n.setMemory(3000);
        assertEquals(n, obj.compareByMemory(n));
    }

    @DisplayName("Should throw CPUFrequencyException when CPUFrequency is not allowed")
    @Test
    void CPUFrequencyExceptionTest() {
        Assertions.assertThrows(CPUFrequencyException.class, () -> {
            obj.setCPU_frequency(1000);
        });
        Assertions.assertThrows(CPUFrequencyException.class, () -> {
            obj.setCPU_frequency(-2);
        });
    }

    @DisplayName("Should throw CoresException when number of cores is not allowed")
    @Test
    void CoresExceptionTest() {
        Assertions.assertThrows(CoresException.class, () -> {
            obj.setCores(1000);
        });
        Assertions.assertThrows(CoresException.class, () -> {
            obj.setCores(-2);
        });
    }

    @DisplayName("Should throw RAMException when RAM capacity is not allowed")
    @Test
    void RAMExceptionTest() {
        Assertions.assertThrows(RAMException.class, () -> {
            obj.setRAM(2000);
        });
        Assertions.assertThrows(RAMException.class, () -> {
            obj.setRAM(-2);
        });
    }
}