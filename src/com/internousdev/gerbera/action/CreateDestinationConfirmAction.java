package com.internousdev.gerbera.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.gerbera.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationConfirmAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String userAddress;
	private String telNumber;
	private String email;

	private List<String> familyNameErrorMessageList = new ArrayList<String>();
	private List<String> firstNameErrorMessageList = new ArrayList<String>();
	private List<String> famimyNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> firstNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> userAddressErrorMessageList = new ArrayList<String>();
	private List<String> telNumberErrorMessageList = new ArrayList<String>();
	private List<String> emailErrorMessageList = new ArrayList<String>();

	private Map<String, Object> session;

	public String execute(){

		if(!session.containsKey("mCategoryList")){
			return "sessionTimeOut";
		}

		String result = ERROR;

		InputChecker inputChecker = new InputChecker();

		//フォームの入力内容(文字種・文字数)をチェックするfamilyName
		familyNameErrorMessageList = inputChecker.doCheck("姓", familyName, 1, 16, true, true, true, false, false, false, false, false, false);
		firstNameErrorMessageList = inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false, false, false, false, false, false);
		famimyNameKanaErrorMessageList = inputChecker.doCheck("姓ふりがな", familyNameKana, 1, 16, false, false, true, false, false, false, false, false, false);
		firstNameKanaErrorMessageList = inputChecker.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false, false, false, false, false);
		userAddressErrorMessageList = inputChecker.doCheck("住所", userAddress, 10, 50, true, true, true, true, true, true, false, false, false);
		telNumberErrorMessageList = inputChecker.doCheck("電話番号", telNumber, 10, 13, false, false, false, true, false, false, false, false, false);
		emailErrorMessageList = inputChecker.doCheck("メールアドレス", email, 10, 32, true, false, false, true, true, false, false, false, false);

		//入力内容に問題が無ければSUCCESSを返す
		if(familyNameErrorMessageList.size()==0
				&& firstNameErrorMessageList.size()==0
				&& famimyNameKanaErrorMessageList.size()==0
				&& firstNameKanaErrorMessageList.size()==0
				&& userAddressErrorMessageList.size()==0
				&& telNumberErrorMessageList.size()==0
				&& emailErrorMessageList.size()==0){
			result = SUCCESS;
		}

		return result;
	}

	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFamilyNameKana() {
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}
	public String getFirstNameKana() {
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getFamilyNameErrorMessageList() {
		return familyNameErrorMessageList;
	}

	public List<String> getFirstNameErrorMessageList() {
		return firstNameErrorMessageList;
	}

	public List<String> getFamimyNameKanaErrorMessageList() {
		return famimyNameKanaErrorMessageList;
	}

	public List<String> getFirstNameKanaErrorMessageList() {
		return firstNameKanaErrorMessageList;
	}

	public List<String> getUserAddressErrorMessageList() {
		return userAddressErrorMessageList;
	}

	public List<String> getTelNumberErrorMessageList() {
		return telNumberErrorMessageList;
	}

	public List<String> getEmailErrorMessageList() {
		return emailErrorMessageList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
