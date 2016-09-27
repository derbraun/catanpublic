package shared.locations;

/**
 * Represents the location of an edge on a hex map
 */
public class EdgeLocation
{
	
	private HexLocation hexLoc;
	private EdgeDirection dir;
	
	public EdgeLocation(HexLocation hexLoc, EdgeDirection dir)
	{
		setHexLoc(hexLoc);
		setDir(dir);
	}
	
	public HexLocation getHexLoc()
	{
		return hexLoc;
	}
	
	private void setHexLoc(HexLocation hexLoc)
	{
		if(hexLoc == null)
		{
			throw new IllegalArgumentException("hexLoc cannot be null");
		}
		this.hexLoc = hexLoc;
	}
	
	public EdgeDirection getDir()
	{
		return dir;
	}
	
	private void setDir(EdgeDirection dir)
	{
		this.dir = dir;
	}
	
	@Override
	public String toString()
	{
		return "EdgeLocation [hexLoc=" + hexLoc + ", dir=" + dir + "]";
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dir == null) ? 0 : dir.hashCode());
		result = prime * result + ((hexLoc == null) ? 0 : hexLoc.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		EdgeLocation other = (EdgeLocation)obj;
		if(dir != other.dir)
			return false;
		if(hexLoc == null)
		{
			if(other.hexLoc != null)
				return false;
		}
		else if(!hexLoc.equals(other.hexLoc))
			return false;
		return true;
	}
	
	/**
	 * Returns a canonical (i.e., unique) value for this edge location. Since
	 * each edge has two different locations on a map, this method converts a
	 * hex location to a single canonical form. This is useful for using hex
	 * locations as map keys.
	 * 
	 * @return Normalized hex location
	 */
	public EdgeLocation getNormalizedLocation()
	{
		
		// Return an EdgeLocation that has direction NW, N, or NE
		
		switch (dir)
		{
			case NorthWest:
			case North:
			case NorthEast:
				return this;
			case SouthWest:
			case South:
			case SouthEast:
				return new EdgeLocation(hexLoc.getNeighborLoc(dir),
										dir.getOppositeDirection());
			default:
				assert false;
				return null;
		}
	}
	
	/**
	 * Checks for adjacency of this edge location to another edge location
	 * @param adj
	 * @return True if adjacent, false otherwise
	 */
	public boolean isAdjacent(EdgeLocation adj){
		
		if(adj == null)
		{
			throw new IllegalArgumentException("adj cannot be null");
		}
		
		if (this.equals(adj)){return false;}
		
		switch (dir)
		{
			case NorthWest:
				if ((this.hexLoc == adj.hexLoc && adj.dir == EdgeDirection.North) ||
						(this.hexLoc == adj.hexLoc && adj.dir == EdgeDirection.SouthWest) ||
						(this.hexLoc.getNeighborLoc(this.dir) == adj.hexLoc 
							&& adj.dir == EdgeDirection.South) ||
						(this.hexLoc.getNeighborLoc(this.dir) == adj.hexLoc 
							&& adj.dir == EdgeDirection.NorthEast) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.North) == adj.hexLoc 
							&& adj.dir == EdgeDirection.South) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.North) == adj.hexLoc 
							&& adj.dir == EdgeDirection.SouthWest) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.SouthWest) == adj.hexLoc 
							&& adj.dir == EdgeDirection.North) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.SouthWest) == adj.hexLoc 
							&& adj.dir == EdgeDirection.NorthEast)){
					return true;
				}
				break;
			case North:
				if ((this.hexLoc == adj.hexLoc && adj.dir == EdgeDirection.NorthWest) ||
						(this.hexLoc == adj.hexLoc && adj.dir == EdgeDirection.NorthEast) ||
						(this.hexLoc.getNeighborLoc(this.dir) == adj.hexLoc 
							&& adj.dir == EdgeDirection.SouthWest) ||
						(this.hexLoc.getNeighborLoc(this.dir) == adj.hexLoc 
							&& adj.dir == EdgeDirection.SouthEast) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.NorthWest) == adj.hexLoc 
							&& adj.dir == EdgeDirection.SouthEast) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.NorthWest) == adj.hexLoc 
							&& adj.dir == EdgeDirection.NorthEast) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.NorthEast) == adj.hexLoc 
							&& adj.dir == EdgeDirection.SouthWest) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.NorthEast) == adj.hexLoc 
							&& adj.dir == EdgeDirection.NorthWest)){
					return true;
				}
				break;
			case NorthEast:
				if ((this.hexLoc == adj.hexLoc && adj.dir == EdgeDirection.North) ||
						(this.hexLoc == adj.hexLoc && adj.dir == EdgeDirection.SouthEast) ||
						(this.hexLoc.getNeighborLoc(this.dir) == adj.hexLoc 
							&& adj.dir == EdgeDirection.NorthWest) ||
						(this.hexLoc.getNeighborLoc(this.dir) == adj.hexLoc 
							&& adj.dir == EdgeDirection.South) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.North) == adj.hexLoc 
							&& adj.dir == EdgeDirection.South) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.North) == adj.hexLoc 
							&& adj.dir == EdgeDirection.SouthEast) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.SouthEast) == adj.hexLoc 
							&& adj.dir == EdgeDirection.NorthWest) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.SouthEast) == adj.hexLoc 
							&& adj.dir == EdgeDirection.North)){
					return true;
				}
				break;
			case SouthWest:
				if ((this.hexLoc == adj.hexLoc && adj.dir == EdgeDirection.NorthWest) ||
						(this.hexLoc == adj.hexLoc && adj.dir == EdgeDirection.South) ||
						(this.hexLoc.getNeighborLoc(this.dir) == adj.hexLoc 
							&& adj.dir == EdgeDirection.North) ||
						(this.hexLoc.getNeighborLoc(this.dir) == adj.hexLoc 
							&& adj.dir == EdgeDirection.SouthEast) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.NorthWest) == adj.hexLoc 
							&& adj.dir == EdgeDirection.South) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.NorthWest) == adj.hexLoc 
							&& adj.dir == EdgeDirection.SouthEast) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.South) == adj.hexLoc 
							&& adj.dir == EdgeDirection.NorthWest) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.South) == adj.hexLoc 
							&& adj.dir == EdgeDirection.North)){
					return true;
				}
				break;
			case South:
				if ((this.hexLoc == adj.hexLoc && adj.dir == EdgeDirection.SouthWest) ||
						(this.hexLoc == adj.hexLoc && adj.dir == EdgeDirection.SouthEast) ||
						(this.hexLoc.getNeighborLoc(this.dir) == adj.hexLoc 
							&& adj.dir == EdgeDirection.NorthWest) ||
						(this.hexLoc.getNeighborLoc(this.dir) == adj.hexLoc 
							&& adj.dir == EdgeDirection.NorthEast) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.SouthWest) == adj.hexLoc 
							&& adj.dir == EdgeDirection.NorthEast) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.SouthWest) == adj.hexLoc 
							&& adj.dir == EdgeDirection.SouthEast) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.SouthEast) == adj.hexLoc 
							&& adj.dir == EdgeDirection.NorthWest) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.SouthEast) == adj.hexLoc 
							&& adj.dir == EdgeDirection.SouthWest)){
					return true;
				}
				break;
			case SouthEast:
				if ((this.hexLoc == adj.hexLoc && adj.dir == EdgeDirection.South) ||
						(this.hexLoc == adj.hexLoc && adj.dir == EdgeDirection.NorthEast) ||
						(this.hexLoc.getNeighborLoc(this.dir) == adj.hexLoc 
							&& adj.dir == EdgeDirection.North) ||
						(this.hexLoc.getNeighborLoc(this.dir) == adj.hexLoc 
							&& adj.dir == EdgeDirection.SouthWest) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.South) == adj.hexLoc 
							&& adj.dir == EdgeDirection.NorthEast) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.South) == adj.hexLoc 
							&& adj.dir == EdgeDirection.North) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.NorthEast) == adj.hexLoc 
							&& adj.dir == EdgeDirection.SouthWest) ||
						(this.hexLoc.getNeighborLoc(EdgeDirection.NorthEast) == adj.hexLoc 
							&& adj.dir == EdgeDirection.South)){
					return true;
				}
				break;
			default:
				assert false;
				return false;
		}
		
		return false;
	}
}

