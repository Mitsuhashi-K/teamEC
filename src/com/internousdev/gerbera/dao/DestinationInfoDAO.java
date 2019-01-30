package com.internousdev.gerbera.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.gerbera.dto.DestinationInfoDTO;
import com.internousdev.gerbera.util.DBConnector;

public class DestinationInfoDAO {

	/**
	 * 引数に指定された宛先をDBに追加するメソッド
	 * @param userId
	 * @param familyName
	 * @param firstName
	 * @param familyNameKana
	 * @param firstNameKana
	 * @param email
	 * @param telNumber
	 * @param userAddress
	 * @return int型 更新件数(通常は1件)
	 */
	public int insert(String userId, String familyName, String firstName, String familyNameKana,
			String firstNameKana, String email, String telNumber, String userAddress){

		//DBに接続
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		int count = 0;	//更新件数

		//宛先情報をDBに挿入するSQL文
		String sql = "INSERT INTO destination_info(user_id, family_name, first_name, family_name_kana, first_Name_Kana, email, tel_number, user_address, regist_date, update_date) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, now(), now())";

		try{
			//SQL文の各パラメータを代入する
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, familyName);
			ps.setString(3, firstName);
			ps.setString(4, familyNameKana);
			ps.setString(5, firstNameKana);
			ps.setString(6, email);
			ps.setString(7, telNumber);
			ps.setString(8, userAddress);

			//SQL文を実行し、更新件数(通常は1件)をcountに代入する
			count = ps.executeUpdate();

		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}

		return count;
	}

	/**
	 * DBからログイン中のユーザーの宛先情報一覧を取得するメソッド
	 * @param loginId
	 * @return List<DestinationInfoDTO>型 宛先情報のリスト
	 */
	public List<DestinationInfoDTO> getDestinationInfo(String loginId){

		//DBに接続
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//宛先情報を格納するリストを宣言
		List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();

		//宛先情報をDBから取得するSQL文
		String sql = "SELECT id, family_name, first_name, family_name_kana, first_name_kana, user_address, tel_number, email "
				+ "FROM destination_info "
				+ "WHERE user_id = ?";

		try{
			//SQL文の各パラメータを代入する
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);

			//SQLを実行し、ResultSetをrsに代入する
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				DestinationInfoDTO destinationInfoDTO = new DestinationInfoDTO();

				//ResultSetから宛先情報を取得し、destinationInfoDTOに格納する
				destinationInfoDTO.setId(rs.getInt("id"));
				destinationInfoDTO.setFamilyName(rs.getString("family_name"));
				destinationInfoDTO.setFirstName(rs.getString("first_name"));
				destinationInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				destinationInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				destinationInfoDTO.setEmail(rs.getString("email"));
				destinationInfoDTO.setTelNumber(rs.getString("tel_number"));
				destinationInfoDTO.setUserAddress(rs.getString("user_address"));

				//宛先情報が格納されたdestinationInfoDTOをdestinationInfoDtoListにaddする
				destinationInfoDtoList.add(destinationInfoDTO);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return destinationInfoDtoList;
	}

}
