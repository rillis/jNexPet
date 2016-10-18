package com.nexpetapp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.tools.JavaFileObject;

import org.json.JSONObject;

public class Functions {
		private final static String USER_AGENT = "Mozilla/5.0";
		public final static String WEBSERVICE = "http://nexpetapp.com.br/java/";
		public static String sendPost(String url, String email, String senha) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "email="+email+"&password="+senha;

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		/**
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
		*/

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		return response.toString();

	}
		private static String sendPostAgendamentos(String url, String nome) throws Exception {

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = "nome="+nome;

			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			/**
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);
			*/

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			return response.toString();

		}
		public static String sysout(Object x){
			System.out.println(x);
			return x.toString();
		}
		public static String[][] getAgendamentos(){
			try {
				JSONObject json = new JSONObject(sendPostAgendamentos(WEBSERVICE+"getAgendamentos.php", Credentials.NOME));
				//PADROES
				JSONObject user = json.getJSONObject("user");
				//N
				int n = user.getInt("n");
				String[] id = user.getJSONArray("id").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] uid = user.getJSONArray("uid").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] dataAgendada = user.getJSONArray("dataAgendada").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] nomeAnimal = user.getJSONArray("nomeAnimal").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] nomePetshop = user.getJSONArray("nomePetshop").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] servico = user.getJSONArray("servico").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] precoFinal = user.getJSONArray("precoFinal").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] servicoAdicional = user.getJSONArray("servicoAdicional").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] formaPagamento = user.getJSONArray("formaPagamento").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] usuarioUID = user.getJSONArray("usuarioUID").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] confirmado = user.getJSONArray("confirmado").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] pagou = user.getJSONArray("pagou").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				
				String[][] agendados = new String[n][12];
				for (int i = 0; i < n; i++) {
					agendados[i][Constants.ID]=id[i];
					agendados[i][Constants.UID]=uid[i];
					agendados[i][Constants.DATAAGENDADA]=dataAgendada[i];
					agendados[i][Constants.NOMEANIMAL]=nomeAnimal[i];
					agendados[i][Constants.NOMEPETSHOP]=nomePetshop[i];
					agendados[i][Constants.SERVICO]=servico[i];
					agendados[i][Constants.PRECOFINAL]=precoFinal[i];
					agendados[i][Constants.SERVICOADICIONAL]=servicoAdicional[i];
					agendados[i][Constants.FORMAPAGAMENTO]=formaPagamento[i];
					agendados[i][Constants.USUARIOUID]=usuarioUID[i];
					agendados[i][Constants.CONFIRMADO]=confirmado[i];
					agendados[i][Constants.PAGOU]=pagou[i];
				}
				return agendados;
			} catch (Exception e) {e.printStackTrace(); return null;}
		}
		public static String getNamebyUID(String UID){
			try {
				JSONObject json = new JSONObject(sendPostAgendamentos(WEBSERVICE+"name.php", UID));
				String nome;
				try{
					nome = json.getString("user");
				}catch(Exception e){
					nome = json.getString("error_msg");
				}
				return nome;
			} catch (Exception e) {e.printStackTrace(); return null;}
		}
		public static String dataArrumada(String x){
			String[] dataehora = x.split(" ");
			String[] data = dataehora[0].split("-");
			String[] hora = dataehora[1].split(":");
			
			String ano = data[0];
			String mes = data[1];
			String dia = data[2];
			
			String horas = hora[0];
			String minutos = hora[1];
			String segundos = hora[2];
			
			Date date = new Date();
			if(Integer.parseInt(new SimpleDateFormat("dd").format(date))==Integer.parseInt(dia) && Integer.parseInt(new SimpleDateFormat("MM").format(date))==Integer.parseInt(mes) && Integer.parseInt(new SimpleDateFormat("yyyy").format(date))==Integer.parseInt(ano) ){
				return horas+"h"+minutos+" de hoje";
			}if(Integer.parseInt(new SimpleDateFormat("dd").format(date))+1==Integer.parseInt(dia) && Integer.parseInt(new SimpleDateFormat("MM").format(date))==Integer.parseInt(mes) && Integer.parseInt(new SimpleDateFormat("yyyy").format(date))==Integer.parseInt(ano) ){
				return horas+"h"+minutos+" de amanhã";
			}if(Integer.parseInt(new SimpleDateFormat("dd").format(date))-1==Integer.parseInt(dia) && Integer.parseInt(new SimpleDateFormat("MM").format(date))==Integer.parseInt(mes) && Integer.parseInt(new SimpleDateFormat("yyyy").format(date))==Integer.parseInt(ano) ){
				return horas+"h"+minutos+" de ontem";
			}else{
			return horas+"h"+minutos+" de "+dia+"/"+mes+"/"+ano;
			}
		}
}
