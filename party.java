public class party{
	
	private int votes;
	private int seats = 0;
	private String name;

	public party(String pname, int vs){
		name = pname;
		votes = vs;
	}
	
	public double quot(){
		return (double)(votes / (2 * seats + 1));
	}

	public void AddSeat(){
		seats++;
	}

	@Override
	public String toString(){
		return name + " votes:" + Integer.toString(votes) + " seats:" + Integer.toString(seats);
	} 
}
