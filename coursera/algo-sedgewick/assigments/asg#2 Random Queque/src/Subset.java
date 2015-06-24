import java.util.Map;
import java.util.HashMap;

class Subset{
	private static Map<String, String> st;

	Subset(){
		st = new HashMap<String, String>();
	}
	public void put(String el){
		st.put(el, "");
	}

	public static void print(){
		for (String key: st.keySet()){
			StdOut.println(key+ " ");
		}
	}

	public static void main(String[] args){
		Subset set = new Subset();

		while(!StdIn.isEmpty()){
			String ch = StdIn.readString();
			set.put(ch);
		}

		print();
	}
}