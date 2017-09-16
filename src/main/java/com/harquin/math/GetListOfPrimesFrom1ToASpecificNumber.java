package com.harquin.math;

import java.util.ArrayList;
import java.util.List;

public class GetListOfPrimesFrom1ToASpecificNumber {
	
	public List<Long> getListOfPrimesToASpecificNumber(int bound)
	{
		List<Long> primeFactorList = new ArrayList<Long>();
		
		for (long factorIndex = 2; factorIndex < bound; factorIndex++)
		{
			boolean isPrime = true;
			for (int primeIndex = 0; primeIndex < primeFactorList.size(); primeIndex++)
			{
				if (factorIndex % primeFactorList.get(primeIndex) == 0)
				{
					isPrime = false;
					break;
				}
			}
			if (isPrime)
			{
				primeFactorList.add(factorIndex);
			}
		}
		
		return primeFactorList;
	}
}