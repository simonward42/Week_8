public interface PrimeDivisorList {
	/**
	*	Adds a new divisor to the list.
	*	@param the divisor to add
	*	@throws NullPointerException if a null number is passed
	*	@throws IllegalArgumentException if a non-prime number is added
	*/
	void add(Integer divisor);
	/**
	*	Removes the first instance of a given Integer from the list.
	*	@param the divisor to be removed
	*	@return true if successfully found and removed, false otherwise
	*	@throws NullPointerException if a null number is passed
	*/
	boolean remove(Integer divisor);
	/**
	*	Removes the Integer at a given index from the list.
	*	@param the index of divisor to be removed
	*	@return true if successfully found and removed, false otherwise
	*	@throws IndexOutOfBoundsException if the index passed is out of bounds
	*/
	boolean remove(int index);
}