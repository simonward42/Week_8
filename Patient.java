public class Patient {
	private String name;
	private int age;
	private String illness;
	private Patient nextPatient;
	private Patient previousPatient;
	private static Patient lastPatient;
	private static Patient firstPatient;
	
	/**
	 *	@throws IllegalArgumentException if the age entered is negative or greater than 130.
	 */
	public Patient(String name, int age, String illness) throws IllegalArgumentException {
		this.name = name;
		this.age = age;
		if(age < 0 || age > 130) {
			throw new IllegalArgumentException();
		}
		this.illness = illness;
		this.nextPatient = null;
		this.previousPatient = null;
	}	
	
	public String name() {
		return this.name;
	}
	
	public int age() {
		return this.age;
	}
	
	public String illness() {
		return this.illness;
	}
	
	public Patient next() {
		return this.nextPatient;
	}
	
	public Patient previous() {
		return this.previousPatient;
	}
	
	public Patient last() {
		return lastPatient;
	}
	
	public Patient first() {
		return firstPatient;
	}
	
	public void addPatient(Patient newPatient) {
		if(this.nextPatient == null) {
			// last patient in the list
			this.nextPatient = newPatient;
			newPatient.previousPatient = this;
			lastPatient = this.nextPatient;
			if(this.previousPatient == null) {
				// must be first patient
				firstPatient = this;
			}
		} else {
			this.nextPatient.addPatient(newPatient);
		}
	}
	
	public boolean deletePatient(Patient patient) {
		if(this.nextPatient == null) {
			// patient to remove was not found
			return false;
		} else if (this.name.equals(patient.name)) {
			// patient to delete is first patient
			this.nextPatient.previousPatient = null;
			firstPatient = this.nextPatient;
			return true;
		} else if (this.nextPatient.name.equals(patient.name)) {
			// Found it! Need to delete next one -
			// so link this patient to the one after next...
			this.nextPatient = nextPatient.nextPatient;
			// and one after next (now next) to this one as long as this isn't last
			if(this.nextPatient !=null) {
				this.nextPatient.previousPatient = this;
			}
			// if deleted the lastPatient, make sure this is the new lastPatient
			else {
				lastPatient = this;
			}
			return true;
		} else {
			return this.nextPatient.deletePatient(patient);
		}
	}
}