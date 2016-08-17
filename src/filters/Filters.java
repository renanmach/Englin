package filters;

public class Filters {
	private boolean lowercased = false;
	private boolean removeAccents = false;
	private boolean removeSpecials = false;
	private boolean keepSpecials = true;
	
	public String applyFilters(String input) {
		String output = input;
		
		if(lowercased) {
			output = output.toLowerCase();
		}
		
		// TODO implement
		if(removeAccents) {
			
		}
		
		if(removeSpecials) {
			
		}
		
		else if(keepSpecials) {
			
		}
		
		return output;
	}

	public boolean isLowercased() {
		return lowercased;
	}

	public void setLowercased(boolean lowercased) {
		this.lowercased = lowercased;
	}

	public boolean isRemoveAccents() {
		return removeAccents;
	}

	public void setRemoveAccents(boolean removeAccents) {
		this.removeAccents = removeAccents;
	}

	public boolean isRemoveSpecials() {
		return removeSpecials;
	}

	public void setRemoveSpecials(boolean removeSpecials) {
		this.removeSpecials = removeSpecials;
	}

	public boolean isKeepSpecials() {
		return keepSpecials;
	}

	public void setKeepSpecials(boolean keepSpecials) {
		this.keepSpecials = keepSpecials;
	}
}
