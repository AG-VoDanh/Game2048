package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.Game2048Controller;
import model.Game2048Model;
public class Game2048View extends JPanel{
	private Game2048Model game2048Model = new Game2048Model() ;
	private JButton[][] oGame = new JButton[4][4];
	private int[][] chiSoOGame = new int[4][4];
	private Font font = new Font("Time New Roman",Font.BOLD,20);
	private JLabel diemHienThi = new JLabel("Điểm : "+game2048Model.getDiemCuaBan());
	private boolean kiemTraDiChuyenVaHop = false;
	private JPanel mainGame = new JPanel();
	private Game2048Controller game2048Controller = new Game2048Controller(this);
	public Game2048View() {		
		diemHienThi.setForeground(new Color(187, 173, 160));
		diemHienThi.setFont(font);
		JLabel diemCaoHienThi = new JLabel("Điểm Cao Nhất : "+game2048Model.getDiemCaoNhat());
		diemCaoHienThi.setForeground(new Color(187, 173, 160));
		diemCaoHienThi.setFont(font);
		
		JPanel dongDau = new JPanel(new GridLayout());
		dongDau.add(diemHienThi);
		dongDau.add(diemCaoHienThi);	
		
		mainGame.setPreferredSize(new Dimension(520, 540));
		mainGame.setBackground(new Color(187, 173, 160));
		for(int i = 0 ; i < 4 ; i++){
			for(int j = 0 ; j < 4 ; j++){
				oGame[i][j] = new JButton();
				oGame[i][j].setPreferredSize(new Dimension(120,120));
				oGame[i][j].setBorder(BorderFactory.createLineBorder(new Color(187, 173, 160)));
				chiSoOGame[i][j] = 0;
				oGame[i][j].setEnabled(false);
				oGame[i][j].setBackground(new Color(205, 193, 180));
				oGame[i][j].addMouseListener(game2048Controller);
				mainGame.add(oGame[i][j]);
		}}
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.add(dongDau);
		this.add(mainGame);
		this.taoOGameNgauNhien();
		this.taoOGameNgauNhien();
		this.addMouseListener(game2048Controller);
		this.setVisible(true);
}
    public JPanel lostWinView(String a , String b){
        this.setLayout(new GridLayout(2,1));

        JLabel jLabel = new JLabel(a);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setFont(new Font("Arial",Font.BOLD,90));
        jLabel.setForeground(new Color(102, 102, 102));

        JLabel jLabel_score = new JLabel("Score: "+game2048Model.getDiemCuaBan());
        jLabel_score.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel_score.setFont(new Font("Arial",Font.BOLD,30));
        jLabel_score.setForeground(new Color(102, 102, 102));
        
        JPanel jPanel_text = new JPanel();
        jPanel_text.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
        jPanel_text.add(jLabel);
        jPanel_text.add(jLabel_score);

        JButton jButton= new JButton(b);
        jButton.setBounds(180,0,150,60);
        jButton.setBackground(new Color(187, 173, 160));
        jButton.setFocusPainted(false);  
        jButton.setBorderPainted(false);
        jButton.setFont(new Font("Arial",Font.BOLD,20));
        jButton.addActionListener(game2048Controller);
        JButton jButton_quit = new JButton("Quit");
        jButton_quit.setBounds(180,100,150,60);
        jButton_quit.setBackground(new Color(187, 173, 160));
        jButton_quit.setFocusPainted(false);  
        jButton_quit.setBorderPainted(false);
        jButton_quit.setFont(new Font("Arial",Font.BOLD,20));
        jButton_quit.addActionListener(game2048Controller);

        JPanel jPanel_buttom = new JPanel();
        jPanel_buttom.setLayout(null);
        jPanel_buttom.add(jButton);
        jPanel_buttom.add(jButton_quit);

        this.add(jPanel_text);
        this.add(jPanel_buttom);
        this.setVisible(true);
        
        return this;
    }
	public Color setMauOGame(int chiSo) {
		switch (chiSo) {
		case 2: 
			return new Color(255, 255, 255);
		case 4:
			return new Color (255, 255, 224);
		case 8:
			return new Color (255, 218, 185);
		case 16:
			return new Color(250, 210, 170);
		case 32:
			return new Color(176, 224, 230);
		case 64:
			return new Color(173, 216, 230);
		case 128:
			return new Color(135, 206, 250);
		case 256:
			return new Color(240, 128, 128);
		case 512:
			return new Color(205, 92, 92);
		case 1024:
			return new Color(220, 20, 60);
		case 2048:
			return new Color(255, 215, 0);
		}
		return new Color(205, 193, 180);
	}
	public JPanel getManGame() {
		return this.mainGame;
	}
	public boolean getkiemTraDiChuyenVaHop(){
		return this.kiemTraDiChuyenVaHop;
	}
	public void setkiemTraDiChuyenVaHop(boolean kiemTraDiChuyenVaHop){
		this.kiemTraDiChuyenVaHop = kiemTraDiChuyenVaHop;
	}
	public int getChiSoOGame(int x , int y){
		return this.chiSoOGame[x][y];
	}
	public void setChiSoOGame(int x , int y , int z){
		 this.chiSoOGame[x][y] = z;
	}
	public void hienDiemManGame(int x , int y){
		game2048Model.setDiemCuaBan(game2048Model.getDiemCuaBan()+chiSoOGame[x][y]);
		this.diemHienThi.setText("Điểm : "+game2048Model.getDiemCuaBan());
	}
	public void taoOGame(int x , int y){
		oGame[x][y].setBackground(setMauOGame(chiSoOGame[x][y]));
		oGame[x][y].setText(String.valueOf(chiSoOGame[x][y]));
		if(chiSoOGame[x][y] == 0){
			oGame[x][y].setText("");
		}
		oGame[x][y].setFont(font);
	}
	public void taoOGameNgauNhien(){
		while(true) {
			Random random = new Random();
			int chiSoOGameX = random.nextInt(4);
			int chiSoOGameY = random.nextInt(4);
			if(chiSoOGame[chiSoOGameX][chiSoOGameY] == 0) {
					chiSoOGame[chiSoOGameX][chiSoOGameY] = Math.random() < 0.9 ? 2 : 4;
					this.taoOGame(chiSoOGameX, chiSoOGameY);
					break;
					}}
	}
	public boolean KiemTraWinRong(int chiSo){
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++){
				if(chiSoOGame[i][j] == chiSo){
					return true;
		}}}
		return false;
	}
	public void ketThuc() {
		if(this.KiemTraWinRong(0) && kiemTraDiChuyenVaHop == true) {
			this.taoOGameNgauNhien();
		}
			kiemTraDiChuyenVaHop = false;
			boolean kiemTraKetThuc = true;
			for (int i = 0; i < 3; i++) {
				if(chiSoOGame[i][3] == chiSoOGame[i+1][3]) {
					kiemTraKetThuc =  false;
					break;
				}
				for (int j = 0; j < 3; j++) {
					if(chiSoOGame[i][j] == chiSoOGame[i+1][j] || chiSoOGame[i][j] == chiSoOGame[i][j+1] || chiSoOGame[3][j] == chiSoOGame[3][j+1]) {
						kiemTraKetThuc = false;
						break;
				}}
				if(kiemTraKetThuc == false) {
					break;
				}
			}
			if(kiemTraKetThuc == true && this.KiemTraWinRong(0) == false) {
				this.removeAll();
				if(this.KiemTraWinRong(2048) == true) {
					 this.lostWinView("You Win","New Game");
				}else {
					 this.lostWinView("You Lost","Try Again"); 
				}
				this.revalidate();
				 if(this.game2048Model.getDiemCuaBan() > game2048Model.getDiemCaoNhat()) {
					     game2048Model.setDiemCaoNhat();
			}}			
	}
}

