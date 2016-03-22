package jersy;

import com.sudhir.model.SplitterDTO;
import com.sudhir.model.services.SplitterDTOService;

public class Test1 {

	public static void main(String[] args) {
		String str="{\"city\":\"Bangalore\",\"userName\":\"sudhiris057\",\"fullName\":\"Sudhir Yadav\"}";
		SplitterDTO splitterDTO=SplitterDTOService.getSplitterDTO(str);
		System.out.println(splitterDTO);

	}

}
