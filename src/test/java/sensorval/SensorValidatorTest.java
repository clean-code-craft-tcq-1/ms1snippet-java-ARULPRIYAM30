package sensorval;

import static org.junit.Assert.*;
import jdk.nashorn.internal.AssertsEnabled;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class SensorValidatorTest 
{
    @Test
    public void reportsErrorWhenSOCjumps()
    {
        Double[] readings = {0.0, 0.01, 0.5, 0.51};
        List<Double> socs = Arrays.asList(readings);
        assertFalse(SensorValidator.validateSOCreadings(socs));
    }
    @Test
    public void reportsErrorWhenCurrentjumps()
    {
        Double[] readings = {0.03, 0.03, 0.03, 0.33};
        List<Double> currents = Arrays.asList(readings);
        assertFalse(SensorValidator.validateCurrentreadings(currents));
    }
    
    @Test
    public void reportsErrorWhenCurrentAllValuesNull()
    {
       List<Double> readings = null;
       assertFalse(SensorValidator.validateCurrentreadings(readings));
    }
    @Test
    public void reportsErrorWhenCurrentHasNull()
    {
        Double[] readings = {0.03, 0.03, null, 0.33};
        List<Double> currents = Arrays.asList(readings);
        assertFalse(SensorValidator.validateCurrentreadings(currents));
    }
    
    @Test
    public void reportsErrorWhenSOCAllValuesNull()
    {
       List<Double> readings = null;
       assertFalse(SensorValidator.validateSOCreadings(readings));
    }
    @Test
    public void reportsErrorWhenSOCHasNull()
    {
        Double[] readings = {0.03, 0.03, null, 0.33};
        List<Double> socs = Arrays.asList(readings);
        assertFalse(SensorValidator.validateSOCreadings(socs));
    } 
}
