package circuit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResistorElmTest
{
    ResistorElm resistor;

    @Before
    public void setUp() {
        resistor = new ResistorElm(0, 0);
    }

    @Test
    public void currentTest()
    {
        resistor.resistance = 100;
        resistor.volts[1]=0;
        resistor.volts[0]=5;

        resistor.calculateCurrent();

        assertEquals(0.05, resistor.current, 0.001);
    }

}
