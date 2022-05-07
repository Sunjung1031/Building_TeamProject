package unit.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mvc.command.CommandHandler;
import unit.model.Unit;
import unit.service.DeleteUnitService;
import unit.service.PermissionDeniedException;
import unit.service.ReadUnitService;
import unit.service.UnitNotFoundException;

public class DeleteUnitHandler implements CommandHandler {

	 private static final String FORM_VIEW = "/WEB-INF/view/unitDeleteForm.jsp";
	  private ReadUnitService readService = new ReadUnitService();
	  private DeleteUnitService deleteService = new DeleteUnitService();
	   
	  @Override
		public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
			if (req.getMethod().equalsIgnoreCase("GET")) {
				return processForm(req, res);
			} else if (req.getMethod().equalsIgnoreCase("POST")) {
				return processSubmit(req, res); // 오류 발견 *processSubmit
			} else {
				res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				return null;
			}
		}

		private String processForm(HttpServletRequest req, HttpServletResponse res) throws IOException {
			try {
				String noVal = req.getParameter("no");
				int no = Integer.parseInt(noVal);
				Unit unit = readService.getContent(no);
				//int unitNo = Integer.parseInt((String) req.getSession().getAttribute("no"));

				unit = new Unit(unit.getNo(), unit.getName(), unit.getHire(), unit.getLease(), unit.getRent_fee(),
						unit.getPeriod(), unit.getSize(), unit.getComing(), unit.getLeaving());
				req.setAttribute("unit", unit);
				return FORM_VIEW;
			} catch (UnitNotFoundException e) {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
				return null;
			}
		}

		private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {

			Unit no = (Unit)req.getSession().getAttribute("no");
				System.out.println(no);
			//String noVal = req.getParameter("no");
			//int no = Integer.parseInt(noVal);

			Unit unit= new Unit(no.getNo(), req.getParameter("name"), req.getParameter("hire"),
					req.getParameter("lease"), Integer.parseInt(req.getParameter("rent_fee")), req.getParameter("period"),
					Integer.parseInt(req.getParameter("size")));
			req.setAttribute("unit", unit);

			Map<String, Boolean> errors = new HashMap<String, Boolean>();
			req.setAttribute("errors", errors);
			if (!errors.isEmpty()) {
				return FORM_VIEW;
			}
			try {
				deleteService.deletion(unit);
				return "/WEB-INF/view/unitDeleteSuccess.jsp";
			} catch (UnitNotFoundException e) {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
				return null;
			} catch (PermissionDeniedException e) {
				res.sendError(HttpServletResponse.SC_NOT_FOUND);
				return null;
			}
		}
}
