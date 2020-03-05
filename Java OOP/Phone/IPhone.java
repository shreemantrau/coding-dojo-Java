package abstraction;
public class IPhone extends Phone implements Ringable {
    
	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }
    @Override
    public String ring() {
        String s= "iphone "+ getVersionNumber() + " says "; 
    	return s+=getRingTone();
    }
    @Override
    public String unlock() {
        return "Unlocking via facial recogition!";
    }
    @Override
    public void displayInfo() {
    	System.out.println(iphoneInfo());
    }
}
