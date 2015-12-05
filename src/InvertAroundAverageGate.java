/* Simple Quantum Gate which inverts about the mean.
 * It is a key part of the diffusion operator.
 * Author: J. Colin Crowley
 */

public class InvertAroundAverageGate extends QuantumGate
{
	public InvertAroundAverageGate(int nQubits) 
	{
		super((int) Math.pow(2, nQubits));
		for(int i = 0; i < size; i ++)
		{
			for(int j = 0; j < size; j++)
			{
				if(i == 0 && j == 0)
					matrix[i][j] = new ComplexNumber(-1, 0);
				else if (i == j)
					matrix[i][j] = new ComplexNumber(1, 0);
				else
					matrix[i][j] = new ComplexNumber();
			}
		}
	}
	
}
