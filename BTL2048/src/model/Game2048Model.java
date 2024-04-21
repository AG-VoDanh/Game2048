package model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.jar.JarFile;
public class Game2048Model {
	private int diemCuaBan,diemCaoNhat;
	public Game2048Model(){
		this.diemCuaBan = 0;
		this.diemCaoNhat = 0;
	}
	public int getDiemCuaBan(){
		return this.diemCuaBan;
	}
	public void setDiemCuaBan(int diemCuaBan){
		this.diemCuaBan = diemCuaBan;
	}
	public void setDiemCaoNhat(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/model/DiemCaoNhat.txt"));
            bw.write(String.valueOf(this.getDiemCuaBan()));
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
	}
	public int getDiemCaoNhat(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/model/DiemCaoNhat.txt"));
            diemCaoNhat = Integer.parseInt(br.readLine());
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        return diemCaoNhat;
	}
}
