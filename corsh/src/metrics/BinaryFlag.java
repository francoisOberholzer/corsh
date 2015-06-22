package metrics;

public class BinaryFlag implements Cloneable{
	private int numBits;
	private boolean[] bits;
    
	public BinaryFlag(int n) {
		numBits = n;
		bits = new boolean[numBits];
		for(int i = 0; i < numBits; i++)
			bits[i] = false;
	}
          
	public Object clone() throws CloneNotSupportedException {
		BinaryFlag copy = (BinaryFlag)super.clone();
		copy.numBits = this.numBits;
		copy.bits = new boolean[numBits];
        for (int i=0; i<numBits; i++)
        	copy.bits[i] = this.bits[i];
        return copy;
	}
	
	public String toString() {
	  String s = "";
	  for (int i=numBits-1; i>=0; i--) {
		  if(bits[i])
		    s = s + "1";
		  else
		    s = s + "0";
	  }
	  return s;
	}
	
	public boolean next() {
		for(int i = 0; i < numBits; i++) {
			if(bits[i] == false) {
				bits[i] = true;
				return true;
			}
			else {
				bits[i] = false;
			}     
		}
	    return false; 
	}
	
	public boolean isSet(int i) {
	    return bits[i];
	}
	  
	public void flipBit(int i) {
	    bits[i] = !bits[i];
	}
}
