package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import test.main;
import view.Game2048View;
import view.StartView;
public class Game2048Controller implements ActionListener , MouseListener{
	private StartView startView;
	private Game2048View game2048View;
	private int x , y;
	public Game2048Controller(StartView startView) {
		this.startView = startView;
	}
	public Game2048Controller(Game2048View game2048View) {
		this.game2048View = game2048View;
		game2048View.getManGame().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "Left");
		game2048View.getManGame().getActionMap().put("Left", sangTrai);

		game2048View.getManGame().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "Right");
		game2048View.getManGame().getActionMap().put("Right", sangPhai);

		game2048View.getManGame().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "Up");
		game2048View.getManGame().getActionMap().put("Up", diLen);

		game2048View.getManGame().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "Down");
		game2048View.getManGame().getActionMap().put("Down", diXuong);
	}
    AbstractAction diLen = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            diLen();
        }
    };

    AbstractAction diXuong = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            diXuong();
        }
    };

    AbstractAction sangTrai = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SangTrai();
        }
    };

    AbstractAction sangPhai = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            SangPhai();
        }
    };
	public void diLen() {
		for(int j = 0 ; j < 4 ; j++){
			boolean KiemTracong  = false;
			for(int i = 1 ; i < 4 ; i++){
					for (int k = i; k > 0; k--){
						if(game2048View.getChiSoOGame(k, j) !=0){
							if(game2048View.getChiSoOGame(k-1, j) ==0){
								game2048View.setChiSoOGame(k-1, j,game2048View.getChiSoOGame(k, j));
								game2048View.setChiSoOGame(k, j, 0);
								game2048View.taoOGame(k-1, j);
								game2048View.taoOGame(k, j);
								game2048View.setkiemTraDiChuyenVaHop(true);
							}else if(game2048View.getChiSoOGame(k, j) == game2048View.getChiSoOGame(k-1, j) && KiemTracong == false){
								game2048View.hienDiemManGame(k-1, j);
								game2048View.setChiSoOGame(k-1, j,game2048View.getChiSoOGame(k-1, j)*2);
								game2048View.setChiSoOGame(k, j, 0);
								game2048View.taoOGame(k-1,j);
								game2048View.taoOGame(k,j);
								game2048View.setkiemTraDiChuyenVaHop(true);
								KiemTracong = true;
								break;
		}}}}}
		game2048View.ketThuc();
	}
	public void diXuong() {
		for(int j = 0 ; j < 4 ; j++)
		{
			boolean KiemTracong  = false;
			for(int i = 2 ; i > -1 ; i--)
			{
					for (int k = i; k < 3 ; k++) {
						if(game2048View.getChiSoOGame(k, j) !=0){
							if(game2048View.getChiSoOGame(k+1, j) ==0){
								game2048View.setChiSoOGame(k+1, j,game2048View.getChiSoOGame(k, j));
								game2048View.setChiSoOGame(k, j, 0);
								game2048View.taoOGame(k+1, j);
								game2048View.taoOGame(k, j);
								game2048View.setkiemTraDiChuyenVaHop(true);
							}else if(game2048View.getChiSoOGame(k, j) == game2048View.getChiSoOGame(k+1, j) && KiemTracong == false){
								game2048View.hienDiemManGame(k+1, j);
								game2048View.setChiSoOGame(k+1, j,game2048View.getChiSoOGame(k+1, j)*2);
								game2048View.setChiSoOGame(k, j, 0);
								game2048View.taoOGame(k+1,j);
								game2048View.taoOGame(k,j);
								game2048View.setkiemTraDiChuyenVaHop(true);
								KiemTracong = true;
								break;
		}}}}}
		game2048View.ketThuc();
	}
	public void SangTrai() {
		for(int i = 0 ; i < 4 ; i++)
		{
			boolean KiemTracong  = false;
			for(int j = 1 ; j < 4 ; j++)
			{
					for (int k = j; k > 0; k--) {
						if(game2048View.getChiSoOGame(i, k) !=0){
							if(game2048View.getChiSoOGame(i, k-1) ==0){
								game2048View.setChiSoOGame(i, k-1,game2048View.getChiSoOGame(i, k));
								game2048View.setChiSoOGame(i, k, 0);
								game2048View.taoOGame(i, k-1);
								game2048View.taoOGame(i,k );
								game2048View.setkiemTraDiChuyenVaHop(true);
							}else if(game2048View.getChiSoOGame(i, k) == game2048View.getChiSoOGame(i, k-1) && KiemTracong == false){
								game2048View.hienDiemManGame(i, k-1);
								game2048View.setChiSoOGame(i, k-1,game2048View.getChiSoOGame(i, k-1)*2);
								game2048View.setChiSoOGame(i, k, 0);
								game2048View.taoOGame(i,k-1);
								game2048View.taoOGame(i,k);
								game2048View.setkiemTraDiChuyenVaHop(true);
								KiemTracong = true;
								break;
		}}}}}
		game2048View.ketThuc();
	}
	public void SangPhai() {
		for(int i = 0 ; i < 4 ; i++)
		{
			boolean KiemTracong  = false;
			for(int j = 2 ; j > -1 ; j--)
			{
					for (int k = j; k < 3; k++) {
						if(game2048View.getChiSoOGame(i, k) !=0){
							if(game2048View.getChiSoOGame(i, k+1) ==0){
								game2048View.setChiSoOGame(i, k+1,game2048View.getChiSoOGame(i, k));
								game2048View.setChiSoOGame(i, k, 0);
								game2048View.taoOGame(i, k+1);
								game2048View.taoOGame(i,k );
								game2048View.setkiemTraDiChuyenVaHop(true);
							}else if(game2048View.getChiSoOGame(i, k) == game2048View.getChiSoOGame(i, k+1) && KiemTracong == false){
								game2048View.hienDiemManGame(i, k+1);
								game2048View.setChiSoOGame(i, k+1,game2048View.getChiSoOGame(i, k+1)*2);
								game2048View.setChiSoOGame(i, k, 0);
								game2048View.taoOGame(i,k+1);
								game2048View.taoOGame(i,k);
								game2048View.setkiemTraDiChuyenVaHop(true);
								KiemTracong = true;
								break;
		}}}}}
		game2048View.ketThuc();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		 x = e.getX();
		 y = e.getY();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if( y - e.getY() > 100 && Math.abs(e.getX() - x) < 100) {
			this.diLen();
		}
		if( e.getY() - y > 100 && Math.abs(e.getX() - x) < 100) {
			this.diXuong();
		}
		if( x - e.getX() > 100 && Math.abs(e.getY() - y) < 100) {
			this.SangTrai();;
		}
		if( e.getX() - x > 100 && Math.abs(e.getY() - y) < 100) {
			this.SangPhai();
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		startView = main.getStartView();
		if(s.equals("Quit")) {
			System.exit(0);
		}else {
			startView.setContentPane(new Game2048View());
			startView.revalidate();
		}
	}
}
