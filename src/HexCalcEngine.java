/**
 * In this subclass of CalcEngine we only have one method that is to be overwritten, numberPressed()
 * @author Elisa
 *
 */
public class HexCalcEngine extends CalcEngine {
	
	@Override
	public void numberPressed(int number){
		 if(buildingDisplayValue) {
	            // Incorporate this digit.
	            displayValue = displayValue*16 + number;
	            
	        }
	        else {
	            // Start building a new number.
	            displayValue = number;
	            buildingDisplayValue = true;
	}
}
}
