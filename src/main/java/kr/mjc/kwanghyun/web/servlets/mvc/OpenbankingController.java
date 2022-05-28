package kr.mjc.kwanghyun.web.servlets.mvc;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Handles requests for the application home page.
 */
@Controller
public class OpenbankingController {
	
	private static final Logger logger = LoggerFactory.getLogger(OpenbankingController.class);
	
	
	/**
	 * 오픈뱅킹 메인 
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	@RequestMapping(value = "/openbanking_default", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView OpenBankingDefault(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		ModelAndView mv = new ModelAndView("/Openbanking/openbanking_default");
		
		return mv;
	}

	
	/**
	 * 사용자 인증시 인증 번호 받기1
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	@RequestMapping(value = "/openbanking_token_default", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView OpenBankingTokenDefault(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/Openbanking/openbanking_token_default");
		return mv;
	}
	
	
	/**
	 * 사용자 정보 조회
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	@RequestMapping(value = "/openbanking_me_default", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView OpenBankingMeDefault(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/Openbanking/openbanking_me_default");

		return mv;
		
	}

	
	/**
	 * 사용자 등록 계좌 리스트
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/openbanking_accountlist_default", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView OpenBankingAccountListDefault(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/Openbanking/openbanking_accountlist_default");

		return mv;
		
	}

	
	/**
	 * 계좌 거래 리스트 보기
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/openbanking_transaction_default", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView OpenBankingTransactionDefault(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/Openbanking/openbanking_transaction_default");

		return mv;
		
	}
	
	
	/**
	 * 계좌 거래 리스트 차트로 표현
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/openbanking_transaction_chart", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView OpenBankingTransactionChart(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/Openbanking/openbanking_transaction_chart");

		return mv;
		
	}

	
	/**
	 * 계좌 해지 하기
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/openbanking_cancel_default", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView OpenBankingCancelDefault(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/Openbanking/openbanking_cancel_default");

		return mv;
		
	}


}
