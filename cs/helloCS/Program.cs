using System;

class Program
{
	static void Main(string[] args)
	{
		string? name = Console.ReadLine();
		string introduction = $"hello Mrs.{name}";
		Console.WriteLine(introduction);
	}
}
