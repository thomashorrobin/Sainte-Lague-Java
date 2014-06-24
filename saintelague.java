import java.util.*;
import java.io.*;

public class saintelague{

	public static void main(String[] args){
		saintelague sl = new saintelague();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.print("Party Name: ");
			String name = "";
			try {
			name = br.readLine();
			if(name.equals("done")) break;
			if(name.equals("file1")){
				sl.LoadFromFile("2011results.txt");
				break;
			}
			if(name.equals("file2")){
				sl.LoadFromFile("2008results.txt");
				break;
			}
			if(name.equals("print")){
				sl.PrintAll();
				continue;
			}
			} catch (IOException ex) {
			System.out.println(ex);
			break;
			}
			System.out.print("Total votes: ");
			String votes = "";
			int vs = 0;
			try {
			votes = br.readLine();
			vs = Integer.parseInt(votes);
			} catch (IOException ex) {
			System.out.println(ex);
			break;
			}
			party p = new party(name,vs);
			sl.AddParty(p);
		}
		sl.CalculateSeats();
		sl.PrintAll();
	}

	public void LoadFromFile(String fileName){
		Scanner sc;
		try{
			sc = new Scanner(new File(fileName));
			while(sc.hasNextLine()){
				String line = sc.nextLine();
				Scanner scline = new Scanner(line);
				String partyName = scline.next();
				int vote = scline.nextInt();
				String inParlement = scline.next();
				if(inParlement.equals("true")){
					party np = new party(partyName,vote);
					//np.toString();
					this.AddParty(np);
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		}
	}

	private void CalculateSeats(){
		int seats = 120;
		while(seats > 0){
			party p = list.get(0);
			for(party pty: list){
				if(pty.quot() > p.quot()) p=pty;
			}
			p.AddSeat();
			seats--;
		}
	}

	private ArrayList<party> list = new ArrayList<party>();

	public void AddParty(party p){
		list.add(p);
	}

	public void PrintAll(){
		for(party p: list){
			System.out.println(p.toString());
		}
	}
}
