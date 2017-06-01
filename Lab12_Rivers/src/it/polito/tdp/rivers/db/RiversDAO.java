package it.polito.tdp.rivers.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.River;

public class RiversDAO {

	public List<River> getAllRivers() {
		List<River> rivers = new ArrayList<River>();
		Connection conn = DBConnect.getInstance().getConnection();
		final String sql="select * from river";
		PreparedStatement st;

		try {
			st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

           while (res.next())
				rivers.add(new River(res.getInt("id"),res.getString("name")));
           
           res.close();
           conn.close();
			

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		 }
		
	  
		return rivers;
	}
	
	
	public List<Flow> getAllFlows(River river) {
		List<Flow> flows = new ArrayList<Flow>();
		Connection conn = DBConnect.getInstance().getConnection();
		final String sql="select * from flow where river=? order by day";
		PreparedStatement st;

		try {
			st = conn.prepareStatement(sql);
			st.setInt(1,river.getId());
			ResultSet res = st.executeQuery();

           while (res.next()){
        	    Flow flow=new Flow(res.getInt("id"),res.getDate("day").toLocalDate(),res.getFloat("flow"));
				flows.add(flow);
                river.setFlows(flows);
           }
           res.close();
           conn.close();
			

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore connessione al database");
			throw new RuntimeException("Error Connection Database");
		 }
		
	  
		return flows;
	}
		
		

}
