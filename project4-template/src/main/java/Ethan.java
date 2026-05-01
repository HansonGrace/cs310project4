import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;

// Ethan made these functions

public class Ethan {

	public static <T> boolean member(T atm, List<T> lizt){
		if(lizt.isEmpty()){
			return false;
		} else if (lizt.get(0).equals(atm)){
			return true;
		} else{
			return member(atm,lizt.subList(1,lizt.size()));
		}
	}

	public static <T> List<T> append(List<T> lizt1,List<T> lizt2){
		if(lizt1.isEmpty()){
			return new ArrayList<>(lizt2);
		} else{
			List<T> a=new ArrayList<>();
			a.add(lizt1.get(0));
			a.addAll(append(lizt1.subList(1,lizt1.size()),lizt2));
			return a;
		}
	}

	public static <T,R> List<R> map(Function<T,R> f,List<T> lizt){
		if(lizt.isEmpty()){
			return new ArrayList<>();
		} else{
			List<R> a=new ArrayList<>();
			a.add(f.apply(lizt.get(0)));
			a.addAll(map(f,lizt.subList(1,lizt.size())));
			return a;
		}
	}

	public static <T> boolean same(List<T> lizt1,List<T> lizt2){
		if(lizt1.isEmpty()){
			return lizt2.isEmpty();
		} else if (lizt2.isEmpty()) {
			return false;
		} else if(lizt1.get(0).equals(lizt2.get(0))){
			return same(lizt1.subList(1,lizt1.size()),lizt2.subList(1,lizt2.size()));
		} else{
			return false;
		}
	}

	public static <T> List<T> intersect(List<T> lizt1,List<T> lizt2){
		if(lizt1.isEmpty()){
			return new ArrayList<>();
		} else if (member(lizt1.get(0),lizt2)){
			List<T> a=new ArrayList<>();
			a.add(lizt1.get(0));
			a.addAll(intersect(lizt1.subList(1,lizt1.size()),lizt2));
			return a;
		} else{
			return intersect(lizt1.subList(1,lizt1.size()),lizt2);
		}
	}
}
