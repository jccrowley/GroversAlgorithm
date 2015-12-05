import java.util.Random;

import javax.swing.JOptionPane;

/* Simulation of Grover's Algorithm.
 * After running the program, take note of the random solution
 * state that was chosen, and then see how that state differs
 * from the rest (particularly the amplitude.)
 * Author: J. Colin Crowley 
 */

public class Main 
{
	public static void main(String[]args)
	{
		/* Here we set up the system. In this simulation, the qubits are represented
		 * by an array of all their possible states. Each possible state is represented
		 * by a complex number, where the amplitude of that number is the probability of
		 * that state being observed. All qubits start out in the "on" state, which 
		 * corresponds to the first state in the array of global states. Thus, that global
		 * state's amplitiude is 1. */
		int numQubits = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of qubits (between 2 and 9, inclusive)"));
		int numGlobalStates = (int) Math.pow(2,  numQubits);
		ComplexNumber[] globalStates = new ComplexNumber[numGlobalStates];
		globalStates[0] = new ComplexNumber(1, 0);
		for(int i = 1; i < numGlobalStates; i++)
		{
			globalStates[i] = new ComplexNumber(0, 0);
		}
		System.out.println("Number of global states: " + numGlobalStates);
		
		
		// Here we randomly select a solution state. In practice, we would not know this state.
		Random randGen = new Random();
		int stateToFind = randGen.nextInt(numGlobalStates);
		System.out.println("Random solution state chosen: " + stateToFind + "\n");
		
		
		/* Here we set up the quantum gates needed for Grover's Algorithm.
		 * Like with classical computers, running the qubits through a gate
		 * is just ONE operation. The power of quantum computing lies in the
		 * fact that quantum gates act on a superposition of all possible
		 * states, which allows us to take advantage of interference. */
		UnknownGate ugate = new UnknownGate(numQubits, stateToFind);
		HadamardGate hgate = new HadamardGate(numQubits);
		InvertAroundAverageGate igate = new InvertAroundAverageGate(numQubits);
		
		
		/* The first step of the algorithm uses a Hadamard Gate to create a 
		  uniform superposition of all possible states. */
		globalStates = hgate.act(globalStates);
		
		
		/* This is the meat of the algorithm. Each iteration of the loop is a 
		* "Grover Step". The global states are passed through the unknown gate
		* to separate the solution state from the other states, and the rest of
		* the step is the diffusion operator, which amplifies the solution state.
		* The algorithm repeatedly destructively intereferes out non-solutions. */
		for(int i = 0; i < numQubits-1; i++)
		{
			globalStates = ugate.act(globalStates);
			globalStates = hgate.act(globalStates);
			globalStates = igate.act(globalStates);
			globalStates = hgate.act(globalStates);
		}
		
		
		// Display all states.
		for(int i = 0; i < numGlobalStates; i++)
		{
			System.out.println("State "+i);
			globalStates[i].print();
		}
	}
	
}
