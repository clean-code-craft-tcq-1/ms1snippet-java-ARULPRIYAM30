package sensorval;

import java.util.List;

public class SensorValidator 
{
	static final double MAX_SOC_VALUE=0.05;
	static final double MAX_CURRENT_VALUE=0.1;
	
    private static boolean checkSuddenJump(double value, double nextValue, double maxDelta) {
    	return (nextValue - value > maxDelta);
    }
    public static boolean validateSOCreadings(List<Double> values) {
    	return isValid(values)? validateReadings(values,MAX_SOC_VALUE):false;
    }
	public static boolean validateCurrentreadings(List<Double> values) {
    	return isValid(values)? validateReadings(values,MAX_CURRENT_VALUE):false;
    }
    private static boolean isValid(List<Double> values) {
		return notNull(values) && noNullContent(values);
	}
	private static boolean noNullContent(List<Double> values) {
		return !values.contains(null);
	} 
    private static boolean notNull(List<Double> values) {
    	return (values!=null && values.size()>0);
    }
    
  public static boolean validateReadings(List<Double> values,double maxInterval){
    	int lastButOneIndex = values.size() - 1;
        for(int i = 0; i < lastButOneIndex; i++) {
            if(checkSuddenJump(values,i,maxInterval)) {
            return false;
            }
        }
        return true;
    }
}

