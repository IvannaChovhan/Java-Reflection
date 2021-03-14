package hw;

import hw.exception.CPUFrequencyException;
import hw.exception.CoresException;
import hw.exception.RAMException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    Computer obj;

    @BeforeEach
    void initEach() {
        obj = new Computer();
    }

    @DisplayName("Should return string with switching on instruction")
    @Test
    void switchOnTest() {
        assertEquals("Switching on", obj.switchOn());
    }

    @DisplayName("Should return string with switching off instruction")
    @Test
    void switchOffTest() {
        assertEquals("Switching off", obj.switchOff());
    }

    @DisplayName("Should return string with reboot instruction")
    @Test
    void rebootTest() {
        assertEquals("Reboot...", obj.reboot());
    }

    @DisplayName("Should return threshed memory")
    @Test
    void cleanMemoryTest() {
        obj.setMemory(2400);
        assertEquals(2400, obj.cleanMemory());

        obj.setMemory(-8450);
        assertEquals(8450, obj.cleanMemory());

        obj.setMemory(0);
        assertEquals(0, obj.cleanMemory());
    }

    @DisplayName("Should return computer object wich have more memory")
    @Test
    void compareTest() {
        Computer c = new Computer();

        obj.setMemory(2400);
        c.setMemory(2400);
        assertEquals(obj, obj.compareByMemory(c));

        c.setMemory(5000);
        assertEquals(c, obj.compareByMemory(c));

        c.setMemory(1024);
        assertEquals(obj, obj.compareByMemory(c));
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