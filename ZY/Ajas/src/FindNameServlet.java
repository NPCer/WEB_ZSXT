import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NameService.NameService;


public class FindNameServlet extends HttpServlet {
	
	private List<String> names = new ArrayList<String>();


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("this is findNameServlet");
		String prefix = request.getParameter("names");
		//System.out.println(prefix);
		NameService service = NameService.getInstance(names);
		List matching = service.findNames(prefix);
		if(matching.size()>0){
			PrintWriter out = response.getWriter();
			response.setContentType("text/xml");
			response.setHeader("Cache-Control", "no-cache");
			out.println("<response>");
			Iterator iter = matching.iterator();
			while(iter.hasNext()){
				String name = (String) iter.next();
				out.println("<name>"+name+"</name>");
			}
			out.println("</response>");
			matching = null;
			service = null;
			out.close();
		}else{
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void init() throws ServletException {
		System.out.println("this is init");
		names.add("Abc");
		names.add("Abstract");
		names.add("class");
		names.add("Java");
		names.add("Database");
		names.add("Caculate");
		names.add("Copmputer");
		names.add("Destinstion");
		names.add("developer");
		names.add("Juint");
		names.add("Struts");
		names.add("Spring");
		names.add("Hibernate");
		
	}


}
