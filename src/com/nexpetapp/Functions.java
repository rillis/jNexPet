package com.nexpetapp;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.tools.JavaFileObject;

import org.json.JSONObject;

public class Functions {
		private final static String USER_AGENT = "Mozilla/5.0";
		public final static String WEBSERVICE = "http://localhost:8080/webservice/java/";
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
		private static String sendPostServicos(String url, String id) throws Exception {

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = "id="+id;

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
		public static String[][] getServicos(){
			try {
				String response = sendPostServicos(WEBSERVICE+"getServicos.php", Credentials.UID);
				JSONObject json = new JSONObject(response);
				//PADROES
				JSONObject user = json.getJSONObject("user");
				//N
				int n = user.getInt("n");
				String[] id = user.getJSONArray("id").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] nome = user.getJSONArray("nome").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] precoP = user.getJSONArray("precoP").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] precoM = user.getJSONArray("precoM").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] precoG = user.getJSONArray("precoG").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] precoGG = user.getJSONArray("precoGG").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] precoGato = user.getJSONArray("precoGato").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] duracaoCao = user.getJSONArray("duracaoCao").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] duracaoGato = user.getJSONArray("duracaoGato").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				String[] descricao = user.getJSONArray("descricao").toString().replace("[", "").replace("]", "").replace("\"", "").split(",");
				
				
				String[][] servicos = new String[n][12];
				for (int i = 0; i < n; i++) {
					servicos[i][0]=id[i];
					servicos[i][1]=nome[i];
					servicos[i][2]=precoP[i];
					servicos[i][3]=precoM[i];
					servicos[i][4]=precoG[i];
					servicos[i][5]=precoGG[i];
					servicos[i][6]=precoGato[i];
					servicos[i][7]=duracaoCao[i];
					servicos[i][8]=duracaoGato[i];
					servicos[i][9]=descricao[i];
				}
				return servicos;
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
		public static List<Image> getIconList() {
			List<Image> icons = new ArrayList<Image>();
			URL icon16 = ClassLoader.getSystemResource("img/icon16.png");
			URL icon24 = ClassLoader.getSystemResource("img/icon24.png");
			URL icon32 = ClassLoader.getSystemResource("img/icon32.png");
			URL icon64 = ClassLoader.getSystemResource("img/icon64.png");
			Toolkit kit = Toolkit.getDefaultToolkit();
			icons.add(kit.createImage(icon16));
			icons.add(kit.createImage(icon24));
			icons.add(kit.createImage(icon32));
			icons.add(kit.createImage(icon64));
			return icons;
		}
		public static ArrayList<String> read( File file ) throws FileNotFoundException, IOException{
		    ArrayList<String> linhas;
		        
		    try (BufferedReader leitor = new BufferedReader( new FileReader(file) )) {
		       linhas = new ArrayList<>();
		       String linha = "";
		            
		       while( (linha = leitor.readLine()) != null ){
		          if( linha.length() > 0 )
		              linhas.add(linha);
		       }
		    }
		    return linhas;
		}
		public static void delete(File file){
			if(file.exists()){
				file.delete();
			}
		}
		public static void write(File file,String what) throws IOException{
			BufferedWriter writer;
			if(file.exists()){
				writer = new BufferedWriter(new FileWriter(file,true));
				writer.newLine();
				writer.write(what);
			}else{
				writer = new BufferedWriter(new FileWriter(file));
				writer.write(what);
			}
			writer.flush();
			writer.close();
		}
		public static void createAutoLogin(String e, String s) {
			File config = new File("config.np");
			delete(config);
			try {
				write(config, e);
				write(config, s);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		public static void apagarServico(String id) {
			try {
				sendPostServicos(WEBSERVICE+"deleteServico.php", id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
