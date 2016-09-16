package shared.models.map;

import java.util.ArrayList;
import java.util.Map;

import shared.definitions.ResourceType;

public class ResProdResult {
	
	private Map<ResourceType,Integer> numPerResource;
	
	private Map<Integer,ArrayList<ResourceType>> resourcesByPlayer;
	
	public int getNumResByType(ResourceType type){
		return 0;
	}
	
	public int getNumPlayerRes(int pID,ResourceType type){
		return 0;
	}
}
