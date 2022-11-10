//PATIENCE CELE - BE-2022-W7Y3D1
//JAVA BASIC PROJECT - VERSION A (QUESTION 1)

import java.util.*;
public class MapProject
{
	public static void main(String [] args)
	{
		Map<String, String> map = new HashMap<>();
		map.put("Name", "Patience");
		map.put("Surname", "Cele");
		map.put("Institution", "Eduvos");
		map.put("Campus", "Bedforview");
		map.put("Field", "Information Systems");
		map.put("Qualification type", "Software development");
		System.out.println(map+"\n");
		System.out.println(map.get("Field"));
		map.remove("Qualification type");
		System.out.println("\n"+map+"\n");
		
		Map<String, String> link = new LinkedHashMap<>();
		link.put("Country", "South Africa");
		link.put("Continent", "Africa");
		link.put("Region", "SADC");
		link.put("City", "Johannesburg");
		link.put("Province", "Gauteng");
		System.out.println(link);
	}
}