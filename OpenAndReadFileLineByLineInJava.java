		// read in triangle points
		Path file = Paths.get("triangles.txt");
		Charset charset = Charset.forName("UTF-8");

		int result = 0;

		try (BufferedReader fileReader = Files.newBufferedReader(file, charset))
		{

			for (String newLine = ""; newLine != fileReader.readLine();)
			{
				newLine = fileReader.readLine();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}