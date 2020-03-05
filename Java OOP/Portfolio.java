package assignments;
import java.util.*;
public class Portfolio {
	List<Project>list=new ArrayList<>();
	
	public void addInPortfolio(Project p) {
		list.add(p);
	}

	public List<Project> getList() {
		return list;
	}

	public void setList(List<Project> list) {
		this.list = list;
	}
}
