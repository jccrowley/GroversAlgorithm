/* Implementation of Hadamard Gates, which are used to form uniform
 * distributions of superpositions from absolute states and vice versa.
 * Author: J. Colin Crowley
 */

public class HadamardGate extends QuantumGate
{
	public HadamardGate(int nQubits) 
	{
		super((int) Math.pow(2, nQubits));
		if(nQubits == 0)
		{
			matrix[0][0] = new ComplexNumber(1, 0);
		}
		else
		{
			initializeQuadrant(0, (size-1)/2, 0, (size-1)/2, new ComplexNumber(1, 0));
			initializeQuadrant(((size-1)/2)+1, (size-1), 0, (size-1)/2, new ComplexNumber(1, 0));
			initializeQuadrant(0, (size-1)/2, ((size-1)/2)+1, (size-1), new ComplexNumber(1, 0));
			initializeQuadrant(((size-1)/2)+1, (size-1), ((size-1)/2)+1, (size-1), new ComplexNumber(-1, 0));
		}
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				matrix[i][j].multiply(1/Math.sqrt(size));
			}
		}
	}
	
	// Recursively initialize the quadrants of the Hadamard Gate.
	public void initializeQuadrant(int is, int ie, int js, int je, ComplexNumber value)
	{
		if(is == ie && js == je)
		{
			matrix[is][js] = value;
		}
		else
		{
			int size = ie - is + 1;
			initializeQuadrant(is, is+(size-1)/2, js, js+(size-1)/2, value);
			initializeQuadrant(is+((size-1)/2)+1, is+(size-1), js, js+(size-1)/2, value.copy());
			initializeQuadrant(is, is+(size-1)/2, js+((size-1)/2)+1, js+(size-1), value.copy());
			initializeQuadrant(is+((size-1)/2)+1, is+(size-1), js+((size-1)/2)+1, js+(size-1), value.negCopy());
		}
	}
	
}
