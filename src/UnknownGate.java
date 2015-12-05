/* This Quantum Gate represents the function for which we
 * are trying to find a satisfiable input. Because we don't know
 * the solution, we say the gate is unknown.
 */

public class UnknownGate extends QuantumGate
{
	public UnknownGate(int nQubits, int solution) 
	{
		super((int) Math.pow(2, nQubits));
		for(int i = 0; i < size; i ++)
		{
			for(int j = 0; j < size; j++)
			{
				if(i == solution && j == solution)
					matrix[i][j] = new ComplexNumber(-1, 0);
				else if (i == j)
					matrix[i][j] = new ComplexNumber(1, 0);
				else
					matrix[i][j] = new ComplexNumber();
			}
		}
	}
	
}
