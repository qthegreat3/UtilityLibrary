	public ArrayList<int> getListOfPrimesToASpecificNumber(int bound)
	{
		ArrayList<Long> primeFactorList = new ArrayList<Long>();
		
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