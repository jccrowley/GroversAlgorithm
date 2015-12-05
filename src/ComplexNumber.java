/* Simple implementation of Complex Numbers.
 * Author: J. Colin Crowley
 */

public class ComplexNumber 
{
	public double imaginary;
	public double real;
	
	public ComplexNumber()
	{
		imaginary = real = 0;
	}
	
	public ComplexNumber(double r, double i)
	{
		imaginary = i;
		real = r;
	}

	public double magnitude()
	{
		return Math.sqrt((Math.pow(imaginary, 2) + Math.pow(real, 2)));
	}
	
	public double phase()
	{
		return Math.atan2(imaginary, real);
	}
	
	public double amplitude()
	{
		return Math.pow(this.magnitude(), 2);
	}
	
	public ComplexNumber add(ComplexNumber c)
	{
		return new ComplexNumber(real + c.real, imaginary + c.imaginary);
	}
	
	public ComplexNumber subtract(ComplexNumber c)
	{
		return new ComplexNumber(real - c.real, imaginary - c.imaginary);
	}
	
	public ComplexNumber multiply(ComplexNumber c)
	{
		return new ComplexNumber((real * c.real) - (imaginary * c.imaginary), (real * c.imaginary) + (imaginary * c.real));
	}
	
	public void multiply(double scalar)
	{
		real *= scalar;
		imaginary *= scalar;
	}
	
	public ComplexNumber q()
	{
		return new ComplexNumber(1, 0).subtract(this);
	}
	
	public void print()
	{
		System.out.println("Real: " + real);
		System.out.println("Imaginary: " + imaginary);
		System.out.println("Magnitude: " + this.magnitude());
		System.out.println("Phase: " + this.phase());
		System.out.println("Amplitude: " + this.amplitude());
		System.out.println();
	}
	
	public ComplexNumber copy()
	{
		return new ComplexNumber(real, imaginary);
	}
	
	public ComplexNumber negCopy()
	{
		return new ComplexNumber(-real, -imaginary);
	}
	
}
