package ch02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MemberFileIO {
	String filePath;
	
	public MemberFileIO(String filePath){
		this.filePath = filePath;
		String dir = filePath.substring(0,filePath.lastIndexOf("\\"));
		File f = new File(dir);
		if(! f.exists()){
			f.mkdirs();
		}
	}
	public MemberFileIO(){
		super();
	}
	public String getFilePath(){
		return filePath;
	}
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	public MemberBean getMemberBeanById(int id) throws IOException{
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		MemberBean mb =null ;
		while((line=br.readLine())!=null){
			String[] dataArray = line.split("\\");
			String key = dataArray[0];
			if(key.equals(id)){
				mb = new MemberBean();
				mb.setMemberId(dataArray[0]);
				mb.setPassword(dataArray[1]);
				mb.setName(dataArray[2]);
				mb.setAddress(dataArray[3]);
				mb.setPhone(dataArray[4]);
				java.sql.Date d = java.sql.Date.valueOf(dataArray[5]);
				mb.setBirthday(d);
				java.sql.Timestamp ts = java.sql.Timestamp.valueOf(dataArray[6]);
				mb.setRegisterDate(ts);
				double dl = Double.parseDouble(dataArray[7].trim());
				mb.setWeight(dl);
			}
		}
		br.close();
		return mb;
	}
	public List<MemberBean> getAllMembers(){
		List<MemberBean> result = new ArrayList<>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line = br.readLine();
			while(line!=null){
				String[] dataArray = line.split("\\|");
				String key = dataArray[0];
				MemberBean mb = new MemberBean();
				mb.setMemberId(key);
				mb.setPassword(dataArray[1]);
				mb.setName(dataArray[2]);
				mb.setAddress(dataArray[3]);
				mb.setPhone(dataArray[4]);
				java.sql.Date d = java.sql.Date.valueOf(dataArray[5]);
				mb.setBirthday(d);
				java.sql.Timestamp ts = java.sql.Timestamp.valueOf(dataArray[6]);
				mb.setRegisterDate(ts);
				double weight = Double.parseDouble(dataArray[7]);
				mb.setWeight(weight);
				result.add(mb);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
			
		
		return result;
	}
	
	public void insertMember(MemberBean mb) throws IOException{
		FileWriter fw = new FileWriter(filePath,true);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(mb.getMemberId()+"|"+mb.getPassword()+"|"+mb.getName()
				+"|"+mb.getAddress()+"|"+mb.getPhone()+"|"+mb.getBirthday()
				+"|"+mb.getRegisterDate()+"|"+mb.getWeight());
		pw.close();
	}
	
	
	
	
}
