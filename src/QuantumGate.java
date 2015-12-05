/* Implementation of Quantum Gates as matrices of complex numbers.
 * Author: J. Colin Crowley
 */

public class QuantumGate 
{
	public ComplexNumber[][] matrix; 
	public int size;
	
	public QuantumGate(int s)
	{
		size = s;
		matrix = new ComplexNumber[s][s];
	}
	
	public ComplexNumber[] act(ComplexNumber[] globalStates)
	{
		ComplexNumber[] newGlobalStates = new ComplexNumber[size];
		ComplexNumber sum = new ComplexNumber();
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				sum = sum.add(globalStates[j].multiply(matrix[j][i]));
			}
			newGlobalStates[i] = sum;
			sum = new ComplexNumber();
		}
		return newGlobalStates;
	}
	
}
